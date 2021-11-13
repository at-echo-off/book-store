package com.zwl.web;

import com.google.gson.Gson;
import com.zwl.pojo.Book;
import com.zwl.pojo.Cart;
import com.zwl.pojo.CartItem;
import com.zwl.service.BookService;
import com.zwl.service.impl.BookServiceImpl;
import com.zwl.utils.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CartServlet extends BaseServlet{

    BookService bookService = new BookServiceImpl();

    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        int id = WebUtils.parseInt(req.getParameter("id"),0);
        Book book = bookService.queryBookById(id);

        CartItem cartItem = new CartItem(book.getId(), book.getName(),1, book.getPrice(), book.getPrice());
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null){
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);
        req.getSession().setAttribute("lastName",cartItem.getName());

//        System.out.println(cart);

        resp.sendRedirect(req.getHeader("Referer"));

    }

    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        int id = WebUtils.parseInt(req.getParameter("id"),0);
        Book book = bookService.queryBookById(id);

        CartItem cartItem = new CartItem(book.getId(), book.getName(),1, book.getPrice(), book.getPrice());
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null){
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);
        req.getSession().setAttribute("lastName",cartItem.getName());

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("cartTotalCount",cart.getTotalCount());
        resultMap.put("cartLastBookName",cartItem.getName());

        Gson gson = new Gson();
        String resultJson = gson.toJson(resultMap);

        resp.getWriter().write(resultJson);
    }

    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        int id = WebUtils.parseInt(req.getParameter("id"),0);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null){
            cart.deleteCart(id);
            resp.sendRedirect(req.getHeader("Referer"));
        }

    }

    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null){
            cart.clear();
            resp.sendRedirect(req.getHeader("Referer"));
        }

    }

    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        int count = WebUtils.parseInt(req.getParameter("count"), 1);
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if (cart != null){
            cart.updateCount(id,count);
            resp.sendRedirect(req.getHeader("Referer"));
        }

    }
}











