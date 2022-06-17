package com.helmi.TunningMarket.repositories;

import com.helmi.TunningMarket.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Override
    Optional<Article> findById(Long id);
}
