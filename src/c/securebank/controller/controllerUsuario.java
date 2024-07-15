package c.securebank.controller;

import c.securebank.dao.DaoUsuario;
import java.sql.SQLException;

public class controllerUsuario {
    DaoUsuario dao = new DaoUsuario();
    
    public boolean VerificarLogin(String usernameDigitado, String senhaDigitada) {
        boolean login =  dao.VerificarLogin(usernameDigitado, senhaDigitada);
        return login;
    }
    
    public double obterSaldo(String usernameDigitado) {
        double saldo = dao.obterSaldo(usernameDigitado);
        return saldo;
    }
    
    public boolean verificarNumeroContaExistente(int numeroConta) {
        boolean conta = dao.verificarNumeroContaExistente(numeroConta);
        return conta;
    }
    
    public int obterNumeroConta(String username) throws SQLException {
        int conta = dao.obterNumeroConta(username);
        return conta;
    }
    
    public String VerificarSenha(String usernameDigitado) {
        String senha = dao.VerificarSenha(usernameDigitado);
        return senha;
    }
    
    public String VerificarNomeConta(int numeroConta) {
        String NomeConta = dao.VerificarNomeConta(numeroConta);
        return NomeConta;
    }
    
    public int VerificarID(String usernameDigitado) {
        int id = dao.VerificarID(usernameDigitado);
        return id;
    }
    
    public void AtualizarNome(String usernameDigitado, String nome) {
        dao.AtualizarNome(usernameDigitado, nome);
    }
    
    public void AtualizarUsername(String usernameDigitado, String nome) {
        dao.AtualizarUsername(usernameDigitado, nome);
    }
    
    public void AtualizarSenha(String usernameDigitado, String nome) {
        dao.AtualizarSenha(usernameDigitado, nome);
    }
    
    public void AtualizarSaldo(String usernameDigitado, double saldo) {
        dao.AtualizarSaldo(usernameDigitado, saldo);
    }
}
