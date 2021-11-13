package com.zwl.test;

import com.zwl.pojo.Cart;
import com.zwl.pojo.CartItem;
import com.zwl.service.OrderService;
import com.zwl.service.impl.OrderServiceImpl;
import com.zwl.utils.JdbcUtils;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderServiceImplTest {

    OrderService orderService = new OrderServiceImpl();

    @Test
    public void createOrder() {
        Cart cart = new Cart();

        cart.addItem(new CartItem(1,"Java从入门到放弃",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"Java从入门到放弃",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"Python从入门到起飞",1,new BigDecimal(99),new BigDecimal(99)));

        System.out.println(orderService.createOrder(cart,1));

    }

    @Test
    public void myOrders() {

        System.out.println(orderService.myOrders(1));

    }

    @Test
    public void orderDetails() {

        System.out.println(orderService.orderDetails("16362024839201"));

    }

    @Test
    public void allOrders() {

        System.out.println(orderService.allOrders());

    }

    @Test
    public void sendOrder() {

        orderService.sendOrder("16362010189541");
        JdbcUtils.commitAndClose();

    }

    @Test
    public void receiveOrder() {

        orderService.receiveOrder("16362024839201");
        JdbcUtils.commitAndClose();

    }
}