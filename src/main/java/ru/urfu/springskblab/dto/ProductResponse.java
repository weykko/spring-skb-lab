package ru.urfu.springskblab.dto;

import lombok.Data;
import java.util.Date;

@Data
public class ProductResponse {

    private Float price;
    private Info info;

    @Data
    public static class Info {
        private Long id;
        private Date date;
    }
}
