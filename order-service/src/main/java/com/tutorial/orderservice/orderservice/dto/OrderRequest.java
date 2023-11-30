package com.tutorial.orderservice.orderservice.dto;

import com.tutorial.orderservice.orderservice.model.OrderItems;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    private List<OrderItems> orderItemsList;
}
