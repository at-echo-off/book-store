package com.zwl.dao;

import com.zwl.pojo.Order;

import java.util.List;

public interface OrderDao {

    public int saveOrder(Order order);

    public List<Order> queryMyOrders(Integer userId);

    public List<Order> queryAllOrders();

    public int changeOrder(String orderId, int i);

    public Order queryOrderByOrderId(String orderId);
}
