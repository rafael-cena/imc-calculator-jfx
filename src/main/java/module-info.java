module br.unoeste.imccalculatorjfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens br.unoeste.imccalculatorjfx to javafx.fxml;
    opens br.unoeste.imccalculatorjfx.entity to javafx.fxml;
    exports br.unoeste.imccalculatorjfx;
    exports br.unoeste.imccalculatorjfx.entity;
}