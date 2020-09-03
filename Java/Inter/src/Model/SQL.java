package Model;

import Conexao.BDFabricaConexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public abstract class SQL {

    protected ResultSet rset;
    protected String tabela, sql;

    public SQL(String tabela) {
        this.tabela = tabela;
    }

    protected void select(String sql) throws SQLException {
        try {
            Connection con = (Connection) BDFabricaConexao.getConnection();
            Statement stm = (Statement) con.createStatement();
            rset = stm.executeQuery(sql);
            while (rset.next()) {
                JOptionPane.showMessageDialog(null, "SELECT: " + rset.getString("name_manager"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    ResultSet getRset() {
        return rset;
    }

    String getTabela() {
        return tabela;
    }

    void setRset(ResultSet rset) {
        this.rset = rset;
    }

    void setTabela(String tabela) {
        this.tabela = tabela;
    }
}
