import {
  GET_USER_ORDERS_FAILURE,
  GET_USER_ORDERS_REQUEST,
  GET_USER_ORDERS_SUCCESS,
} from "./ActionType";

const initialState = {
  orders: [],
  loading: false,
  error: null,
};

export const orderReducer = (state = initialState, { type, payload }) => {
  switch (type) {
    case GET_USER_ORDERS_REQUEST:
      return {
        ...state,
        loading: true,
        error: null,
      };
    case GET_USER_ORDERS_SUCCESS:
      return {
        ...state,
        loading: false,
        orders: payload,
        error: null,
      };
    case GET_USER_ORDERS_FAILURE:
      return {
        ...state,
        loading: false,
        error: payload,
      };

    default:
      return state;
  }
};
