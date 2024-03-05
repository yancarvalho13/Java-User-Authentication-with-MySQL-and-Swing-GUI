package application;

import VIEW.frmLoginVIEW;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Criando uma instância de frmLoginVIEW
        SwingUtilities.invokeLater(() -> {
            frmLoginVIEW loginView = new frmLoginVIEW();
            JFrame frame = new JFrame("Login");
            frame.setContentPane(loginView); // Adicionando o painel de login à moldura
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.pack();
            frame.setVisible(true);
        });
    }
}
