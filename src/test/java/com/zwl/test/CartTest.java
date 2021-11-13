package com.zwl.test;

import com.zwl.pojo.Cart;
import com.zwl.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartTest {

    @Test
    public void addItem() {

        Cart cart = new Cart();

        cart.addItem(new CartItem(1,"Java从入门到放弃",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"Java从入门到放弃",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"Python从入门到起飞",1,new BigDecimal(99),new BigDecimal(99)));

        System.out.println(cart);

    }

    @Test
    public void deleteCart() {

        Cart cart = new Cart();

        cart.addItem(new CartItem(1,"Java从入门到放弃",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"Java从入门到放弃",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"Python从入门到起飞",1,new BigDecimal(99),new BigDecimal(99)));

        cart.deleteCart(1);

        System.out.println(cart);

    }

    @Test
    public void clear() {

        Cart cart = new Cart();

        cart.addItem(new CartItem(1,"Java从入门到放弃",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"Java从入门到放弃",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"Python从入门到起飞",1,new BigDecimal(99),new BigDecimal(99)));

        cart.clear();

        System.out.println(cart);

    }

    @Test
    public void updateCount() {

        Cart cart = new Cart();

        cart.addItem(new CartItem(1,"Java从入门到放弃",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"Java从入门到放弃",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"Python从入门到起飞",1,new BigDecimal(99),new BigDecimal(99)));

        cart.clear();

        cart.addItem(new CartItem(1,"Java从入门到放弃",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"Java从入门到放弃",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"Python从入门到起飞",1,new BigDecimal(99),new BigDecimal(99)));

        cart.updateCount(1,3);

        System.out.println(cart);

    }
}