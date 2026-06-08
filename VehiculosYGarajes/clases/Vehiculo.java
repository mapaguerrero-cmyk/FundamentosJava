package clases;

public class Vehiculo {
    //Atributos
    private String marca;
    private String modelo;
    private int ano;
    //Constructor
    public Vehiculo(String marca, String modelo, int ano){
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }
    
    //Metodo de instancia
    public String despliegaInformacion(){
        return "Marca: "+ this.marca + " | Modelo: "+ this.modelo + " | Ano: " + this.ano;
    }


}
