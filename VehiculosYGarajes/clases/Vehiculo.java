package clases;

public class Vehiculo {
    //Atributos
    public String marca;
    public String modelo;
    public int ano;
    //Constructor
    public Vehiculo(String marca, String modelo, int ano){
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }
    
    //@Override
    public String despliegaInformacion(){
        return "Marca: "+ this.marca + " " + "Modelo: "+ this.modelo + " " + "Ano: " + this.ano;
    }


}
