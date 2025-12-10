module org.tookaystewie.calculatorfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    //opens basically allows other modules access to our content
    //here, we open up to javaFX to reference our code
    opens org.tookaystewie.calculatorfx to javafx.fxml;
    opens org.tookaystewie.controllers to javafx.fxml;
    exports org.tookaystewie.calculatorfx;
    exports org.tookaystewie.controllers;

}