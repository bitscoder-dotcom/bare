package com.bitcoder_dotcom.bare.exercise3.ui;

import com.bitcoder_dotcom.bare.exercise3.dto.StockDto;
import com.bitcoder_dotcom.bare.exercise3.service.StockService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.data.domain.PageRequest;

@Route
public class MainView extends VerticalLayout {

    private final StockService stockService;

    private Grid<StockDto.Response> grid;

    public MainView(StockService stockService) {
        this.stockService = stockService;

        H1 title = new H1("List of Stock");
        add(title);

        this.grid = new Grid<>(StockDto.Response.class);
        grid.setColumns("id", "name", "currentPrice", "createDate", "lastUpdate");
        grid.getColumnByKey("id").setHeader("Stock ID");
        grid.getColumnByKey("name").setHeader("Stock Name");
        grid.getColumnByKey("currentPrice").setHeader("Current Price");
        grid.getColumnByKey("createDate").setHeader("Creation Date");
        grid.getColumnByKey("lastUpdate").setHeader("Last Update");

        add(grid);
        listStocks();
    }

    private void listStocks() {
        grid.setItems(stockService.getListOfStocks(PageRequest.of(0, 10)).getBody().getData().getContent());
    }
}
