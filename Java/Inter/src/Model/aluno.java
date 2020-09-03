package Model;

import java.sql.Blob;

public class aluno {
    private int id_aluno;
    private int idade_Aluno;
    private int endereco_Aluno;
    private int login;
    private Blob img_Aluno;

    public Blob getImg_Aluno() {
        return img_Aluno;
    }

    public void setImg_Aluno(Blob img_Aluno) {
        this.img_Aluno = img_Aluno;
    }
    
    public int getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(int id_aluno) {
        this.id_aluno = id_aluno;
    }

    public int getIdade_Aluno() {
        return idade_Aluno;
    }

    public void setIdade_Aluno(int idade_Aluno) {
        this.idade_Aluno = idade_Aluno;
    }

    public int getEndereco_Aluno() {
        return endereco_Aluno;
    }

    public void setEndereco_Aluno(int endereco_Aluno) {
        this.endereco_Aluno = endereco_Aluno;
    }

    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }
    
    
}
