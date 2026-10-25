package model;

public class Materia {

    private String nombre, codigo;
    private int totalHorasSemestre;
    private byte creditos;

    public Materia(String nombre, String codigo, int totalHorasSemestre, byte creditos) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.totalHorasSemestre = totalHorasSemestre;
        this.creditos = creditos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getTotalHorasSemestre() {
        return totalHorasSemestre;
    }

    public void setTotalHorasSemestre(int totalHorasSemestre) {
        this.totalHorasSemestre = totalHorasSemestre;
    }

    public byte getCreditos() {
        return creditos;
    }

    public void setCreditos(byte creditos) {
        this.creditos = creditos;
    }
}
