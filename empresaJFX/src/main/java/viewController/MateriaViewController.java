package viewController;

import co.edu.uniquindio.poo.empresajfx.App;
import controller.MateriaController;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Materia;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MateriaViewController {

    MateriaController materiaController;
    ObservableList<Materia> listaMaterias= FXCollections.observableArrayList();
    Materia selectedMateria;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNombre;

    @FXML
    private Button btnLimpiar;

    @FXML
    private TableView<Materia> tblListMaterias;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnActualizarMateria;

    @FXML
    private Button btnLimpiarLista;

    @FXML
    private TableColumn<Materia,String> tbcNombre;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TableColumn<Materia, String> tbcCodigo;

    @FXML
    private Button btbAgregarMateria;

    @FXML
    private TableColumn<Materia, Integer> tbcTotalHorasSemestre;

    @FXML
    private TextField txtTotalHorasSemestre;
    private App app;

    @FXML
    private TextField txtCreditos;

    @FXML
    private TableColumn<Materia,Byte> tbcCreditos;

    @FXML
    void onAgregarMateria(){
        agregarMateria();
    }

    @FXML
    void onActualizarMateria(){
        actualizarMateria();
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
        eliminarMateria();
    }

    @FXML
    void onVolverPrincipal() throws IOException{
        app.volverPrincipal();
    }

    @FXML
    void initialize(){
        this.app=app;
        materiaController = new MateriaController(app.empresa);
        initializeView();
    }

    private void initializeView(){
        //Traer los datos del estudiante a la tabla
        initDataBinding();

        //obtiene la lista
        obtenerMateria();

        //Limpiar la tabla
        tblListMaterias.getItems().clear();

        //Agregar los elementos a la tabla
        tblListMaterias.setItems(listaMaterias);

        //Seleccionar elemento de la tabla
        listenerSelection();
    }

    private void initDataBinding(){
        tbcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbcCodigo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigo()));
        tbcTotalHorasSemestre.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getTotalHorasSemestre()));
        tbcCreditos.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCreditos()));

        //Usamos SimpleObjectProperty para manejar Double, Integer y byte correctamente
    }

    private void obtenerMateria(){
        listaMaterias.addAll(materiaController.obtenerListaMaterias());
    }

    private void listenerSelection(){
        tblListMaterias.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)->{
            selectedMateria=newSelection; mostrarInformacionMateria(selectedMateria);});
    }

    private void mostrarInformacionMateria(Materia materia){
        if(materia!=null){
            txtNombre.setText(materia.getNombre());
            txtCodigo.setText(materia.getCodigo());
            txtTotalHorasSemestre.setText(String.valueOf(materia.getTotalHorasSemestre()));
            txtCreditos.setText(String.valueOf(materia.getCreditos()));
        }
    }
    private void agregarMateria(){
        Materia materia = buildMateria();
        if(materiaController.crearMateria(materia)){
            listaMaterias.add(materia);
            limpiarCamposMateria();
        }
    }

    private Materia buildMateria(){

        Materia materia = new Materia(txtNombre.getText(),txtCodigo.getText(),Integer.valueOf(txtTotalHorasSemestre.getText()), Byte.valueOf(txtCreditos.getText()));
        return materia;
    }

    private void eliminarMateria(){
        if(materiaController.eliminarMateria(txtCodigo.getText())){
            listaMaterias.remove(selectedMateria);
            limpiarCamposMateria();
            limpiarSeleccion();
        }
    }

    private void actualizarMateria(){
        if(selectedMateria!=null && materiaController.actualizarMateria(selectedMateria.getCodigo(),buildMateria())){

            int index = listaMaterias.indexOf(selectedMateria);
            if(index>=0){
                listaMaterias.set(index,buildMateria());
            }

            tblListMaterias.refresh();
            limpiarSeleccion();
            limpiarCamposMateria();
        }
    }

    private void limpiarSeleccion(){
        tblListMaterias.getSelectionModel().clearSelection();
        limpiarCamposMateria();
    }

    public void limpiarCamposMateria(){
        txtNombre.clear();
        txtCodigo.clear();
        txtTotalHorasSemestre.clear();
        txtCreditos.clear();
    }

    public void setApp(App app){
        this.app=app;
    }

    public void limpiarTabla(){
        tblListMaterias.getItems().clear();
        limpiarCamposMateria();
    }
}
