package c.securebank.dao;
import c.securebank.ConectaBD;
import c.securebank.view.login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoEndereco {
    private ConectaBD conexao;
    
    public DaoEndereco() {
        this.conexao = new ConectaBD();
        this.conexao.getConnection();
    }
    
    public void AtualizarRua(String usernameDigitado, String NovaRua) {
        String sql = "UPDATE usuarios INNER JOIN enderecos ON usuarios.endereco_id = enderecos.id SET enderecos.rua = ? WHERE usuarios.usuario = ?;";

        try (Connection connection = conexao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, NovaRua);
            preparedStatement.setString(2, usernameDigitado);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void AtualizarNumeroCasa(String usernameDigitado, int NumeroCasa) {
        String sql = "UPDATE usuarios INNER JOIN enderecos ON usuarios.endereco_id = enderecos.id SET enderecos.numero = ? WHERE usuarios.usuario = ?;";

        try (Connection connection = conexao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, NumeroCasa);
            preparedStatement.setString(2, usernameDigitado);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void AtualizarSetor(String usernameDigitado, String setor) {
        String sql = "UPDATE usuarios INNER JOIN enderecos ON usuarios.endereco_id = enderecos.id SET enderecos.setor = ? WHERE usuarios.usuario = ?;";

        try (Connection connection = conexao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, setor);
            preparedStatement.setString(2, usernameDigitado);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void AtualizarCidade(String usernameDigitado, String cidade) {
        String sql = "UPDATE usuarios INNER JOIN enderecos ON usuarios.endereco_id = enderecos.id SET enderecos.cidade = ? WHERE usuarios.usuario = ?;";

        try (Connection connection = conexao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, cidade);
            preparedStatement.setString(2, usernameDigitado);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void AtualizarEstado(String usernameDigitado, String estado) {
        String sql = "UPDATE usuarios INNER JOIN enderecos ON usuarios.endereco_id = enderecos.id SET enderecos.estado = ? WHERE usuarios.usuario = ?;";

        try (Connection connection = conexao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, estado);
            preparedStatement.setString(2, usernameDigitado);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void AtualizarCEP(String usernameDigitado, String cep) {
        String sql = "UPDATE usuarios INNER JOIN enderecos ON usuarios.endereco_id = enderecos.id SET enderecos.cep = ? WHERE usuarios.usuario = ?;";

        try (Connection connection = conexao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, cep);
            preparedStatement.setString(2, usernameDigitado);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void AtualizarComplemento(String usernameDigitado, String complemento) {
        String sql = "UPDATE usuarios INNER JOIN enderecos ON usuarios.endereco_id = enderecos.id SET enderecos.complemento = ? WHERE usuarios.usuario = ?;";

        try (Connection connection = conexao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, complemento);
            preparedStatement.setString(2, usernameDigitado);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
