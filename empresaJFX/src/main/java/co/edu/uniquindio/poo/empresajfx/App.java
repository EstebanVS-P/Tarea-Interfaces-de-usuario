package co.edu.uniquindio.poo.empresajfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Empresa;
import model.Estudiante;
import model.Materia;
import viewController.EstudianteViewController;
import viewController.MateriaViewController;
import viewController.PrimaryController;

import java.io.IOException;

/*
 * JavaFX App
 */
public class App extends Application {

    private Stage primaryStage;
    public static Empresa empresa = new Empresa("Uniquindio");

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Gestion estudiantes UQ");
        openViewPrincipal();
    }

    private void openViewPrincipal(){
        inicializarData();

        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/primary.fxml"));
            javafx.scene.layout.VBox rootLayout = (javafx.scene.layout.VBox)
            loader.load();
            PrimaryController primaryController = loader.getController();
            primaryController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException exception){
            //Todo Auto-generated catch block
            exception.printStackTrace();
        }
    }

    public void volverPrincipal(){
        openViewPrincipal();
    }

    public static void main(String args[]){
        launch();
    }

    public void openCrudEstudiante(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/crudEstudiante.fxml"));
            AnchorPane rootLayout= (AnchorPane) loader.load();
            EstudianteViewController estudianteViewController = loader.getController();
            estudianteViewController.setApp(this);

            Scene scene = new Scene (rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException exception){
            //Todo Auto-generated catch block
            exception.printStackTrace();
        }
    }
    //servicios
    public void inicializarData(){
        Estudiante estudiante = new Estudiante("12233", "juan", "apellido","Ingenieria de sistemas");
        empresa.agregarEstudiante(estudiante);

        Materia materia = new Materia("Programacion 1","12309",(byte)3,(byte)4);
        empresa.agregarMateria(materia);
    }

    public void openCrudMateria(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/crudMateria.fxml"));
            AnchorPane rootLayout= (AnchorPane) loader.load();
            MateriaViewController materiaViewController = loader.getController();
            materiaViewController.setApp(this);

            Scene scene = new Scene (rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException exception){
            //Todo Auto-generated catch block
            exception.printStackTrace();
        }
    }
}
