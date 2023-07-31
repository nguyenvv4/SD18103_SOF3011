package com.example.sd18103.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Cart {

    private List<CartItem> list;

    @Override
    public String toString() {
        return "Cart{" +
                "list=" + list +
                '}';
    }
}
