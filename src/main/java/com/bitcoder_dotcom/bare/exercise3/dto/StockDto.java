package com.bitcoder_dotcom.bare.exercise3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class StockDto {

    private String name;
    private double currentPrice;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdate;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response {
        private Long id;
        private String name;
        private double currentPrice;
        private LocalDateTime createDate;
        private LocalDateTime lastUpdate;
    }
}
