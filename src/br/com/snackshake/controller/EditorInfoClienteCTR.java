package br.com.snackshake.controller;

import java.io.IOException;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *
 * @author Carlos
 */
public class EditorInfoClienteCTR extends AnchorPane {

    @FXML
    private Label lblCampoHead;

    @FXML
    private Label lblCampo;

    @FXML
    private TextField txtInfo;

    private Label lblInfo;
    private Stage stage;

    public EditorInfoClienteCTR(Label info) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/snackshake/view/views/editInfoClient.fxml"));
        loader.setRoot((Object) this);
        loader.setController((Object) this);

        try {
            loader.load();
            Scene scene = new Scene(this);
            scene.setFill(null);
            stage = new Stage();
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();

            this.lblInfo = info;
            this.lblCampoHead.setText("Editar " + info.getId().substring(3));
            this.lblCampo.setText("Novo(a) " + info.getId().substring(3) + ":");

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        scaleIn((AnchorPane) this);
    }

    @FXML
    private void alterar(MouseEvent event) {
        if (txtInfo.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Informação não pode ser vazia.");
            alert.showAndWait();
        } else {
            lblInfo.setText(txtInfo.getText());
            scaleOut((AnchorPane) this);
        }
    }

    @FXML
    private void cancelar(MouseEvent event) {
        scaleOut((AnchorPane) this);
    }

    private void scaleIn(AnchorPane pane) {
        ScaleTransition st = new ScaleTransition(Duration.millis(350), pane);
        st.setFromX(0);
        st.setFromY(0);
        st.setToX(1);
        st.setToY(1);
        st.play();
    }

    private void scaleOut(AnchorPane pane) {
        ScaleTransition st = new ScaleTransition(Duration.millis(350), pane);
        st.setFromX(1);
        st.setFromY(1);
        st.setToX(0);
        st.setToY(0);
        st.setOnFinished(e -> stage.close());
        st.play();
    }
}
