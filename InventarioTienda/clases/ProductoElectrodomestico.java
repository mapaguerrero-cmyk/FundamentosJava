package clases;

public class ProductoElectrodomestico {
    //Atributos
    private String nombre;
    private double precio;
    private int cantidadDisponible;

    //Constructor
    public ProductoElectrodomestico(String nombre, double precio, int cantidadDisponible){
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
    }

    public ProductoElectrodomestico(String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadDisponible = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }
    //Metodo de instancia que Imprime los detalles del producto.
    public String mostrarInformacion(){
        return "Producto: " + this.getNombre() + "| precio: $" + this.getPrecio() + " | Stock: " + this.getCantidadDisponible();
    }

    
}  