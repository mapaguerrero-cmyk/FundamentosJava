import clases.CuentaBancaria;
import clases.Persona;

public class Aplicacion {
    public static void main(String[] args) {
        //Crear minimo tres instancias de la clase Persona.
        Persona sergio = new Persona("Sergio Lira" , 45);
        Persona marta = new Persona("Marta Lagos", 35);
        Persona gonza = new Persona("Gonzalo Tapia", 38);
        Persona ana = new Persona("Ana Mora", 30);

        //Crea instancias de la clase CuentaBancaria por persona
        CuentaBancaria cuentaSergio = new CuentaBancaria(100.0, sergio);
        CuentaBancaria cuentaMarta = new CuentaBancaria(300.0, marta);
        CuentaBancaria cuentaGonza = new CuentaBancaria(150.0, gonza);
        CuentaBancaria cuentaAna = new CuentaBancaria(100.0, ana);
        

        //Movimientos en la cuenta de Sergio
        cuentaSergio.despliegaInformacion();
        System.out.println("\n Movimientos de Sergio");
        cuentaSergio.depositar(10.0);
        System.out.println("Saldo de la cuenta: "+ cuentaSergio.getSaldo());
        cuentaSergio.retirar(100.0);
        System.out.println("Saldo de la cuenta: "+ cuentaSergio.getSaldo());
        cuentaSergio.retirar(100.0);
        System.out.println("Saldo de la cuenta: "+ cuentaSergio.getSaldo());
    

        //Movimientos en la cuenta de Marta
        cuentaMarta.despliegaInformacion();
        System.out.println("\n Movimientos de Marta");
        System.out.println("Saldo de la cuenta: "+ cuentaMarta.getSaldo());
        cuentaMarta.retirar(250.0);
        System.out.println("Saldo de la cuenta: "+ cuentaMarta.getSaldo());
        cuentaMarta.retirar(150.0);

        //Movimientos en la cuenta de Gonza
        cuentaGonza.despliegaInformacion();
        System.out.println("\n Movimientos de Gonzalo");
        System.out.println("Saldo de la cuenta: "+ cuentaGonza.getSaldo());
        cuentaGonza.retirar(100.0);
        cuentaGonza.depositar(80.0);
        System.out.println("Saldo de la cuenta: "+ cuentaGonza.getSaldo());

        //Movimientos en la cuenta de Ana
        cuentaAna.despliegaInformacion();
        System.out.println("\n Movimientos de Ana");
        System.out.println("Saldo de la cuenta: "+ cuentaAna.getSaldo());
        cuentaAna.depositar(50.0);
        cuentaAna.retirar(170.0);
        

        CuentaBancaria.imprimeInformacionDeTodasLasCuentas();



    }
    
}
