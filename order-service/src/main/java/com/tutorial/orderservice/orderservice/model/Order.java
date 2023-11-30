package com.tutorial.orderservice.orderservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "t_orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "order_number", nullable = false, unique = true)
    private String orderNumber;
    @Column(name = "order_items_list")
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItems> orderItemsList;
}
