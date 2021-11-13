package com.zwl.service.impl;

import com.zwl.dao.BookDao;
import com.zwl.dao.impl.BookDaoImpl;
import com.zwl.pojo.Book;
import com.zwl.pojo.Page;
import com.zwl.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {

        bookDao.addBook(book);

    }

    @Override
    public void deleteBookById(Integer id) {

        bookDao.deleteBookById(id);

    }

    @Override
    public void updateBook(Book book) {

        bookDao.updateBook(book);

    }

    @Override
    public Book queryBookById(Integer id) {

        return bookDao.queryBookById(id);

    }

    @Override
    public List<Book> queryBooks() {

        return bookDao.queryBooks();

    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {

        Page<Book> page = new Page<>();

        page.setPageSize(pageSize);

        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);

        int pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0){
            pageTotal++;
        }
        page.setPageTotal(pageTotal);

        page.setPageNo(pageNo);

        Integer begin = (page.getPageNo() - 1) * pageSize;
        List<Book> books = bookDao.queryForPageItems(begin, pageSize);
        page.setItems(books);

        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<>();

        page.setPageSize(pageSize);

        Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(min,max);
        page.setPageTotalCount(pageTotalCount);

        int pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0){
            pageTotal++;
        }
        page.setPageTotal(pageTotal);

        page.setPageNo(pageNo);

        Integer begin = (page.getPageNo() - 1) * pageSize;
        List<Book> books = bookDao.queryForPageItemsByPrice(begin, pageSize, min, max);
        page.setItems(books);

        return page;
    }
}
