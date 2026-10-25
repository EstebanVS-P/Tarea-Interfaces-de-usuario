package viewController;

import co.edu.uniquindio.poo.empresajfx.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.net.URL;
import java.util.ResourceBundle;

public class PrimaryController {

    public PrimaryController() {
        super();
    }
    @FXML
    private ResourceBundle resources;

    App app;
    @FXML
    private URL location;

    @FXML
    private Button primaryButton;

    @FXML
    void onOpenCrudEstudiante(){
        app.openCrudEstudiante();
    }

    @FXML
    void onOpenCrudMateria(){app.openCrudMateria();}

    public void setApp(App app){
        this.app = app;
    }

    @FXML
    void initialize(){

    }
}
