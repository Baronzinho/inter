package DAO;

import Connection.SQL;
import Model.AulaMarcada;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class AulaMarcadaDAO extends SQL{
    
    
    public void marcaAula(int id_Prof,int id_Aluno,LocalDate data, String hora )throws SQLException{
        String status = "Pendente";
        sql = "INSERT INTO Aula_Marcada (id_Professor,id_Aluno,data_Marcada,hora_Aula,statusDaAula) VALUES (" + id_Prof + ", " + id_Aluno + ", '" + data + "', '" + hora + "', '" + status +"');";
        update(sql);
     }
    
    public List <AulaMarcada> exibeAulasMarcadasAluno(int id_Aluno) {
        String status = "Confirmado";
        List<AulaMarcada> listaAulas = new ArrayList();
        sql = "SELECT * FROM AulasMarcadasAluno WHERE id_Aluno = " + id_Aluno + " AND statusDaAula = '" + status +"' ;";
        try {
            rset = select(sql);
            while (rset.next()) {
                AulaMarcada aula = new AulaMarcada();
                aula.setId_Aluno(rset.getInt(1));
                aula.setId_Professor(rset.getInt(2));
                aula.setId_Aula_Marcada(rset.getInt(3));
                aula.setNome(rset.getString(4));
                aula.setMateria_Professor(rset.getString(5));
                aula.setData_Aula(rset.getDate(6));
                aula.setHora_Aula(rset.getString(7));
                listaAulas.add(aula);
            }
        }catch (SQLException ex) {
            System.out.println("ERRO: Lista Não foi Retornada ");
            return null;
        }    
        return listaAulas;
    }
    
    public List <AulaMarcada> exibeAulasMarcadasAluno(int id_Aluno,String pesquisa) {
        String status = "Confirmado";
        List<AulaMarcada> listaAulas = new ArrayList();
        sql = "SELECT * FROM AulasMarcadasAluno WHERE id_Aluno = " + id_Aluno + " AND statusDaAula = '" + status +"' AND materia_Professor LIKE '%"+pesquisa+"%' OR nome LIKE '%"+pesquisa+"%';";
        try {
            rset = select(sql);
            while (rset.next()) {
                AulaMarcada aula = new AulaMarcada();
                aula.setId_Aluno(rset.getInt(1));
                aula.setId_Professor(rset.getInt(2));
                aula.setId_Aula_Marcada(rset.getInt(3));
                aula.setNome(rset.getString(4));
                aula.setMateria_Professor(rset.getString(5));
                aula.setData_Aula(rset.getDate(6));
                aula.setHora_Aula(rset.getString(7));
                listaAulas.add(aula);
            }
        }catch (SQLException ex) {
            System.out.println("ERRO: Lista Não foi Retornada ");
            return null;
        }    
        return listaAulas;
    }
    
    public ResultSet retornaAulaMarcada(int id) throws SQLException{
         sql = "SELECT data_Marcada, hora_Aula FROM Aula_Marcada where id_Professor = " + id + ";";
         rset = select(sql);
        return rset;
     }
}
