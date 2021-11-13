package com.zwl.test;

import com.zwl.dao.OrderItemDao;
import com.zwl.dao.impl.OrderItemDaoImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderItemDaoImplTest {

    OrderItemDao orderItemDao = new OrderItemDaoImpl();

    @Test
    public void queryOrderDetailsByOrderId() {

        System.out.println(orderItemDao.queryOrderDetailsByOrderId("16362016034971"));

    }
}