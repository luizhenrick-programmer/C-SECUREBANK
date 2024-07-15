package c.securebank.controller;

import c.securebank.dao.DaoTransacao;
import c.securebank.model.Transacao;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class controllerTransacao {
    DaoTransacao dao = new DaoTransacao();
    
    public void inserirTransacao(int usuarioId, double valor, String descricao, LocalDateTime dataTransacao) throws SQLException {
        dao.inserirTransacao(usuarioId, valor, descricao, dataTransacao);
    }
    
    public List<Transacao> obterInformacoesTransacoes(String username) throws SQLException {
        List<Transacao> obterInformacoesTransacoes = dao.obterInformacoesTransacoes(username);
        return obterInformacoesTransacoes;
    }
}
