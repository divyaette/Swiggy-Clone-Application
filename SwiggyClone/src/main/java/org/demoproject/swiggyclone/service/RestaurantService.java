package org.demoproject.swiggyclone.service;

import jakarta.transaction.Transactional;
import org.demoproject.swiggyclone.entity.Menu;
import org.demoproject.swiggyclone.entity.Restaurant;
import org.demoproject.swiggyclone.repo.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }
   @Transactional
    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
   }
   @Transactional
   public List<Menu> getMenuForRestaurant(int restaurantId) {
       return restaurantRepository.findMenuItemsByRestaurantId(restaurantId);
   }

}
