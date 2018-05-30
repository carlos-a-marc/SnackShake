package br.com.snackshake.controller;

import br.com.snackshake.model.dao.ClienteDAO;
import br.com.snackshake.model.vo.ClienteVO;
import java.io.File;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos
 */
public class MeusDadosCTR extends AnchorPane {

    @FXML
    private ImageView imgFoto;

    @FXML
    private Label lblNameHeader;

    @FXML
    private Label lblmailHeader;

    @FXML
    private ImageView imgAlterarFoto;

    @FXML
    private Label lblUsuario;

    @FXML
    private Label lblAltUsuario;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblAltEmail;

    @FXML
    private Label lblSenha;

    @FXML
    private Label lblAltSenha;

    @FXML
    private Label lblNome;

    @FXML
    private Label lblAltNome;

    @FXML
    private Label lblDocumento;

    @FXML
    private Label lblAltDocumento;

    @FXML
    private Label lblTelefone;

    @FXML
    private Label lblAltTelefone;

    @FXML
    private Label lblRua;

    @FXML
    private Label lblAltRua;

    @FXML
    private Label lblBairro;

    @FXML
    private Label lblAltBairro;

    @FXML
    private Label lblCidade;

    @FXML
    private Label lblAltCidade;

    private ClienteVO cliente;
    private Stage stage;

    public MeusDadosCTR(ClienteVO cliente) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/snackshake/view/views/meusDados.fxml"));
        loader.setRoot((Object) this);
        loader.setController((Object) this);

        try {
            loader.load();
            stage = new Stage();
            stage.setScene(new Scene(this));
            stage.show();

            this.cliente = cliente;
            preencheInformacoes();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void editarInfo(MouseEvent event) {
        if (event.getSource() == lblAltUsuario) {
            telaEdicao(lblUsuario);
        } else if (event.getSource() == lblAltEmail) {
            telaEdicao(lblEmail);
        } else if (event.getSource() == lblAltDocumento) {
            telaEdicao(lblDocumento);
        } else if (event.getSource() == lblAltTelefone) {
            telaEdicao(lblTelefone);
        } else if (event.getSource() == lblAltRua) {
            telaEdicao(lblRua);
        } else if (event.getSource() == lblAltBairro) {
            telaEdicao(lblBairro);
        } else if (event.getSource() == lblAltCidade) {
            telaEdicao(lblCidade);
        } else if (event.getSource() == lblAltSenha) {
            telaEdicao(lblSenha);
        } else if (event.getSource() == imgFoto) {
            carregarFoto();
        }
    }

    @FXML
    private void mouseForaFoto(MouseEvent event) {
        imgAlterarFoto.setVisible(false);
    }

    @FXML
    private void mouseSobreFoto(MouseEvent event) {
        imgAlterarFoto.setVisible(true);
    }

    @FXML
    private void cancelar(MouseEvent event) {
        stage.close();
    }

    @FXML
    private void salvar(MouseEvent event) {
        // Tratar foto depois
        ClienteVO novo = new ClienteVO(lblNome.getText(), lblUsuario.getText(), lblEmail.getText(), lblSenha.getText(), lblTelefone.getText(), this.cliente.getPhoto());
        new ClienteDAO().atualizarCliente(this.cliente, novo);
    }

    private void preencheInformacoes() {
        this.imgFoto.setImage(new Image(getClass().getResourceAsStream(cliente.getPhoto())));
        this.lblNameHeader.setText(cliente.getName());
        this.lblmailHeader.setText(cliente.getMail());

        this.lblUsuario.setText(cliente.getUser());
        this.lblEmail.setText(cliente.getMail());
        this.lblSenha.setText(cliente.getPassword());

        this.lblNome.setText(cliente.getName());
        this.lblTelefone.setText(cliente.getPhone());

    }

    private void telaEdicao(Label lblInfo) {
        EditorInfoClienteCTR editor = new EditorInfoClienteCTR(lblInfo);
    }

    private void carregarFoto() {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PNG Files", "*.png"));
        File foto = fc.showOpenDialog(null);

        if (foto != null) {
            JOptionPane.showMessageDialog(null, "Não implementado.");
        }
    }

}
