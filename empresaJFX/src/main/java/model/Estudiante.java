package model;

public class Estudiante {

    private String cedula,nombre,apellido,programa;

    public Estudiante(String cedula, String nombre, String apellido, String programa){

        this.cedula=cedula;
        this.nombre=nombre;
        this.apellido= apellido;
        this.programa=programa;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }
}
