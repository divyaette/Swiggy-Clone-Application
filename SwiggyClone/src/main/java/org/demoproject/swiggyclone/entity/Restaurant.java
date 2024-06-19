package org.demoproject.swiggyclone.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int restaurantId;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="address")
    private String address;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
