import { api } from "../../component/Config/Api";
import {
  GET_RESTAURANT_ORDER_FAILURE,
  GET_RESTAURANT_ORDER_REQUEST,
  GET_RESTAURANT_ORDER_SUCCESS,
  UPDATE_ORDER_STATUS_FAILURE,
  UPDATE_ORDER_STATUS_REQUEST,
  UPDATE_ORDER_STATUS_SUCCESS,
} from "./ActionType";

export const updateOrderStatus = ({ orderId, orderStatus, jwt }) => {
  return async (dispatch) => {
    try {
      dispatch({ type: UPDATE_ORDER_STATUS_REQUEST });
      const response = await api.put(
        `/api/admin/orders/${orderId}/${orderStatus}`,
        {},
        {
          headers: {
            Authorization: `Bearer ${jwt}`,
          },
        }
      );

      const updatedOrdere = response.data;

      console.log("updateOrdered", updatedOrdere);

      dispatch({
        type: UPDATE_ORDER_STATUS_SUCCESS,
        payload: updatedOrdere,
      });
    } catch (error) {
      console.log("error", error);
      dispatch({
        type: UPDATE_ORDER_STATUS_FAILURE,
        error,
      });
    }
  };
};

export const fetchRestaurantsOrders = ({ restaurantId, orderStatus, jwt }) => {
  return async (dispatch) => {
    try {
      dispatch({ type: GET_RESTAURANT_ORDER_REQUEST });
      const { data } = await api.get(
        `/api/admin/order/restaurant/${restaurantId}`,
        {
          params: { order_status: orderStatus },
          headers: {
            Authorization: `Bearer ${jwt}`,
          },
        }
      );

      const orders = data;
      console.log("restaurants order----", orders);

      dispatch({
        type: GET_RESTAURANT_ORDER_SUCCESS,
        payload: orders,
      });
    } catch (error) {
      console.log("error", error);
      dispatch({
        type: GET_RESTAURANT_ORDER_FAILURE,
        error,
      });
    }
  };
};
