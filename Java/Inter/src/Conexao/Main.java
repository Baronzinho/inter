package Conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        try {
            Connection con = (Connection) BDFabricaConexao.getConnection();
            String sql = "SELECT * FROM empresa.empregado;";
            Statement stm = (Statement) con.createStatement();
            ResultSet rset = stm.executeQuery(sql);

            while (rset.next()) {
                System.out.print(rset.getInt("ssn") + " - ");
                System.out.println(rset.getString("pnome"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
