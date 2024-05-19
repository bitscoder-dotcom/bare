package com.bitcoder_dotcom.bare.exercise3.service.serviceImpl;

import com.bitcoder_dotcom.bare.exception.ResourceNotFoundException;
import com.bitcoder_dotcom.bare.exercise3.dto.ApiResponse;
import com.bitcoder_dotcom.bare.exercise3.dto.StockDto;
import com.bitcoder_dotcom.bare.exercise3.model.Stock;
import com.bitcoder_dotcom.bare.exercise3.repository.StockRepository;
import com.bitcoder_dotcom.bare.exercise3.service.StockService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;

    @Override
    public ResponseEntity<ApiResponse<StockDto.Response>> createStock (StockDto stockDto) {
        log.info("create stock service method called");

        Stock stock = convertDtoToEntity(stockDto);
        stockRepository.save(stock);
        StockDto.Response stockResponse = convertEntityToDto(stock);
        ApiResponse<StockDto.Response> apiResponse = new ApiResponse<>(
                LocalDateTime.now(),
                UUID.randomUUID().toString(),
                true,
                "Stock created successfully",
                stockResponse
        );
        log.info("Stock "+stockResponse.getName() +", created successfully.");
        return ResponseEntity.ok(apiResponse);
    }

    @Override
    public ResponseEntity<ApiResponse<StockDto.Response>> getStockById(Long stockId) {
        log.info("get stock by id method called");
        Stock stock = stockRepository.findById(stockId)
                .orElseThrow(() -> new ResourceNotFoundException("Stock", "id", stockId));
        StockDto.Response stockResponse = convertEntityToDto(stock);
        ApiResponse<StockDto.Response> apiResponse = new ApiResponse<>(
                LocalDateTime.now(),
                UUID.randomUUID().toString(),
                true,
                "Stock fetched successfully",
                stockResponse
        );
        log.info("Stock fetched successfully with id: {}", stockId);
        return ResponseEntity.ok(apiResponse);
    }

    @Override
    public ResponseEntity<ApiResponse<StockDto.Response>> updateStockPrice(Long stockId, double newPrice) {
        log.info("Update stock price method called for stock, " + stockId);

        Stock stock = stockRepository.findById(stockId)
                .orElseThrow(() -> new ResourceNotFoundException("Stock", "stockId", stockId));
        stock.setCurrentPrice(newPrice);
        stockRepository.save(stock);
        StockDto.Response stockResponse = convertEntityToDto(stock);
        ApiResponse<StockDto.Response> apiResponse = new ApiResponse<>(
                LocalDateTime.now(),
                UUID.randomUUID().toString(),
                true,
                "Stock price updated successfully",
                stockResponse
        );
        log.info("Stock price updated successfully with id: {}", stockId);
        return ResponseEntity.ok(apiResponse);
    }

    @Override
    public ResponseEntity<ApiResponse<Page<StockDto.Response>>> getListOfStocks(Pageable pageable) {
        log.info("Fetching all stocks");
        Page<Stock> stocks = stockRepository.findAll(pageable);
        Page<StockDto.Response> stockResponses = stocks.map(this::convertEntityToDto);
        ApiResponse<Page<StockDto.Response>> apiResponse = new ApiResponse<>(
                LocalDateTime.now(),
                UUID.randomUUID().toString(),
                true,
                "All stocks fetched successfully",
                stockResponses
        );
        log.info("All stocks fetched successfully");
        return ResponseEntity.ok(apiResponse);
    }


    // Helper methods

    private Stock convertDtoToEntity(StockDto stockDto) {
        Stock stock = new Stock();
        stock.setName(stockDto.getName());
        stock.setCurrentPrice(stockDto.getCurrentPrice());
        stock.setCreateDate(stockDto.getCreateDate());
        stock.setLastUpdate(stockDto.getLastUpdate());

        return stock;
    }
    private StockDto.Response convertEntityToDto(Stock stock) {
        StockDto.Response response = new StockDto.Response();
        response.setId(stock.getId());
        response.setName(stock.getName());
        response.setCurrentPrice(stock.getCurrentPrice());
        response.setCreateDate(LocalDateTime.now());
        response.setLastUpdate(LocalDateTime.now());

        return response;
    }
}
