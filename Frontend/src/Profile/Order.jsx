import React, { useEffect } from "react";
import OrderCard from "./OrderCard";
import { useDispatch, useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";
import { getUserOrders } from "../State/Order/Action";

const Order = () => {
  const { auth, cart, order } = useSelector((store) => store);
  const navigate = useNavigate();
  const jwt = localStorage.getItem("jwt");
  const dispatch = useDispatch();

  useEffect(() => {
    dispatch(getUserOrders(jwt));
  }, [auth.jwt]);

  return (
    <div className="flex items-center flex-col">
      <h1 className="text-xl text-center py-7 font-semibold">My Orders</h1>
      <div className="space-y-5 w-full lg:w-1/2">
        {order.orders.map((order) =>
          order.items.map((item, i) => (
            <OrderCard order={order} item={item} key={i} />
          ))
        )}
      </div>
    </div>
  );
};

export default Order;
