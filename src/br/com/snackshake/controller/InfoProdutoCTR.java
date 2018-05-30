package br.com.snackshake.controller;

import br.com.snackshake.controller.util.Trasitions;
import br.com.snackshake.model.vo.ProdutoVO;
import java.io.IOException;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 *
 * @author Carlos
 */
public class InfoProdutoCTR extends AnchorPane {

    @FXML
    private Label lblNome;

    @FXML
    private Label lblPreco;

    private ProdutoVO produto;

    private AnchorPane pInfoProduto;

    public InfoProdutoCTR(ProdutoVO produto, AnchorPane pInfoProduto) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/snackshake/view/views/info.fxml"));
        loader.setRoot((Object) this);
        loader.setController((Object) this);

        try {
            loader.load();
            this.produto = produto;
            this.pInfoProduto = pInfoProduto;
            this.lblNome.setText(produto.getNome());
            this.lblPreco.setText(Double.toString(produto.getPreco()));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        ajustar();
        new Trasitions().slideHorizontal((AnchorPane) this);
    }

    @FXML
    private void fecharInformacao(MouseEvent event) {
        FadeTransition ft = new FadeTransition(Duration.millis(250), this);
        ft.setToValue(0);
        ft.setOnFinished(e -> pInfoProduto.setVisible(false));
        ft.play();
    }

    @FXML
    private void mostrarInfoNutricional(MouseEvent event) {
        NutritionalInfoCTR nic = new NutritionalInfoCTR(produto);
    }

    private void ajustar() {
        AnchorPane.setBottomAnchor(this, 0.0);
        AnchorPane.setLeftAnchor(this, 0.0);
        AnchorPane.setRightAnchor(this, 0.0);
        AnchorPane.setTopAnchor(this, 0.0);
    }
}
