import clases.Cajero;

public class Aplicacion {
    public static void main(String [] args){

        String rta1 = Cajero.retirarDinero(8500);
        System.out.println(rta1);
        String rta2 = Cajero.retirarDinero(7000);
        System.out.println(rta2);
        String rta3 = Cajero.pagarFactura(15000, 10000);
        System.out.println(rta3);
        String rta4 = Cajero.pagarFactura(20000, 20000);
        System.out.println(rta4);
        String rta5 = Cajero.pagarFactura(20000, 25000);
        System.out.println(rta5);

        boolean rta6 = Cajero.cambiarBilletes(2000, 50);
        String rtaCambio1 = rta6 ? "OK cambio billete" : "Lo siento no se puede hacer cambio";
        System.out.println(rtaCambio1);

        boolean rta7 = Cajero.cambiarBilletes(2010, 50);
        String rtaCambio2 = rta7 ? "OK cambio billete" : "Lo siento no se puede hacer cambio";
        System.out.println(rtaCambio2);

        String rta8 = Cajero.totalDeBilletesYMondeas(1999);
        System.out.println(rta8);

    }
    
}
