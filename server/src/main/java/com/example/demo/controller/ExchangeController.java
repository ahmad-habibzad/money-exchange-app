package com.example.demo.controller;


import com.example.demo.model.ExchangeRequest;
import com.example.demo.model.ExchangeResponse;
import com.example.demo.service.ExchangeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class ExchangeController {

    @PostMapping("/exchange")
    public ExchangeResponse getExchangeRate(@RequestBody ExchangeRequest exchangeRequest) {
        ExchangeService service = new ExchangeService();
        double exchangeRate = service.getExchangeRate(exchangeRequest.getFromCurrency(), exchangeRequest.getToCurrency());
        return new ExchangeResponse(exchangeRate);
    }
}
