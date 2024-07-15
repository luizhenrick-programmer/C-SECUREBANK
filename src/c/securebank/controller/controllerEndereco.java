package c.securebank.controller;
import c.securebank.dao.DaoEndereco;
import java.sql.SQLException;

public class controllerEndereco {
    DaoEndereco dao = new DaoEndereco();
    
    public void AtualizarRua(String username, String rua){
        dao.AtualizarRua(username, rua);
    }
    
    public void AtualizarNumeroCasa(String username, int rua){
        dao.AtualizarNumeroCasa(username, rua);
    }
    
    public void AtualizarSetor(String username, String rua){
        dao.AtualizarSetor(username, rua);
    }
    
    public void AtualizarCidade(String username, String rua){
        dao.AtualizarCidade(username, rua);
    }
    
    public void AtualizarEstado(String username, String rua){
        dao.AtualizarEstado(username, rua);
    }
    
    public void AtualizarCEP(String username, String rua){
        dao.AtualizarEstado(username, rua);
    }
    
    public void AtualizarComplemento(String username, String rua){
        dao.AtualizarComplemento(username, rua);
    }
}

