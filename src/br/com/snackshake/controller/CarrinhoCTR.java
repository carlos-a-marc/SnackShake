package br.com.snackshake.controller;

import br.com.snackshake.model.vo.ProdutoVO;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Carlos
 */
public class CarrinhoCTR extends AnchorPane {

    @FXML
    private VBox paneItensCarrinho;

    @FXML
    private Label lblTotalCompra;

    static double valorTotal = 0;
    private Label lblQtdItens;

    public CarrinhoCTR(Label lblQtdItens) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/snackshake/view/views/carrinho.fxml"));
        loader.setRoot((Object) this);
        loader.setController((Object) this);

        try {
            loader.load();
            this.lblQtdItens = lblQtdItens;
            Stage stage = new Stage();
            stage.setScene(new Scene(this));
            stage.show();

            valorTotal = Double.parseDouble(lblTotalCompra.getText());

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        iniciaItensNoCarrinho();
    }

    private void iniciaItensNoCarrinho() {
        ArrayList<ProdutoVO> itensCarrinho = ProdutoCTR.carrinho;
        paneItensCarrinho.getChildren().clear();
        if (itensCarrinho.isEmpty()) {
            paneItensCarrinho.getChildren().add(mensagem());
        } else {
            for (ProdutoVO produto : itensCarrinho) {
                atualizarTotal(produto);
                paneItensCarrinho.getChildren().add(new ItemCarrinhoCTR(produto, paneItensCarrinho, lblQtdItens));
            }
        }
    }

    public void atualizarTotal(ProdutoVO produto) {
        DecimalFormat formato = new DecimalFormat("#0.00");
        valorTotal += produto.getPreco();
        String result = formato.format(valorTotal);
        lblTotalCompra.setText(result.replace(",", "."));
    }

    private Label mensagem() {
        Label mensagem = new Label("Carrinho Vazio.");
        mensagem.setFont(Font.font("Sitka Text", 15));
        return mensagem;
    }

}
