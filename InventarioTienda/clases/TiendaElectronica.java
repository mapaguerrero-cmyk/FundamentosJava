package clases;

import java.util.ArrayList;

public class TiendaElectronica {
    private ArrayList<ProductoElectrodomestico> productosElectrodomesticos;

    //Constructor
    public TiendaElectronica(){
        this.productosElectrodomesticos = new ArrayList<ProductoElectrodomestico>(); //Inicializar inventario tienda
    }

    //Metodos de instancia
    //Agregar un producto al inventario de la tienda
    public void agregarProducto(ProductoElectrodomestico producto){
        this.productosElectrodomesticos.add(producto);
    }

    
    public ArrayList<ProductoElectrodomestico> getProductosElectrodomesticos() {
        return productosElectrodomesticos;
    }

     public void setProductosElectrodomesticos(ArrayList<ProductoElectrodomestico> productosElectrodomesticos) {
        this.productosElectrodomesticos = productosElectrodomesticos;
    }

    //Metodo buscar un producto por su nombre
    public ProductoElectrodomestico buscarProductoPorNombre(String nombre) {
        for (ProductoElectrodomestico producto : this.productosElectrodomesticos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
            return producto;  // Lo encontró
        }
    }
    return null;  // No lo encontró
    }
    
    // Realizar una venta
    public void realizarVenta(String nombreProducto, int cantidad) {
        // Paso 1: Buscar el producto
        ProductoElectrodomestico producto = buscarProductoPorNombre(nombreProducto);
        
        // Paso 2: Verificar si existe
        if (producto == null) {
            System.out.println("Producto no encontrado: " + nombreProducto);
            return;
        }
        
        // Paso 3: Verificar cantidad solicitada para venta sea válida
        if (cantidad <= 0) {
            System.out.println("La cantidad a vender debe ser mayor a 0");
            return;
        }
        
        // Paso 4: Obtener stock actual
        int stockActual = producto.getCantidadDisponible();
        
        // Paso 5: Verificar si hay stock suficiente
        if (stockActual >= cantidad) {
            // Realizar la venta
            int nuevoStock = stockActual - cantidad;
            producto.setCantidadDisponible(nuevoStock);
            System.out.println("Venta realizada: " + cantidad + " unidad(es) de " + nombreProducto);
            System.out.println(" Stock restante: " + nuevoStock);
            
            // Verificar si quedó agotado
            if (nuevoStock == 0) {
                System.out.println("¡Producto agotado! - " + nombreProducto);
            }
        } else {
            // No hay suficiente stock
            System.out.println("Stock insuficiente. Disponible: " + stockActual + ", Solicitado: " + cantidad);
        }
    }


    public void mostrarProductosDisponibles(){
        for(ProductoElectrodomestico producto:this.productosElectrodomesticos){
            System.out.println(producto.mostrarInformacion());
        }
    }



}
