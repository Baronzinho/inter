/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Gabriel
 */
public class Tela_Visualizar_Professor_Controller implements Initializable {
    
    @FXML
    private Button btnVoltar;
    @FXML
    private TextArea txtDescricaoProfessor;
    
    @FXML
    public void VoltarClicked(){
        Stage stageAtual = (Stage) btnVoltar.getScene().getWindow();
        stageAtual.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtDescricaoProfessor.setEditable(false);
    }    
    
}
