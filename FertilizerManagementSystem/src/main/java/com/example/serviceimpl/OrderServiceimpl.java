package com.example.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.OrderNow;
import com.example.repository.OrderRepository;

@Service
public class OrderServiceimpl {

	@Autowired
	private OrderRepository orderRepository;

	public OrderNow saveOrder(OrderNow order) {

		return this.orderRepository.save(order);

	}

	public List<OrderNow> getAllOrder() {

		return this.orderRepository.findAll();

	}

}
