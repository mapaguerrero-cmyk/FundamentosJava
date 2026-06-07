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
    
    @Override
    public String toString(){
        return "Marca: "+ marca + " " + "Modelo: "+ modelo + " " + "Ano: " + ano;
    }


}
