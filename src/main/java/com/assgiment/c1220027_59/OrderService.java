package com.assgiment.c1220027_59;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

//    Using JDBC Template to interact with the database
    private  final JdbcTemplate jdbc;
    String query = "";
    public OrderService(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // Get all orders
    public List<Orders> getAllOrders() {
        query = "SELECT * FROM orders";
        return jdbc.query(query, new BeanPropertyRowMapper<>(Orders.class));
    }

//   Add a new order
    public int addOrder(Orders order) {
        query = "INSERT INTO orders (orderName, orderPrice) VALUES (?, ?)";
        return jdbc.update(query, order.getOrderName(), order.getOrderPrice());
    }

//   Update an existing order
    public int updateOrder(Orders order) {
        query = "UPDATE orders SET orderName = ?, orderPrice = ? WHERE id = ?";
        return jdbc.update(query, order.getOrderName(), order.getOrderPrice(), order.getId());
    }

}
