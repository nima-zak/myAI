import React from "react";
import { Container, Typography, Box } from "@mui/material";

const Footer = () => {
  return (
    <Box
      component="footer"
      sx={{
        backgroundColor: "cyan",
        paddingTop: "2rem",
        paddingBottom: "2rem",
      }}
    >
      <Container>
        <Typography variant="body1" align="center" gutterBottom>
          @ Nimaryamdia
        </Typography>
      </Container>
    </Box>
  );
};

export default Footer;
