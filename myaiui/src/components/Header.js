import React, { useContext } from "react";
import { AppBar, Toolbar, Typography, Button, Box } from "@mui/material";
import { NavLink, useNavigate } from "react-router-dom";
import UserContext from "../contexts/UserContext";

const Header = () => {
  const { loggedInUser, setLoggedInUser } = useContext(UserContext);
  const navigate = useNavigate();

  const handleLogout = () => {
    setLoggedInUser(null);
    navigate("/");
  };

  return (
    <AppBar position="static" style={{ backgroundColor: "blue" }}>
      <Toolbar>
        <Typography variant="h6" sx={{ flexGrow: 1 }}>
          My AI Friend
        </Typography>
        {loggedInUser ? (
          <Box sx={{ flexGrow: 1, display: "flex", justifyContent: "center" }}>
            <Typography variant="subtitle1" color="inherit">
              Welcome, {loggedInUser.name}
            </Typography>
          </Box>
        ) : null}
        <Box>
          {loggedInUser ? (
            <>
              <Button component={NavLink} to="/chat" color="inherit">
                Chat
              </Button>
              <Button component={NavLink} to="/analytics" color="inherit">
                Analytics
              </Button>
              <Button color="inherit" onClick={handleLogout}>
                Logout
              </Button>
            </>
          ) : (
            <>
              <Button component={NavLink} to="/login" color="inherit">
                Login
              </Button>
              <Button component={NavLink} to="/register" color="inherit">
                Register
              </Button>
            </>
          )}
        </Box>
      </Toolbar>
    </AppBar>
  );
};

export default Header;
