package ru.urfu.springskblab.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Product {

    private Long id;
    private Float price;
    private Date date;

}
