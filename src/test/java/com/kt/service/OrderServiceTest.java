package com.kt.service;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kt.domain.order.Order;
import com.kt.domain.product.Product;
import com.kt.domain.user.Gender;
import com.kt.domain.user.User;
import com.kt.repository.order.OrderRepository;
import com.kt.repository.orderproduct.OrderProductRepository;
import com.kt.repository.product.ProductRepository;
import com.kt.repository.user.UserRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderServiceTest {

	@Autowired
	private OrderService orderService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderProductRepository orderProductRepository;

	// 동시성 제어는 Lock을 걸어 처리 -> 3가지
	// 1. 비관적 락(Pessimistic Lock) -> DB에서 지원해주는 Lock -> SELECT ... FOR UPDATE -> 한명이 들어오면 끝날때까지 기다려라
	/* 화장실 -> 한명씩 들어감 -> 앞사람이 오래걸림 -> 기다려라
	 * 단점: 시간이 오래 걸리고 데드락 발생 가능
	 * 2. 낙관적 락(Optimistic Lock) -> 버전 관리 -> 셀렉트할 때 그때의 버전을 가져와서 작업을 끝내고 트랜잭션 커밋되면
	 * 화장실 -> 한명씩 들어가면 일단 들어와 -> 대신 나갈 때 최신 버전 확인
	 * 처음 입장할 때 버전을 조회 - 작업 끝나고 - 나갈 때 다시 버전 조회해서 같으면 재고 차감
	 * 3. 분산 락 -> 레디스
	 * 화장실 -> 한 명씩 들어감 -> 앞 사람이 오래걸림 -> 그냥 끌고나와서(타임아웃) 내가 들어감
	 */

	@BeforeEach
	void setUp() {
		orderProductRepository.deleteAll();
		orderRepository.deleteAll();
		productRepository.deleteAll();
		userRepository.deleteAll();
	}

	@Test
	void 주문_생성_테스트() {
		// given
		var user = userRepository.save(User.normalUser(
				"dd",
				"email",
				"pass",
				"Test User",
				"2000-03-28",
				LocalDate.now(),
				Gender.MALE,
				LocalDateTime.now(),
				LocalDateTime.now()
			)
		);

		var product = productRepository.save(
			new Product(
				"테스트 상품명",
				1000L,
				10L
			)
		);

		// when
		orderService.create(
			user.getId(),
			product.getId(),
			"수신자 이름",
			"수신자 주소",
			"00000",
			2L
		);

		// then
		Optional<Order> foundedOrder = orderRepository.findAll().stream().findFirst();
		Product foundedProduct = productRepository.findByIdOrThrow(product.getId());

		assertThat(foundedProduct.getStock()).isEqualTo(8L);
		// assertThat(foundedProduct.getOrderProducts()).isNotEmpty();
		assertThat(foundedOrder).isPresent();

	}

	@Test
	void 동시에_100명_주문() throws InterruptedException {
		var repeatCount = 500;
		List<User> userList = new ArrayList<>();
		for (int i = 0; i < repeatCount; i++) {
			userList.add(User.normalUser(
				"testuser-" + i,
				"password",
				"Test User - " + i,
				"email-" + i,
				"010-0000-0000" + i,
				LocalDate.now(),
				Gender.MALE,
				LocalDateTime.now(),
				LocalDateTime.now()
			));
		}
		List<User> users = userRepository.saveAll(userList);
		Product product = productRepository.save(
			new Product(
				"테스트 상품명",
				100_000L,
				10L
			)
		);
		productRepository.flush();

		// 동시에 주문해야하니까 쓰레드 100개
		ExecutorService executorService = Executors.newFixedThreadPool(100);
		// 스레드 종료 대기 장치
		CountDownLatch countDownLatch = new CountDownLatch(repeatCount);
		// AtomicInteger -> 동시성 환경에서 안전하게 숫자를 더할 수 있는 객체
		AtomicInteger successCount = new AtomicInteger(0);
		AtomicInteger failureCount = new AtomicInteger(0);

		for (int i = 0; i < repeatCount; i++) {
			int finalI = i;
			executorService.submit(() -> {
				try {
					User targetUser = users.get(finalI);
					orderService.create(
						targetUser.getId(),
						product.getId(),
						targetUser.getName(),
						"수신자주소-" + finalI,
						"010-111-22" + finalI,
						1L

					);
					successCount.incrementAndGet();
				} catch (RuntimeException e) {
					failureCount.incrementAndGet();
				} finally {
					countDownLatch.countDown();

				}
			});
		}
		// 모든 스레드가 끝날 때 까지 대기
		countDownLatch.await();
		// 스레드를 더 생성하지 않음
		executorService.shutdown();

		Product foundedProduct = productRepository.findByIdOrThrow(product.getId());
		assertThat(successCount.get()).isEqualTo(10);
		assertThat(failureCount.get()).isEqualTo(490);
		// System.out.println("successCount.get() = " + successCount.get());
		// System.out.println("faliureCount.get() = " + failureCount.get());
		// System.out.println("foundedProduct.getStock() = " + foundedProduct.getStock());
	}
}