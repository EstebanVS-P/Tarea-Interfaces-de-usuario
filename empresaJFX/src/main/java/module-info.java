module co.edu.uniquindio.poo.empresajfx{
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.uniquindio.poo.empresajfx to javafx.fxml;
    exports co.edu.uniquindio.poo.empresajfx;
    exports viewController;
    opens viewController to javafx.fxml;
}