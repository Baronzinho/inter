package DAO;

import Connection.SQL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

public class AulaMarcadaDAO extends SQL{
    
    
    public void marcaAula(int id_Prof,int id_Aluno,LocalDate data, String hora )throws SQLException{
        String status = "Pendente";
        sql = "INSERT INTO Aula_Marcada (id_Professor,id_Aluno,data_Marcada,hora_Aula,statusDaAula) VALUES (" + id_Prof + ", " + id_Aluno + ", '" + data + "', '" + hora + "', '" + status +"');";
        update(sql);
     }
    
}
