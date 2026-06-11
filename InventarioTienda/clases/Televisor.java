package clases;

public class Televisor extends ProductoElectrodomestico{
    // Atributos adicionales
    private double tamanoPantalla;
    private String resolucion;

    // Constructor
    public Televisor(String nombre, double precio, int cantidadDisponible, double tamanoPantalla, String resolucion){
            // llamar constructor clase base o super clase
            super(nombre, precio, cantidadDisponible);
            this.tamanoPantalla = tamanoPantalla;
            this.resolucion = resolucion;
    }

    //getters y setters
    public double getTamanoPantalla() {
        return tamanoPantalla;
    }

    public void setTamanoPantalla(double tamanoPantalla) {
        this.tamanoPantalla = tamanoPantalla;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }
    
    @Override
    public String mostrarInformacion(){
        return super.mostrarInformacion() + "\nTamano pantalla: " + this.getTamanoPantalla() + " | Resolucion: " + this.getResolucion();
    }

    
}
