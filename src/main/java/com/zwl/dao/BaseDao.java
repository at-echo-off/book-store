package com.zwl.dao;

import com.zwl.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {

    private QueryRunner queryRunner = new QueryRunner();

    /**
     * update()方法用来执行：Insert\Update\Delete语句
     * @param sql sql语句
     * @param objs 占位符内容
     * @return 返回影响行数
     */
    public int update(String sql,Object ... objs){
        Connection connection = JdbcUtils.getConnection();

        try {
            return queryRunner.update(connection,sql,objs);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    /**
     * queryForOne()方法用于查询返回一个JavaBean的sql语句
     * @param sql sql语句
     * @param type 返回的对象类型
     * @param objs 占位符内容
     * @param <T> 返回的类型的泛型类型
     * @return 返回一个JavaBean对象
     */
    public <T> T queryForOne(String sql,Class<T> type,Object ... objs){
        Connection connection = JdbcUtils.getConnection();

        try {
            return queryRunner.query(connection,sql,new BeanHandler<T>(type),objs);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    /**
     * queryForOne()方法用于查询返回多个个JavaBean的sql语句
     * @param sql sql语句
     * @param type 返回的对象类型
     * @param objs 占位符内容
     * @param <T> 返回的类型的泛型类型
     * @return 返回JavaBean对象列表
     */
    public <T> List<T> queryForList(String sql, Class<T> type, Object ... objs){
        Connection connection = JdbcUtils.getConnection();

        try {
            return queryRunner.query(connection,sql,new BeanListHandler<T>(type),objs);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    /**
     * 执行返回一行一列的sql语句
     * @param sql sql语句
     * @param objs 占位符内容
     * @return 返回单个值
     */
    public Object queryForSingleValue(String sql, Object ... objs){
        Connection connection = JdbcUtils.getConnection();

        try {
            return queryRunner.query(connection,sql,new ScalarHandler(),objs);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

}





