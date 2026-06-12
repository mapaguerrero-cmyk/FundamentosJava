package clases;

import java.util.ArrayList;
import java.util.Random;

public class CuentaBancaria {
    //Atributos
    private double saldo;
    private Persona titular;
    private int numeroCuenta;

    //Atributos estaticos
    public static ArrayList<CuentaBancaria> listaDeCuentasBancarias = new ArrayList<CuentaBancaria>();//inicializada
    
    //Constructor
    public CuentaBancaria(double saldo, Persona titular){
        this.saldo = saldo;
        this.titular = titular;
        // 2. Generar número aleatorio entre 100000 y 999999
        Random random = new Random();
        this.numeroCuenta = 100000 + random.nextInt(900000);
        //Agregar la cuenta nueva a la lista de cuentas bancarias.
        listaDeCuentasBancarias.add(this);
    }

    //Metodos de instancia getters y setters

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Persona getTitular() {
        return this.titular;
    }

    public void setTitular(Persona titular) {
        this.titular = titular;
    }

    public int getNumeroCuenta() {
        return this.numeroCuenta;
    }

    public static ArrayList<CuentaBancaria> getListaDeCuentasBancarias() {
        return listaDeCuentasBancarias;
    }

    public static void setListaDeCuentasBancarias(ArrayList<CuentaBancaria> listaDeCuentasBancarias) {
        CuentaBancaria.listaDeCuentasBancarias = listaDeCuentasBancarias;
    }
    
    // Metodo de instancia - Sumar monto especificado al saldo de la cuenta
    public void depositar(double monto){
        if (monto > 0) {
        this.saldo += monto;
        System.out.println("Deposito de: $" + monto + " realizado con exito");
        } else {
        System.out.println("Error: El monto a depositar debe ser positivo.");
        }
    }
    // Retira el monto especificado del saldo de la cuenta, 
    // si hay suficientes fondos.
    public void retirar(double monto){
        double saldoDisponible = this.getSaldo();
        if(saldoDisponible > 0 && saldoDisponible >= monto){
            this.saldo -=monto;
            System.out.println("Retiro de: $" + monto + " realizado con exito");
        }
        else{
            System.out.println("<Saldo insuficiente> $" + this.saldo +" No puede retirar monto: $" + monto);
        }
    }

    //Muestra la información de la cuenta incluyendo la información del titular.
    public void despliegaInformacion(){
        System.out.println("\n----------------Datos de la cuenta -----------");
        System.out.println("Titular de la cuenta: "+ this.titular.getNombre());
        System.out.println("Numero de cuenta: "+ this.numeroCuenta);
        System.out.println("Saldo de la cuenta: " + this.saldo);
        System.out.println("-----------------------------------------------");
    }

    //Método estático que recorre la lista de cuentas bancarias e imprime su información.
    public static void imprimeInformacionDeTodasLasCuentas(){
        System.out.println("\n---------Informacion de todas las cuentas bancarias--------");
        for(CuentaBancaria cuenta:listaDeCuentasBancarias){
            cuenta.despliegaInformacion();

        }

    }


    
    



    
}
