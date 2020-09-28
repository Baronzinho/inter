package DAO;

import Connection.SQL;
import Model.UserProfessor;
import Model.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO extends SQL {

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
        } catch (SQLException ex) {
            System.out.println("ERRO: Lista Não foi Retornada ");
            return null;
        }
        return listaProf;
    }

    public List<UserProfessor> getTodosProfessor(String pesquisa) {
        List<UserProfessor> listaProf = new ArrayList();
        sql = "SELECT * FROM ProcurarProfessor WHERE materia_Professor LIKE  '%" + pesquisa + "%';";
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
        } catch (SQLException ex) {
            System.out.println("ERRO: Lista Não foi Retornada ");
            return null;
        }
        return listaProf;
    }

    public void atualizarUsuario(Usuario newUser) throws SQLException {

        update(sql);
    }

    public ResultSet retornaTotalGasto(Usuario newUser) throws SQLException {
        sql = "SELECT sum(preco_Aula), avg(preco_Aula) FROM Aula_Marcada "
                + "INNER JOIN Professor ON Aula_Marcada.id_Professor = Professor.id_Professor "
                + "WHERE id_Aluno = " + newUser.getId_User() + ";";
        rset = select(sql);
        return rset;
    }

    public ResultSet retornaProximaAula(Usuario newUser) throws SQLException {
        sql = "SELECT DATE_FORMAT(min(data_Marcada),'%d/%m/%Y') FROM Aula_Marcada "
                + "WHERE data_Marcada >= (SELECT CURRENT_TIMESTAMP)"
                + "AND id_Aluno = " + newUser.getId_User() + ";";
        rset = select(sql);
        return rset;
    }

    public ResultSet retornaQtdAulasPendentes(Usuario newUser) throws SQLException {
        sql = "SELECT count(id_Aula_Marcada) FROM Aula_Marcada "
                + "INNER JOIN Professor ON Aula_Marcada.id_Professor = Professor.id_Professor "
                + "WHERE id_Aluno = " + newUser.getId_User() + " "
                + "AND data_Marcada >= (SELECT CURRENT_TIMESTAMP);";
        rset = select(sql);
        return rset;
    }
}
