package com.bitcoder_dotcom.bare.exercise3.service;

import com.bitcoder_dotcom.bare.exercise3.dto.ApiResponse;
import com.bitcoder_dotcom.bare.exercise3.dto.StockDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface StockService {

    ResponseEntity<ApiResponse<StockDto.Response>> createStock (StockDto stockDto);
    ResponseEntity<ApiResponse<StockDto.Response>> getStockById(Long stockId);
    ResponseEntity<ApiResponse<StockDto.Response>> updateStockPrice(Long stockId, double newPrice);
    ResponseEntity<ApiResponse<Page<StockDto.Response>>> getListOfStocks(Pageable pageable);
}
