import React, { useState } from "react";
import { TextField, Button, Typography, Box } from "@mui/material";
import axios from "axios";

const Register = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [name, setName] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post("http://localhost:8080/api/register", {
        username: name,
        email: email,
        password: password,
      });

      if (response.status === 200) {
        // Registration successful
        alert("Registration successful");
      } else {
        // Handle registration error
        console.error("Error during registration:", response.status);
        alert("Registration error");
      }
    } catch (error) {
      if (error.response && error.response.data.error === "Email already exists") {
        alert("Email is already exist");
      } else {
        console.error("Error during registration:", error.message);
      }
    }
  };

  return (
    <Box
      display="flex"
      flexDirection="column"
      justifyContent="center"
      alignItems="center"
      minHeight="100vh"
      width="100%"
    >
      <Typography variant="h4" align="center" marginBottom={1}>
        Please register a new user account
      </Typography>
      <Box component="form" onSubmit={handleSubmit} maxWidth={400} width="100%">
        <TextField
          fullWidth
          margin="normal"
          label="Full Name"
          value={name}
          onChange={(e) => setName(e.target.value)}
        />
        <TextField
          fullWidth
          margin="normal"
          label="Email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />
        <TextField
          fullWidth
          margin="normal"
          label="Password"
          type="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
        <Button
          fullWidth
          type="submit"
          variant="contained"
          color="primary"
          margin="normal"
        >
          Register
        </Button>
      </Box>
    </Box>
  );
};
export default Register;
