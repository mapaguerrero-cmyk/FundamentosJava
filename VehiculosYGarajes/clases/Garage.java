package clases;

import java.util.ArrayList;

public class Garage {
    //Atributos
    public ArrayList<Vehiculo> vehiculos;
    public int capacidad;

    // Constructor
    public Garage(int capacidad){
        this.vehiculos = new ArrayList<Vehiculo>(); //Inicializar la lista
        this.capacidad = capacidad;
    }

    //Metodos

    public void agregarVehiculo(Vehiculo auto){
        int capacidadEnUso = this.vehiculos.size();

        if(capacidadEnUso < this.capacidad){
            this.vehiculos.add(auto);
            System.out.println("Vehiculo agregado: " + auto.marca);
        }else{
            System.out.println("No hay espacio para recibir el vehiculo: " + auto.marca);
        }
    }
    
    @Override
    public String toString(){
        return "Garage registra los vehiculos: " + vehiculos;
    }


    
}


