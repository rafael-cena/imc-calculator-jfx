package br.unoeste.imccalculatorjfx;

import br.unoeste.imccalculatorjfx.entity.Pessoa;
import br.unoeste.imccalculatorjfx.util.Singleton;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class TableController implements Initializable {
    public TableView <Pessoa>tabela;
    public TableColumn <Pessoa, String>coNome;
    public TableColumn <Pessoa, Double>coPeso;
    public TableColumn <Pessoa, Double>coAltura;
    public TableColumn <Pessoa, Double>coIMC;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        coNome.setCellValueFactory(new PropertyValueFactory<>("name"));
        coPeso.setCellValueFactory(new PropertyValueFactory<>("weight"));
        coAltura.setCellValueFactory(new PropertyValueFactory<>("height"));
        coIMC.setCellValueFactory(new PropertyValueFactory<>("imc"));

        tabela.setItems(FXCollections.observableArrayList(Singleton.getRepo().getList()));
    }
}
