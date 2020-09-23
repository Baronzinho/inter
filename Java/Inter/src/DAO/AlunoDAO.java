
package DAO;

import Connection.SQL;
import Model.UserProfessor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AlunoDAO extends SQL{
    
    
    public List<UserProfessor> getTodosProfessor() {
        List<UserProfessor> listaProf = new ArrayList();
        sql = "SELECT * FROM ProcurarProfessor;"; 
        try {
            rset = select(sql);
            while (rset.next()) {
                UserProfessor prof = new UserProfessor();
                prof.setId_Professor(rset.getInt(1));
                prof.setNome(rset.getString(2));
                prof.setMateria_Professor(rset.getString(3));
                prof.setPreco_aula(rset.getString(4));
                listaProf.add(prof);
            }
        }catch (SQLException ex) {
            System.out.println("ERRO: Lista Não foi Retornada ");
            return null;
        }    
        return listaProf;
    }
    
    public List<UserProfessor> getTodosProfessor(String pesquisa) {
        List<UserProfessor> listaProf = new ArrayList();
        sql = "SELECT * FROM ProcurarProfessor WHERE materia_Professor LIKE  '%"+pesquisa+"%';"; 
        try {
            rset = select(sql);
            while (rset.next()) {
                UserProfessor prof = new UserProfessor();
                prof.setId_Professor(rset.getInt(1));
                prof.setNome(rset.getString(2));
                prof.setMateria_Professor(rset.getString(3));
                prof.setPreco_aula(rset.getString(4));
                listaProf.add(prof);
            }
        }catch (SQLException ex) {
            System.out.println("ERRO: Lista Não foi Retornada ");
            return null;
        }    
        return listaProf;
    }
    
    
    
    
    
    
    
    
    
}
