import { CssBaseline, ThemeProvider } from "@mui/material";
import Navbar from "./component/Navbar/Navbar";
import { darkTheme } from "./theme/DarkTheme";
import Home from "./Home/Home";
import RestaurantDetails from "./Restaurant/RestaurantDetails";
import Cart from "./Cart/Cart";
import Profile from "./Profile/Profile";
import CustomerRoute from "./Routers/CustomerRoute";
import { Auth } from "./Auth/Auth";
import { useDispatch, useSelector } from "react-redux";
import { store } from "./State/Store";
import { useEffect } from "react";
import { getUser } from "./State/Authentication/Action";

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
