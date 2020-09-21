
package DAO;

import Connection.SQL;
import Model.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;



public class UsuarioDAO extends SQL{
    ResultSet rset;
        
     public ResultSet Login(String cpf,String senha) throws SQLException {
        sql = "SELECT * FROM Usuario WHERE cpf = '" + cpf + "' AND senha = '" + senha + "';";
        rset = select(sql);
        return rset;
     }
     
     public void inserirUsuario(Usuario newUser)throws SQLException{
         EnderecoDAO endeDAO = new EnderecoDAO();
         ResultSet endereco = endeDAO.ultimoEndereco();
         if(endereco.next()){
             newUser.setId_endereco(endereco.getInt(1));
         }
         
        sql = "INSERT INTO Usuario (cpf,senha,cargo,img, nome, idade, endereco,contato) VALUES ('" + newUser.getCpf() + "', '" + newUser.getSenha() + "', '" + newUser.getCargo() + "', '" + newUser.getImgUser() + "', '" + newUser.getNome() + "', " + newUser.getIdade() + ", " + newUser.getId_endereco() + ", '" + newUser.getContato() + "');";
        update(sql);
     }
     
     
     public void updateUser(int id_User,String nome, int idade, String telefone) throws SQLException {
        sql = "UPDATE Usuario SET nome = '" + nome + "', idade = " + idade + ", contato = '" + telefone + "' WHERE id_User = '" + id_User + ";";
        update(sql);
    }
     
}
