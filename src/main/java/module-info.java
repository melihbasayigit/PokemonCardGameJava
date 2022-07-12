module com.example.pokemoncardgame {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.pokemoncardgame to javafx.fxml;
    exports com.example.pokemoncardgame;
}