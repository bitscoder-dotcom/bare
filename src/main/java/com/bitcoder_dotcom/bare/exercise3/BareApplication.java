package com.bitcoder_dotcom.bare.exercise3;

import com.bitcoder_dotcom.bare.exercise3.dto.StockDto;
import com.bitcoder_dotcom.bare.exercise3.model.Stock;
import com.bitcoder_dotcom.bare.exercise3.repository.StockRepository;
import com.bitcoder_dotcom.bare.exercise3.service.StockService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class BareApplication {

    public static void main(String[] args) {
        SpringApplication.run(BareApplication.class, args);
    }

    @Component
    public static class DataLoader implements CommandLineRunner {

        private final StockRepository stockRepository;

        @Autowired
        public DataLoader(StockRepository repository) {
            this.stockRepository = repository;
        }

        @Override
        public void run(String... args) throws Exception {
            List<Stock> stocks = Arrays.asList(
                    new Stock(null, "Flakes", 200.00, LocalDateTime.now(), LocalDateTime.now()),
                    new Stock(null, "Oats", 2000.00, LocalDateTime.now(), LocalDateTime.now()),
                    new Stock(null, "Bailey", 350.00, LocalDateTime.now(), LocalDateTime.now()),
                    new Stock(null, "Corn", 2300.00, LocalDateTime.now(), LocalDateTime.now()),
                    new Stock(null, "Beans", 200.00, LocalDateTime.now(), LocalDateTime.now()),
                    new Stock(null, "Meat", 400.00, LocalDateTime.now(), LocalDateTime.now())
            );

            this.stockRepository.saveAll(stocks);
        }
    }
}
