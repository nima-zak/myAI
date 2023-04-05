package com.Nima.myai.service;

import com.Nima.myai.entity.Analytics;
import com.Nima.myai.repository.AnalyticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnalyticsServiceImpl implements AnalyticsService {

    @Autowired
    private AnalyticsRepository analyticsRepository;

    @Override
    public Analytics save(Analytics analytics) {
        return analyticsRepository.save(analytics);
    }

    @Override
    public List<Analytics> findAll() {
        return analyticsRepository.findAll();
    }

    @Override
    public Optional<Analytics> findById(Long id) {
        return analyticsRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        analyticsRepository.deleteById(id);
    }
}
