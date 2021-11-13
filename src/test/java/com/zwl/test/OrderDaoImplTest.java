package com.zwl.test;

import com.zwl.dao.OrderDao;
import com.zwl.dao.impl.OrderDaoImpl;
import com.zwl.pojo.Order;
import com.zwl.pojo.OrderItem;
import com.zwl.utils.JdbcUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

public class OrderDaoImplTest {

    OrderDao orderDao = new OrderDaoImpl();

    @Test
    public void saveOrder() {

        orderDao.saveOrder(new Order("1234567890",new Date(),new BigDecimal(100),0,1));

    }

    @Test
    public void queryMyOrders() {

        System.out.println(orderDao.queryMyOrders(1));

    }

    @Test
    public void queryAllOrders() {

        System.out.println(orderDao.queryAllOrders());

    }

    @Test
    public void changeOrder() {


        System.out.println(orderDao.changeOrder("16362010189541",0));
        JdbcUtils.commitAndClose();

    }
}