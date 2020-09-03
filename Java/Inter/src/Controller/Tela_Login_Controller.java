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
    public void c_Logar(ActionEvent event) throws IOException, SQLException {
        //Esse evento está associado ao clique no botão logar. Aqui ele faz o processamento e loga.
        System.out.println("TESTE!");
        
        /*
        String usuarioBanco = null;
        String senhaBanco = null;
        ResultSet rset;

        concessionaria.DQL dql = new concessionaria.DQL("employees");
        rset = dql.selectLogin();

        while (rset.next()) {
            usuarioBanco = rset.getString("employeeNumber");
            senhaBanco = rset.getString("extension");
        }

        if (usuarioBanco.equals(txtUsuario.getText()) && senhaBanco.equals(txtSenha.getText())) {
            Parent root = FXMLLoader.load(getClass().getResource("/view/Tela_Principal.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            Stage stageAtual = (Stage) btnLogar.getScene().getWindow(); //Obtendo a janela atual
            stageAtual.close();
        } else {
            JOptionPane.showMessageDialog(null, "Verifique se todos os campos estão preenchidos \n"
                    + "e que seu Usuário e Senha estão corretos!\n");
        }
        */
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
