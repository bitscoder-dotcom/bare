package com.bitcoder_dotcom.bare.exercise3.repository;

import com.bitcoder_dotcom.bare.exercise3.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
