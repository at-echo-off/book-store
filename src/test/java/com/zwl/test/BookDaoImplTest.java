package com.zwl.test;

import com.zwl.dao.BookDao;
import com.zwl.dao.impl.BookDaoImpl;
import com.zwl.pojo.Book;
import com.zwl.pojo.Page;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class BookDaoImplTest {

    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {

        bookDao.addBook(new Book(null,"Test","Test",new BigDecimal("99.99"),123,321,null));

    }

    @Test
    public void deleteBookById() {

        bookDao.deleteBookById(21);

    }

    @Test
    public void updateBook() {

        bookDao.updateBook(new Book(22,"Test3","Test",new BigDecimal("99.99"),123,321,null));
    }

    @Test
    public void queryBookById() {

        Book book = bookDao.queryBookById(22);
        System.out.println(book);

    }

    @Test
    public void queryBooks() {

        List<Book> books = bookDao.queryBooks();
        for (Book book : books) {
            System.out.println(book);
        }

    }

    @Test
    public void queryForPageTotalCount() {

        System.out.println(bookDao.queryForPageTotalCount());

    }

    @Test
    public void queryForPageItems() {

        for (Book book : bookDao.queryForPageItems(0, Page.PAGE_SIZE)) {
            System.out.println(book);
        }

    }

    @Test
    public void queryForPageTotalCountByPrice() {

        System.out.println(bookDao.queryForPageTotalCountByPrice(0,50));

    }

    @Test
    public void queryForPageItemsByPrice() {

        for (Book book : bookDao.queryForPageItemsByPrice(0, Page.PAGE_SIZE, 0, 50)) {
            System.out.println(book);
        }

    }
}