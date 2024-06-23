package com.orderService.OrderService.service;

import com.orderService.OrderService.model.OrderRequest;

public interface OrderService {

	long placeOrder(OrderRequest orderRequest);

}
