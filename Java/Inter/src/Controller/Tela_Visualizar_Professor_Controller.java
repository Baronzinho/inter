package Controller;

import Model.Endereco;
import Model.UserProfessor;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Tela_Visualizar_Professor_Controller implements Initializable {

    @FXML
    private Button btnVoltar;
    @FXML
    private TextArea txtDescricaoProfessor;
    @FXML
    private Label lblNomeProfessor;
    @FXML
    private Label lblMateriaProfessor;
    @FXML
    private Label lblPrecoAula;
    @FXML
    private Label lblEnderecoProfessor;
    @FXML
    private ImageView imgProfessor;

    @FXML
    public void VoltarClicked() {
        Stage stageAtual = (Stage) btnVoltar.getScene().getWindow();
        stageAtual.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtDescricaoProfessor.setEditable(false);
    }

    public void setDadosProfessor(UserProfessor user) throws SQLException {
        Endereco endereco = new Endereco();
        endereco = endereco.retornaEnderecoUser(user.getId_endereco());
        Image imgProf = new Image(user.getImgUser());
        lblNomeProfessor.setText(user.getNome());
        lblMateriaProfessor.setText(user.getMateria_Professor());
        lblPrecoAula.setText(user.getPreco_aula());
        lblEnderecoProfessor.setText(endereco.getBairro() + ", " + endereco.getRua() + " - " + endereco.getNumero());
        txtDescricaoProfessor.setText(user.getDescricao_Professor());
        imgProfessor.setImage(imgProf);
    }
}
