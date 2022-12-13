package JDBC;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCutils {
    private  static DataSource dateSource=null;
    static {
        try {
            Properties properties = new Properties();
            InputStream resourceAsStream = JDBCutils.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(resourceAsStream);
            dateSource= DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection connection () throws SQLException{
        return dateSource.getConnection();
    }
    public static void close(ResultSet resultSet, Statement statement, Connection connection){
        try {
            if(resultSet!=null)
                resultSet.close();
            if(statement!=null)
                statement.close();
            if(connection!=null)
                connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void close(Statement statement, Connection connection){
        close(null,statement,connection);
    }

    public static DataSource getDateSource() {
        return dateSource;
    }
}
