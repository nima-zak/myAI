// ChatHistoryServiceImpl.java
package com.Nima.myai.service;

import com.Nima.myai.entity.ChatHistory;
import com.Nima.myai.repository.ChatHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatHistoryServiceImpl implements ChatHistoryService {

    @Autowired
    private ChatHistoryRepository chatHistoryRepository;

    @Override
    public ChatHistory save(ChatHistory chatHistory) {
        return chatHistoryRepository.save(chatHistory);
    }

    @Override
    public List<ChatHistory> findAll() {
        return chatHistoryRepository.findAll();
    }

    @Override
    public Optional<ChatHistory> findById(Long id) {
        return chatHistoryRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        chatHistoryRepository.deleteById(id);
    }
}
