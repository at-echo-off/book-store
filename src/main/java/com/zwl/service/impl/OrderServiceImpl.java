package com.zwl.service.impl;

import com.zwl.dao.BookDao;
import com.zwl.dao.OrderDao;
import com.zwl.dao.OrderItemDao;
import com.zwl.dao.impl.BookDaoImpl;
import com.zwl.dao.impl.OrderDaoImpl;
import com.zwl.dao.impl.OrderItemDaoImpl;
import com.zwl.pojo.*;
import com.zwl.service.OrderService;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {

        String orderId = System.currentTimeMillis() + "" + userId;
        Order order = new Order(orderId,new Date(),cart.getTotalPrice(),0,userId);
        orderDao.saveOrder(order);

        for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()){
            CartItem cartItem = entry.getValue();
            OrderItem orderItem = new OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(),orderId);
            orderItemDao.saveOrderItem(orderItem);

            Book book = bookDao.queryBookById(cartItem.getId());
            book.setSales(book.getSales() + cartItem.getCount());
            book.setStock(book.getStock() - cartItem.getCount());
            bookDao.updateBook(book);
        }

        cart.clear();

        return orderId;
    }

    @Override
    public List<Order> myOrders(Integer userId) {

        return orderDao.queryMyOrders(userId);

    }

    @Override
    public List<OrderItem> orderDetails(String orderId) {

        return orderItemDao.queryOrderDetailsByOrderId(orderId);

    }

    @Override
    public List<Order> allOrders() {

        return orderDao.queryAllOrders();

    }

    @Override
    public void sendOrder(String orderId) {

        Order order = orderDao.queryOrderByOrderId(orderId);

        Integer statue = order.getStatue();

        if (statue == 0){

            orderDao.changeOrder(orderId,1);

        }

    }

    @Override
    public void receiveOrder(String orderId) {

        Order order = orderDao.queryOrderByOrderId(orderId);

        Integer statue = order.getStatue();

        if (statue == 1){

            orderDao.changeOrder(orderId,2);

        }

    }
}
