package com.example.sd18103.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItem {

    private Integer idSp;

    private Integer giaBan;

    private String tenSp;

    private Integer soLuong;

    @Override
    public String toString() {
        return "CartItem{" +
                "idSp=" + idSp +
                ", giaBan=" + giaBan +
                ", tenSp='" + tenSp + '\'' +
                ", soLuong=" + soLuong +
                '}';
    }
}
