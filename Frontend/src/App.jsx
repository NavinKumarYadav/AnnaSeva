import { CssBaseline, ThemeProvider } from "@mui/material";
import Navbar from "./component/Navbar/Navbar";
import { darkTheme } from "./theme/DarkTheme";
import Home from "./Home/Home";
import RestaurantDetails from "./Restaurant/RestaurantDetails";
import Cart from "./Cart/Cart";
import Profile from "./Profile/Profile";
import CustomerRoute from "./Routers/CustomerRoute";
import { Auth } from "./Auth/Auth";

function App() {
  return (
    <ThemeProvider theme={darkTheme}>
      <CssBaseline />
      {/* <Navbar /> */}
      {/* <Home /> */}
      {/* <RestaurantDetails /> */}
      {/* <Cart /> */}
      {/* <Profile /> */}
      <CustomerRoute />
    </ThemeProvider>
  );
}

export default App;
