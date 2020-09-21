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
    
    public ResultSet retornaEndereco(int id) throws SQLException{
         sql = "SELECT * FROM endereco where id_Endereco = " + id + ";";
         rset = select(sql);
        return rset;
     }
    
    
    public void inserirEndereco(Endereco newEndereco) throws SQLException{
        sql = "INSERT INTO Endereco (rua,bairro,cidade,numero,cep,complemento) VAlUES ('" + newEndereco.getRua() + "', '" + newEndereco.getBairro() + "', '" + newEndereco.getCidade() + "', '" + newEndereco.getNumero() + "', '" + newEndereco.getCep() + "', '" + newEndereco.getComplemento() + ", " + "');";
        update(sql);
     }
    
    public void updateEndereco(int id_Endereco,String rua, String bairro, String cidade, String numero, String cep, String complemento) throws SQLException {
        sql = "UPDATE Endereco SET rua = '" + rua + "', bairro = '" + bairro + "', cidade = '" + cidade + "', cep = '" + cep +"', complemento = '" + complemento +" WHERE id_Endereco = '" + id_Endereco + ";";
        update(sql);
    }
}
