package com.zwl.web;

import com.zwl.pojo.Book;
import com.zwl.pojo.Page;
import com.zwl.service.BookService;
import com.zwl.service.impl.BookServiceImpl;
import com.zwl.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientBookServlet extends BaseServlet{

    private BookService bookService = new BookServiceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        Page<Book> page = bookService.page(pageNo, pageSize);

        page.setUrl("/client/bookServlet?action=page");

        req.setAttribute("page",page);

        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);

    }

    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(req.getParameter("min"),0);
        int max = WebUtils.parseInt(req.getParameter("max"),Integer.MAX_VALUE);

        Page<Book> page = bookService.pageByPrice(pageNo, pageSize, min, max);

        String url = "/client/bookServlet?action=pageByPrice";

        if (req.getParameter("min") != null){
            url += "&min=" + req.getParameter("min");
        }
        if (req.getParameter("max") != null){
            url += "&max=" + req.getParameter("max");
        }

        page.setUrl(url);

        req.setAttribute("page",page);

        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);

    }
}
