package Controller;

import DAO.AulaMarcadaDAO;
import Model.Endereco;
import Model.Mensagens;
import Model.UserProfessor;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class Tela_Marcar_Aula_Controller implements Initializable {

    @FXML
    private Button btnVoltar;
    @FXML
    private TextField txtHorarioAula;
    @FXML
    private Label lblNomeProfessor;
    @FXML
    private Label lblMateriaProfessor;
    @FXML
    private Label lblPrecoAula;
    @FXML
    private Label lblEnderecoProfessor;
    @FXML
    private DatePicker dtDataAula;

    int idAluno, idProf;
    Mensagens msg = new Mensagens();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void VoltarClicked() {
        Stage stageAtual = (Stage) btnVoltar.getScene().getWindow();
        stageAtual.close();
    }

    public void setDadosParaMarcarAula(UserProfessor user, int idAluno) throws SQLException {
        this.idAluno = idAluno;
        this.idProf = user.getId_Professor();
        Endereco endereco = new Endereco();
        endereco = endereco.retornaEnderecoUser(user.getId_endereco());
        lblNomeProfessor.setText(user.getNome());
        lblMateriaProfessor.setText(user.getMateria_Professor());
        lblPrecoAula.setText(user.getPreco_aula());
        lblEnderecoProfessor.setText(endereco.getBairro() + ", " + endereco.getRua() + " - " + endereco.getNumero());
    }

    @FXML
    public void MarcaAula() throws ParseException, SQLException {
        AulaMarcadaDAO aulaMarcadaD = new AulaMarcadaDAO();
        String hora = txtHorarioAula.getText();
        if (txtHorarioAula.getText().isEmpty()) {
            msg.mensagemAviso("Preencha os campos para marcar a aula");
        } else {
            aulaMarcadaD.marcaAula(idProf, idAluno, dtDataAula.getValue(), hora);
            msg.mensagemInfo("Aula Marcada com Sucesso! Aguarde a confirmaçao do Professor");
            Stage stageAtual = (Stage) btnVoltar.getScene().getWindow();
            stageAtual.close();
        }
    }
}
