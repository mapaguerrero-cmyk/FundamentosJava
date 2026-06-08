package clases;

import java.util.ArrayList;

public class Garage {
    //Atributos
    private ArrayList<Vehiculo> vehiculos;
    private int capacidad;

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
        }else{
            System.out.println("No hay espacio para recibir el vehiculo: " + auto.despliegaInformacion());
        }
    }
    
    //Metodo de instancia
    public void mostrarVehiculos(){
        for(Vehiculo auto:this.vehiculos){
            System.out.println(auto.despliegaInformacion());
        }
    }
}


