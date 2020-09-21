
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Tela_Marcar_Aula_Controller implements Initializable {

    @FXML
    private Button btnVoltar;
    @FXML
    private TextField txtHorarioAula;
    
    @FXML
    public void VoltarClicked(){
        Stage stageAtual = (Stage) btnVoltar.getScene().getWindow();
        stageAtual.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
