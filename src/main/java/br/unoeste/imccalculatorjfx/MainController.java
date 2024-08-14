package br.unoeste.imccalculatorjfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class MainController {

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

    @FXML
    void onSalvarHistorico(ActionEvent event) {

    }

}