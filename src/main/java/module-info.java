module org.tookaystewie.calculatorfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens org.tookaystewie.calculatorfx to javafx.fxml;
    exports org.tookaystewie.calculatorfx;
}