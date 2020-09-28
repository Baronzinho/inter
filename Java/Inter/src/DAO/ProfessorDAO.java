package DAO;

import Connection.SQL;
import Model.UserProfessor;
import Model.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfessorDAO extends SQL {

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

    public ResultSet retornaTotalGanho(int id) throws SQLException {
        sql = "SELECT sum(preco_Aula), avg(preco_Aula), count(id_Aula_Marcada) FROM Aula_Marcada "
                + "INNER JOIN Professor ON Aula_Marcada.id_Professor = Professor.id_Professor "
                + "WHERE Aula_Marcada.id_Professor = " + id + " AND Aula_Marcada.statusDaAula like '%Confirmado%';";
        rset = select(sql);
        return rset;
    }

    public ResultSet retornaProximaAula(int id) throws SQLException {
        sql = "SELECT DATE_FORMAT(min(data_Marcada),'%d/%m/%Y') FROM Aula_Marcada "
                + "WHERE data_Marcada >= (SELECT CURRENT_TIMESTAMP)"
                + "AND Aula_Marcada.id_Professor = " + id + ";";
        rset = select(sql);
        return rset;
    }

    public void atualizaUserProfessor(Usuario newUser) throws SQLException {
        sql = "UPDATE Usuario SET nome = '" + newUser.getNome() + "', "
                + "idade = " + newUser.getIdade() + ", "
                + "contato = '" + newUser.getContato() + "' "
                + "WHERE id_User = '" + newUser.getId_User() + "';";
        update(sql);
    }

    public void insereProfessor(UserProfessor newUser) throws SQLException {
        sql = "INSERT INTO Professor (id_User, descricao_Professor, preco_Aula, materia_Professor) "
                + "VALUES ('" + newUser.getId_User() + "', '"
                + newUser.getDescricao_Professor() + "', '"
                + newUser.getPreco_aula() + "', '"
                + newUser.getMateria_Professor() + "');";
        update(sql);
    }
}
