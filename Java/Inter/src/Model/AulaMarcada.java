package Model;

import java.util.Date;

public class AulaMarcada {
    private int id_Aula_Marcada;
    private int id_Professor;
    private int id_Aluno;
    private Date data_Aula;

    public int getId_Aula_Marcada() {
        return id_Aula_Marcada;
    }

    public void setId_Aula_Marcada(int id_Aula_Marcada) {
        this.id_Aula_Marcada = id_Aula_Marcada;
    }

    public int getId_Professor() {
        return id_Professor;
    }

    public void setId_Professor(int id_Professor) {
        this.id_Professor = id_Professor;
    }

    public int getId_Aluno() {
        return id_Aluno;
    }

    public void setId_Aluno(int id_Aluno) {
        this.id_Aluno = id_Aluno;
    }

    public Date getData_Aula() {
        return data_Aula;
    }

    public void setData_Aula(Date data_Aula) {
        this.data_Aula = data_Aula;
    }
    
    
}
