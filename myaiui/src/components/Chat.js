import React, { useState } from 'react';
import axios from 'axios';
import { TextField, Button } from '@mui/material';

function Chat() {
  const [message, setMessage] = useState('');
  const [messages, setMessages] = useState([]);

  const handleSubmit = (e) => {
    e.preventDefault();
    setMessages([...messages, message]);
    axios.post('/api/chat_history', { messageContent: message }).catch(console.error);
    setMessage('');
  };

  return (
    <div>
      <h2>Chat</h2>
      <div>
        {messages.map((msg, index) => (
          <div key={index}>{msg}</div>
        ))}
      </div>
      <form onSubmit={handleSubmit}>
        <TextField
          label="Message"
          value={message}
          onChange={(e) => setMessage(e.target.value)}
        />
        <Button type="submit" variant="contained" color="primary">
          Send
        </Button>
      </form>
    </div>
  );
}

export default Chat;
