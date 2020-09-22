
package Controller;

import DAO.AlunoDAO;
import Model.Usuario;
import Model.Endereco;
import Model.Mensagens;
import Model.UserProfessor;
import java.io.IOException;
import java.net.URL;
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
    private ImageView imgAluno;
    @FXML
    private TabPane tabPane;
    @FXML
    private TextField txtNomeUser;
    @FXML
    private TextField txtIdadeUser;
    @FXML
    private TextField txtTelefoneUser;
    @FXML
    private TextField txtNumeroEndereco;
    @FXML
    private TextField txtRuaEndereco;
    @FXML
    private TextField txtBairroEndereco;
    @FXML
    private TextField txtCidadeEndereco;
    @FXML
    private TextField txtCepEndereco;
    @FXML
    private TextField txtComplementoEndereco;
    @FXML
    private TextField txtPesquisar;
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
    
    private double xOFFset = 0;
    private double yOFFset = 0;
    
    Usuario usuario = new Usuario();
    Endereco endereco = new Endereco();
    Mensagens msg = new Mensagens();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

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
    }
    @FXML
    public void IdadePressed() {
        btnAtualizar.setDisable(false);
    }
    @FXML
    public void TelefonePressed() {
        btnAtualizar.setDisable(false);
    }
    
    @FXML
    public void AulasClicked() {
        tabPane.setFocusTraversable(false);
        tabPane.getSelectionModel().select(2);
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
    
    public void setLogin(Usuario user) throws SQLException{
        lblUsername.setText(user.getNome());
        lblUsername.setAlignment(Pos.CENTER);
        Image imgUser =  new Image(user.getImgUser());
        imgAluno.setImage(imgUser);
        usuario = user;
        endereco = endereco.retornaEnderecoUser(user.getId_endereco());  
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
        return FXCollections.observableArrayList(alunoD.getPesquisaProfessor(pesquisa));
    }
    
    @FXML
    public void PesquisarProfessor(){
        String pesquisa = txtPesquisar.getText();
        tvProfessores.refresh();
        initTablePesquisaProfessor(pesquisa);
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
    
    @FXML
    public void CancelarClicked(){
        PerfilClicked();
    }
    
    public UserProfessor selectRowProfessor() throws SQLException{
        UserProfessor prof = new UserProfessor();
        
        //if(tvProfessores){
            int id = tvProfessores.getSelectionModel().getSelectedItem().getId_Professor();
            prof = prof.retornaUser(id);
        //}else{
           // msg.mensagemAviso("Seleciona um Professor para visualizar");
            
        //}
        
        return prof;
    }
    
    @FXML
    public void VisualizarProfessorClicked() throws IOException, SQLException{
        UserProfessor prof = new UserProfessor();
        prof = selectRowProfessor();   
        Stage stage = new Stage();
        Parent root=null;
        FXMLLoader loader = new FXMLLoader();
        
        root = loader.load(getClass().getResource("/View/Tela_Visualizar_Professor.fxml").openStream());
        Tela_Visualizar_Professor_Controller aController = (Tela_Visualizar_Professor_Controller) loader.getController();
        
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
        
        aController.setDadosProfessor(prof);
        
        stage.setScene(new Scene(root));
        stage.setTitle("Visualizar Professor");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }
    
    @FXML
    public void MarcarAulaClicked() throws IOException, SQLException{
        UserProfessor prof = new UserProfessor();
        prof = selectRowProfessor();
         
        Stage stage = new Stage();
        Parent root=null;
        FXMLLoader loader = new FXMLLoader();
        root = loader.load(getClass().getResource("/View/Tela_Marcar_Aula.fxml").openStream());
        Tela_Marcar_Aula_Controller aController = (Tela_Marcar_Aula_Controller) loader.getController();
        
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
        aController.setDadosParaMarcarAula(prof,usuario.getId_User());
        
        stage.setScene(new Scene(root));
        stage.setTitle("Marcar Aula");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }
}
