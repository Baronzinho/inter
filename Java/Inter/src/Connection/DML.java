package Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DML extends SQL {

    
   /* public void inserir(String novoLogin) throws SQLException{
        sql = "INSERT INTO Login (cpf,senha,cargo,img) VALUES ('" + novoLogin.getCpf() + "', '" + novoLogin.getSenha() + "','"
                + novoLogin.getCargo() + "', '" + novoLogin.getImagem() + "');";
        update(sql);
    }*/

    public void updateLogin(String cpf, String senha, String cargo) throws SQLException {
        sql = "UPDATE Login  SET cpf = '" + cpf + "', senha = '" + senha + "', cargo = '" + cargo + " WHERE cpf = '" + cpf + ";";
        update(sql);
    }

    public void deleteLogin(int id_Login) throws SQLException {
        sql = "DELETE FROM Login WHERE id_Login = " + id_Login + ";";
        update(sql);
    }

    public void insertAluno(String nome_Aluno, int idade_Aluno, int endereco_Aluno, String contato_Aluno, int login) throws SQLException {
        sql = "INSERT INTO Aluno (nome_Aluno,idade_Aluno,endereco_Aluno,contato_Aluno,login) VALUES ( "
              + nome_Aluno + "', '" + idade_Aluno + "', '" + endereco_Aluno + "', '" + contato_Aluno + "', '" + login + "', ');";
        update(sql);
    }

    public void updateAluno(String nome_Aluno, int idade_Aluno, int endereco_Aluno, String contato_Aluno, int login) throws SQLException {
        sql = "UPDATE Aluno"
                + " SET nome_Aluno = '" + nome_Aluno
                + "', idade_Aluno = '" + idade_Aluno
                + "', endereco_Aluno = '" + endereco_Aluno
                + "', contato_Aluno = '" + contato_Aluno
                + "', login = '" + login
                + " WHERE login = '" + login + "';";
        update(sql);
    }

    public void deleteAluno(int id_aluno) throws SQLException {
        sql = "DELETE FROM Aluno WHERE id_aluno = '" + id_aluno + "';";
        update(sql);
    }
    
    public void insertEndereco(String rua, String bairro, String cidade, String numero, String cep, String complemento) throws SQLException {
        sql = "INSERT INTO Endereco (rua,bairro,cidade,numero,cep,complemento) VAlUES (" + rua + ", '" + bairro + "', '" + cidade + "', '" + numero + "', '" + cep + "', '" + complemento +"');";
        update(sql);
    }

    public void updateEndereco(int id_Endereco,String rua, String bairro, String cidade, String numero, String cep, String complemento) throws SQLException {
        sql = "UPDATE Endereco SET rua = '" + rua + "', bairro = '" + bairro + "', cidade = '" + cidade + "', cep = '" + cep +"', complemento = '" + complemento +" WHERE id_Endereco = '" + id_Endereco + ";";
        update(sql);
    }

    public void deleteEndereco(int id_Endereco) throws SQLException {
        sql = "DELETE FROM Endereco WHERE id_Endereco = " + id_Endereco + ";";
        update(sql);
    }
    
    public void insertProfessor(String nome_Professor, int idade_Professor, String descricao_Professor, float preco_Aula, int endereco_Professor, String contato_Professor, int login) throws SQLException {
        sql = "INSERT INTO Professor (nome_Professor,idade_Professor,cidade,numero,cep,complemento) VAlUES (" 
             + nome_Professor + ", '" + idade_Professor + "', '" + descricao_Professor + "', '" + preco_Aula + "', '" + endereco_Professor + "', '" + contato_Professor + "', '" + login +"');";
        update(sql);
    }

    public void updateProfessor(String nome_Professor, int idade_Professor, String descricao_Professor, float preco_Aula, int endereco_Professor, String contato_Professor, int login) throws SQLException {
        sql = "UPDATE Professor SET nome_Professor = '" + nome_Professor + "', idade_Professor = '" + idade_Professor + "', descricao_Professor = '" + descricao_Professor + "', preco_Aula = '" + preco_Aula +"', endereco_Professor = '" + endereco_Professor + "', contato_Professor = '" + contato_Professor +" WHERE login = '" + login + ";";
        update(sql);
    }

    public void deleteProfessor(int id_Professor) throws SQLException {
        sql = "DELETE FROM Professor WHERE id_Professor = " + id_Professor + ";";
        update(sql);
    }
    
    public void insertMateria(int id_Professor, String materia_Professor) throws SQLException {
        sql = "INSERT INTO Materia_Professor (id_Professor,materia_Professor) VAlUES (" 
             + id_Professor + ", '" + materia_Professor +"');";
        update(sql);
    }

    public void deleteMateria(int id_Professor) throws SQLException {
        sql = "DELETE FROM Materia_Professor WHERE id_Professor = " + id_Professor + ";";
        update(sql);
    }
    
     public void insertAula_Marcada(int id_Professor, int id_Aluno, String data_Marcada) throws SQLException {
        sql = "INSERT INTO Aula_Marcada (id_Professor,id_Aluno,data_Marcada) VAlUES (" 
             + id_Professor + ", '" + id_Aluno + ", '" + data_Marcada +"');";
        update(sql);
    }

    public void deleteAula_Marcada(int id_Aula_Marcada) throws SQLException {
        sql = "DELETE FROM Aula_Marcada WHERE id_Aula_Marcada = " + id_Aula_Marcada + ";";
        update(sql);
    }
}
