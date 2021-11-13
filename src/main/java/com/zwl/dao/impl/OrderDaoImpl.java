package com.zwl.dao.impl;

import com.zwl.dao.BaseDao;
import com.zwl.dao.OrderDao;
import com.zwl.pojo.Order;

import java.util.List;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {

        String sql =
                "insert into t_order(`order_id`,`create_time`,`price`,`statue`,`user_id`) " +
                "values(?,?,?,?,?)";

        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatue(),order.getUserId());

    }

    @Override
    public List<Order> queryMyOrders(Integer userId) {

        String sql =
                "select `order_id` `orderId`,`create_time` `createTime`,`price`,`statue`,`user_id` userId " +
                "from t_order " +
                "where user_id = ?";

        return queryForList(sql,Order.class,userId);

    }

    @Override
    public List<Order> queryAllOrders() {

        String sql =
                "select `order_id` `orderId`,`create_time` `createTime`,`price`,`statue`,`user_id` userId " +
                "from t_order ";

        return queryForList(sql,Order.class);

    }

    @Override
    public int changeOrder(String orderId, int i) {

        String sql = "UPDATE t_order SET `statue` = ? WHERE `order_id` = ?";

        return update(sql, i, orderId);


    }

    @Override
    public Order queryOrderByOrderId(String orderId) {

        String sql =
                "select `order_id` `orderId`,`create_time` `createTime`,`price`,`statue`,`user_id` userId " +
                "from t_order " +
                "where `order_id` = ?";

        return queryForOne(sql,Order.class,orderId);

    }
}















