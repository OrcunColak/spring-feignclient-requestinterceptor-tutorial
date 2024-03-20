package com.colak.springfeignclienttutorial.quote.controller;

import com.colak.springfeignclienttutorial.util.HttpServletRequestUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/quote")
@Slf4j
public class QuoteController {

    @GetMapping(path = "getQuote/{id}")
    public QuoteResponse getQuote(HttpServletRequest request, @PathVariable("id") int id) {
        HttpHeaders headers = HttpServletRequestUtil.getHeaders(request);
        log.info("QuoteController received HttpHeaders : {}", headers);

        String message = "Quote : " + id;
        QuoteResponse quoteResponse = new QuoteResponse();
        quoteResponse.setMsg(message);
        return quoteResponse;
    }
}
