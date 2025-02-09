import axios from "axios";

import { api, API_URL } from "../../component/Config/api";
import {
  ADD_TO_FAVORITE_FAILURE,
  ADD_TO_FAVORITE_REQUEST,
  ADD_TO_FAVORITE_SUCCESS,
  GET_USER_FAILURE,
  GET_USER_REQUEST,
  LOGIN_FAILURE,
  LOGIN_REQUEST,
  LOGIN_SUCCESS,
  LOGOUT,
  REGISTER_FAILURE,
  REGISTER_REQUEST,
  REGISTER_SUCCESS,
} from "./ActionType";

export const registerUser = (reqData) => async (dispach) => {
  dispach({ type: REGISTER_REQUEST });
  try {
    const { data } = await axios.post(
      `${API_URL}/auth/signup`,
      reqData.userData
    );
    if (data.jwt) localStorage.setItem("jwt", data.jwt);
    if (data.role === "ROLE_RESTAURANT_OWNER") {
      reqData.navigate("/admin/restaurant");
    } else {
      reqData.navigate("/");
    }
    dispach({ type: REGISTER_SUCCESS, payload: data.jwt });
    console.log("register success", data);
  } catch (error) {
    dispach({ type: REGISTER_FAILURE, payload: error });
    console.log("error", error);
  }
};

export const loginUser = (reqData) => async (dispach) => {
  dispach({ type: LOGIN_REQUEST });
  try {
    const { data } = await axios.post(
      `${API_URL}/auth/signin`,
      reqData.userData
    );
    if (data.jwt) localStorage.setItem("jwt", data.jwt);
    if (data.role === "ROLE_RESTAURANT_OWNER") {
      reqData.navigate("/admin/restaurant");
    } else {
      reqData.navigate("/");
    }
    dispach({ type: LOGIN_SUCCESS, payload: data.jwt });
    console.log("login success", data);
  } catch (error) {
    dispach({ type: LOGIN_FAILURE, payload: error });
    console.log("error", error);
  }
};

export const getUser = (jwt) => async (dispach) => {
  dispach({ type: GET_USER_REQUEST });
  try {
    const { data } = await api.get(`/auth/signin`, {
      headers: {
        Authorization: `Bearer ${jwt}`,
      },
    });

    dispach({ type: REGISTER_SUCCESS, payload: data });
    console.log("user profile", data);
  } catch (error) {
    dispach({ type: GET_USER_FAILURE, payload: error });
    console.log("error", error);
  }
};

export const addToFavorite = (jwt, restaurantId) => async (dispach) => {
  dispach({ type: ADD_TO_FAVORITE_REQUEST });
  try {
    const { data } = await api.put(
      `/api/restaurants/${restaurantId}/add-favorite`,
      {},
      {
        headers: {
          Authorization: `Bearer ${jwt}`,
        },
      }
    );

    dispach({ type: ADD_TO_FAVORITE_SUCCESS, payload: data });
    console.log("added to favorite", data);
  } catch (error) {
    dispach({ type: ADD_TO_FAVORITE_FAILURE, payload: error });
    console.log("error", error);
  }
};

export const logout = () => async (dispach) => {
  dispach({ type: ADD_TO_FAVORITE_REQUEST });
  try {
    localStorage.clear();
    dispach({ type: LOGOUT });
    console.log("logout success");
  } catch (error) {
    console.log("error", error);
  }
};
