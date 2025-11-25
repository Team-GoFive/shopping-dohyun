package com.kt.domain.customer.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.kt.domain.customer.model.Customer;
import com.kt.domain.customer.repository.CustomerRepository;
import com.kt.domain.customer.request.CustomerCreateRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {

	private final CustomerRepository customerRepository;

	public void create(CustomerCreateRequest request) {
		Customer customer = Customer.memberUser(
			request.loginId(),
			UUID.randomUUID(),
			request.password(),
			request.name(),
			request.birthday(),
			request.gender()
		);
		customerRepository.save(customer);
	}
}
