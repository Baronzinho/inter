package DAO;

import Connection.SQL;
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
}
