package org.demoproject.swiggyclone.entity;

import jakarta.persistence.*;

    @Entity
    @Table(name="menu")
    public class Menu{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int menuItemId;
        @Column(name="name")
        private String name;
        @Column(name="description")
        private String description;
        @Column(name="price")
        private double price;
        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "restaurantId")
        private Restaurant restaurant;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMenuItemId() {
        return menuItemId;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void setMenuItemId(int menuItemId) {
        this.menuItemId = menuItemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

   public Menu() {}

}
