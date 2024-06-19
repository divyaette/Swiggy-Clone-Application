package org.demoproject.swiggyclone.controller;

import org.demoproject.swiggyclone.entity.Menu;
import org.demoproject.swiggyclone.entity.Restaurant;
import org.demoproject.swiggyclone.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController()
@RequestMapping("/api/restaurants")
public class RestaurantController {
    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/browse")
    public List<Restaurant> getRestaurants() {
        return restaurantService.getAll();
    }
    @GetMapping("/{restaurantId}/menu")
    public List<Menu> getMenuForRestaurant(@PathVariable int restaurantId) {
        return restaurantService.getMenuForRestaurant(restaurantId);
    }

}
