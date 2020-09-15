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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;
import javafx.stage.Stage;
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
    private Hyperlink linkCadastrar;
    @FXML
    private Button btnLogar;
    
    private double xOFFset = 0;
    private double yOFFset = 0;
    
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
                        FXMLLoader loader = new FXMLLoader();
                        //JOptionPane.showMessageDialog(null, "Logou como Aluno!");
                        Parent root = loader.load(getClass().getResource("/View/Tela_Principal_Aluno.fxml"));
                        Stage stage = new Stage();
                        Scene scene = new Scene(root);
                        stage.initStyle(StageStyle.DECORATED.UNDECORATED);

                        root.setOnMousePressed(new EventHandler<MouseEvent>(){
                            @Override
                            public void handle(MouseEvent event){
                                xOFFset = event.getSceneX();
                                yOFFset = event.getSceneY();
                            }
                        });

                        root.setOnMouseDragged(new EventHandler<MouseEvent>(){
                            @Override
                            public void handle(MouseEvent event){
                                stage.setX(event.getScreenX() - xOFFset);
                                stage.setY(event.getScreenY() - yOFFset);
                            }
                        });
                        
                        Tela_Principal_Aluno_Controller pa = (Tela_Principal_Aluno_Controller) loader.getController();
                        pa.SetLogin(txtUsuario.getText(), txtSenha.getText());
                        
                        stage.setScene(scene);
                        stage.show();
                                                
                        Stage stageAtual = (Stage) btnLogar.getScene().getWindow(); //Obtendo a janela atual
                        stageAtual.close();
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
    public void cadastrar() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Tela_Cadastro.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.DECORATED.UNDECORATED);
        
        root.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                xOFFset = event.getSceneX();
                yOFFset = event.getSceneY();
            }
        });
        
        root.setOnMouseDragged(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                stage.setX(event.getScreenX() - xOFFset);
                stage.setY(event.getScreenY() - yOFFset);
            }
        });
        
        stage.setScene(scene);
        stage.show();
        Stage stageAtual = (Stage) linkCadastrar.getScene().getWindow(); //Obtendo a janela atual
        stageAtual.close();
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
