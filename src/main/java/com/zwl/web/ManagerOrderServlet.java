package com.zwl.web;

import com.zwl.pojo.Order;
import com.zwl.service.OrderService;
import com.zwl.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ManagerOrderServlet extends BaseServlet{

    private OrderService orderService = new OrderServiceImpl();

    protected void allOrders(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        List<Order> allOrders = orderService.allOrders();

        req.setAttribute("allOrders",allOrders);

        req.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(req,resp);
    }

    protected void sendOrder(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String orderId = req.getParameter("orderId");

        orderService.sendOrder(orderId);

        resp.sendRedirect(req.getContextPath() + "/manager/managerOrderServlet?action=allOrders");

    }


}
