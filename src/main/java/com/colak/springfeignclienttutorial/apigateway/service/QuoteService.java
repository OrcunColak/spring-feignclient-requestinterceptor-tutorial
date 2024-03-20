package com.colak.springfeignclienttutorial.apigateway.service;

import com.colak.springfeignclienttutorial.apigateway.feignclient.QuoteClient;
import com.colak.springfeignclienttutorial.quote.controller.QuoteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;

@RequiredArgsConstructor
@Service
public class QuoteService {

    private final QuoteClient quoteClient;

    public String gather(int id) {
        URI baseUrl = URI.create("http://localhost:8080/api/quote");
        ResponseEntity<QuoteResponse> response2 = quoteClient.getQuote(baseUrl, id);
        QuoteResponse quoteResponse = response2.getBody();

        assert quoteResponse != null;
        return quoteResponse.getMsg();
    }
}
