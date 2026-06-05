public class TiendaOnline {
    public static void main(String[] args) {
        // VARIABLES DE LA TIENDA
        
        // Mensajes de la aplicación
        String mensajeBienvenida = "Bienvenido a nuestra tienda en línea, ";
        String mensajeConfirmacion = ", tu pedido ha sido confirmado";
        String mensajeRechazo = ", lamentablemente el artículo seleccionado está agotado";
        String mensajeMostrarTotal = "El total de tu compra es: $";
        
        // Variables de productos (agrega las tuyas a continuación)
        double precioLibro = 15.99;
        double precioCamiseta = 25.50;

        double precioPantalon = 45.00; //precio pantalon
        double precioZapatos = 50.00; //precio zapatos
    
        // Variables de clientes (agrega las tuyas a continuación)
        String cliente1 = "Ana";

        String cliente2 = "Alex";
        String cliente3 = "Miguel";

    
        // Estado de pedidos (agrega las tuyas a continuación)
        boolean pedidoConfirmadoCliente1 = true;

        boolean pedidoConfirmacionCliente2 = true;
        boolean pedidoConfirmacionCliente3 = true;
    
        // INTERACCIÓN DE LA APLICACIÓN
        System.out.println(mensajeBienvenida + cliente1); // Muestra "Bienvenido a nuestra tienda en línea, Ana"
        // ** Aquí irán las declaraciones de impresión relacionadas con la interacción del cliente ** //

        if (pedidoConfirmadoCliente1){
            System.out.println("El Cliente " + cliente1 + " " + mensajeConfirmacion);
        }

        if (pedidoConfirmacionCliente3) {
            System.out.println("El Cliente " + cliente3 + " " + mensajeConfirmacion);
            
        }

        double valorTotalCompra = (precioZapatos * 2) + precioCamiseta + precioPantalon;

        if (pedidoConfirmacionCliente2){
            System.out.println("El Cliente " + cliente2 + " " + mensajeMostrarTotal + valorTotalCompra);
        }

        double precioCobrado = Math.ceil(precioPantalon + precioCamiseta);//redondea
        double nuevoTotal = Math.ceil(precioZapatos + precioLibro);

        double diferenciaPrecio = (precioCobrado - nuevoTotal);
        System.out.println("Para el Cliente " + cliente3 + " su nuevo Total es: "+ nuevoTotal);
        System.out.println("\nLa diferencia de Precio es: " + diferenciaPrecio);









    }
}