package clases;

import java.util.ArrayList;

public class Prestamo {
    //Atributos
    private String nombreUsuario;
    private ArrayList<Libro> libros;
    private boolean estatus;

    //Constructor
    public Prestamo(){
        this.nombreUsuario="Invitado";
        this.libros = new ArrayList<Libro>();
        this.estatus = true;
    }

    public Prestamo(String nombreUsuario, boolean estatus){
        this.nombreUsuario = nombreUsuario;
        this.libros = new ArrayList<Libro>();
        this.estatus = estatus;
    }

     //Metodos de instancia

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    public void agregarUnLibro(Libro libro){
        this.libros.add(libro);

    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

    public void mostrarEstatus(){
        String resultado= " ";
        resultado = isEstatus() ? "Prestamo Activo":"Prestamo Inactivo";
        System.out.println(resultado);
    }

    public Double calcularTotalDeReemplazo(){
        if (this.libros == null || this.libros.isEmpty()) {
        return 0.0;
        }
        double total = 0;
        for(Libro libro:this.libros){
            total +=libro.getPrecioDeReemplazo();
        }
        return total;

    }

    public void mostrarDetallesPrestamo(){
        System.out.println("Nombre usuario: " + this.nombreUsuario + " .Usted tiene en prestamo los siguientes libros: ");
        for(Libro libro:this.libros){
            System.out.println(libro.toString());
        }
    }
}
