package com.zwl.test;

import com.zwl.dao.OrderItemDao;
import com.zwl.dao.impl.OrderItemDaoImpl;
import com.zwl.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

public class OrderItemImplTest {

    OrderItemDao orderItemDao = new OrderItemDaoImpl();

    @Test
    public void saveOrderItem() {

        orderItemDao.saveOrderItem(new OrderItem(null,"java",1,new BigDecimal("100"),new BigDecimal("100"),"1234567890"));
        orderItemDao.saveOrderItem(new OrderItem(null,"C++",1,new BigDecimal("100"),new BigDecimal("100"),"1234567890"));
        orderItemDao.saveOrderItem(new OrderItem(null,"JS",1,new BigDecimal("100"),new BigDecimal("100"),"1234567890"));

    }
}