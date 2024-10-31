module hexlet.code.my_wave_app {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires jlayer;
    requires static lombok;
    requires java.sql;

    opens hexlet.code.my_wave_app to javafx.fxml;
    exports hexlet.code.my_wave_app;
}