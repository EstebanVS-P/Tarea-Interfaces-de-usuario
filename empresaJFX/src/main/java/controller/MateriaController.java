package controller;

import model.Empresa;
import model.Materia;

import java.util.Collection;

public class MateriaController {

    Empresa empresa;

    public MateriaController(Empresa empresa){
        this.empresa = empresa;
    }

    public boolean crearMateria(Materia materia){
        return empresa.agregarMateria(materia);
    }

    public Collection<Materia> obtenerListaMaterias(){
        return empresa.getMaterias();
    }

    public boolean eliminarMateria(String codigo){
        return empresa.eliminarMateria(codigo);
    }

    public boolean actualizarMateria(String codigo,Materia materia){
        return empresa.actualizarMateria(codigo, materia);
    }
}
