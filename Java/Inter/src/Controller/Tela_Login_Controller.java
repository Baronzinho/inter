package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class Tela_Login_Controller implements Initializable {

    @FXML
    private TextField txtUsuario;
    @FXML
    private TextField txtSenha;
    @FXML
    private Button btnLogar;

    protected ResultSet rset;
    protected String sql;
    
    @FXML
    public void logar(ActionEvent event) throws IOException, SQLException {
        //Esse evento está associado ao clique no botão logar. Aqui ele faz o processamento e loga.
        System.out.println("TESTE!");
        
        
        String usuarioBanco = null;
        String senhaBanco = null;
        String cargoBanco = null;
        ResultSet rset;

        Model.DQL dql = new Model.DQL("inter_caio_gabriel");
        rset = dql.selectLogin();

        while (rset.next()) {
            usuarioBanco = rset.getString("cpf");
            senhaBanco = rset.getString("senha");
            cargoBanco = rset.getString("cargo");
        }
        
        if (cargoBanco.equals("Aluno") ){
            
            if (usuarioBanco.equals(txtUsuario.getText()) && senhaBanco.equals(txtSenha.getText())) {
                Parent root = FXMLLoader.load(getClass().getResource("/View/Tela_Principal_Aluno.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

                Stage stageAtual = (Stage) btnLogar.getScene().getWindow(); //Obtendo a janela atual
                stageAtual.close();
            }else {
                JOptionPane.showMessageDialog(null, "Verifique se todos os campos estão preenchidos \n"
                + "e que seu Usuário e Senha estão corretos!\n");
            }
            
        }else if (cargoBanco.equals("Professor")){
            
            if (usuarioBanco.equals(txtUsuario.getText()) && senhaBanco.equals(txtSenha.getText())) {
                Parent root = FXMLLoader.load(getClass().getResource("/View/Tela_Pricipal_Professor.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

                Stage stageAtual = (Stage) btnLogar.getScene().getWindow(); //Obtendo a janela atual
                stageAtual.close();
            }else {
                JOptionPane.showMessageDialog(null, "Verifique se todos os campos estão preenchidos \n"
                + "e que seu Usuário e Senha estão corretos!\n");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Tipo de usuario não reconhecido!\n");
        } 
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
