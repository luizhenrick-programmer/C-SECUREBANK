package c.securebank.controller;
import c.securebank.dao.DaoCadastro;
import java.sql.SQLException;

public class controllerCadastro {
    DaoCadastro dao = new DaoCadastro();
    
    public int inserirEndereco(String rua, int numero, String setor, String cidade, String estado, String cep, String complemento) throws SQLException{
        int endereco = dao.inserirEndereco(rua, numero, setor, cidade, estado, cep, complemento);
        return endereco;
    }
    
    public void inserirUsuario(String nome, String nascimento, String CPF, String RG, double saldo, String usuario, String senha, int NumeroConta, int EnderecoID) throws SQLException {
        dao.inserirUsuario(nome, nascimento, CPF, RG, saldo, usuario, senha, NumeroConta, EnderecoID);
    }
}
