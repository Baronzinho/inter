package Controller;

import Model.Mascara;
import DAO.AlunoDAO;
import DAO.AulaMarcadaDAO;
import DAO.EnderecoDAO;
import Model.AulaMarcada;
import Model.Usuario;
import Model.Endereco;
import Model.Mensagens;
import Model.UserProfessor;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

public class Tela_Principal_Aluno_Controller implements Initializable {

    @FXML
    private Button btnInicio;
    @FXML
    private Button btnPerfil;
    @FXML
    private Button btnAulas;
    @FXML
    private Button btnProfessores;
    @FXML
    private Button btnSair;
    @FXML
    private Label lblUsername;
    @FXML
    private Label lblValorAulas;
    @FXML
    private Label lblValorMedioAulas;
    @FXML
    private Label lblQtdAulas;
    @FXML
    private Label lblProximaAula;
    @FXML
    private ImageView imgAluno;
    @FXML
    private TabPane tabPane;
    @FXML
    private TextField txtNomeUser;
    @FXML
    private TextField txtIdadeUser;
    @FXML
    private Mascara txtTelefoneUser;
    @FXML
    private TextField txtNumeroEndereco;
    @FXML
    private TextField txtRuaEndereco;
    @FXML
    private TextField txtBairroEndereco;
    @FXML
    private TextField txtCidadeEndereco;
    @FXML
    private Mascara txtCepEndereco;
    @FXML
    private TextField txtComplementoEndereco;
    @FXML
    private TextField txtPesquisar;
    @FXML
    private TextField txtPesquisarAula;
    @FXML
    private Button btnAtualizar;
    @FXML
    private Button btnCancelar;
    @FXML
    private TableView<UserProfessor> tvProfessores;
    @FXML
    private TableColumn<UserProfessor, String> ColNomeProf;
    @FXML
    private TableColumn<UserProfessor, String> ColMateria;
    @FXML
    private TableColumn<UserProfessor, String> ColPreco;
    @FXML
    private TableView<AulaMarcada> tvAulasMarcadas;
    @FXML
    private TableColumn<AulaMarcada, String> ColNomeProfessor;
    @FXML
    private TableColumn<AulaMarcada, String> ColMateriaAula;
    @FXML
    private TableColumn<AulaMarcada, String> ColData;
    @FXML
    private TableColumn<AulaMarcada, String> ColHora;

    private double xOFFset = 0;
    private double yOFFset = 0;

