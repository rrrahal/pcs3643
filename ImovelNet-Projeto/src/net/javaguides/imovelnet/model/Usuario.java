package net.javaguides.imovelnet.model;

public class Usuario {
    protected int idUsuario;
    protected String role;
    protected String cpf;
    protected String nome;
    protected String senha;
    protected String email;

    public Usuario(int id,  String nome, String role) {
        this.idUsuario = id;
        this.nome = nome;
        this.role = role;
    }
    public Usuario(int id,  String nome, String role, String CPF, String Email) {
        this.idUsuario = id;
        this.nome = nome;
        this.role = role;
        this.cpf = CPF;
        this.email = Email;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
