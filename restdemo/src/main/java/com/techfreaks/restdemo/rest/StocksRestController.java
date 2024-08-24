/**
 * 
 */
package com.techfreaks.restdemo.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techfreaks.restdemo.entity.Stocks;

import jakarta.annotation.PostConstruct;

/**
 * @author Omkar
 *
 */
@RestController
@RequestMapping("/stockapi")
public class StocksRestController {

    private List<Stocks> theStockList;

    @PostConstruct
    public void LoadData() {
        theStockList = new ArrayList<Stocks>();
        theStockList.add(new Stocks("RELIANCE", "Bollinger", "sell", "23/08/2024"));
        theStockList.add(new Stocks("ADITYABIRLA", "Smart Money", "buy", "23/08/2024"));
        theStockList.add(new Stocks("TATASTEEL", "ICMCBO", "buy", "23/08/2024"));
        theStockList.add(new Stocks("M&M", "ZigZag", "buy", "23/08/2024"));
        theStockList.add(new Stocks("ADANI", "ICMCBO", "sell", "23/08/2024"));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/stocks")
    public List<Stocks> getStocks() {
        return theStockList;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/stocks")
    public void addStocks(@RequestBody Stocks stock) {
        theStockList.add(stock);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/stocks/{id}")
    public Stocks getStockbyId(@PathVariable String id) {
        Stocks stock = null;
        for (Stocks stocks : this.theStockList) {
            if (stocks.getStockId()
                .equalsIgnoreCase(id)) {
                stock = stocks;
            }
        }
        return stock;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/stocks/{id}")
    public ResponseEntity<Stocks> updateStockbyId(@PathVariable String id, @RequestBody Stocks stock) {
        Stocks stockDTO = null;
        for (Stocks stocks : this.theStockList) {
            if (stocks.getStockId()
                .equalsIgnoreCase(id)) {
                stockDTO = stocks;
            }
        }
        if (stockDTO != null) {
            stockDTO.setStrategyName(stock.getStrategyName());
            stockDTO.setResult(stock.getResult());
            stockDTO.setDate(stock.getDate());
        }
        return ResponseEntity.ok(stockDTO);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/stocks/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteStockbyId(@PathVariable String id) {
        Stocks stockDTO = null;
        for (Stocks stocks : this.theStockList) {
            if (stocks.getStockId()
                .equalsIgnoreCase(id)) {
                stockDTO = stocks;
            }
        }
        if (stockDTO != null) {
            this.theStockList.remove(stockDTO);
        }
        Map<String, Boolean> response = new HashMap<String, Boolean>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
