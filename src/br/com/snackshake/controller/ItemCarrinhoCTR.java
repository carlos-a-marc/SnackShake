package br.com.snackshake.controller;

import br.com.snackshake.model.vo.ProdutoVO;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Carlos
 */
public class ItemCarrinhoCTR extends AnchorPane {

    @FXML
    private ImageView imgImagem;

    @FXML
    private Label lblNome;

    @FXML
    private Label lblPreco;

    @FXML
    private Label lblSubtotal;

    @FXML
    private Label lblContadorQtd;

    private ProdutoVO produto;
    private VBox paneItensCarrinho;
    private Label lblQtdItens;
    private int qtd = 1;
    private double valorSubTotal;

    public ItemCarrinhoCTR(ProdutoVO produto, VBox paneItensCarrinho, Label lblQtdItens) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/snackshake/view/views/itemCarrinho.fxml"));
        loader.setRoot((Object) this);
        loader.setController((Object) this);

        try {
            loader.load();
            this.produto = produto;
            this.paneItensCarrinho = paneItensCarrinho;
            this.lblQtdItens = lblQtdItens;

            this.imgImagem.setImage(new Image(getClass().getResourceAsStream(produto.getImagem())));
            this.lblNome.setText(produto.getNome());
            lblContadorQtd.setText(Integer.toString(qtd));
            this.lblPreco.setText("R$ " + Double.toString(produto.getPreco()));
            this.valorSubTotal = qtd * produto.getPreco();
            this.lblSubtotal.setText("R$ " + valorSubTotal);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void RemoverUm(MouseEvent event) {
        qtd--;
        if (qtd >= 1) {
            lblContadorQtd.setText(Integer.toString(qtd));

            DecimalFormat formato = new DecimalFormat("#0.00");
            valorSubTotal -= produto.getPreco();
            String result = formato.format(valorSubTotal);
            lblSubtotal.setText("R$ " + result.replace(",", "."));
        } else {
            qtd = 1;
        }
    }

    @FXML
    private void adicinarMaisUm(MouseEvent event) {
        qtd++;
        lblContadorQtd.setText(Integer.toString(qtd));

        //Atualizando subtotal
        DecimalFormat formato = new DecimalFormat("#0.00");
        valorSubTotal += produto.getPreco();
        String result = formato.format(valorSubTotal);
        lblSubtotal.setText("R$ " + result.replace(",", "."));
        

    }

    @FXML
    private void removerItem(MouseEvent event) {
        ProdutoCTR.carrinho.remove(produto);
        ArrayList<ProdutoVO> itensAtualizados = ProdutoCTR.carrinho;
        atualizarCarrinho(itensAtualizados);
        lblQtdItens.setText(Integer.toString(itensAtualizados.size()));

    }

    private void atualizarCarrinho(ArrayList<ProdutoVO> itens) {
        paneItensCarrinho.getChildren().clear();
        for (ProdutoVO p : itens) {
            paneItensCarrinho.getChildren().add(new ItemCarrinhoCTR(p, paneItensCarrinho, lblQtdItens));
        }
    }
}
