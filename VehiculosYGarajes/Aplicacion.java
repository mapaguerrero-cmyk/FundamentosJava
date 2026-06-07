import clases.Garage;
import clases.Vehiculo;
public class Aplicacion {
    public static void main(String[] args){
            int capacidadMaxima = 2;
            Garage garaje1 = new Garage(capacidadMaxima);
        
            Vehiculo auto1 = new Vehiculo("Citroen", "Zara", 2020);
            System.out.println(auto1.toString());
            Vehiculo auto2 = new Vehiculo("Omoda", "Electrico", 2024);
            System.out.println(auto2.toString());
            Vehiculo auto3 = new Vehiculo("Toyota", "Corolla", 2022);
            System.out.println(auto3.toString());
            
            garaje1.agregarVehiculo(auto1);
            garaje1.agregarVehiculo(auto2);
            garaje1.agregarVehiculo(auto3);

            System.out.println(garaje1.toString());
            
        }

    }