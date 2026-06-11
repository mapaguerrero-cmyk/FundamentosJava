import clases.ProductoElectrodomestico;
import clases.ComputadoraPortatil;
import clases.Televisor;
import clases.TiendaElectronica;

public class Aplicacion{

    public static void main(String[] args) {

        // Crear productos
        Televisor tvSony = new Televisor("Sony",550000.0 , 8, 50, "Hihg Definition");
        ComputadoraPortatil hpPortatil = new ComputadoraPortatil("Corei7", 800000.0, 10, "HP Intel Core 7", "8 Mbyte", "00342-41428OEM");
        Televisor tvXiaomi = new Televisor("Xiaomi", 700000.0, 15, 55, "High");

        // Crear la tienda
        TiendaElectronica tienda = new TiendaElectronica();

        // Agregar productos a la tienda
        tienda.agregarProducto(tvSony);
        tienda.agregarProducto(hpPortatil);
        tienda.agregarProducto(tvXiaomi);

        // Mostrar inventario inicial
        System.out.println("\n=== INVENTARIO INICIAL ===");
        tienda.mostrarProductosDisponibles();

        // Buscar un producto por nombre
        System.out.println("\n=== BUSCAR PRODUCTO ===");
        ProductoElectrodomestico encontrado = tienda.buscarProductoPorNombre("Sony");
        if (encontrado != null){
            System.out.println("Producto encontrado: ");
            System.out.println(encontrado.mostrarInformacion());
        }else{
            System.out.println("Producto no encontrado");

        }
        // Realizar ventas
        System.out.println("\n=== REALIZAR VENTAS ===");

        // Vender 8 televisores Sony
        tienda.realizarVenta("Sony", 8);

        // Vender 5 computadora HP
        tienda.realizarVenta("Corei7", 5);

        // Vender 10 tv Xiaomi
        tienda.realizarVenta("Xiaomi", 10);


        // Intentar vender más de lo que hay (prueba de error)
        System.out.println("\n=== 10 unidades de Sony (prueba de stock insuficiente) ===");
        tienda.realizarVenta("Sony", 10);

        // Venta de producto inexistente
        tienda.realizarVenta("Jugera", 1);

        // Mostrar inventario después de las ventas
        System.out.println("\n=== INVENTARIO FINAL ===");
        tienda.mostrarProductosDisponibles();



        
    }
}
    