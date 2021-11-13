package com.zwl.dao;

import com.zwl.pojo.Book;

import java.util.List;

public interface BookDao {
    /**
     * 向数据库中添加图书信息
     * @param book 添加的图书信息
     * @return 返回-1表示添加失败<br/>返回1表示添加成功
     */
    public int addBook(Book book);

    /**
     * 删除数据库中指定id的图书
     * @param id 要删除的图书的id
     * @return 返回-1表示删除失败<br/>返回1表示删除成功
     */
    public int deleteBookById(Integer id);

    /**
     * 修改图书信息<br/>注意：需要在book中指定id
     * @param book 要修改的图书信息
     * @return 返回-1表示修改失败<br/>返回1表示修改成功
     */
    public int updateBook(Book book);

    /**
     * 查询指定id的图书信息
     * @param id 要查询的图书的id
     * @return 返回null表示查询失败<br/>否则返回指定id的图书信息
     */
    public Book queryBookById(Integer id);

    /**
     * 查询所有图书的信息
     * @return 返回所有图书信息
     */
    public List<Book> queryBooks();

    /**
     * 查询总条目数
     * @return 返回总条目数
     */
    public Integer queryForPageTotalCount();

    /**
     * 查询当前页面的图书列表
     * @param begin 起始行
     * @param pageSize 每页行数
     * @return 返回图书列表
     */
    public List<Book> queryForPageItems(Integer begin, int pageSize);

    /**
     * 按照价格区间查询条目数
     * @param min 价格最小值
     * @param max 价格最大值
     * @return 返回查询到的条目数
     */
    public Integer queryForPageTotalCountByPrice(int min, int max);

    /**
     * 查询价格区间的图书信息
     * @param begin 起始行
     * @param pageSize 每页行数
     * @param min 价格最小值
     * @param max 价格最大值
     * @return 返回查询到的图书信息列表
     */
    public List<Book> queryForPageItemsByPrice(Integer begin, int pageSize, int min, int max);
}
