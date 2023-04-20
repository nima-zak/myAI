import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import React, { useContext } from "react";
import UserContext from "./contexts/UserContext";
import Header from "./components/Header";
import Footer from "./components/Footer";
import Login from "./components/Login";
import Register from "./components/Register";
import Chat from "./components/Chat";
import Analytics from "./components/Analytics";
import Dashboard from "./pages/Dashboard";
import { Box } from "@mui/material";

function AppRouter() {
  const { loggedInUser } = useContext(UserContext);
  return (
    <Router>
      <Header />
      <Box display="flex" flexDirection="column" minHeight="100vh">
        <Box flexGrow={1}>
          <Routes>
            {loggedInUser ? (
              <>
                <Route path="/" element={<Dashboard />} />
                <Route path="/chat" element={<Chat />} />
                <Route path="/analytics" element={<Analytics />} />
              </>
            ) : (
              <>
                <Route path="/" element={<Dashboard />} />
                <Route path="/login" element={<Login />} />
                <Route path="/register" element={<Register />} />
              </>
            )}
          </Routes>
        </Box>
        <Footer />
      </Box>
    </Router>
  );
}

export default AppRouter;
