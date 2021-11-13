package com.zwl.test;

import com.zwl.pojo.Book;
import com.zwl.pojo.Page;
import com.zwl.service.BookService;
import com.zwl.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookServiceImplTest {

    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {

        bookService.addBook(new Book(null,"Test","Test",new BigDecimal("99.99"),123,321,null));

    }

    @Test
    public void deleteBookById() {

        bookService.deleteBookById(21);

    }

    @Test
    public void updateBook() {

        bookService.updateBook(new Book(21,"Test1","Test1",new BigDecimal("99.99"),123,321,null));

    }

    @Test
    public void queryBookById() {

        System.out.println(bookService.queryBookById(21));

    }

    @Test
    public void queryBooks() {

        for (Book queryBook : bookService.queryBooks()) {
            System.out.println(queryBook);
        }

    }

    @Test
    public void page() {

        System.out.println(bookService.page(2, Page.PAGE_SIZE));

    }

    @Test
    public void pageByPrice() {

        System.out.println(bookService.pageByPrice(0,Page.PAGE_SIZE,0,50));

    }
}