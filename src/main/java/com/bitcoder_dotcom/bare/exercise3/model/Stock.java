package com.bitcoder_dotcom.bare.exercise3.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "stocks")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double currentPrice;
    @CreationTimestamp
    private LocalDate createDate;
    @UpdateTimestamp
    private LocalDate lastUpdate;
}


/**
 * id (Number),
 * name (String),
 * currentPrice (Amount)
 * createDate and lastUpdate(Timestamp).
 */