package ru.urfu.springskblab.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Product {

    private Long id;
    private Float price;
    private Date date;

    public Product(Float price, Date date, Long id) {
        this.price = price;
        this.date = date;
        this.id = id;
    }
}
