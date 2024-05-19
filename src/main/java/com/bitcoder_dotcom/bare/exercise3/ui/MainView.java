//package com.bitcoder_dotcom.bare.exercise3.ui;
//
//import com.bitcoder_dotcom.bare.exercise3.dto.StockDto;
//import com.bitcoder_dotcom.bare.exercise3.service.StockService;
//import com.vaadin.flow.component.grid.Grid;
//import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//import com.vaadin.flow.router.Route;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.stereotype.Component;
//
//@Route
//@Component
//public class MainView extends VerticalLayout {
//
//    private final StockService stockService;
//
//    private Grid<StockDto.Response> grid;
//
//    @Autowired
//    public MainView(StockService stockService) {
//        this.stockService = stockService;
//        this.grid = new Grid<>(StockDto.Response.class);
//        add(grid);
//        listStocks();
//    }
//
//    private void listStocks() {
//        grid.setItems(stockService.getListOfStocks(PageRequest.of(0, 10)).getBody().getData().getContent());
//    }
//}
