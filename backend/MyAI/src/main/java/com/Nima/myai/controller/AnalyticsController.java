package com.Nima.myai.controller;

import com.Nima.myai.entity.Analytics;
import com.Nima.myai.service.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {
    @Autowired
    private AnalyticsService analyticsService;

    @PostMapping
    public ResponseEntity<Analytics> createAnatycs(@RequestBody Analytics analytics){
        Analytics savedAnalytics = analyticsService.save(analytics);
        return ResponseEntity.ok(savedAnalytics);
    }
    @GetMapping
    public ResponseEntity<List<Analytics>> getAllAnalytics(){
        List<Analytics> analytics = analyticsService.findAll();
        return ResponseEntity.ok((analytics));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Analytics> getAnalyticsById(@PathVariable Long id){
        Optional<Analytics> analyticsOptional = analyticsService.findById(id);
        if (analyticsOptional.isPresent()){
            return ResponseEntity.ok(analyticsOptional.get());
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Analytics> updateAnalytics(@PathVariable Long id, @RequestBody Analytics analytics) {
        Optional<Analytics> analyticsOptional = analyticsService.findById(id);
        if (analyticsOptional.isPresent()) {
            Analytics updatedAnalytics = analyticsService.save(analytics);
            return ResponseEntity.ok(updatedAnalytics);
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnalytics(@PathVariable Long id) {
        analyticsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
