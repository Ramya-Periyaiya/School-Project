package com.School.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.School.bo.LoginBO;

public class LoginDao {
    public boolean checkLogin(LoginBO login) throws SQLException {
        boolean value = false;
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet r = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school2db", "root", "admin");
            String userName = login.getUserName();
            String password = login.getPasswords();

            // Correcting the SQL query and using a prepared statement
            String sql = "SELECT * FROM login WHERE userName=? AND passwords=?";
            statement = con.prepareStatement(sql);
            statement.setString(1, userName);
            statement.setString(2, password);

            r = statement.executeQuery();

            if (r.next()) {
                // If a record is found, set value to true
                value = true;
            }

            System.out.println("Connected successfully");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Closing resources properly in finally block
            if (r != null) {
                r.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return value;
    }
}
