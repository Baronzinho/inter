
package Controller;

import Model.AulaMarcada;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Tela_Visualizar_Aula_Professor_Controller implements Initializable {
    
    @FXML
    private Button btnVoltar;
    @FXML
    private Label lblNomeAluno;
    @FXML
    private Label lblEnderecoAluno;
    @FXML
    private Label lblTelefoneAluno;
    @FXML
    private Label lblMateriaProfessor;
    @FXML
    private Label lblDataAula;
    @FXML
    private Label lblHorarioAula;
    @FXML
    private ImageView imgAluno;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
     public void setDadosAula(AulaMarcada aula){
         lblNomeAluno.setText(aula.getNome());
         lblEnderecoAluno.setText(aula.getCargo());
         lblTelefoneAluno.setText(aula.getContato());
         lblMateriaProfessor.setText(aula.getMateria_Professor());
         lblDataAula.setText(aula.getData_Aula().toString());
         lblHorarioAula.setText(aula.getHora_Aula());
         Image imgUser =  new Image(aula.getImgUser());
         imgAluno.setImage(imgUser);
     }

    @FXML
    public void VoltarClicked(){
        Stage stageAtual = (Stage) btnVoltar.getScene().getWindow();
        stageAtual.close();
    }    
}
