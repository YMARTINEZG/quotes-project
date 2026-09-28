package me.sigom.practical.quoteapi.service;

import me.sigom.practical.quoteapi.model.Quote;
import me.sigom.practical.quoteapi.model.QuotePayload;
import me.sigom.practical.quoteapi.repositories.QuoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteService {
    private final QuoteRepository quoteRepository;
    public QuoteService(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public List<Quote> findAll() {
        return quoteRepository.findAll();
    }

    public Quote save(QuotePayload payload) {
        Quote product = new Quote();
        product.setAuthor(payload.author());
        product.setQuote(payload.quote());
        return quoteRepository.save(product);
    }
    public Quote findById(Integer id) {
        return quoteRepository.findById(id).orElse(null);
    }
}
