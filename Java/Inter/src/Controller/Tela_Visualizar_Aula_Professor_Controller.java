
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Tela_Visualizar_Aula_Professor_Controller implements Initializable {
    
    @FXML
    private Button btnVoltar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    public void VoltarClicked(){
        Stage stageAtual = (Stage) btnVoltar.getScene().getWindow();
        stageAtual.close();
    }    
}
