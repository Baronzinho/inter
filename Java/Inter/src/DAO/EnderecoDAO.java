package DAO;

import Model.Endereco;
import java.sql.ResultSet;
import java.sql.SQLException;
import Connection.SQL;


public class EnderecoDAO extends SQL{
    ResultSet rset;
    
    public ResultSet ultimoEndereco() throws SQLException{
         sql = "SELECT MAX(id_endereco) FROM endereco;";
         rset = select(sql);
        return rset;
     }
    
    public void inserirEndereco(Endereco newEndereco) throws SQLException{
        sql = "INSERT INTO Endereco (rua,bairro,cidade,numero,cep,complemento) VAlUES ('" + newEndereco.getRua() + "', '" + newEndereco.getBairro() + "', '" + newEndereco.getCidade() + "', '" + newEndereco.getNumero() + "', '" + newEndereco.getCep() + "', '" + newEndereco.getComplemento() + ", " + "');";
        update(sql);
     }
}
