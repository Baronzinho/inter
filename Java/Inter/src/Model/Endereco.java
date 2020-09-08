package Model;

public class Endereco {
    private int id_Endereco;
    private String rua;
    private String bairro;
    private String cidade;
    private String complemento;
    private char numero;

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

    public char getNumero() {
        return numero;
    }

    public void setNumero(char numero) {
        this.numero = numero;
    }
    
    
}
