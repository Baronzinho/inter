package Controller;

import Model.Endereco;
import Model.UserProfessor;
import Model.AulaMarcada;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Tela_Visualizar_Aula_Controller implements Initializable {

    @FXML
    private Button btnVoltar;
    @FXML
    private Label lblNomeProfessor;
    @FXML
    private Label lblMateriaProfessor;
    @FXML
    private Label lblDataMarcada;
    @FXML
    private Label lblEnderecoProfessor;
    @FXML
    private Label lblPrecoAula;
    @FXML
    private Label lblHoraMarcada;
    @FXML
    private TextArea txtDescricaoProfessor;

    @FXML
    public void VoltarClicked() {
        Stage stageAtual = (Stage) btnVoltar.getScene().getWindow();
        stageAtual.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtDescricaoProfessor.setEditable(false);
    }

    public void setDadosAula(UserProfessor user) throws SQLException {
        AulaMarcada aula = new AulaMarcada();
        Endereco endereco = new Endereco();
        endereco = endereco.retornaEnderecoUser(user.getId_endereco());
        aula = aula.retornaAula(user.getId_Professor());
        lblDataMarcada.setText(aula.getData_Aula().toString());
        lblHoraMarcada.setText(aula.getHora_Aula());
        lblNomeProfessor.setText(user.getNome());
        lblMateriaProfessor.setText(user.getMateria_Professor());
        lblPrecoAula.setText(user.getPreco_aula());
        lblEnderecoProfessor.setText(endereco.getBairro() + ", " + endereco.getRua() + " - " + endereco.getNumero());
        txtDescricaoProfessor.setText(user.getDescricao_Professor());
    }
}
