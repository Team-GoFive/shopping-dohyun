package com.kt.repository.product;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import com.kt.domain.product.Product;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional // -> @Test가 붙어있는 곳에서 실행된다면, 데이터를 다 삭제해줌
class ProductRepositoryTest {

	@Autowired
	private ProductRepository productRepository;

	@BeforeEach
	void setup() {
		productRepository.save(
			new Product(
				"테스트 상품명",
				100_000L,
				10L
			)
		);
	}

	@Test
	void 이름으로_상품_검색() {
		// given 준비단계
		// 먼저 상품을 저장해놔야 검색을 했을 때 있는지 없는지 알 수 있다
		Product product = productRepository.save(new Product(
			"테스트 상품명1",
			100_000L,
			10L
		));

		// 실행 when
		// 검색
		var foundedProduct = productRepository.findByName("테스트 상품명");

		// 검증 then
		assertThat(foundedProduct).isPresent();

	}

}