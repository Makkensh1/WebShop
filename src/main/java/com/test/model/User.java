package com.test.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User extends Human {

    private double cash;

    @Transient
    transient private final Role ROLE = new Role("ROLE_USER");

    public User() {
        this.cash = 0.0;
    }

    @OneToMany(mappedBy="orderOwner")
    private List<Order> orders;

    @OneToMany(mappedBy="cartOwner")
    private List<Cart> carts;
}