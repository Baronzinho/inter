package Model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuario {

    private int id_User, idade, id_endereco;
    private String cpf, senha, cargo, nome, contato, imgUser;

    public int getId_User() {
        return id_User;
    }

    public void setId_User(int id_User) {
        this.id_User = id_User;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(int id_endereco) {
        this.id_endereco = id_endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getImgUser() {
        return imgUser;
    }

    public void setImgUser(String imgUser) {
        this.imgUser = imgUser;
    }

    public Usuario retornaUser(String cpf, String senha) throws SQLException {
        Usuario user = new Usuario();
        DAO.UsuarioDAO userD = new DAO.UsuarioDAO();
        ResultSet rs;

        rs = userD.Login(cpf, senha);

        if (rs.next()) {
            user.setId_User(rs.getInt(1));
            user.setCpf(rs.getString(2));
            user.setSenha(rs.getString(3));
            user.setCargo(rs.getString(4));
            user.setImgUser(rs.getString(5));
            user.setNome(rs.getString(6));
            user.setIdade(rs.getInt(7));
            user.setId_endereco(rs.getInt(8));
            user.setContato(rs.getString(9));

        } else {
            user.setId_User(0);
        }

        return user;
    }

}
