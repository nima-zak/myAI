CREATE TABLE analytics (
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    average_sentiment_score DECIMAL(4, 2),
    date DATE,
    FOREIGN KEY (user_id) REFERENCES users(id)
);


