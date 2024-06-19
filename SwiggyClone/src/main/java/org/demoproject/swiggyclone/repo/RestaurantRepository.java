package org.demoproject.swiggyclone.repo;

import org.demoproject.swiggyclone.entity.Menu;
import org.demoproject.swiggyclone.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>
{
        @Query("SELECT mi FROM Menu mi WHERE mi.restaurant.restaurantId = :restaurantId")
        List<Menu> findMenuItemsByRestaurantId(@Param("restaurantId") int restaurantId);
}



