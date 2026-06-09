import clases.CuentaBancaria;
import clases.Persona;

public class Aplicacion {
    public static void main(String[] args) {
        //Crear minimo tres instancias de la clase Persona.
        Persona persona1 = new Persona("Sergio Lira" , 45);
        Persona persona2 = new Persona("Marta Lagos", 35);
        Persona persona3 = new Persona("Gonzalo Tapia", 38);
        Persona persona4 = new Persona("Ana Mora", 30);

        //Crea minimo tres instancias de la clase CuentaBancaria por persona
        CuentaBancaria cuenta11 = new CuentaBancaria(1000000, persona1);
        CuentaBancaria cuenta12 = new CuentaBancaria(8000000, persona1);
        CuentaBancaria cuenta13 = new CuentaBancaria(500000, persona1);

        CuentaBancaria cuenta21 = new CuentaBancaria(8000000, persona2);
        CuentaBancaria cuenta22 = new CuentaBancaria(5500000, persona2);
        CuentaBancaria cuenta23 = new CuentaBancaria(3400000, persona2);

        CuentaBancaria cuenta31 = new CuentaBancaria(1500000, persona3);
        CuentaBancaria cuenta32 = new CuentaBancaria(500000, persona3);
        CuentaBancaria cuenta33 = new CuentaBancaria(600000, persona3);

        CuentaBancaria cuenta41 = new CuentaBancaria(9000000, persona4);
        CuentaBancaria cuenta42 = new CuentaBancaria(600000, persona4);
        CuentaBancaria cuenta43 = new CuentaBancaria(7700000, persona4);

        //Operaciones de depósito y retiro en las cuentas bancaria

        cuenta11.retirar(100000);
        System.out.println("<<< El saldo >>> ");
        cuenta11.despliegaInformacion();//Consulta saldo despues

        cuenta12.depositar(50000);
        System.out.println("<<< El saldo >>> ");
        cuenta12.despliegaInformacion();

        cuenta13.retirar(15000);
        cuenta13.despliegaInformacion();

        cuenta21.retirar(8000000); //retirar todo el saldo
        cuenta21.retirar(150000); //Sobregiro No debe permitir

        cuenta22.depositar(6000);
        cuenta22.despliegaInformacion();

        cuenta23.setSaldo(300000);
        cuenta23.despliegaInformacion();

        cuenta31.retirar(1600000);//retirar mas del saldo.
        cuenta31.despliegaInformacion();

        cuenta32.retirar(450000);//retira y queda saldo
        cuenta32.despliegaInformacion();
        cuenta32.retirar(150000);//retirar mas del saldo. No debe permitir
        
        cuenta33.depositar(500000);//depositar monto
        cuenta33.despliegaInformacion(); //consultar saldo

        cuenta41.depositar(50000);
        cuenta41.despliegaInformacion();

        cuenta42.retirar(650000);//retirar mas del saldo. No debe permitir
        
        cuenta43.retirar(50000);//retira y queda saldo
        cuenta43.despliegaInformacion();

        System.out.println("<<< Informacion de todas las cuentas Bancarias >>>");
        CuentaBancaria.imprimeInformacionDeTodasLasCuentas();



    }
    
}
