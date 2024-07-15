package c.securebank.dao;

import c.securebank.ConectaBD;
import c.securebank.view.login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class DaoUsuario {
    private ConectaBD conexao;
    
    public DaoUsuario() {
        this.conexao = new ConectaBD();
        this.conexao.getConnection();
    }
    
    public boolean VerificarLogin(String usernameDigitado, String senhaDigitada) {
        String sql = "SELECT * FROM Usuarios WHERE usuario = ? AND senha = ?";

        try (Connection connection = conexao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, usernameDigitado);
            preparedStatement.setString(2, senhaDigitada);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    JOptionPane.showInternalMessageDialog(null, "LOGIN REALIZADO COM SUCESSO!");
                    return true;
                } else {
                    JOptionPane.showInternalMessageDialog(null, "Falha ao efetivar login! Verifique seu usuario e senha...");
                    return false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public double obterSaldo(String usernameDigitado) {
        String sql = "SELECT saldo FROM Usuarios WHERE usuario = ?";

        try (Connection connection = conexao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, usernameDigitado);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getDouble("saldo");
                } else {
                    return 0.0;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0.0;
    }

    public boolean verificarNumeroContaExistente(int numeroConta) {
        String sql = "SELECT COUNT(*) AS count FROM Usuarios WHERE numero_conta = ?";

        try (Connection connection = conexao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, numeroConta);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt("count");
                    return count > 0;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public int obterNumeroConta(String username) throws SQLException {
        String sql = "SELECT numero_conta FROM Usuarios WHERE usuario = ?";

        try (Connection connection = conexao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, username);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("numero_conta");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return -1;
    }
    
    public String VerificarSenha(String usernameDigitado) {
        String sql = "SELECT senha FROM usuarios WHERE usuario = ?";

        try (Connection connection = conexao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, usernameDigitado);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("senha");
                } else {
                    return null;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String VerificarNomeConta(int numeroConta) {
        String sql = "SELECT usuario FROM usuarios WHERE numero_conta = ?";

        try (Connection connection = conexao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, numeroConta);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("usuario");
                } else {
                    return null;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int VerificarID(String usernameDigitado) {
        String sql = "SELECT id FROM usuarios WHERE usuario = ?";

        try (Connection connection = conexao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, usernameDigitado);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("id");
                } else {
                    return -1;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public void AtualizarNome(String usernameDigitado, String nome) {
        String sql = "UPDATE usuarios SET nome = ? WHERE usuario = ?;";

        try (Connection connection = conexao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, usernameDigitado);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void AtualizarUsername(String usernameDigitado, String username) {
        String sql = "UPDATE usuarios SET usuario = ? WHERE usuario = ?;";

        try (Connection connection = conexao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, usernameDigitado);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void AtualizarSenha(String usernameDigitado, String senha) {
        String sql = "UPDATE usuarios SET senha = ? WHERE usuario = ?;";

        try (Connection connection = conexao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, senha);
            preparedStatement.setString(2, usernameDigitado);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void AtualizarSaldo(String username, double novoSaldo) {
        String sql = "UPDATE Usuarios SET saldo = ? WHERE usuario = ?";

        try (Connection connection = conexao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDouble(1, novoSaldo);
            preparedStatement.setString(2, username);

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}
