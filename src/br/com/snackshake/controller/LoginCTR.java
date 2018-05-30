package br.com.snackshake.controller;

import br.com.snackshake.model.dao.ClienteDAO;
import br.com.snackshake.model.vo.ClienteVO;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos
 */
public class LoginCTR extends AnchorPane {

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtSenha;

    private Stage stage;
    private ClienteVO cliente;

    public LoginCTR() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/snackshake/view/views/login.fxml"));
        loader.setRoot((Object) this);
        loader.setController((Object) this);

        try {
            loader.load();
            stage = new Stage();
            stage.setScene(new Scene(this));
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void cancelar(MouseEvent event) {
        stage.close();
    }

    @FXML
    private void logar(MouseEvent event) {
        if (!txtEmail.getText().isEmpty() && !txtSenha.getText().isEmpty()) {
            cliente = new ClienteDAO().lerCliente(new ClienteVO(null, null, txtEmail.getText(), txtSenha.getText(), null, null));
            if (cliente != null) {
                stage.close();
                new HomeCTR().preencheInfoClienteLog(cliente);
            } else {
                JOptionPane.showMessageDialog(null, "Email ou senha incorento.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Email ou senha incorento.");
        }
    }

}
