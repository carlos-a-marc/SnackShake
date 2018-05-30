package br.com.snackshake.controller;

import br.com.snackshake.model.vo.ClienteVO;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Carlos
 */
public class MenuCTR extends AnchorPane {

    @FXML
    private Label lblMeusDados;

    @FXML
    private ImageView imgFoto;

    @FXML
    private Label lblNome;

    private ClienteVO cliente;
    private Label lblQtdItens;

    public MenuCTR(ClienteVO cliente, Label lblQtdItens) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/snackshake/view/views/menu.fxml"));
        loader.setRoot((Object) this);
        loader.setController((Object) this);

        try {
            loader.load();
            this.cliente = cliente;
            this.lblQtdItens = lblQtdItens;
            this.imgFoto.setImage(new Image(getClass().getResourceAsStream(cliente.getPhoto())));
            this.lblNome.setText("Olá, " + cliente.getName());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void menu(MouseEvent event) {
        if (event.getSource() == lblMeusDados) {
            MeusDadosCTR mdc = new MeusDadosCTR(cliente);
        }
    }

    @FXML
    private void abrirCarrinho(MouseEvent event) {
        CarrinhoCTR cc = new CarrinhoCTR(lblQtdItens);
    }
}
