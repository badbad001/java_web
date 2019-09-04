package cn.itcast.utils;



import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author: badbad
 * @Date: 2019/9/1 21:21
 * @Version 1.0
 */
public class JDBCUtils {
    private static DataSource ds;

    static {
        Properties prop = new Properties();
        try {
            prop.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));

            ds=DruidDataSourceFactory.createDataSource(prop);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource(){
        return ds;
    }

    public static Connection getConnnetion() throws SQLException {
        return ds.getConnection();
    }
}
