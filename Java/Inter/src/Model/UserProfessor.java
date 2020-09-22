package Model;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserProfessor extends Usuario {
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
        
    public UserProfessor retornaUser(int idProf) throws SQLException{
     UserProfessor prof = new UserProfessor();
     DAO.ProfessorDAO profD = new DAO.ProfessorDAO();
     ResultSet rs;
     rs = profD.DadosProfessor(idProf);
     
      
     if(rs.next()){
         prof.setId_Professor(rs.getInt(1));
         prof.setImgUser(rs.getString(2));
         prof.setNome(rs.getString(3));
         prof.setId_endereco(rs.getInt(4));
         prof.setContato(rs.getString(5));
         prof.setDescricao_Professor(rs.getString(6));
         prof.setPreco_aula(rs.getString(7));
         prof.setMateria_Professor(rs.getString(8));
     }else{
         prof.setId_User(0);
     }
     
     
    return prof;
    }
    
}
