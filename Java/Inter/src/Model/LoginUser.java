package Model;

import javax.swing.JOptionPane;



public class LoginUser {
    private int id_Login;
    private String cpf;
    private String senha;
    private String tipoUsuario;
        
    public int getId_login() {
        return id_Login;
    }

    public void setId_login(int id_login) {
        this.id_Login = id_login;
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
        return tipoUsuario;
    }

    public void setCargo(String cargo) {
        this.tipoUsuario = cargo;
    }
    
    public String verificacaoLogin(String cargoBanco){
        String Aluno = "Aluno";
        String Professor = "Professor";
        
        if (cargoBanco.equals("Aluno")){
            return Aluno;
        }
        else if (cargoBanco.equals("Professor")){
            return Professor;
        }
        else{
            JOptionPane.showMessageDialog(null, "Tipo de usuario não reconhecido!\n");
            return null;
        }
    }
}
