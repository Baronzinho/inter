package Model;

import java.sql.Blob;

public class Professor {
    private int id_Professor;  
    private int idade_Professor;
    private int endereco_professor;
    private int login;
    private double preco_aula;
    private String nome_Professor;
    private String descricao_Professor;
    private Blob img_Aluno;

    public Blob getImg_Aluno() {
        return img_Aluno;
    }

    public void setImg_Aluno(Blob img_Aluno) {
        this.img_Aluno = img_Aluno;
    }
    
    public int getEndereco_professor() {
        return endereco_professor;
    }

    public void setEndereco_professor(int endereco_professor) {
        this.endereco_professor = endereco_professor;
    }

    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }

    
    public int getId_Professor() {
        return id_Professor;
    }

    public void setId_Professor(int id_Professor) {
        this.id_Professor = id_Professor;
    }

    public int getIdade_Professor() {
        return idade_Professor;
    }

    public void setIdade_Professor(int idade_Professor) {
        this.idade_Professor = idade_Professor;
    }

    public String getNome_Professor() {
        return nome_Professor;
    }

    public void setNome_Professor(String nome_Professor) {
        this.nome_Professor = nome_Professor;
    }

    public String getDescricao_Professor() {
        return descricao_Professor;
    }

    public void setDescricao_Professor(String descricao_Professor) {
        this.descricao_Professor = descricao_Professor;
    }

    public double getPreco_aula() {
        return preco_aula;
    }

    public void setPreco_aula(double preco_aula) {
        this.preco_aula = preco_aula;
    }
    
    
    
}
