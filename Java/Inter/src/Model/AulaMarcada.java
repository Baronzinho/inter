package Model;

import DAO.AulaMarcadaDAO;
import DAO.EnderecoDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class AulaMarcada extends UserProfessor{
    private int id_Aula_Marcada;
    private int id_Professor;
    private int id_Aluno;
    private Date data_Aula;
    private String status,hora_Aula;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHora_Aula() {
        return hora_Aula;
    }

    public void setHora_Aula(String hora_Aula) {
        this.hora_Aula = hora_Aula;
    }
    
    public AulaMarcada retornaAula(int idProfessor) throws SQLException{
        AulaMarcada aula = new AulaMarcada();
        ResultSet rs;
        AulaMarcadaDAO aulaD = new AulaMarcadaDAO();
    
        rs = aulaD.retornaAulaMarcada(idProfessor);
     
        if(rs.next()){
            aula.setData_Aula(rs.getDate(1));
            aula.setHora_Aula(rs.getString(2));
        }
        return aula;
    }
    
    public AulaMarcada vizualizaAulaMarcadaProfessor(int idAula) throws SQLException{
        AulaMarcada aula = new AulaMarcada();
        ResultSet rs;
        AulaMarcadaDAO aulaD = new AulaMarcadaDAO();
    
        rs = aulaD.retornaAulaMarcadaProfessor(idAula);
     
        if(rs.next()){
            aula.setNome(rs.getString(4));
            aula.setMateria_Professor(rs.getString(5));
            aula.setData_Aula(rs.getDate(6));
            aula.setHora_Aula(rs.getString(7));
            aula.setCargo(rs.getString(9));
            aula.setContato(rs.getString(10));
            aula.setImgUser(rs.getString(11));
        }
        return aula;
    }
}
