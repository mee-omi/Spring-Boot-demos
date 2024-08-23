/**
 * 
 */
package com.techfreaks.restdemo.entity;

/**
 * @author Omkar
 *
 */
public class Stocks {

    private String stockId;
    private String strategyName;
    private String result;
    private String date;

    public String getStockId() {
        return stockId;
    }

    public Stocks(String stockId, String strategyName, String result, String date) {
        super();
        this.stockId = stockId;
        this.strategyName = strategyName;
        this.result = result;
        this.date = date;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public String getStrategyName() {
        return strategyName;
    }

    public void setStrategyName(String strategyName) {
        this.strategyName = strategyName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
