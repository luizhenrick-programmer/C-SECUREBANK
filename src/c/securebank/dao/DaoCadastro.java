package c.securebank.dao;
import c.securebank.ConectaBD;
import c.securebank.model.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DaoCadastro {
    private ConectaBD conexao;
    private List<Usuarios> listaUsuarios;
    
    public DaoCadastro() {
        this.conexao = new ConectaBD();
        this.conexao.getConnection();
        this.listaUsuarios = new ArrayList<>();
    }
    
    public int inserirEndereco(String rua, int numero, String setor, String cidade, String estado, String cep, String complemento) throws SQLException {
        String sql = "INSERT INTO Enderecos (rua, numero, setor, cidade, estado, cep, complemento) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = conexao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, rua);
            preparedStatement.setInt(2, numero);
            preparedStatement.setString(3, setor);
            preparedStatement.setString(4, cidade);
            preparedStatement.setString(5, estado);
            preparedStatement.setString(6, cep);
            preparedStatement.setString(7, complemento);

            preparedStatement.executeUpdate();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    JOptionPane.showInternalMessageDialog(null, "ERRO AO TENTAR CADASTRAR USUÁRIO!");
                }
            }
        }
        return 0;
    }

    public void inserirUsuario(String nome, String nascimento, String CPF, String RG, double saldo, String usuario, String senha, int NumeroConta, int EnderecoID) throws SQLException {
        int novoID = -1;  // Valor padrão indicando falha no cadastro

        String sql = "INSERT INTO Usuarios (nome, nascimento, CPF, RG, saldo, usuario, senha, numero_conta, endereco_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = conexao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, nascimento);
            preparedStatement.setString(3, CPF);
            preparedStatement.setString(4, RG);
            preparedStatement.setDouble(5, saldo);
            preparedStatement.setString(6, usuario);
            preparedStatement.setString(7, senha);
            preparedStatement.setInt(8, NumeroConta);
            preparedStatement.setInt(9, EnderecoID);
            preparedStatement.executeUpdate();
            
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    novoID = generatedKeys.getInt(1);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showInternalMessageDialog(null, "ERRO AO TENTAR CADASTRAR USUÁRIO!");
            System.out.println(ex);
        }

        if (novoID != -1) {
            Usuarios novoUsuario = new Usuarios(novoID, nome, nascimento, CPF, RG, saldo, usuario, senha, NumeroConta, EnderecoID);
            listaUsuarios = new ArrayList<>();
            listaUsuarios.add(novoUsuario);
        }

    }
}
