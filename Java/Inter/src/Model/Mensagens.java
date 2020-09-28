package Model;

import javafx.scene.control.Alert;

public class Mensagens {

    public void mensagemInfo(String Info) {
        Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
        dialogoInfo.setTitle("Diálogo de Informação");
        dialogoInfo.setHeaderText(Info);
        dialogoInfo.showAndWait();
    }

    public void mensagemErro(String Info) {
        Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
        dialogoErro.setTitle("Diálogo de Error");
        dialogoErro.setHeaderText(Info);
        dialogoErro.showAndWait();
    }

    public void mensagemAviso(String Info) {
        Alert dialogoAviso = new Alert(Alert.AlertType.WARNING);
        dialogoAviso.setTitle("Diálogo de Aviso");
        dialogoAviso.setHeaderText(Info);
        dialogoAviso.showAndWait();
    }
}
