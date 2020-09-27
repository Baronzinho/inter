
package Controller;

import Model.Usuario;
import Model.Mensagens;
import Model.Mascara;
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

public class Tela_Login_Controller implements Initializable {
    
    @FXML
    private Mascara txtUsuario;
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
    
    Mascara mascara = new Mascara();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //txtUsuario.setMask("NNN.NNN.NNN-NN");
        txtUsuario.setMask("***********");
    }
    
    @FXML
    public void logar(ActionEvent event) throws IOException, SQLException{
        String usuarioBanco = null;
        String senhaBanco = null;
        Usuario user = new Usuario();
        Mensagens msg = new Mensagens();
        
        user = user.retornaUser(txtUsuario.getText(), txtSenha.getText());
             
        if(user.getId_User() == 0){
            msg.mensagemAviso("Usuario ou Senha incorretos!");
        }
        else{
            Stage stage = new Stage();
            Stage stageAtual = (Stage) txtUsuario.getScene().getWindow();
            Parent root=null;
            FXMLLoader loader = new FXMLLoader();
            
            if(user.getCargo().equals("Aluno")){
                
                root = loader.load(getClass().getResource("/View/Tela_Principal_Aluno.fxml").openStream());
                Tela_Principal_Aluno_Controller aController = (Tela_Principal_Aluno_Controller) loader.getController();
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
                
                aController.setLogin(user);
            }
            else if(user.getCargo().equals("Professor")){
                
                root = loader.load(getClass().getResource("/View/Tela_Principal_Professor.fxml").openStream());
                Tela_Principal_Professor_Controller aController = (Tela_Principal_Professor_Controller) loader.getController();
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
                
                aController.setLoginProf(user);
            }
            else{
                msg.mensagemErro("Cargo não esperado!");
            }
            stage.setScene(new Scene(root));
            stage.setTitle("Principal");
            stage.show();

            stageAtual.close();
        }
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
        Stage stageAtual = (Stage) linkCadastrar.getScene().getWindow(); 
        stageAtual.close();
    }
    
    @FXML
    private void sair(ActionEvent event){
        System.exit(0);
    }    
    
}
