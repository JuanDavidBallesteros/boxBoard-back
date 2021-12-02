package sql;

import java.sql.*;

public class MySQL {

    private Connection connection;

    public MySQL(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void connection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://200.3.193.22:3306/P09728_1_11","P09728_1_11","ZCSaQGZU");
    }

    public void close() throws SQLException {
        connection.close();
    }
    // select
    public ResultSet getDataMySQL(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(sql);
    }

    //Comandos: DELETE, EDIT, INSERT
    public void comandSQL(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
    }

}