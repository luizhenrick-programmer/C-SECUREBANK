package c.securebank;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConectaBD {
    private Connection conexao;

    public Connection getConnection() {
        try {
            String user = "root";
            String password = "";
            String url = "jdbc:mysql://localhost:3306/csecurebank";
            
            conexao = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão bem-sucedida com o banco de dados.");
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar ao banco de dados: " + ex.getMessage());
        }
        return conexao;
    }
    
    public void fecharConexao() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
                System.out.println("Conexão com o banco de dados fechada com sucesso.");
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao fechar a conexão com o banco de dados: " + ex.getMessage());
        }
    }
}
