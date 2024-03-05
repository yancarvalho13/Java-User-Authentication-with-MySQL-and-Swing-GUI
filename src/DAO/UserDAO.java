package DAO;

import DTO.UserDTO;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    Connection connection;

    public ResultSet userAuthentication(UserDTO userDTO) {
        connection = new ConnectionDao().connectDB();

        try {
            String sql = "select * from user where name_user = ? and password_user = ? ";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, userDTO.getName_User());
            pstm.setString(2, userDTO.getPassword_User());

            ResultSet rs = pstm.executeQuery();
            return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }

    }
}
