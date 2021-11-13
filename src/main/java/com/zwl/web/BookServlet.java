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
import java.util.List;

public class BookServlet extends BaseServlet{

    private BookService bookService = new BookServiceImpl();

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Book> books = bookService.queryBooks();
        req.setAttribute("books",books);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);

    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),0);
        pageNo++;
        Book book = WebUtils.copyParamToBean(req.getParameterMap(),new Book());
        bookService.addBook(book);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);

    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        bookService.deleteBookById(WebUtils.parseInt(req.getParameter("id"),0));
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + req.getParameter("pageNo"));

    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Book book = bookService.queryBookById(WebUtils.parseInt(req.getParameter("id"), 0));
        req.setAttribute("book",book);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);

    }

    protected  void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        bookService.updateBook(WebUtils.copyParamToBean(req.getParameterMap(),new Book()));
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + req.getParameter("pageNo"));

    }

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        Page<Book> page = bookService.page(pageNo, pageSize);

        page.setUrl("/manager/bookServlet?action=page");

        req.setAttribute("page",page);

        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);

    }
}
