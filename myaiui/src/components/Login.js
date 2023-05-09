import React, { useState, useContext } from "react";
import { TextField, Button, Typography, Box } from "@mui/material";
import axios from "axios";
import UserContext from "../contexts/UserContext";
// import { authHeader } from "../api";

const Login = () => {
  const { setLoggedInUser } = useContext(UserContext);
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      axios
        .post("http://localhost:8080/api/login", {
          username: email,
          password: password,
        })
        .then((response) => {
          console.log(response);
          // if (response.status === 200) {
          //   // Login successful
          //   console.log(response)
          //   localStorage.setItem("token", response.data)
          //   setLoggedInUser(response.data);
          //   alert("Login successful");
          // } else {
          //   // Handle login error
          //   console.error("Error during login:", response.status);
          //   alert("Email or Password is wrong");
          // }
        });
    } catch (error) {
      console.error("Error during login:", error.message);
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
      <Typography variant="h4" align="center">
        Please Login
      </Typography>
      <Box component="form" onSubmit={handleSubmit} maxWidth={400} width="100%">
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
          Login
        </Button>
      </Box>
    </Box>
  );
};

export default Login;
