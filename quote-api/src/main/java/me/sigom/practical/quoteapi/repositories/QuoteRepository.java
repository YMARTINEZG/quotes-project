package me.sigom.practical.quoteapi.repositories;

import me.sigom.practical.quoteapi.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepository extends JpaRepository<Quote, Integer> {
}
