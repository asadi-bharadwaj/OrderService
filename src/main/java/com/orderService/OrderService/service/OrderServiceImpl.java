package com.orderService.OrderService.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderService.OrderService.entity.Order;
import com.orderService.OrderService.external.client.ProductService;
import com.orderService.OrderService.model.OrderRequest;
import com.orderService.OrderService.repository.OrderRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductService productService;

	@Override
	public long placeOrder(OrderRequest orderRequest) {
		// -> create order entity and save the data with status order created
		// -> we can call the productService to block our products(to reduce the
		// quantity)
		// -> we need to call the paymentService to complete the payment. ->success ->
		// COMPLETE, ->else -> CANCELLED
		
		log.info("placing order request : "+ orderRequest);
		
		productService.reduceQuantity(orderRequest.getProductId(), orderRequest.getQuantity() );
		
		log.info("Creating order with status CREATED");
		
		
		Order order = Order.builder()
				.amount(orderRequest.getTotalAmount())
				.OrderStatus("ORDER_CREATED")
				.productId(orderRequest.getProductId())
				.orderDate(Instant.now())
				.quantity(orderRequest.getQuantity())
				.build();
		order = orderRepository.save(order);
		log.info("Order placed successfully with order id {} : ",order.getId());
		return order.getId();
		
		
	}

}
