package org.demoproject.swiggyclone.controller;

import org.demoproject.swiggyclone.PlaceOrderRequest;
import org.demoproject.swiggyclone.entity.Order;
import org.demoproject.swiggyclone.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping("/place")
    public ResponseEntity<String> placeOrder(@RequestBody PlaceOrderRequest request) {
        Order order = orderService.placeOrder(request.getUserId(), request.getRestaurantId(), request.getMenuItemIds());
        return ResponseEntity.ok("Order placed successfully. Order ID: " + order.getOrderId());
    }
    @GetMapping("track/{orderId}")
    public Order trackOrder(@PathVariable int orderId) {
        return orderService.findById(orderId);
    }
    @GetMapping("/history/{userId}")
    public List<Order> getOrderHistory(@PathVariable int userId) {
        return orderService.getOrderHistory(userId);
    }
    @DeleteMapping("/cancel/{orderId}")
    public void deleteOrder(@PathVariable int orderId) {
        orderService.delete(orderId);
    }

}