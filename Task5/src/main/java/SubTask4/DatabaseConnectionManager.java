package SubTask4;

import java.sql.*;
import java.util.Properties;
public class DatabaseConnectionManager {

    public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private final String url;
    private final Properties properties;

    public DatabaseConnectionManager(String host, String databaseName,
                                     String username, String password) {
        this.url = "jdbc:mysql://" + host+ "/"+databaseName;
        this.properties = new Properties();
        this.properties.setProperty("user", username);
        this.properties.setProperty("password", password);
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER_NAME);
        return DriverManager.getConnection(this.url, this.properties);
    }

}