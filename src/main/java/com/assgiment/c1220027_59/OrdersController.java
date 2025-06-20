package com.assgiment.c1220027_59;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    private final OrderService orderService;

    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Get all orders
    @GetMapping("/")
    public List<Orders> getAllOrders() {
        return orderService.getAllOrders();
    }

    // Add a new order
    @PostMapping("/")
    public int addOrder(@RequestBody Orders order) {
        return orderService.addOrder(order);
    }

    // Update an existing order
    @PutMapping("/{id}")
    public int updateOrder(@PathVariable int id, @RequestBody Orders order) {
        order.setId(id);
        return orderService.updateOrder(order);
    }
}
