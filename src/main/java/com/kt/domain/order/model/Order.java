package com.kt.domain.order.model;

import java.util.ArrayList;
import java.util.List;

import com.kt.domain.customer.model.Customer;
import com.kt.domain.orderproduct.model.OrderProduct;
import com.kt.global.common.BaseEntity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Order extends BaseEntity {

	@Embedded
	private AddressVO addressVO;
	private Long totalPrice;
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customerId;

	@OneToMany(mappedBy = "order_product")
	private List<OrderProduct> orderProductList = new ArrayList<>();

}
