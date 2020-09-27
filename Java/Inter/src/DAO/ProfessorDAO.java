package DAO;

import Connection.SQL;
import Model.UserProfessor;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfessorDAO extends SQL{
    
    public ResultSet DadosProfessor(int idProf) throws SQLException {
        sql = "SELECT * FROM DadosProfessor WHERE id_Professor = " + idProf + ";";
        rset = select(sql);
        return rset;
     }
    
     public ResultSet DadosProfessorPeloIdUser(int idUser) throws SQLException {
        sql = "SELECT * FROM DadosProfessor WHERE id_User = " + idUser + ";";
        rset = select(sql);
        return rset;
     }
     
     public ResultSet retornaTotalGanho(int id) throws SQLException{
        sql = "SELECT sum(preco_Aula), avg(preco_Aula), count(id_Aula_Marcada) FROM Aula_Marcada "
                + "INNER JOIN Professor ON Aula_Marcada.id_Professor = Professor.id_Professor "
                + "WHERE Aula_Marcada.id_Professor = " + id + ";";
        rset = select(sql);
        return rset;
    }
    
    public ResultSet retornaProximaAula(int id) throws SQLException{
        sql = "SELECT min(data_Marcada) FROM Aula_Marcada "
                + "WHERE data_Marcada >= (SELECT CURRENT_TIMESTAMP)"
                + "AND Aula_Marcada.id_Professor = " + id + ";";
        rset = select(sql);
        return rset;
    }
}
