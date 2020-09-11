/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Gabriel
 */
public class Tela_Login_Controller implements Initializable {
    
    @FXML
    private TextField txtUsuario;
    @FXML
    private TextField txtSenha;
    @FXML
    private Button btnLogar;

    protected ResultSet rset;
    protected String sql;
    
    @FXML
    public void logar(ActionEvent event) throws IOException, SQLException {        
        
        String usuarioBanco = null;
        String senhaBanco = null;
        String cargoBanco = null;
        ResultSet rset = null;

        Connection.DQL dql = new Connection.DQL("Login");
        
        rset = dql.selectLogin(txtUsuario.getText(), txtSenha.getText());
        
        Model.LoginUser login = new Model.LoginUser();
        
        if(!rset.isBeforeFirst()){
            JOptionPane.showMessageDialog(null, "Usuario ou Senha incorretos!");
        }
        else{
            while(rset.next()){
                if(!rset.getString("cargo").equals("")){
                    cargoBanco = rset.getString("cargo");

                    if(cargoBanco.equals("Aluno")){
                        JOptionPane.showMessageDialog(null, "Logou como Aluno!");
                    }
                    else if(cargoBanco.equals("Professor")){
                        JOptionPane.showMessageDialog(null, "Logou como Professor!");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Cargo não esperado!");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Erro Inesperado!");
                }
            }
        }
        
        
        /*
        if (cargoBanco.equals("Aluno")){
            
            if (usuarioBanco.equals(txtUsuario.getText()) && senhaBanco.equals(txtSenha.getText())) {
                Parent root = FXMLLoader.load(getClass().getResource("/View/Tela_Principal_Aluno.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

                Stage stageAtual = (Stage) btnLogar.getScene().getWindow(); //Obtendo a janela atual
                stageAtual.close();
            }else {
                JOptionPane.showMessageDialog(null, "Verifique se todos os campos estão preenchidos \n"
                + "e que seu Usuário e Senha estão corretos!\n");
            }
            
        }else if (cargoBanco.equals("Professor")){
            
            if (usuarioBanco.equals(txtUsuario.getText()) && senhaBanco.equals(txtSenha.getText())) {
                Parent root = FXMLLoader.load(getClass().getResource("/View/Tela_Pricipal_Professor.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

                Stage stageAtual = (Stage) btnLogar.getScene().getWindow(); //Obtendo a janela atual
                stageAtual.close();
            }else {
                JOptionPane.showMessageDialog(null, "Verifique se todos os campos estão preenchidos \n"
                + "e que seu Usuário e Senha estão corretos!\n");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Tipo de usuario não reconhecido!\n");
        } 
        */
    }
    
    @FXML
    private void sair(ActionEvent event){
        System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
