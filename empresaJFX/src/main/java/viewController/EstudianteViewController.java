package viewController;

import co.edu.uniquindio.poo.empresajfx.App;
import controller.EstudianteController;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Estudiante;

import java.net.URL;
import java.util.ResourceBundle;

public class EstudianteViewController {

    EstudianteController estudianteController;
    ObservableList<Estudiante> listaEstudiantes= FXCollections.observableArrayList();
    Estudiante selectedEstudiante;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNombre;

    @FXML
    private Button btnLimpiar;

    @FXML
    private TableView<Estudiante> tblListEstudiante;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnActualizarEstudiante;

    @FXML
    private Button btnLimpiarLista;

    @FXML
    private TableColumn<Estudiante,String> tbcNombre;

    @FXML
    private TextField txtApellido;

    @FXML
    private TableColumn<Estudiante, String> tbcApellido;

    @FXML
    private Button btbAgregarEstudiante;

    @FXML
    private TableColumn<Estudiante, String> tbcCedula;

    @FXML
    private TextField txtCedula;
    private App app;

    @FXML
    private TextField txtPrograma;

    @FXML
    private TableColumn<Estudiante,String> tbcPrograma;

    @FXML
    void onAgregarEstudiante(){
        agregarEstudiante();
    }

    @FXML
    void onActualizarEstudiante(){
        actualizarEstudiante();
    }

    @FXML
    void onLimpiar(){
        limpiarSeleccion();
    }

    @FXML
    void onLimpiarLista(){
        limpiarTabla();
    }

    @FXML
    void onEliminar(){
        eliminarEstudiante();
    }

    @FXML
    void onVolverPrincipal(){
        app.volverPrincipal();
    }

    @FXML
    void initialize(){
        this.app=app;
        estudianteController = new EstudianteController(app.empresa);
        initializeView();
    }

    private void initializeView(){
        //Traer los datos del estudiante a la tabla
        initDataBinding();

        //obtiene la lista
        obtenerEstudiantes();

        //Limpiar la tabla
        tblListEstudiante.getItems().clear();

        //Agregar los elementos a la tabla
        tblListEstudiante.setItems(listaEstudiantes);

        //Seleccionar elemento de la tabla
        listenerSelection();
    }

    private void initDataBinding(){
        tbcCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        tbcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbcApellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        tbcPrograma.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrograma()));

        //Usamos SimpleObjectProperty para manejar Double y Integer correctamente
    }

    private void obtenerEstudiantes(){
        listaEstudiantes.addAll(estudianteController.obtenerListaEstudiantes());
    }

    private void listenerSelection(){
        tblListEstudiante.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)->{
            selectedEstudiante=newSelection;
            mostrarInformacionEstudiante(selectedEstudiante);});
    }

    private void mostrarInformacionEstudiante(Estudiante estudiante){
        if(estudiante!=null){
            txtCedula.setText(estudiante.getCedula());
            txtNombre.setText(estudiante.getNombre());
            txtApellido.setText(estudiante.getApellido());
            txtPrograma.setText(estudiante.getPrograma());
        }
    }
    private void agregarEstudiante(){
        Estudiante estudiante = buildEstudiante();
        if(estudianteController.crearEstudiante(estudiante)){
            listaEstudiantes.add(estudiante);
            limpiarCamposEstudiante();
        }
    }

    private Estudiante buildEstudiante(){

        Estudiante estudiante = new Estudiante(txtCedula.getText(),txtNombre.getText(),txtApellido.getText(), txtPrograma.getText());
        return estudiante;
    }

    private void eliminarEstudiante(){
        if(estudianteController.eliminarEstudiante(txtCedula.getText())){
            listaEstudiantes.remove(selectedEstudiante);
            limpiarCamposEstudiante();
            limpiarSeleccion();
        }
    }

    private void actualizarEstudiante(){
        if(selectedEstudiante!=null && estudianteController.actualizarEstudiante(selectedEstudiante.getCedula(),buildEstudiante())){

            int index = listaEstudiantes.indexOf(selectedEstudiante);
            if(index>=0){
                listaEstudiantes.set(index,buildEstudiante());
            }

            tblListEstudiante.refresh();
            limpiarSeleccion();
            limpiarCamposEstudiante();
        }
    }

    private void limpiarSeleccion(){
        tblListEstudiante.getSelectionModel().clearSelection();
        limpiarCamposEstudiante();
    }

    public void limpiarCamposEstudiante(){
        txtCedula.clear();
        txtNombre.clear();
        txtApellido.clear();
        txtPrograma.clear();
    }

    public void setApp(App app){
        this.app=app;
    }

    public void limpiarTabla(){
        tblListEstudiante.getItems().clear();
        limpiarCamposEstudiante();
    }
}
