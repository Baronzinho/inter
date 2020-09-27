package Controller;

import Connection.DML;
import DAO.EnderecoDAO;
import Model.Endereco;
import Model.Usuario;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;


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
    
    String path;
    String absolutPath;
    
    @FXML
    private void CancelarCadastro(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/Tela_Login.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.DECORATED.UNDECORATED);
        
        stage.setScene(scene);
        stage.show();
        
        Stage stageAtual = (Stage) btnCancelar.getScene().getWindow();
        stageAtual.close();
    }
    
    @FXML
    private void SelecionaImagem(ActionEvent event) throws IOException{
        try {
            FileChooser fl = new FileChooser();
            fl.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imagens", "*.jpg", " *.png", "*.jpeg"));
            File file = fl.showOpenDialog(new Stage());
            txtImagem.setText("file:///" + file.getAbsolutePath());
             
            absolutPath = file.getAbsolutePath();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Nenhuma Imagem Selecionada", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    @FXML
    private void CadastrarUser(ActionEvent event) throws IOException{
        
        try {
             Usuario newUser = new Usuario();
             Endereco newEndereco = new Endereco();
             DAO.UsuarioDAO userDao = new DAO.UsuarioDAO();
             EnderecoDAO endeDAO = new EnderecoDAO();
             
             if(txtCpfUser.getText().isEmpty() || txtTelefoneUser.getText().isEmpty() || txtIdadeUser.getText().isEmpty() || txtNomeUser.getText().isEmpty() || txtBairroEndereco.getText().isEmpty() 
                     || txtCidadeEndereco.getText().isEmpty()|| txtComplementoEndereco.getText().isEmpty()|| txtRuaEndereco.getText().isEmpty()|| txtNumeroEndereco.getText().isEmpty() 
                     || txtCepEndereco.getText().isEmpty()|| txtConfirmSenhaUser.getText().isEmpty()|| txtSenhaUser.getText().isEmpty() || txtImagem.getText().equals("Imagem do Perfil")){
                JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
             }else{
             if(txtSenhaUser.getText().equals(txtConfirmSenhaUser.getText())){
                 newUser.setSenha(txtSenhaUser.getText());
                 newUser.setCpf(txtCpfUser.getText());
                 newUser.setContato(txtTelefoneUser.getText());
                 newUser.setIdade(Integer.parseInt(txtIdadeUser.getText()));
                 newUser.setNome(txtNomeUser.getText());
                 newEndereco.setBairro(txtBairroEndereco.getText());
                 newEndereco.setCidade(txtCidadeEndereco.getText());
                 newEndereco.setComplemento(txtComplementoEndereco.getText());
                 newEndereco.setRua(txtRuaEndereco.getText());
                 newEndereco.setNumero(txtNumeroEndereco.getText());
                 newEndereco.setCep(txtCepEndereco.getText());
                 
                 endeDAO.inserirEndereco(newEndereco);
                 
                 path =  txtNomeUser.getText() + ".jpg";
                 newUser.setImgUser( "/ImgsUsers/" + path);
                 File imgPath = new File(absolutPath);
                 BufferedImage bImage = ImageIO.read(imgPath);
                 //ImageIO.write(bImage, "jpg", new File("D:\\GITHUB\\inter\\Java\\Inter\\src\\ImgsUsers\\" + path));
                 ImageIO.write(bImage, "jpg", new File("C:\\Users\\Gabriel\\Desktop\\GITHUB\\inter\\Java\\Inter\\src\\ImgsUsers\\" + path));
             }
             else{
                 JOptionPane.showMessageDialog(null, "As senhas não coincidem!");
             }
             
             if(rbAluno.isSelected() == true){
                 newUser.setCargo("Aluno");       
                 userDao.inserirUsuario(newUser);
                 JOptionPane.showMessageDialog(null, "Novo Usuario Cadastrado!");
                 
                 
             }
             else if(rbProfessor.isSelected() == true){
                 newUser.setCargo("Professor");     
                 userDao.inserirUsuario(newUser);
                 JOptionPane.showMessageDialog(null, "Novo Usuario Cadastrado!");
             }else{
                 JOptionPane.showMessageDialog(null, "Selecione um tipo de usuario!");
             }
             
             
             }

             } catch (Exception ex) {
             Logger.getLogger(Tela_Cadastro_Controller.class.getName()).log(Level.SEVERE, null, ex);
         }            
            
            Parent root = FXMLLoader.load(getClass().getResource("/View/Tela_Login.fxml"));
            Stage stage = new Stage();
            Stage stage2 = new Stage();
            Scene scene = new Scene(root);
            
            stage.initStyle(StageStyle.DECORATED.UNDECORATED);
            stage.setScene(scene);
            stage.show();
            
            Stage stageAtual = (Stage) btnCancelar.getScene().getWindow();
            stageAtual.close();
    }
    
    @FXML
    private void sair(ActionEvent event){
        System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        
    }    
}
