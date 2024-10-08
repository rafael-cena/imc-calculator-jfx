package br.unoeste.imccalculatorjfx;

import br.unoeste.imccalculatorjfx.entity.Pessoa;
import br.unoeste.imccalculatorjfx.repository.PessoaRepo;
import br.unoeste.imccalculatorjfx.util.IMC;
import br.unoeste.imccalculatorjfx.util.Singleton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainController {

    public Label lbPeso;

    public Label lbAltura;

    @FXML
    private Label lbCategoria;

    @FXML
    private Label lbIMC;

    @FXML
    private Slider slAltura;

    @FXML
    private Slider slPeso;

    @FXML
    private TextField tfNome;

    private void valueDefault () {
        tfNome.setText("");
        slPeso.setValue(60.00);
        lbPeso.setText(String.format("%.2f Kg", slPeso.getValue()));
        slAltura.setValue(160);
        lbAltura.setText(String.format("%.0f cm", slAltura.getValue()));
        calcIMC();
    }

    @FXML
    void onSalvarHistorico(ActionEvent event) {
        if (!tfNome.getText().isEmpty()) {
            // salvar via serialização
            Pessoa pessoa = new Pessoa(tfNome.getText(), slPeso.getValue(), slAltura.getValue(), Double.parseDouble(lbIMC.getText().replace(",",".")));
//            PessoaRepo repo = new PessoaRepo();
            Singleton.getRepo().add(pessoa);

            valueDefault();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("O campo nome não pode estar vazio!");
            alert.setContentText("Informe seu nome");
            alert.showAndWait();
            Platform.runLater(() -> {tfNome.requestFocus();});
        }
    }

    public void onPesoMouseMouseClicked(MouseEvent mouseEvent) {
        lbPeso.setText(String.format("%.2f Kg", slPeso.getValue()));
        calcIMC();
    }

    public void onAlturaMouseMouseClicked(MouseEvent mouseEvent) {
        lbAltura.setText(String.format("%.0f cm", slAltura.getValue()));
        calcIMC();
    }

    public void onPesoMouseDragged(MouseEvent mouseEvent) {
        lbPeso.setText(String.format("%.2f Kg", slPeso.getValue()));
        calcIMC();
    }

    public void onAlturaMouseDragged(MouseEvent mouseEvent) {
        lbAltura.setText(String.format("%.0f cm", slAltura.getValue()));
        calcIMC();
    }

    private void calcIMC () {
        double peso = slPeso.getValue();
        double altura = slAltura.getValue()/100;
//        double imc = peso/(Math.pow(altura,2));
//        lbIMC.setText(String.format("%.1f", imc));
        lbIMC.setText(String.format("%.1f", IMC.get(peso, altura)));
        lbCategoria.setText(IMC.getCondicao(IMC.get(peso, altura)));
    }

    public void onNovoIMC(ActionEvent actionEvent) {

    }

    public void onMostrarHistorico(ActionEvent actionEvent) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(IMCCalculator.class.getResource("table-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 469);
        Stage stage = new Stage();
        stage.setTitle("Histórico");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UTILITY);
        stage.showAndWait();
    }
}