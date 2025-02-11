import { CssBaseline, ThemeProvider } from "@mui/material";
import { darkTheme } from "./theme/DarkTheme";
import CustomerRoute from "./Routers/CustomerRoute";
import { useDispatch, useSelector } from "react-redux";
import { useEffect } from "react";
import { getUser } from "./State/Authentication/Action.js";

function App() {
  const dispatch = useDispatch();
  const jwt = localStorage.getItem("jwt");
  const { auth } = useSelector((store) => store);
  useEffect(() => {
    dispatch(getUser(auth.jwt || jwt));
  }, [auth.jwt, dispatch, jwt]);
  return (
    <ThemeProvider theme={darkTheme}>
      <CssBaseline />
      <CustomerRoute />
    </ThemeProvider>
  );
}

export default App;
