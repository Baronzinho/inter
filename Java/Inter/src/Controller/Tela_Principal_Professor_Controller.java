
package Controller;

import DAO.AulaMarcadaDAO;
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
import java.util.ArrayList;
import java.util.List;
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
    private TextField txtTelefoneUser;
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
    private TextField txtCepEndereco;
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
        //lblUsername.setText(user.getNome());
        lblUsername.setAlignment(Pos.CENTER);
    }    
     public void setPainelControle() throws SQLException{
        ProfessorDAO alunoDAO = new ProfessorDAO();
        ResultSet rset;
        
        rset = alunoDAO.retornaTotalGanho(uProf.getId_Professor());
        while (rset.next()){
            lblValorAulas.setText(rset.getString(1));
            lblValorMedioAula.setText(rset.getString(2));
            lblQtdAulas.setText(Integer.toString(rset.getInt(3)));
        }
        
        rset = alunoDAO.retornaProximaAula(uProf.getId_Professor());
        while (rset.next()){
            lblProxAula.setText(rset.getString(1));
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
    
    public void setLoginProf(Usuario user) throws SQLException{
        lblUsername.setText(user.getNome());
        lblUsername.setAlignment(Pos.CENTER);
        Image imgUser =  new Image(user.getImgUser());
        imgProfessor.setImage(imgUser);
        usuario = user;
        endereco = endereco.retornaEnderecoUser(user.getId_endereco());  
        uProf = uProf.retornaProfPeloIdUser(user.getId_User());
        setPainelControle();
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
        return FXCollections.observableArrayList(aulaMD.exibeAulasMarcadasProfessorPesquisa(uProf.getId_Professor(),pesquisa));
    }
    
    @FXML
    public void PesquisaAulaMarcada(){
        String pesquisa = txtPesquisarAula.getText();
        tvAulasMarcadas.refresh();
        initTableAulasMarcadasPesquisa(pesquisa);
    }
    
    @FXML
    public void VisualizarAulaClicked() throws SQLException, IOException{
        AulaMarcada aulaMarcada = new AulaMarcada();
        int controlaErro = 0;
        
        try{
            aulaMarcada = selectRowAulaMarcada();
        } 
        catch(NullPointerException e){
            msg.mensagemAviso("Selecione um professor para visualizar.");
            controlaErro++;
        }
        
        if(controlaErro == 0){
            Stage stage = new Stage();
            Parent root=null;
            FXMLLoader loader = new FXMLLoader();

            root = loader.load(getClass().getResource("/View/Tela_Visualizar_Aula_Professor.fxml").openStream());
            Tela_Visualizar_Aula_Professor_Controller aController = (Tela_Visualizar_Aula_Professor_Controller) loader.getController();

            stage.initStyle(StageStyle.DECORATED.UNDECORATED);

            root.setOnMousePressed(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event){
                    xOFFset = event.getSceneX();
                    yOFFset = event.getSceneY();
                }
            });

            root.setOnMouseDragged(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event){
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
    
    public AulaMarcada selectRowAulaMarcada() throws SQLException{
        AulaMarcada aulaMarcada = new AulaMarcada();
        int id = tvAulasMarcadas.getSelectionModel().getSelectedItem().getId_Aula_Marcada();
        aulaMarcada = aulaMarcada.vizualizaAulaMarcadaProfessor(id);
        return aulaMarcada;
    }
    
    public int selectRowAulaPendentes() throws SQLException{
        AulaMarcada aulaMarcada = new AulaMarcada();
        int id = tvAulasPendentes.getSelectionModel().getSelectedItem().getId_Aula_Marcada();
        return id;
    }
    
    @FXML
    public void RecusarAula() throws SQLException{
        AulaMarcadaDAO aulaD = new AulaMarcadaDAO();
        aulaD.recusaAula(selectRowAulaPendentes());
        tvAulasPendentes.refresh();
        initTableAulasPendentes();
    }
    
    @FXML
    public void ConfirmaAula() throws SQLException{
        AulaMarcadaDAO aulaD = new AulaMarcadaDAO();
        aulaD.confirmaAula(selectRowAulaPendentes());
        tvAulasPendentes.refresh();
        initTableAulasPendentes();
    }
    
    @FXML
    public void SairClicked() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Tela_Login.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.DECORATED.UNDECORATED);
        
        root.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                xOFFset = event.getSceneX();
                yOFFset = event.getSceneY();
            }
        });
        
        root.setOnMouseDragged(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
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
    private void sair(ActionEvent event){
        System.exit(0);
    }
    
}
