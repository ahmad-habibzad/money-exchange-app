package com.example.demo.service;

import com.example.demo.model.ExchangeRates;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class ExchangeService {
    RestTemplate restTemplate = new RestTemplate();

    public Double getExchangeRate(String fromCurrency, String toCurrency){
        String currencyCode = fromCurrency.split(" - ")[0];
        ExchangeRates response = restTemplate.getForObject(
                "https://api.exchangerate-api.com/v4/latest/"+currencyCode,
                ExchangeRates.class);

        assert response != null;
        Map<String, Double> rates = response.getRates();
        for (String currency : rates.keySet()){
            String target = toCurrency.split(" - ")[0];
            if (currency.equalsIgnoreCase(target)){
                return rates.get(currency);
            }
        }
        throw new RuntimeException("Currency not found");
    }
}
