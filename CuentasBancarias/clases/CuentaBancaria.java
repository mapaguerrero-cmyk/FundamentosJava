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
        } else {
        System.out.println("Error: El monto a depositar debe ser positivo.");
        }
        this.saldo +=monto;
    }
    // Retira el monto especificado del saldo de la cuenta, 
    // si hay suficientes fondos.
    public void retirar(double monto){
        double saldoDisponible = this.getSaldo();
        if(saldoDisponible >= monto){
            this.saldo -=monto;
        }
        else{
            System.out.println("<Saldo insuficiente> $" + this.saldo +" No puede retirar monto: $" + monto);
        }
    }

    //Muestra la información de la cuenta incluyendo la información del titular.
    public void despliegaInformacion(){
        System.out.println("Titular: " + this.titular + " | Nro de cuenta: " + this.numeroCuenta + " | Saldo: $" + this.saldo);
    }

    //Método estático que recorre la lista de cuentas bancarias e imprime su información.
    public static void imprimeInformacionDeTodasLasCuentas(){
        for(CuentaBancaria cuenta:listaDeCuentasBancarias){
            cuenta.despliegaInformacion();

        }

    }


    
    



    
}
