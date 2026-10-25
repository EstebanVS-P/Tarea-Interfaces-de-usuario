package model;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Optional;

public class Empresa {

    private String nombre;

    private Collection<Estudiante> estudiantes = new LinkedList<>();
    private Collection<Materia> materias = new LinkedList<>();
//constructor
    public Empresa(String nombre) {
        this.nombre = nombre;
    }
    //get y set


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public Collection<Materia> getMaterias() {
        return materias;
    }

    public void setEstudiantes(Collection<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public void setMaterias(Collection<Materia> materias) {
        this.materias = materias;
    }

    //crud estudiante
    public boolean agregarEstudiante(Estudiante estudiante){
        boolean centinela = false;
        Optional<Estudiante> estudianteOptional = verificarEstudiante(estudiante.getCedula());
        if(estudianteOptional.isPresent()){
            return centinela;
        }else{
            estudiantes.add(estudiante);
            return true;
        }
    }

    public boolean eliminarEstudiante(String cedula){
        boolean centinela = false;
        Optional<Estudiante> estudianteOptional = verificarEstudiante(cedula);
        if(estudianteOptional.isPresent()){
            estudiantes.remove(estudianteOptional.get());
            return true;
        }
        return centinela;
    }

    public boolean actualizarEstudiante(String cedula, Estudiante actualizado){
        boolean centinela = false;
        Optional<Estudiante> estudianteOptional = verificarEstudiante(cedula);
        if(estudianteOptional.isPresent()){
            estudianteOptional.get().setCedula(actualizado.getCedula());
            estudianteOptional.get().setNombre(actualizado.getNombre());
            estudianteOptional.get().setApellido(actualizado.getApellido());
            estudianteOptional.get().setPrograma(actualizado.getPrograma());
            return true;
        }
        return centinela;
    }

    public Optional<Estudiante> verificarEstudiante(String cedula){
        return estudiantes.stream().filter(estudiante -> estudiante.getCedula().equals(cedula)).findFirst();
    }

    //crud materia
        public boolean agregarMateria(Materia materia){
        boolean centinela = false;
        Optional<Materia> materiaOptional = verificarMateria(materia.getCodigo());
        if(materiaOptional.isPresent()){
            return centinela;
        }else{
            materias.add(materia);
            return true;
        }
    }

    public boolean eliminarMateria(String codigo){
        boolean centinela = false;
        Optional<Materia> materiaOptional = verificarMateria(codigo);
        if(materiaOptional.isPresent()){
            materias.remove(materiaOptional.get());
            return true;
        }
        return centinela;
    }

        public boolean actualizarMateria(String codigo, Materia actualizada){
        boolean centinela = false;
        Optional<Materia> materiaOptional = verificarMateria(codigo);
        if(materiaOptional.isPresent()){
            materiaOptional.get().setCodigo(actualizada.getCodigo());
            materiaOptional.get().setNombre(actualizada.getNombre());
            materiaOptional.get().setTotalHorasSemestre(actualizada.getTotalHorasSemestre());
                materiaOptional.get().setCreditos(actualizada.getCreditos());
            return true;
        }
        return centinela;
    }

    public Optional<Materia> verificarMateria(String codigo){
        return materias.stream().filter(materia -> materia.getCodigo().equals(codigo)).findFirst();
    }
}