    Usuario usuario = new Usuario();
    Endereco endereco = new Endereco();
    Mensagens msg = new Mensagens();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtTelefoneUser.setMask("NN NNNN-NNNN?N");
        txtCepEndereco.setMask("NNNNN-NNN");
    }

    public void setPainelControle() throws SQLException {
        AlunoDAO alunoDAO = new AlunoDAO();
        ResultSet rset;

        rset = alunoDAO.retornaTotalGasto(usuario);
        while (rset.next()) {
            lblValorAulas.setText(rset.getString(1));
            lblValorMedioAulas.setText(rset.getString(2));
        }

        rset = alunoDAO.retornaProximaAula(usuario);
        while (rset.next()) {
            lblProximaAula.setText(rset.getString(1));
        }

        rset = alunoDAO.retornaQtdAulasPendentes(usuario);
        while (rset.next()) {
            lblQtdAulas.setText(Integer.toString(rset.getInt(1)));
        }
    }

    @FXML
    public void InicioClicked() {
        tabPane.setFocusTraversable(false);
        tabPane.getSelectionModel().select(0);
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
        txtNumeroEndereco.setText(endereco.getNumero());
        txtRuaEndereco.setText(endereco.getRua());
        txtBairroEndereco.setText(endereco.getBairro());
        txtCidadeEndereco.setText(endereco.getCidade());
        txtCepEndereco.setText(endereco.getCep());
        txtComplementoEndereco.setText(endereco.getComplemento());

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
    public void AulasClicked() {
        tabPane.setFocusTraversable(false);
        tabPane.getSelectionModel().select(2);
        initTableAulasMarcadas();
    }

    @FXML
    public void ProfessoresClicked() {
        tabPane.setFocusTraversable(false);
        tabPane.getSelectionModel().select(3);
        initTableProfessor();
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
    public void ProfessoresEntered() {
        btnProfessores.setStyle("-fx-background-color: #0562a3; ");
    }

    @FXML
    public void ProfessoresExited() {
        btnProfessores.setStyle("-fx-background-color: #0598ff; ");
    }

    @FXML
    public void SairEntered() {
        btnSair.setStyle("-fx-background-color: #0562a3; ");
    }

    @FXML
    public void SairExited() {
        btnSair.setStyle("-fx-background-color: #0598ff; ");
    }

    public void setLogin(Usuario user) throws SQLException {
        lblUsername.setText(user.getNome());
        lblUsername.setAlignment(Pos.CENTER);
        Image imgUser = new Image(user.getImgUser());
        imgAluno.setImage(imgUser);
        usuario = user;
        endereco = endereco.retornaEnderecoUser(user.getId_endereco());
        setPainelControle();
    }

    public void initTableProfessor() {
        ColNomeProf.setCellValueFactory(new PropertyValueFactory("nome"));
        ColMateria.setCellValueFactory(new PropertyValueFactory("materia_Professor"));
        ColPreco.setCellValueFactory(new PropertyValueFactory("preco_aula"));
        tvProfessores.setItems(professores());
    }

    public void initTablePesquisaProfessor(String pesquisa) {
        ColNomeProf.setCellValueFactory(new PropertyValueFactory("nome"));
        ColMateria.setCellValueFactory(new PropertyValueFactory("materia_Professor"));
        ColPreco.setCellValueFactory(new PropertyValueFactory("preco_aula"));
        tvProfessores.setItems(pesquisaProfessores(pesquisa));
    }

    public ObservableList<UserProfessor> professores() {
        AlunoDAO alunoD = new AlunoDAO();
        return FXCollections.observableArrayList(alunoD.getTodosProfessor());
    }

    public ObservableList<UserProfessor> pesquisaProfessores(String pesquisa) {
        AlunoDAO alunoD = new AlunoDAO();
        return FXCollections.observableArrayList(alunoD.getTodosProfessor(pesquisa));
    }

    public void initTableAulasMarcadas() {
        ColNomeProfessor.setCellValueFactory(new PropertyValueFactory("nome"));
        ColMateriaAula.setCellValueFactory(new PropertyValueFactory("materia_Professor"));
        ColData.setCellValueFactory(new PropertyValueFactory("data"));
        ColHora.setCellValueFactory(new PropertyValueFactory("hora_Aula"));
        tvAulasMarcadas.setItems(aulasMarcadasAluno());
    }

    public void initTableAulasMarcadasPesquisa(String pesquisa) {
        ColNomeProfessor.setCellValueFactory(new PropertyValueFactory("nome"));
        ColMateriaAula.setCellValueFactory(new PropertyValueFactory("materia_Professor"));
        ColData.setCellValueFactory(new PropertyValueFactory("data"));
        ColHora.setCellValueFactory(new PropertyValueFactory("hora_Aula"));
        tvAulasMarcadas.setItems(pesquisaAulasMarcadasAluno(pesquisa));
    }

    public ObservableList<AulaMarcada> aulasMarcadasAluno() {
        AulaMarcadaDAO aulaD = new AulaMarcadaDAO();
        return FXCollections.observableArrayList(aulaD.exibeAulasMarcadasAluno(usuario.getId_User()));
    }

    public ObservableList<AulaMarcada> pesquisaAulasMarcadasAluno(String pesquisa) {
        AulaMarcadaDAO aulaD = new AulaMarcadaDAO();
        return FXCollections.observableArrayList(aulaD.exibeAulasMarcadasAluno(usuario.getId_User(), pesquisa));
    }

    @FXML
    public void PesquisarProfessor() {
        String pesquisa = txtPesquisar.getText();
        tvProfessores.refresh();
        initTablePesquisaProfessor(pesquisa);
    }

    @FXML
    public void PesquisarAula() {
        String pesquisa = txtPesquisarAula.getText();
        tvAulasMarcadas.refresh();
        initTableAulasMarcadasPesquisa(pesquisa);
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

    @FXML
    public void CancelarClicked() {
        PerfilClicked();
    }

    public UserProfessor selectRowProfessor() throws SQLException {
        UserProfessor prof = new UserProfessor();

        int id = tvProfessores.getSelectionModel().getSelectedItem().getId_Professor();

        prof = prof.retornaUser(id);
        return prof;
    }

    public UserProfessor selectRowAulas() throws SQLException {
        UserProfessor prof = new UserProfessor();

        int id = tvAulasMarcadas.getSelectionModel().getSelectedItem().getId_Professor();

        prof = prof.retornaUser(id);
        return prof;
    }

    @FXML
    public void VisualizarProfessorClicked() throws IOException, SQLException {
        UserProfessor prof = new UserProfessor();
        int controlaErro = 0;

        try {
            prof = selectRowProfessor();
        } catch (NullPointerException e) {
            msg.mensagemAviso("Selecione um professor para visualizar.");
            controlaErro++;
        }

        if (controlaErro == 0) {
            Stage stage = new Stage();
            Parent root = null;
            FXMLLoader loader = new FXMLLoader();

            root = loader.load(getClass().getResource("/View/Tela_Visualizar_Professor.fxml").openStream());
            Tela_Visualizar_Professor_Controller aController = (Tela_Visualizar_Professor_Controller) loader.getController();

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

            aController.setDadosProfessor(prof);

            stage.setScene(new Scene(root));
            stage.setTitle("Visualizar Professor");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        }
    }

    @FXML
    public void MarcarAulaClicked() throws IOException, SQLException {
        UserProfessor prof = new UserProfessor();
        int controlaErro = 0;
        
        try {
            prof = selectRowProfessor();
        } catch (NullPointerException e) {
            msg.mensagemAviso("Selecione um professor para Marcar a Aula.");
            controlaErro++;
        }
        
        if(controlaErro == 0){
            Stage stage = new Stage();
            Parent root = null;
            FXMLLoader loader = new FXMLLoader();
            root = loader.load(getClass().getResource("/View/Tela_Marcar_Aula.fxml").openStream());
            Tela_Marcar_Aula_Controller aController = (Tela_Marcar_Aula_Controller) loader.getController();

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
            aController.setDadosParaMarcarAula(prof, usuario.getId_User());

            stage.setScene(new Scene(root));
            stage.setTitle("Marcar Aula");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        }
    }

    @FXML
    public void VisualizarAulaClicked() throws IOException, SQLException {
        UserProfessor prof = new UserProfessor();
        int controlaErro = 0;
        
        try {
            prof = selectRowAulas();
        } catch (NullPointerException e) {
            msg.mensagemAviso("Selecione um aula para visualizar.");
            controlaErro++;
        }
        
        if(controlaErro == 0){
            Stage stage = new Stage();
            Parent root = null;
            FXMLLoader loader = new FXMLLoader();

            root = loader.load(getClass().getResource("/View/Tela_Visualizar_Aula.fxml").openStream());
            Tela_Visualizar_Aula_Controller aController = (Tela_Visualizar_Aula_Controller) loader.getController();

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

            aController.setDadosAula(prof);

            stage.setScene(new Scene(root));
            stage.setTitle("Visualizar Aula");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        }
    }

    @FXML
    public void AtualizarClicked() throws IOException, SQLException {
        DAO.UsuarioDAO userDAO = new DAO.UsuarioDAO();
        EnderecoDAO endeDAO = new EnderecoDAO();

        if (txtTelefoneUser.getText().isEmpty() || txtIdadeUser.getText().isEmpty()
                || txtNomeUser.getText().isEmpty() || txtBairroEndereco.getText().isEmpty()
                || txtCidadeEndereco.getText().isEmpty() || txtComplementoEndereco.getText().isEmpty()
                || txtRuaEndereco.getText().isEmpty() || txtNumeroEndereco.getText().isEmpty()
                || txtCepEndereco.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        } else {
            usuario.setContato(txtTelefoneUser.getText());
            usuario.setIdade(Integer.parseInt(txtIdadeUser.getText()));
            usuario.setNome(txtNomeUser.getText());
            endereco.setBairro(txtBairroEndereco.getText());
            endereco.setCidade(txtCidadeEndereco.getText());
            endereco.setComplemento(txtComplementoEndereco.getText());
            endereco.setRua(txtRuaEndereco.getText());
            endereco.setNumero(txtNumeroEndereco.getText());
            endereco.setCep(txtCepEndereco.getText());

            userDAO.atualizarUsuario(usuario);
            endeDAO.updateEndereco(endereco);

            PerfilClicked();
            msg.mensagemInfo("Perfil atualizado com sucesso.");
        }
    }
}
