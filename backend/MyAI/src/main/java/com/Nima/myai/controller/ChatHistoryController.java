package com.Nima.myai.controller;

import com.Nima.myai.entity.ChatHistory;
import com.Nima.myai.service.ChatHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/chat_history")
public class ChatHistoryController {

    @Autowired
    private ChatHistoryService chatHistoryService;

    @PostMapping
    public ResponseEntity<ChatHistory> createChatHistory(@RequestBody ChatHistory chatHistory) {
        ChatHistory savedChatHistory = chatHistoryService.save(chatHistory);
        return ResponseEntity.ok(savedChatHistory);
    }

    @GetMapping
    public ResponseEntity<List<ChatHistory>> getAllChatHistory() {
        List<ChatHistory> chatHistories = chatHistoryService.findAll();
        return ResponseEntity.ok(chatHistories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatHistory> getChatHistoryById(@PathVariable Long id) {
        Optional<ChatHistory> chatHistoryOptional = chatHistoryService.findById(id);
        if (chatHistoryOptional.isPresent()) {
            return ResponseEntity.ok(chatHistoryOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChatHistory> updateChatHistory(@PathVariable Long id, @RequestBody ChatHistory chatHistory) {
        Optional<ChatHistory> chatHistoryOptional = chatHistoryService.findById(id);
        if (chatHistoryOptional.isPresent()) {
            ChatHistory updatedChatHistory = chatHistoryService.save(chatHistory);
            return ResponseEntity.ok(updatedChatHistory);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChatHistory(@PathVariable Long id) {
        chatHistoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
