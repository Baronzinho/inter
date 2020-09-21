package Model;

import DAO.EnderecoDAO;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Endereco {
    private int id_Endereco;
    private String rua;
    private String bairro;
    private String cidade;
    private String complemento;
    private String numero;
    private String cep;

    public int getId_Endereco() {
        return id_Endereco;
    }

    public void setId_Endereco(int id_Endereco) {
        this.id_Endereco = id_Endereco;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    public Endereco retornaEnderecoUser(int idEndereco) throws SQLException{
    Endereco enderecoUser = new Endereco();
    ResultSet rs;
    EnderecoDAO enderecoD = new EnderecoDAO();
    
    rs = enderecoD.retornaEndereco(idEndereco);
     
     if(rs.next()){
         enderecoUser.setId_Endereco(rs.getInt(1));
         enderecoUser.setRua(rs.getString(2));
         enderecoUser.setBairro(rs.getString(3));
         enderecoUser.setCidade(rs.getString(4));
         enderecoUser.setNumero(rs.getString(5));
         enderecoUser.setCep(rs.getString(6));
         enderecoUser.setComplemento(rs.getString(7));
     }
    
        return enderecoUser;
    }
}
