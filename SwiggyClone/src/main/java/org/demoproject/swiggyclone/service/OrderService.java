package org.demoproject.swiggyclone.service;

import jakarta.transaction.Transactional;
import org.demoproject.swiggyclone.entity.*;
import org.demoproject.swiggyclone.repo.MenuItemRepository;
import org.demoproject.swiggyclone.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private MenuItemRepository menuRepository;

    public OrderService(OrderRepository repository) {
        this.orderRepository = repository;
    }

  @Transactional
    public Order findById(int id) {
        return orderRepository.findById(id).orElse(null);
    }
   @Transactional
    public void delete(int id) {
        orderRepository.deleteById(id);
    }
    @Transactional
    public List<Order> getOrderHistory(int userId) {
        return orderRepository.findOrdersByUserId(userId);
    }
    @Transactional
    public Order placeOrder(int userId,int restaurantId,List<Integer>menuItemIds){
        Order order=new Order();
        order.setStatus("Pending");

        User user=new User();
        user.setUserId(userId);
        order.setUser(user);

        Restaurant restaurant=new Restaurant();
        restaurant.setRestaurantId(restaurantId);
        order.setRestaurant(restaurant);

        double totalPrice=0.0;
        List<Menu>selectedMenuItems=new ArrayList<>();
        for(int menuItemId:menuItemIds){
            Menu menuItem=menuRepository.findById(menuItemId).orElse(null);
            if(menuItem!=null&&menuItem.getRestaurant().getRestaurantId()==restaurantId){
                selectedMenuItems.add(menuItem);
                totalPrice+=menuItem.getPrice();
            }else{
                throw new IllegalArgumentException("Invalidmenuitemselected.");
            }

        }
        order.setTotalPrice(totalPrice);
        return orderRepository.save(order);
    }

}