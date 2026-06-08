import clases.Prestamo;
import clases.Libro;
public class Aplicacion {
    public static void main(String[] args) {
        //Crea 2 préstamos con usuarios no especificados.
        Prestamo prestamo1 = new Prestamo();
        Prestamo prestamo2 = new Prestamo();

        //Crea 3 préstamos personalizados con nombres diferentes.
        Prestamo prestamo3 = new Prestamo("Paola Fuentes", false);
        Prestamo prestamo4 = new Prestamo("Luis Matus", false);
        Prestamo prestamo5 = new Prestamo("Sergio Vargas", true);

        //Crea y añade al menos 2 libros a cada préstamo.
        prestamo1.agregarUnLibro(new Libro("Cien años de soledad", "Gabriel García Márquez", 25.50));
        prestamo1.agregarUnLibro(new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", 30.00));

        prestamo2.agregarUnLibro(new Libro("1984", "George Orwell", 18.75));
        prestamo2.agregarUnLibro(new Libro("El Principito", "Antoine de Saint-Exupéry", 12.00));

        prestamo3.agregarUnLibro(new Libro("Crónica de una muerte anunciada", "Gabriel García Márquez", 15.50));
        prestamo3.agregarUnLibro(new Libro("Rayuela", "Julio Cortázar", 22.00));

        prestamo4.agregarUnLibro(new Libro("El Principito", "Antoine de Saint-Exupéry", 12.00));
        prestamo4.agregarUnLibro(new Libro("Cien años de soledad", "Gabriel García Márquez", 25.50));

        prestamo5.agregarUnLibro(new Libro("1984", "George Orwell", 18.75));
        prestamo5.agregarUnLibro(new Libro("Rayuela", "Julio Cortázar", 22.00));

        //Muestra los detalles de cada préstamo
        prestamo1.mostrarDetallesPrestamo();
        Double valorTotal1= prestamo1.calcularTotalDeReemplazo();
        System.out.println("Valor total es: $" + valorTotal1);
        prestamo2.mostrarDetallesPrestamo();
        prestamo3.mostrarDetallesPrestamo();
        prestamo3.mostrarEstatus();
        prestamo4.mostrarDetallesPrestamo();
        prestamo4.mostrarEstatus();
        prestamo5.mostrarDetallesPrestamo();
        prestamo5.mostrarEstatus();
        Double valorTotal5= prestamo5.calcularTotalDeReemplazo();
        System.out.println("Valor Total es: $" + valorTotal5);
        
    }
    
}
