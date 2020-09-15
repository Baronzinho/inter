package Controller;

import Connection.DML;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import UTIL.ManipularImagem;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import Model.LoginUser;

public class Tela_Cadastro_Controller implements Initializable {
    
    @FXML
    private TextField txtNomeUser;
    @FXML
    private TextField txtCpfUser;
    @FXML
    private TextField txtIdadeUser;
    @FXML
    private TextField txtTelefoneUser;
    @FXML
    private TextField txtPrecoAula;
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
    private TextField txtSenhaUser;
    @FXML
    private TextField txtConfirmSenhaUser;
    @FXML
    private RadioButton rbAluno;
    @FXML
    private RadioButton rbProfessor;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnCadastrar;
    @FXML
    private Button btnSelecionar;
    @FXML
    private Text txtImagem;
    
    BufferedImage imagem;
    
    @FXML
    private void CancelarCadastro(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/Tela_Login.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.DECORATED.UNDECORATED);
        
        stage.setScene(scene);
        stage.show();
        
        Stage stageAtual = (Stage) btnCancelar.getScene().getWindow(); //Obtendo a janela atual
        stageAtual.close();
    }
    
    @FXML
    private void SelecionaImagem(ActionEvent event) throws IOException{
        JFileChooser fc = new JFileChooser();
        int res = fc.showOpenDialog(null);

        if (res == JFileChooser.APPROVE_OPTION) {
            File arquivo = fc.getSelectedFile();

            try {
                imagem = ManipularImagem.setImagemDimensao(arquivo.getAbsolutePath(), 160, 160);
                
                String nomeArquivo = arquivo.getName();
                
                txtImagem.setText("Imagem - " + nomeArquivo);
                //lblImagem.setIcon(new ImageIcon(imagem));

            } catch (Exception ex) {
               // System.out.println(ex.printStackTrace().toString());
            }

        } else {
            JOptionPane.showMessageDialog(null, "Voce nao selecionou nenhum arquivo.");
        }
    }
    
    @FXML
    private void CadastrarUser(ActionEvent event){
        
        try {
             LoginUser obj = new LoginUser();
             obj.setImagem(ManipularImagem.getImgBytes(imagem));
             obj.setCpf(txtCpfUser.getText());
             if(rbAluno.isSelected() == true){
                 obj.setCargo("Aluno");
             }
             else{
                 obj.setCargo("Professor");
             }
             
             if(txtSenhaUser.getText().equals(txtConfirmSenhaUser.getText())){
                 obj.setSenha(txtSenhaUser.getText());
             }
             else{
                 JOptionPane.showMessageDialog(null, "As senhas não coincidem!");
             }
             
             DML dao = new DML("");
             dao.inserir(obj);
             
             } catch (Exception ex) {
             Logger.getLogger(Tela_Cadastro_Controller.class.getName()).log(Level.SEVERE, null, ex);
         }
         
    }
    
    @FXML
    private void sair(ActionEvent event){
        System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
