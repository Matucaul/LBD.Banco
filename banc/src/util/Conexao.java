package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    public static Connection getConexao() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/banco_malvader", "root", "sua_senha");
        } catch (Exception e) {
            throw new RuntimeException("Erro ao conectar ao banco", e);
        }
    }
}