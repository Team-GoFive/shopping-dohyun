package com.kt.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kt.common.ErrorCode;
import com.kt.common.Preconditions;
import com.kt.domain.Receiver;
import com.kt.domain.order.Order;
import com.kt.domain.orderproduct.OrderProduct;
import com.kt.domain.product.Product;
import com.kt.domain.user.User;
import com.kt.repository.order.OrderRepository;
import com.kt.repository.orderproduct.OrderProductRepository;
import com.kt.repository.product.ProductRepository;
import com.kt.repository.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

	private final UserRepository userRepository;
	private final ProductRepository productRepository;
	private final OrderRepository orderRepository;
	private final OrderProductRepository orderProductRepository;

	// 주문 생성
	public void create(
		Long userId,
		Long productId,
		String receiverName,
		String receiverAddress,
		String receiverMobile,
		Long quantity
	) {
		Product product = productRepository.findByIdOrThrow(productId);
		// 재고가 충분한가?
		Preconditions.validate(
			product.canProvide(quantity),
			ErrorCode.NOT_ENOUGH_STOCK
		);

		User user = userRepository.findByIdOrThrow(
			userId,
			ErrorCode.NOT_FOUND_USER
		);

		Receiver receiver = new Receiver(
			receiverName,
			receiverAddress,
			receiverMobile
		);

		Order order = orderRepository.save(
			Order.create(
				receiver,
				user
			)
		);

		OrderProduct orderProduct = orderProductRepository.save(
			new OrderProduct(
				order,
				product,
				quantity
			));
		// 주문 생성 완료

		product.decreaseStock(quantity);

		// 양방향 테이블 연관 작업
		product.mapToOrderProduct(orderProduct);
		order.mapToOrderProduct(orderProduct);
	}
}
