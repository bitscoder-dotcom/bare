package com.bitcoder_dotcom.bare.exercise3.controller;

import com.bitcoder_dotcom.bare.exercise3.dto.ApiResponse;
import com.bitcoder_dotcom.bare.exercise3.dto.StockDto;
import com.bitcoder_dotcom.bare.exercise3.service.StockService;
import com.vaadin.flow.component.page.Page;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@AllArgsConstructor
@RequestMapping("/api")
public class StockController {

    private final StockService stockService;

    @PostMapping("/stocks")
    public ResponseEntity<ApiResponse<StockDto.Response>> createStock(@RequestBody StockDto stockDto) {
        log.info("Controller for create stock called");
        return stockService.createStock(stockDto);
    }

    @GetMapping("/stocks/{stockId}")
    public ResponseEntity<ApiResponse<StockDto.Response>> getStockById(@PathVariable Long stockId) {
        log.info("Controller for get stock by id called");
        return stockService.getStockById(stockId);
    }

    @PutMapping("/stocks/{stockId}")
    public ResponseEntity<ApiResponse<StockDto.Response>> updateStockPrice(@PathVariable Long stockId, double price) {
        log.info("Controller for update stock price called");
        return stockService.updateStockPrice(stockId, price);
    }

//    @GetMapping("/stocks")
//    public ResponseEntity<ApiResponse<Page<StockDto.Response>>> getStockList(Pageable pageable) {
//        log.info("Controller to get list of all stocks called");
//        return stockService.getListOfStocks(pageable);
//    }
}
