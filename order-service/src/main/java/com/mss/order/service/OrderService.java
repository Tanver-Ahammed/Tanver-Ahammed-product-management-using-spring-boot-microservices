package com.mss.order.service;

import com.mss.order.dto.OrderRequest;
import com.mss.order.model.Order;
import com.mss.order.dto.OrderResponse;
import com.mss.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.collection.spi.PersistentList;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {
        // map order request to order Object
        Order order = Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                .totalAmount(orderRequest.totalAmount())
                .skuCode(orderRequest.skuCode())
                .quantity(orderRequest.quantity())
                .build();
        // save order to order repository
        order = this.orderRepository.save(order);
//        return new OrderResponse(order.getId(), order.getOrderNumber(),
//                order.getSkuCode(), order.getTotalAmount(), order.getQuantity());
    }

    public List<OrderResponse> getAllOrders() {
        return this.orderRepository.findAll()
                .stream()
                .map(order -> new OrderResponse(order.getId(), order.getOrderNumber(),
                        order.getSkuCode(), order.getTotalAmount(), order.getQuantity()))
                .toList();
    }

    public OrderResponse getOrderByNumber(String orderNumber) {
        Order order = this.orderRepository
                .findByOrderNumber(orderNumber);
        return new OrderResponse(order.getId(), order.getOrderNumber(),
                order.getSkuCode(), order.getTotalAmount(), order.getQuantity());
    }

}
