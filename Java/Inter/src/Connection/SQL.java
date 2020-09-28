package Connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class SQL {

    protected ResultSet rset;
    protected String sql;

    protected ResultSet select(String sql) throws SQLException {
        try {
            Connection con = (Connection) BDFabricaConexao.getConnection();
            Statement stm = (Statement) con.createStatement();
            rset = stm.executeQuery(sql);

        } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rset;
    }

    protected void update(String sql) throws SQLException {
        try {
            Connection con = (Connection) BDFabricaConexao.getConnection();
            Statement stm = (Statement) con.createStatement();
            stm.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void conect(String sql) throws SQLException {
        try {
            Connection con = (Connection) BDFabricaConexao.getConnection();
            Statement stm = (Statement) con.createStatement();
            rset = stm.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
