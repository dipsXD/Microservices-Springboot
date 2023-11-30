package com.tutorial.orderservice.orderservice.service;

import com.tutorial.orderservice.orderservice.dto.OrderRequest;
import com.tutorial.orderservice.orderservice.model.Order;
import com.tutorial.orderservice.orderservice.model.OrderItems;
import com.tutorial.orderservice.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {


    private final OrderRepository orderRepository;
    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderItems> orderItems = orderRequest.getOrderItemsList()
                .stream()
                .map(this::mapToDto)
                .toList();
        order.setOrderItemsList(orderItems);
        orderRepository.save(order);
    }

    private OrderItems mapToDto(OrderItems orderItemsDto) {
        OrderItems orderItems = new OrderItems();
        orderItems.setPrice(orderItemsDto.getPrice());
        orderItems.setSkuCode(orderItemsDto.getSkuCode());
        orderItems.setQuantity(orderItemsDto.getQuantity());
        return orderItems;
    }
}
