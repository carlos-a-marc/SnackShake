package br.com.snackshake.controller;

import br.com.snackshake.model.dao.ProdutoDAO;
import br.com.snackshake.model.vo.ClienteVO;
import br.com.snackshake.model.vo.ProdutoVO;
import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author Carlos
 */
public class HomeCTR extends AnchorPane {

    @FXML
    private AnchorPane pMenu;

    @FXML
    private HBox pAreaProdutos;

    @FXML
    private AnchorPane pInfoProduto;

    @FXML
    private HBox pOptionHeader;

    @FXML
    private Label lblLogin;

    @FXML
    private Label lblQtdItens;

    private boolean menuVisivel = false;
    private ClienteVO clienteLogado;
    private ArrayList<ProdutoVO> listaProdutos = new ProdutoDAO().lerProdutos();
    private HBox paneClienteLog;
    private Label login;
    private ImageView foto;
    private Label nome;
    private Stage stage;
    static int itensCart = 0;

    public HomeCTR() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/snackshake/view/views/home.fxml"));
        loader.setRoot((Object) this);
        loader.setController((Object) this);

        try {
            loader.load();
            stage = new Stage();
            stage.setScene(new Scene(this));
            stage.setMinWidth(800);
            stage.setMinHeight(520);
            stage.show();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        mostraProdutos();
        criandoPaneCliente();
        clienteDeslogado();
    }

    @FXML
    private void abrirCarrinho(MouseEvent event) {
        CarrinhoCTR cc = new CarrinhoCTR(lblQtdItens);
    }

    @FXML
    private void meusDados(MouseEvent event) {
        if (clienteLogado != null) {
            MeusDadosCTR mdc = new MeusDadosCTR(clienteLogado);
        } else {
            LoginCTR lc = new LoginCTR();
            stage.close();
        }
    }

    private void showMenu(MouseEvent event) {
        if (menuVisivel) {
            pMenu.setVisible(false);
            menuVisivel = false;
        } else {
            pMenu.setVisible(true);
            menuVisivel = true;
            pMenu.getChildren().clear();
            pMenu.getChildren().add(new MenuCTR(clienteLogado, lblQtdItens)); // Corrigir depois
        }
    }

    private void mostraProdutos() {
        pAreaProdutos.getChildren().clear();
        for (ProdutoVO produto : listaProdutos) {
            pAreaProdutos.getChildren().add(new ProdutoCTR(produto, this.pInfoProduto, lblQtdItens));
        }
    }

    private void criandoPaneCliente() {
        foto = new ImageView();
        foto.setFitWidth(32);
        foto.setFitHeight(32);

        ImageView seta = new ImageView(new Image(getClass().getResourceAsStream("/br/com/snackshake/view/img/arrow-down-sign-to-navigate.png")));
        seta.setFitWidth(10);
        seta.setFitHeight(10);

        nome = new Label("label", seta);
        nome.setOpacity(0.51);
        nome.setUnderline(true);
        nome.setContentDisplay(ContentDisplay.RIGHT);

        paneClienteLog = new HBox(foto, nome);
        paneClienteLog.setAlignment(Pos.BOTTOM_CENTER);
        paneClienteLog.setCursor(Cursor.HAND);
        paneClienteLog.setSpacing(5);
        paneClienteLog.setId("pClienteLog");

        paneClienteLog.setOnMouseClicked(e -> showMenu(e));
    }

    public void preencheInfoClienteLog(ClienteVO cliente) {
        clienteLogado = cliente;
        foto.setImage(new Image(getClass().getResourceAsStream(cliente.getPhoto())));
        nome.setText(cliente.getName());

        int index = pOptionHeader.getChildren().indexOf(login);
        pOptionHeader.getChildren().set(index, paneClienteLog);
    }

    private void clienteDeslogado() {
        login = new Label("Login");
        login.setOpacity(0.51);
        login.setTextFill(Paint.valueOf("#4e4d4d"));
        login.setId("login");
        login.setCursor(Cursor.HAND);
        login.setFont(Font.font("System", FontWeight.BOLD, 12));

        int index = 0;
        pOptionHeader.getChildren().set(index, login);
        login.setOnMouseClicked(e -> {
            LoginCTR lc = new LoginCTR();
            stage.close();
        });
    }
}
