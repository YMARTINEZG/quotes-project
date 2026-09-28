package me.sigom.practical.quoteapi.controller;


import lombok.extern.slf4j.Slf4j;
import me.sigom.practical.quoteapi.model.Quote;
import me.sigom.practical.quoteapi.model.QuotePayload;
import me.sigom.practical.quoteapi.service.QuoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
@Slf4j
public class QuoteController {
    private final QuoteService apiFacade;

    public QuoteController(QuoteService apiFacade) {
        this.apiFacade = apiFacade;
    }

    @GetMapping("/quotes")
    public ResponseEntity<List<Quote>> findAll() {
        return new ResponseEntity<>(apiFacade.findAll(), HttpStatus.OK);
    }

    @PostMapping("/quote/new")
    public ResponseEntity<Quote> save(@RequestBody QuotePayload newQuote) {
        Quote tmpQuote = apiFacade.save(newQuote);
        return ResponseEntity.ok(tmpQuote);
    }
}
