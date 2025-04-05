package ru.urfu.springskblab.dto;

import lombok.Data;
import java.util.Date;

@Data
public class ProductRequest {

    private Float price;
    private Info info;

    @Data
    public static class Info {
        private Date date;
    }
}
