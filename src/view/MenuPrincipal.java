package view;

import controller.LoginService;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal extends JFrame {

    public MenuPrincipal() {
        setTitle("Banco Malvader - Login");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 1));

        JLabel titulo = new JLabel("Bem-vindo ao Banco Malvader", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        add(titulo);

        JTextField cpfField = new JTextField();
        JPasswordField senhaField = new JPasswordField();
        JTextField otpField = new JTextField();

        add(new JLabel("CPF:"));
        add(cpfField);

        add(new JLabel("Senha:"));
        add(senhaField);

        add(new JLabel("OTP (6 dígitos):"));
        add(otpField);

        JPanel botoes = new JPanel();
        JButton botaoFuncionario = new JButton("Entrar como Funcionário");
        JButton botaoCliente = new JButton("Entrar como Cliente");
        JButton botaoSair = new JButton("Sair");

        botoes.add(botaoFuncionario);
        botoes.add(botaoCliente);
        botoes.add(botaoSair);

        add(botoes);

        // Ação de login para funcionário
        botaoFuncionario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cpf = cpfField.getText();
                String senha = new String(senhaField.getPassword());
                String otp = otpField.getText();

                boolean ok = LoginService.autenticar(cpf, senha, otp);

                if (ok) {
                    JOptionPane.showMessageDialog(null, "Login de Funcionário bem-sucedido!");
                    // Aqui você pode abrir a tela de menu do funcionário
                } else {
                    JOptionPane.showMessageDialog(null, "CPF, senha ou OTP inválidos.");
                }
            }
        });

        // Ação de login para cliente
        botaoCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cpf = cpfField.getText();
                String senha = new String(senhaField.getPassword());
                String otp = otpField.getText();

                boolean ok = LoginService.autenticar(cpf, senha, otp);

                if (ok) {
                    JOptionPane.showMessageDialog(null, "Login de Cliente bem-sucedido!");
                    // Aqui você pode abrir a tela de menu do cliente
                } else {
                    JOptionPane.showMessageDialog(null, "CPF, senha ou OTP inválidos.");
                }
            }
        });

        botaoSair.addActionListener(e -> System.exit(0));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuPrincipal().setVisible(true));
    }
}
