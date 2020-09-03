package Conexao;

import java.sql.Connection;

public class BDFabricaConexao {

    public static Connection getConnection() {

        return new BDConexaoMySQL().getConnection();

    }

}
