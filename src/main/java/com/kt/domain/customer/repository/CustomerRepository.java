package com.kt.domain.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kt.domain.customer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
