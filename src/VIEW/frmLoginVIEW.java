package VIEW;

import DAO.UserDAO;
import DTO.UserDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class frmLoginVIEW extends JPanel {

    private JTextField username;

    private JPasswordField password;
    private JButton loginButton;

    public frmLoginVIEW() {
        initComponents();
    }

    public void initComponents() {
        setLayout(new BorderLayout());
        JPanel panel = new JPanel(new GridLayout(3, 1));
        username = new JTextField();
        password = new JPasswordField();
        loginButton = new JButton("Login");
        panel.add(new JLabel("Username"));
        panel.add(username);
        panel.add(new JLabel("Password"));
        panel.add(password);
        panel.add(loginButton);

        add(panel, BorderLayout.CENTER);
        loginButton.addActionListener(this::loginButtonActionPerformed);
    }

    private void loginButtonActionPerformed(java.awt.event.ActionEvent event) {
        Login();

    }

    public void Login() {
        try {
            String name_User, password_User;
            UserDTO userDTO = new UserDTO();
            userDTO.setName_User(username.getText());
            userDTO.setPassword_User(password.getText());

            UserDAO userDAO = new UserDAO();
            ResultSet rsUserDAO = userDAO.userAuthentication(userDTO);

            if (rsUserDAO.next()) {
                //Fecha a janela de Login atual
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
                frame.dispose();

                //Abre a janela nova do frmPrincipalVIEW
                SwingUtilities.invokeLater(() -> {
                    frmPrincipalVIEW principalVIEW = new frmPrincipalVIEW();
                    principalVIEW.setVisible(true);
                });
            } else {
                //Envia menssagem informando erro
                JOptionPane.showMessageDialog(null, "Invalid User or Password");
            }

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }

    }


}
