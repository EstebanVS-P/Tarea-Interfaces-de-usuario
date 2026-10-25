package controller;

import model.Empresa;
import model.Estudiante;

import java.util.Collection;

public class EstudianteController {

    Empresa empresa;

    public EstudianteController(Empresa empresa){
        this.empresa = empresa;
    }

    public boolean crearEstudiante(Estudiante estudiante){
        return empresa.agregarEstudiante(estudiante);
    }

    public Collection<Estudiante> obtenerListaEstudiantes(){
        return empresa.getEstudiantes();
    }

    public boolean eliminarEstudiante(String cedula){
        return empresa.eliminarEstudiante(cedula);
    }

    public boolean actualizarEstudiante(String cedula,Estudiante estudiante){
        return empresa.actualizarEstudiante(cedula,estudiante);
    }
}
