package c.securebank.dao;
import c.securebank.ConectaBD;
import c.securebank.model.Transacao;
import c.securebank.model.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoTransacao {
    private ConectaBD conexao;
    private List<Usuarios> listaUsuarios;
    
    public DaoTransacao() {
        this.conexao = new ConectaBD();
        this.conexao.getConnection();
        this.listaUsuarios = new ArrayList<>();
    }
    
    public void inserirTransacao(int usuarioId, double valor, String descricao, LocalDateTime dataTransacao) throws SQLException {
    String sql = "INSERT INTO Transacoes (usuario_id, valor, descricao, data_transacao) VALUES (?, ?, ?, ?)";

    try (Connection connection = conexao.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        preparedStatement.setInt(1, usuarioId);
        preparedStatement.setDouble(2, valor);
        preparedStatement.setString(3, descricao);
        Timestamp timestamp = Timestamp.valueOf(dataTransacao);
        preparedStatement.setTimestamp(4, timestamp);
        preparedStatement.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(DaoTransacao.class.getName()).log(Level.SEVERE, null, ex);
        throw ex; // Propaga a exceção para ser tratada no código que chama esta função
    }
}
    
    public List<Transacao> obterInformacoesTransacoes(String username) throws SQLException {
        String sql = "SELECT * FROM Transacoes INNER JOIN Usuarios ON Transacoes.usuario_id = Usuarios.id WHERE Usuarios.usuario = ?";
        List<Transacao> transacoes = new ArrayList<>();
        try (Connection connection = conexao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, username);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    double valor = resultSet.getDouble("valor");
                    String descricao = resultSet.getString("descricao");
                    Timestamp datahora = resultSet.getTimestamp("data_transacao");
                    transacoes.add(new Transacao(valor, descricao, String.valueOf(datahora)));
                }
                return transacoes;
            }
        }
    }
    
    
}

