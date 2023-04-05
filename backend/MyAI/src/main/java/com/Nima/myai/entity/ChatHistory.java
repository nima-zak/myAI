package com.Nima.myai.entity;
import javax.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "chat_history")
public class ChatHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "message_content", nullable = false)
    private String messageContent;

    @Column(name = "chatbot_response", nullable = false)
    private String chatbotResponse;

    @Column(name = "sentiment_score")
    private BigDecimal sentimentScore;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;
}