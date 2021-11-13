package com.zwl.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {

    private static ThreadLocal<Connection> connThreadLocal = new ThreadLocal<>();

    private static DruidDataSource dataSource = null;

    static {
        try {
            Properties properties = new Properties();
            // 读取 jdbc.properties属性配置文件
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            // 从流中加载数据
            properties.load(inputStream);
            // 创建数据库连接池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取数据库连接池中的连接
     *
     * @return 如果返回null, 说明获取连接失败<br />有值就是获取连接成功
     */
    public static Connection getConnection() {
        Connection conn = connThreadLocal.get();

        if (conn == null) {
            try {
                conn = dataSource.getConnection();
                connThreadLocal.set(conn);
                conn.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return conn;
    }

    /**
     * 提交事务并关闭连接
     */
    public static void commitAndClose(){

        Connection connection = connThreadLocal.get();

        if (connection != null){
            try {
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        connThreadLocal.remove();
    }

    /**
     * 回滚事务并关闭连接
     */
    public static void rollbackAndClose(){

        Connection connection = connThreadLocal.get();

        if (connection != null){
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        connThreadLocal.remove();
    }

}
