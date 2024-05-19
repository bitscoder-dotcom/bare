package com.bitcoder_dotcom.bare;

import com.bitcoder_dotcom.bare.exercise3.dto.ApiResponse;
import com.bitcoder_dotcom.bare.exercise3.dto.StockDto;
import com.bitcoder_dotcom.bare.exercise3.model.Stock;
import com.bitcoder_dotcom.bare.exercise3.repository.StockRepository;
import com.bitcoder_dotcom.bare.exercise3.service.serviceImpl.StockServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class StockServiceTest {

    @Mock
    private StockRepository stockRepository;

    @InjectMocks
    private StockServiceImpl stockService;



    @Test
    public void testCreateStock() {
        StockDto stockDto = new StockDto("Test Stock", 100.0, LocalDateTime.now(), LocalDateTime.now());
        Stock stock = new Stock(null, "Test Stock", 100.0, LocalDateTime.now(), LocalDateTime.now());
        when(stockRepository.save(any(Stock.class))).thenReturn(stock);

        ResponseEntity<ApiResponse<StockDto.Response>> response = stockService.createStock(stockDto);

        assertEquals("Stock created successfully", response.getBody().getMessage());
        verify(stockRepository, times(1)).save(any(Stock.class));
    }

    @Test
    public void testGetStockById() {
        Stock stock = new Stock(1L, "Test Stock", 100.0, LocalDateTime.now(), LocalDateTime.now());
        when(stockRepository.findById(1L)).thenReturn(Optional.of(stock));

        ResponseEntity<ApiResponse<StockDto.Response>> response = stockService.getStockById(1L);

        assertEquals("Stock fetched successfully", response.getBody().getMessage());
        verify(stockRepository, times(1)).findById(1L);
    }

    @Test
    public void testUpdateStockPrice() {
        Stock stock = new Stock(1L, "Test Stock", 100.0, LocalDateTime.now(), LocalDateTime.now());
        when(stockRepository.findById(1L)).thenReturn(Optional.of(stock));
        when(stockRepository.save(any(Stock.class))).thenReturn(stock);

        ResponseEntity<ApiResponse<StockDto.Response>> response = stockService.updateStockPrice(1L, 200.0);

        assertEquals("Stock price updated successfully", response.getBody().getMessage());
        verify(stockRepository, times(1)).findById(1L);
        verify(stockRepository, times(1)).save(any(Stock.class));
    }

    @Test
    public void testGetListOfStocks() {
        Stock stock1 = new Stock(1L, "Test Stock 1", 100.0, LocalDateTime.now(), LocalDateTime.now());
        Stock stock2 = new Stock(2L, "Test Stock 2", 200.0, LocalDateTime.now(), LocalDateTime.now());
        Page<Stock> page = new PageImpl<>(Arrays.asList(stock1, stock2));
        when(stockRepository.findAll(any(Pageable.class))).thenReturn(page);

        ResponseEntity<ApiResponse<Page<StockDto.Response>>> response = stockService.getListOfStocks(PageRequest.of(0, 10));

        assertEquals("All stocks fetched successfully", response.getBody().getMessage());
        verify(stockRepository, times(1)).findAll(any(Pageable.class));
    }
}
