package com.example.demo.model;

public class ExchangeResponse {
    private double exchangeRate;

    public ExchangeResponse(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}
