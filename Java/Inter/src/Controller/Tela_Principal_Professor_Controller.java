package Controller;

import Model.Mascara;
import DAO.AulaMarcadaDAO;
import DAO.EnderecoDAO;
import DAO.ProfessorDAO;
import Model.AulaMarcada;
import Model.Endereco;
import Model.Mensagens;
import Model.UserProfessor;
import Model.Usuario;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

public class Tela_Principal_Professor_Controller implements Initializable {

    @FXML
    private Button btnInicio;
    @FXML
    private Button btnPerfil;
    @FXML
    private Button btnAulas;
    @FXML
    private Button btnPendencias;
    @FXML
    private Button btnSair;
    @FXML
    private Button btnAtualizar;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnAceitarAula;
    @FXML
    private Button btnRecusarAula;
    @FXML
    private Label lblUsername;
    @FXML
    private TabPane tabPane;
    @FXML
    private ImageView imgProfessor;
    @FXML
    private TextField txtNomeUser;
    @FXML
    private TextField txtIdadeUser;
    @FXML
    private Mascara txtTelefoneUser;
    @FXML
    private TextField txtMateriaProfessor;
    @FXML
    private TextField txtPrecoAula;
    @FXML
    private TextField txtNumeroEndereco;
    @FXML
    private TextField txtRuaEndereco;
    @FXML
    private TextField txtPesquisarAula;
    @FXML
    private TextField txtBairroEndereco;
    @FXML
    private TextField txtCidadeEndereco;
    @FXML
    private Mascara txtCepEndereco;
    @FXML
    private TextField txtComplementoEndereco;
    @FXML
    private TextArea txtDescricaoProfessor;
    @FXML
    private Label lblValorAulas;
    @FXML
    private Label lblValorMedioAula;
    @FXML
    private Label lblProxAula;
    @FXML
    private Label lblQtdAulas;
    @FXML
    private TableView<AulaMarcada> tvAulasPendentes;
    @FXML
    private TableColumn<AulaMarcada, String> ColNomeAluno;
    @FXML
    private TableColumn<AulaMarcada, String> ColDataAulaPendente;
    @FXML
    private TableColumn<AulaMarcada, String> ColHora;
    @FXML
    private TableColumn<AulaMarcada, String> ColEnderecoAluno;
    @FXML
    private TableView<AulaMarcada> tvAulasMarcadas;
    @FXML
    private TableColumn<AulaMarcada, String> ColNomeAlunoC;
    @FXML
    private TableColumn<AulaMarcada, String> ColData;
    @FXML
    private TableColumn<AulaMarcada, String> ColMateriaAula;
    @FXML
    private TableColumn<AulaMarcada, String> ColHoraC;

    Usuario usuario = new Usuario();
    Endereco endereco = new Endereco();
    Mensagens msg = new Mensagens();
    UserProfessor uProf = new UserProfessor();

