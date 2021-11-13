package com.zwl.service;

import com.zwl.pojo.Cart;
import com.zwl.pojo.Order;
import com.zwl.pojo.OrderItem;

import java.util.List;

public interface OrderService {

    public String createOrder(Cart cart, Integer userId);

    public List<Order> myOrders(Integer userId);

    public List<OrderItem> orderDetails(String orderId);

    public List<Order> allOrders();

    public void sendOrder(String orderId);

    public void receiveOrder(String orderId);
}
