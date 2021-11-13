package com.zwl.dao.impl;

import com.zwl.dao.BaseDao;
import com.zwl.dao.OrderItemDao;
import com.zwl.pojo.OrderItem;

import java.util.List;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {

        String sql =
                "insert into t_order_item(`name`,`count`,`price`,`total_price`,`order_id`) " +
                "values(?,?,?,?,?)";

        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());

    }

    @Override
    public List<OrderItem> queryOrderDetailsByOrderId(String orderId) {

        String sql =
                "select `id`,`name`,`count`,`price`,`total_price` `totalPrice`,`order_id` `orderId` " +
                "from t_order_item " +
                "where `order_id` = ?";

        String q =
                "select `id`,`name`,`count`,`price`,`total_price` `totalPrice`,`order_id` `orderId` " +
                "from t_order_item " +
                "where `order_id` = 16362016034971 ";

        return queryForList(sql,OrderItem.class,orderId);

    }
}