    private double xOFFset = 0;
    private double yOFFset = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtTelefoneUser.setMask("NN NNNN-NNNN?N");
        txtCepEndereco.setMask("NNNNN-NNN");
    }

    public void setPainelControle() throws SQLException {
        ProfessorDAO alunoDAO = new ProfessorDAO();
        ResultSet rset;

        rset = alunoDAO.retornaTotalGanho(uProf.getId_Professor());
        while (rset.next()) {
            lblValorAulas.setText(rset.getString(1));
            lblValorMedioAula.setText(rset.getString(2));
            lblQtdAulas.setText(Integer.toString(rset.getInt(3)));
        }

        rset = alunoDAO.retornaProximaAula(uProf.getId_Professor());
        while (rset.next()) {
            lblProxAula.setText(rset.getString(1));
        }
    }

    @FXML
    public void InicioClicked() {
        tabPane.setFocusTraversable(false);
        tabPane.getSelectionModel().select(0);
    }

    @FXML
    public void NomePressed() {
        btnAtualizar.setDisable(false);
        btnCancelar.setDisable(false);
    }

    @FXML
    public void IdadePressed() {
        btnAtualizar.setDisable(false);
        btnCancelar.setDisable(false);
    }

    @FXML
    public void TelefonePressed() {
        btnAtualizar.setDisable(false);
        btnCancelar.setDisable(false);
    }

    @FXML
    public void MateriaPressed() {
        btnAtualizar.setDisable(false);
        btnCancelar.setDisable(false);
    }

    @FXML
    public void PrecoPressed() {
        btnAtualizar.setDisable(false);
        btnCancelar.setDisable(false);
    }

    @FXML
    public void DescricaoPressed() {
        btnAtualizar.setDisable(false);
        btnCancelar.setDisable(false);
    }

    @FXML
    public void NumeroPressed() {
        btnAtualizar.setDisable(false);
        btnCancelar.setDisable(false);
    }

    @FXML
    public void RuaPressed() {
        btnAtualizar.setDisable(false);
        btnCancelar.setDisable(false);
    }

    @FXML
    public void BairroPressed() {
        btnAtualizar.setDisable(false);
        btnCancelar.setDisable(false);
    }

    @FXML
    public void CidadePressed() {
        btnAtualizar.setDisable(false);
        btnCancelar.setDisable(false);
    }

    @FXML
    public void CepPressed() {
        btnAtualizar.setDisable(false);
        btnCancelar.setDisable(false);
    }

    @FXML
    public void ComplementoPressed() {
        btnAtualizar.setDisable(false);
        btnCancelar.setDisable(false);
    }

    @FXML
    public void PerfilClicked() {
        tabPane.setFocusTraversable(false);
        tabPane.getSelectionModel().select(1);
        btnAtualizar.setDisable(true);
        btnCancelar.setDisable(true);

        txtNomeUser.setText(usuario.getNome());
        txtIdadeUser.setText(Integer.toString(usuario.getIdade()));
        txtTelefoneUser.setText(usuario.getContato());
        txtMateriaProfessor.setText(uProf.getMateria_Professor());
        txtPrecoAula.setText(uProf.getPreco_aula());
        txtDescricaoProfessor.setText(uProf.getDescricao_Professor());
        txtNumeroEndereco.setText(endereco.getNumero());
        txtRuaEndereco.setText(endereco.getRua());
        txtBairroEndereco.setText(endereco.getBairro());
        txtCidadeEndereco.setText(endereco.getCidade());
        txtCepEndereco.setText(endereco.getCep());
        txtComplementoEndereco.setText(endereco.getComplemento());

        btnInicio.setDisable(false);
        btnPerfil.setDisable(false);
        btnAulas.setDisable(false);
        btnPendencias.setDisable(false);
        txtNomeUser.setDisable(false);
        txtIdadeUser.setDisable(false);
        txtTelefoneUser.setDisable(false);
        txtNumeroEndereco.setDisable(false);
        txtRuaEndereco.setDisable(false);
        txtBairroEndereco.setDisable(false);
        txtCidadeEndereco.setDisable(false);
        txtCepEndereco.setDisable(false);
        txtComplementoEndereco.setDisable(false);
    }

    @FXML
    public void AulasClicked() {
        tabPane.setFocusTraversable(false);
        tabPane.getSelectionModel().select(2);
        initTableAulasMarcadas();

    }

    @FXML
    public void PendenciasClicked() {
        tabPane.setFocusTraversable(false);
        tabPane.getSelectionModel().select(3);
        initTableAulasPendentes();
    }

    @FXML
    public void CancelarClicked() {
        PerfilClicked();
    }

    @FXML
    public void AtualizarClicked() throws SQLException {

        DAO.ProfessorDAO profDAO = new DAO.ProfessorDAO();
        EnderecoDAO endeDAO = new EnderecoDAO();

        if (txtTelefoneUser.getText().isEmpty() || txtIdadeUser.getText().isEmpty()
                || txtNomeUser.getText().isEmpty() || txtBairroEndereco.getText().isEmpty()
                || txtMateriaProfessor.getText().isEmpty() || txtPrecoAula.getText().isEmpty()
                || txtDescricaoProfessor.getText().isEmpty() || txtCidadeEndereco.getText().isEmpty()
                || txtComplementoEndereco.getText().isEmpty() || txtRuaEndereco.getText().isEmpty()
                || txtNumeroEndereco.getText().isEmpty() || txtCepEndereco.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        } else {
            usuario.setContato(txtTelefoneUser.getText());
            usuario.setIdade(Integer.parseInt(txtIdadeUser.getText()));
            usuario.setNome(txtNomeUser.getText());

            uProf.setId_User(usuario.getId_User());
            uProf.setDescricao_Professor(txtDescricaoProfessor.getText());
            uProf.setMateria_Professor(txtMateriaProfessor.getText());
            uProf.setPreco_aula(txtPrecoAula.getText());

            endereco.setBairro(txtBairroEndereco.getText());
            endereco.setCidade(txtCidadeEndereco.getText());
            endereco.setComplemento(txtComplementoEndereco.getText());
            endereco.setRua(txtRuaEndereco.getText());
            endereco.setNumero(txtNumeroEndereco.getText());
            endereco.setCep(txtCepEndereco.getText());

            profDAO.atualizaUserProfessor(usuario);
            profDAO.insereProfessor(uProf);
            endeDAO.updateEndereco(endereco);

            PerfilClicked();
            msg.mensagemInfo("Perfil atualizado com sucesso.");

        }

    }

    @FXML
    public void InicioEntered() {
        btnInicio.setStyle("-fx-background-color: #0562a3; ");
    }

    @FXML
    public void InicioExited() {
        btnInicio.setStyle("-fx-background-color: #0598ff; ");
    }

    @FXML
    public void PerfilEntered() {
        btnPerfil.setStyle("-fx-background-color: #0562a3; ");
    }

    @FXML
    public void PerfilExited() {
        btnPerfil.setStyle("-fx-background-color: #0598ff; ");
    }

    @FXML
    public void AulasEntered() {
        btnAulas.setStyle("-fx-background-color: #0562a3; ");
    }

    @FXML
    public void AulasExited() {
        btnAulas.setStyle("-fx-background-color: #0598ff; ");
    }

    @FXML
    public void PendenciasEntered() {
        btnPendencias.setStyle("-fx-background-color: #0562a3; ");
    }

    @FXML
    public void PendenciasExited() {
        btnPendencias.setStyle("-fx-background-color: #0598ff; ");
    }

    @FXML
    public void SairEntered() {
        btnSair.setStyle("-fx-background-color: #0562a3; ");
    }

    @FXML
    public void SairExited() {
        btnSair.setStyle("-fx-background-color: #0598ff; ");
    }

    public void setLoginProf(Usuario user) throws SQLException {
        lblUsername.setText(user.getNome());
        lblUsername.setAlignment(Pos.CENTER);
        Image imgUser = new Image(user.getImgUser());
        imgProfessor.setImage(imgUser);
        usuario = user;
        endereco = endereco.retornaEnderecoUser(user.getId_endereco());
        uProf = uProf.retornaProfPeloIdUser(user.getId_User());
        setPainelControle();

        if (uProf.getDescricao_Professor() == null && uProf.getMateria_Professor() == null
                && uProf.getPreco_aula() == null) {
            primeiroAcessoProfessor();
        }
    }

    public void primeiroAcessoProfessor() {
        tabPane.setFocusTraversable(false);
        tabPane.getSelectionModel().select(1);
        btnInicio.setDisable(true);
        btnPerfil.setDisable(true);
        btnAulas.setDisable(true);
        btnPendencias.setDisable(true);
        txtNomeUser.setDisable(true);
        txtIdadeUser.setDisable(true);
        txtTelefoneUser.setDisable(true);
        txtNumeroEndereco.setDisable(true);
        txtRuaEndereco.setDisable(true);
        txtBairroEndereco.setDisable(true);
        txtCidadeEndereco.setDisable(true);
        txtCepEndereco.setDisable(true);
        txtComplementoEndereco.setDisable(true);
        btnCancelar.setDisable(true);

        msg.mensagemAviso("Complete seu perfil para continuar!");

        tabPane.setFocusTraversable(false);
        tabPane.getSelectionModel().select(1);
        btnAtualizar.setDisable(true);
        btnCancelar.setDisable(true);

        txtNomeUser.setText(usuario.getNome());
        txtIdadeUser.setText(Integer.toString(usuario.getIdade()));
        txtTelefoneUser.setText(usuario.getContato());
        txtMateriaProfessor.setText(uProf.getMateria_Professor());
        txtPrecoAula.setText(uProf.getPreco_aula());
        txtDescricaoProfessor.setText(uProf.getDescricao_Professor());
        txtNumeroEndereco.setText(endereco.getNumero());
        txtRuaEndereco.setText(endereco.getRua());
        txtBairroEndereco.setText(endereco.getBairro());
        txtCidadeEndereco.setText(endereco.getCidade());
        txtCepEndereco.setText(endereco.getCep());
        txtComplementoEndereco.setText(endereco.getComplemento());
    }

    public void initTableAulasPendentes() {
        ColNomeAluno.setCellValueFactory(new PropertyValueFactory("nome"));
        ColDataAulaPendente.setCellValueFactory(new PropertyValueFactory("data_Aula"));
        ColHora.setCellValueFactory(new PropertyValueFactory("hora_Aula"));
        ColEnderecoAluno.setCellValueFactory(new PropertyValueFactory("contato"));
        tvAulasPendentes.setItems(AulasPendentes());
    }

    public ObservableList<AulaMarcada> AulasPendentes() {
        AulaMarcadaDAO aulaMD = new AulaMarcadaDAO();
        return FXCollections.observableArrayList(aulaMD.exibeAulasPendentesProfessor(uProf.getId_Professor()));
    }

    public void initTableAulasMarcadas() {
        ColNomeAlunoC.setCellValueFactory(new PropertyValueFactory("nome"));
        ColData.setCellValueFactory(new PropertyValueFactory("data_Aula"));
        ColHoraC.setCellValueFactory(new PropertyValueFactory("hora_Aula"));
        ColMateriaAula.setCellValueFactory(new PropertyValueFactory("materia_Professor"));
        tvAulasMarcadas.setItems(AulasMarcadas());
    }

    public ObservableList<AulaMarcada> AulasMarcadas() {
        AulaMarcadaDAO aulaMD = new AulaMarcadaDAO();
        return FXCollections.observableArrayList(aulaMD.exibeAulasMarcadasProfessor(uProf.getId_Professor()));
    }

    public void initTableAulasMarcadasPesquisa(String pesquisa) {
        ColNomeAlunoC.setCellValueFactory(new PropertyValueFactory("nome"));
        ColData.setCellValueFactory(new PropertyValueFactory("data_Aula"));
        ColHoraC.setCellValueFactory(new PropertyValueFactory("hora_Aula"));
        ColMateriaAula.setCellValueFactory(new PropertyValueFactory("materia_Professor"));
        tvAulasMarcadas.setItems(AulasMarcadas(pesquisa));
    }

    public ObservableList<AulaMarcada> AulasMarcadas(String pesquisa) {
        AulaMarcadaDAO aulaMD = new AulaMarcadaDAO();
        return FXCollections.observableArrayList(aulaMD.exibeAulasMarcadasProfessorPesquisa(uProf.getId_Professor(), pesquisa));
    }

    @FXML
    public void PesquisaAulaMarcada() {
        String pesquisa = txtPesquisarAula.getText();
        tvAulasMarcadas.refresh();
        initTableAulasMarcadasPesquisa(pesquisa);
    }

    @FXML
    public void VisualizarAulaClicked() throws SQLException, IOException {
        AulaMarcada aulaMarcada = new AulaMarcada();
        int controlaErro = 0;

        try {
            aulaMarcada = selectRowAulaMarcada();
        } catch (NullPointerException e) {
            msg.mensagemAviso("Selecione um professor para visualizar.");
            controlaErro++;
        }

        if (controlaErro == 0) {
            Stage stage = new Stage();
            Parent root = null;
            FXMLLoader loader = new FXMLLoader();

            root = loader.load(getClass().getResource("/View/Tela_Visualizar_Aula_Professor.fxml").openStream());
            Tela_Visualizar_Aula_Professor_Controller aController = (Tela_Visualizar_Aula_Professor_Controller) loader.getController();

            stage.initStyle(StageStyle.DECORATED.UNDECORATED);

            root.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    xOFFset = event.getSceneX();
                    yOFFset = event.getSceneY();
                }
            });

            root.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    stage.setX(event.getScreenX() - xOFFset);
                    stage.setY(event.getScreenY() - yOFFset);
                }
            });

            aController.setDadosAula(aulaMarcada);

            stage.setScene(new Scene(root));
            stage.setTitle("Visualizar Aula");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        }

    }

    public AulaMarcada selectRowAulaMarcada() throws SQLException {
        AulaMarcada aulaMarcada = new AulaMarcada();
        int id = tvAulasMarcadas.getSelectionModel().getSelectedItem().getId_Aula_Marcada();
        aulaMarcada = aulaMarcada.vizualizaAulaMarcadaProfessor(id);
        return aulaMarcada;
    }

    public int selectRowAulaPendentes() throws SQLException {
        AulaMarcada aulaMarcada = new AulaMarcada();
        int id = tvAulasPendentes.getSelectionModel().getSelectedItem().getId_Aula_Marcada();
        return id;
    }

    @FXML
    public void RecusarAula() throws SQLException {
        AulaMarcadaDAO aulaD = new AulaMarcadaDAO();
        
        try {
            aulaD.recusaAula(selectRowAulaPendentes());
            tvAulasPendentes.refresh();
            initTableAulasPendentes();
        } catch (NullPointerException e) {
            msg.mensagemAviso("Selecione uma aula para poder Recusar.");
        }
    }

    @FXML
    public void ConfirmaAula() throws SQLException {
        AulaMarcadaDAO aulaD = new AulaMarcadaDAO();
        
        try{
            aulaD.confirmaAula(selectRowAulaPendentes());
            tvAulasPendentes.refresh();
            initTableAulasPendentes();
        }catch (NullPointerException e){
            msg.mensagemAviso("Selecione uma aula para poder Confirmar.");
        }
    }

    @FXML
    public void SairClicked() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Tela_Login.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.DECORATED.UNDECORATED);

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOFFset = event.getSceneX();
                yOFFset = event.getSceneY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOFFset);
                stage.setY(event.getScreenY() - yOFFset);
            }
        });

        stage.setScene(scene);
        stage.show();
        Stage stageAtual = (Stage) btnSair.getScene().getWindow();
        stageAtual.close();
    }

    @FXML
    private void sair(ActionEvent event) {
        System.exit(0);
    }

}
