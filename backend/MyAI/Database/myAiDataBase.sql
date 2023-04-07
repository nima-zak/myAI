CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    avatar_url VARCHAR(255),
    chatbot_personality VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE chat_history (
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    message_content TEXT NOT NULL,
    chatbot_response TEXT NOT NULL,
    sentiment_score DECIMAL(4, 2),
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id)
);
CREATE TABLE analytics (
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    average_sentiment_score DECIMAL(4, 2),
    date DATE,
    FOREIGN KEY (user_id) REFERENCES users(id)
);
