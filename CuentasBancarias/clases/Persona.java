package clases;

public class Persona {
    //Atributos
    private String nombre;
    private int edad;
    
    //Constructor
    public Persona(String nombre, int edad){
        this.nombre = nombre;
        this.edad =edad;
    }

    //Metodos de instancia
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    @Override 
    public String toString(){
        return "Nombre Titular: " + this.nombre + " | Edad: " + this.edad;
    }
    
}
