package Model;

import java.sql.Blob;

public class UserProfessor {
    private int id_Professor,id_User;
    private String descricao_Professor,preco_aula,materia_Professor;

    public int getId_Professor() {
        return id_Professor;
    }

    public void setId_Professor(int id_Professor) {
        this.id_Professor = id_Professor;
    }

    public int getId_User() {
        return id_User;
    }

    public void setId_User(int id_User) {
        this.id_User = id_User;
    }

    public String getDescricao_Professor() {
        return descricao_Professor;
    }

    public void setDescricao_Professor(String descricao_Professor) {
        this.descricao_Professor = descricao_Professor;
    }

    public String getPreco_aula() {
        return preco_aula;
    }

    public void setPreco_aula(String preco_aula) {
        this.preco_aula = preco_aula;
    }

    public String getMateria_Professor() {
        return materia_Professor;
    }

    public void setMateria_Professor(String materia_Professor) {
        this.materia_Professor = materia_Professor;
    }


    
    
}
