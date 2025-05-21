package controller;

import util.Conexao;

import java.sql.*;
import java.time.LocalDateTime;
import util.Conexao;
import util.Seguranca;

public class LoginService {
    public static boolean autenticar(String cpf, String senha, String otp) {
        boolean autenticado = false;

        try (Connection conn = Conexao.getConexao()) {
            String sql = "SELECT senha_hash, otp_ativo, otp_expiracao FROM usuario WHERE cpf = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String senhaHash = rs.getString("senha_hash");
                String otpAtivo = rs.getString("otp_ativo");
                Timestamp expiracao = rs.getTimestamp("otp_expiracao");

                String senhaMd5 = Seguranca.md5(senha);
                LocalDateTime agora = LocalDateTime.now();

                if (senhaMd5.equalsIgnoreCase(senhaHash)
                        && otp.equals(otpAtivo)
                        && expiracao != null
                        && agora.isBefore(expiracao.toLocalDateTime())) {
                    autenticado = true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return autenticado;
    }
}
