import clases.Garage;
import clases.Vehiculo;
public class Aplicacion {
    public static void main(String[] args){
            //Crear un garaje con una capacidad definida para dos vehículos.
            int capacidadMaxima = 2;
            Garage garaje1 = new Garage(capacidadMaxima);

            //Crear al menos tres vehículos con diferentes marcas, modelos y años.
            Vehiculo auto1 = new Vehiculo("Citroen", "Zara", 2020);
            Vehiculo auto2 = new Vehiculo("Omoda", "Electrico", 2024);
            Vehiculo auto3 = new Vehiculo("Toyota", "Corolla", 2022);
            
            //Agregar dos vehículos al garaje y verificar que no se exceda la capacidad.
            garaje1.agregarVehiculo(auto1);
            garaje1.agregarVehiculo(auto2);
            //Imprimir los vehículos almacenados en el garaje para verificar que se añadieron correctamente.
            System.out.println("Garage almacena los siguientes vehiculos: ");
            garaje1.mostrarVehiculos();

            //Intentar agregar un tercer vehículo cuando el garaje está lleno 
            garaje1.agregarVehiculo(auto3);
        }

    }