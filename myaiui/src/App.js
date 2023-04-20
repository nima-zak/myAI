import React, { useState } from "react";
import AppRouter from "./AppRouter";
import UserContext from "./contexts/UserContext";

function App() {
  const [loggedInUser, setLoggedInUser] = useState(null);

  return (
    <div>
      <UserContext.Provider value={{ loggedInUser, setLoggedInUser }}>
        <AppRouter />
      </UserContext.Provider>
    </div>
  );
}

export default App;
