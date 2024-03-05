package DAO;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDao {

    public Connection connectDB(){
        Connection connection = null;

        try{
            String url = "jdbc:mysql://localhost:3306/bancoteste?user=developer&password=123456";
            connection = DriverManager.getConnection(url);

        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return connection;
    }
}
