package com.Nima.myai.service;

import com.Nima.myai.entity.Analytics;

import java.util.List;
import java.util.Optional;

public interface AnalyticsService {
    Analytics save(Analytics analytics);
    List<Analytics> findAll();
    Optional<Analytics> findById(Long id);
    void deleteById(Long id);
}
