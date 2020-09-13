package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Tela_Cadastro_Controller implements Initializable {
    
    @FXML
    private TextField txtNomeUser;
    @FXML
    private TextField txtCpfUser;
    @FXML
    private TextField txtIdadeUser;
    @FXML
    private TextField txtTelefoneUser;
    @FXML
    private TextField txtPrecoAula;
    @FXML
    private TextField txtNumeroEndereco;
    @FXML
    private TextField txtRuaEndereco;
    @FXML
    private TextField txtBairroEndereco;
    @FXML
    private TextField txtCidadeEndereco;
    @FXML
    private TextField txtCepEndereco;
    @FXML
    private TextField txtComplementoEndereco;
    @FXML
    private TextField txtSenhaUser;
    @FXML
    private TextField txtConfirmSenhaUser;
    @FXML
    private RadioButton rbAluno;
    @FXML
    private RadioButton rbProfessor;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnCadastrar;
    
    @FXML
    private void CancelarCadastro(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/Tela_Login.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.DECORATED.UNDECORATED);
        
        stage.setScene(scene);
        stage.show();
        
        Stage stageAtual = (Stage) btnCancelar.getScene().getWindow(); //Obtendo a janela atual
        stageAtual.close();
    }
     @FXML
    private void CadastrarUser(ActionEvent event){
        
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
