package com.zwl.web;

import com.zwl.pojo.Cart;
import com.zwl.pojo.Order;
import com.zwl.pojo.OrderItem;
import com.zwl.pojo.User;
import com.zwl.service.OrderService;
import com.zwl.service.impl.OrderServiceImpl;
import com.zwl.utils.JdbcUtils;
import com.zwl.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class OrderServlet extends BaseServlet{

    private OrderService orderService = new OrderServiceImpl();

    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cart cart = (Cart) req.getSession().getAttribute("cart");
        User loginUser = (User) req.getSession().getAttribute("user");
        if (loginUser == null){
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }
        Integer userId = loginUser.getId();

        String orderId = orderService.createOrder(cart, userId);

        req.getSession().setAttribute("orderId",orderId);

        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");

    }

    protected void myOrders(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        User user = (User) req.getSession().getAttribute("user");
        Integer userId = user.getId();

        List<Order> myOrderList = orderService.myOrders(userId);

        req.setAttribute("myOrderList",myOrderList);

        req.getRequestDispatcher("/pages/order/order.jsp").forward(req,resp);

    }

    protected void orderDetails(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String orderId = req.getParameter("orderId");

        List<OrderItem> orderDetails = orderService.orderDetails(orderId);

        req.setAttribute("orderDetails",orderDetails);

        req.getRequestDispatcher("/pages/order/orderDetails.jsp").forward(req,resp);
    }


    protected void receiveOrder(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String orderId = req.getParameter("orderId");

        orderService.receiveOrder(orderId);

        resp.sendRedirect(req.getContextPath() + "/orderServlet?action=myOrders");

    }
}
