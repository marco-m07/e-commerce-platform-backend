package com.me.ecommerce.product;

import jakarta.persistence.*;

/**
 * This class defines a Product of the E-Commerce platform.
 */

@Table
@Entity(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private String imageUrl;

    // Default and all args constructor.
    public Product() {
    }

    public Product(Long id, String name, Double price, String imageUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    // Getters.
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    // Setters.
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    // Instance methods.
    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + id.hashCode();
        hash = 31 * hash + name.hashCode();
        hash = 31 * hash + price.hashCode();
        hash = 31 * hash + imageUrl.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Product)) {
            return false;
        }
        Product product = (Product) obj;
        return product.id.equals(id) &&
                product.name.equals(name) &&
                product.price.equals(price) &&
                product.imageUrl.equals(imageUrl);
    }

    @Override
    public String toString() {
        return String.join("_",
                String.valueOf(id),
                name,
                String.valueOf(price),
                imageUrl);
    }
}
