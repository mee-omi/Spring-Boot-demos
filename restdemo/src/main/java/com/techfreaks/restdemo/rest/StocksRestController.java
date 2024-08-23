/**
 * 
 */
package com.techfreaks.restdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
    public List<Stocks> getStudents() {
        return theStockList;
    }

}
