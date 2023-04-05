package com.Nima.myai.service;
import com.Nima.myai.entity.ChatHistory;
import java.util.List;
import java.util.Optional;

public interface ChatHistoryService {
    ChatHistory save(ChatHistory chatHistory);
    List<ChatHistory> findAll();
    Optional<ChatHistory> findById(Long id);
    void deleteById(Long id);
}
