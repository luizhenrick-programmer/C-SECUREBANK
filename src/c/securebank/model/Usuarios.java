package c.securebank.model;

public class Usuarios {

    int id;
    String nome;
    String nascimento;
    String CPF;
    String RG;
    double saldo;
    String username;
    String password;
    int numero_conta;
    int id_endereco;

    public Usuarios(int id, String nome, String nascimento, String CPF, String RG, double saldo, String username, String password, int numero_conta, int id_endereco) {
        this.id = id;
        this.nome = nome;
        this.nascimento = nascimento;
        this.CPF = CPF;
        this.RG = RG;
        this.saldo = saldo;
        this.username = username;
        this.password = password;
        this.numero_conta = numero_conta;
        this.id_endereco = id_endereco;
    }
    

    public int getID() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNascimento() {
        return nascimento;
    }
    
    public String getCPF() {
        return CPF;
    }
    
    public String getRG() {
        return RG;
    }
    
    public double getsaldo() {
        return saldo;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public int getNumeroConta() {
        return numero_conta;
    }
    
    public int getIDEndereco() {
        return id_endereco;
    }
}
