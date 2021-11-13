package com.zwl.dao;

import com.zwl.pojo.OrderItem;

import java.util.List;

public interface OrderItemDao {

    public int saveOrderItem(OrderItem orderItem);

    public List<OrderItem> queryOrderDetailsByOrderId(String orderId);
}
