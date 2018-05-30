package br.com.snackshake.controller;

import br.com.snackshake.model.vo.ProdutoVO;
import java.io.IOException;
import java.util.ArrayList;
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
public class ProdutoCTR extends AnchorPane {

    @FXML
    private ImageView imgImagem;

    @FXML
    private Label lblNome;

    @FXML
    private Label lblDescricao;

    private ProdutoVO produto;
    private AnchorPane pInfoProduto;
    static ArrayList<ProdutoVO> carrinho = new ArrayList<>();
    private Label lblQtdItens;

    public ProdutoCTR(ProdutoVO produto, AnchorPane pInfoProduto, Label lblQtdItens) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/snackshake/view/views/produto.fxml"));
        loader.setRoot((Object) this);
        loader.setController((Object) this);

        try {
            loader.load();
            this.produto = produto;
            this.pInfoProduto = pInfoProduto;
            this.lblQtdItens = lblQtdItens;
            this.imgImagem.setImage(new Image(getClass().getResourceAsStream(produto.getImagem())));
            this.lblNome.setText(produto.getNome());
            this.lblDescricao.setText(produto.getDescricao());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void informacaoProduto(MouseEvent event) {
        pInfoProduto.getChildren().clear();
        pInfoProduto.setVisible(true);
        pInfoProduto.getChildren().add(new InfoProdutoCTR(produto, pInfoProduto));
    }

    @FXML
    private void addAoCarrinho(MouseEvent event) {
        carrinho.add(produto);
        lblQtdItens.setText(Integer.toString(carrinho.size()));
    }
}
