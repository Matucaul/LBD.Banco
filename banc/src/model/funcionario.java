package model;

public class funcionario {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String cargo;

    public funcionario() {}

    public funcionario(int id, String nome, String email, String senha, String cargo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cargo = cargo;
    }

    // getters e setters...
}
