
package Controller;

import Model.Usuario;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
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
import javafx.scene.image.Image;
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
    private Label lblUsername;
    @FXML
    private TabPane tabPane;
    
    private double xOFFset = 0;
    private double yOFFset = 0;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //lblUsername.setText(user.getNome());
        lblUsername.setAlignment(Pos.CENTER);
    }    
    
    public void setLogin(Usuario user) throws SQLException{
        
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
    }
    
    @FXML
    public void AulasClicked() {
        tabPane.setFocusTraversable(false);
        tabPane.getSelectionModel().select(2);
    }
    
    @FXML
    public void PendenciasClicked() {
        tabPane.setFocusTraversable(false);
        tabPane.getSelectionModel().select(3);
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
    public void VisualizarAulaClicked() throws IOException{
            Stage stage = new Stage();
            Parent root=null;
            FXMLLoader loader = new FXMLLoader();

            root = loader.load(getClass().getResource("/View/Tela_Visualizar_Aula_Professor.fxml").openStream());
            
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

            stage.setScene(new Scene(root));
            stage.setTitle("Visualizar Aulas Marcadas");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
    }
}
