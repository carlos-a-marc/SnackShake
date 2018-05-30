package br.com.snackshake.controller;

import br.com.snackshake.model.vo.ProdutoVO;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Carlos
 */
public class NutritionalInfoCTR extends AnchorPane {

    @FXML
    private ImageView imgImagem;
    
    @FXML
    private Label lblkcal;

    @FXML
    private Label lblCarbohidratos;

    @FXML
    private Label lblProteinas;

    @FXML
    private Label lblGorduras;

    @FXML
    private Label lblSodio;


    public NutritionalInfoCTR(ProdutoVO produto) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/snackshake/view/views/nutricional.fxml"));
        loader.setRoot((Object) this);
        loader.setController((Object) this);

        try {
            loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(this));
            stage.setResizable(false);
            stage.show();
            
            this.imgImagem.setImage(new Image(getClass().getResourceAsStream(produto.getImagem())));
            this.lblkcal.setText(Integer.toString(produto.getInfoNutricional().getCalorias()));
            this.lblCarbohidratos.setText(Integer.toString(produto.getInfoNutricional().getCarbohidratos()));
            this.lblProteinas.setText(Integer.toString(produto.getInfoNutricional().getProteinas()));
            this.lblGorduras.setText(Integer.toString(produto.getInfoNutricional().getGorduras()));
            this.lblSodio.setText(Integer.toString(produto.getInfoNutricional().getSodio()));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
