
package Controller;

import Model.Usuario;
import Model.Endereco;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
    private Button btnAtualizar;
    @FXML
    private Button btnCancelar;
    
    private double xOFFset = 0;
    private double yOFFset = 0;
    
    Usuario usuario = new Usuario();
    Endereco endereco = new Endereco();
    
    public void setLogin(Usuario user) throws SQLException{
        lblUsername.setText(user.getNome());
        lblUsername.setAlignment(Pos.CENTER);
        Image imgUser =  new Image(user.getImgUser());
        imgAluno.setImage(imgUser);
        usuario = user;
        endereco.setId_Endereco(usuario.getId_endereco());
    }
    
    public void initTable() throws SQLException{
     
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

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
        
        /*
        txtNumeroEndereco.setText(endereco.getNumero());
        txtRuaEndereco.setText(endereco.getRua());
        txtBairroEndereco.setText(endereco.getBairro());
        txtCidadeEndereco.setText(endereco.getCidade());
        txtCepEndereco.setText(endereco.getCep());
        txtComplementoEndereco.setText(endereco.getComplemento());
        */
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
    
    @FXML
    public void VisualizarProfessorClicked() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/Tela_Visualizar_Professor.fxml"));
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
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }
    
    @FXML
    public void MarcarAulaClicked() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/Tela_Marcar_Aula.fxml"));
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
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }
}
