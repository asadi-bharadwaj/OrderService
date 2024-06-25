package com.orderService.OrderService.service;

import com.orderService.OrderService.model.OrderRequest;
import com.orderService.OrderService.model.OrderResponse;

public interface OrderService {

	long placeOrder(OrderRequest orderRequest);

	OrderResponse getOrdeDetails(long orderId);

}
