package com.kt.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kt.domain.product.Product;
import com.kt.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {
	private final ProductRepository productRepository;

	public void create(String name, Long price, Long quantity) {
		productRepository.save(new Product(
			name,
			price,
			quantity
		));
	}

	public void update(Long id, String name, Long price, Long quantity) {
		Product product = productRepository.findByIdOrThrow(id);
		product.update(
			name,
			price,
			quantity
		);
	}

	public void soldOut(Long id) {
		Product product = productRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("Product not found"));
		product.soldOut();
	}

	public void activate(Long id) {
		var product = productRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("Product not found"));
		product.activate();
	}

	public void inActivate(Long id) {
		var product = productRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("Product not found"));
		product.inActivate();
	}

	public void delete(Long id) {
		var product = productRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("Product not found"));
		product.delete();
	}

	public void decreaseStock(Long id, Long quantity) {
		Product product = productRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("Product not found"));
		product.decreaseStock(quantity);
	}

	public void increaseStock(Long id, Long quantity) {
		Product product = productRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("Product not found"));
		product.increaseStock(quantity);
	}
}
