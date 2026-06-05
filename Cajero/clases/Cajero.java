package clases;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Cajero {
    // Declaramos el formateador aquí, fuera de cualquier método
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    
    public static String retirarDinero(double cantidadRetirar){
        if(cantidadRetirar > 8000){
            return "Estas tratando de retirar: $" + cantidadRetirar +" mucho dinero, el limite es $8000";
        }else 
            return "Retiraste exitosamente la cantidad de: $"+ cantidadRetirar;
    }

    public static String pagarFactura(double totalFactura, double cantidadaPagar){
        double cantidadFaltante = totalFactura - cantidadaPagar;
        double cantidadSobrante = cantidadaPagar - totalFactura;
        // 2. Formatear la fecha actual
        String fechaFormateada = sdf.format(new Date());
        
        if(cantidadaPagar < totalFactura){
            return "El dia de " + fechaFormateada + " pagaste: $" + cantidadaPagar + "\naun te hacen falta: $" + cantidadFaltante;
        }else if(cantidadaPagar == totalFactura){
            return "Gracias por tu pago completo el dia de "+ fechaFormateada;
        }else{
            return "Gracias por tu pago el dia de: " + fechaFormateada + "\n, tu cambio es de: $"+ cantidadSobrante;
        }
    }
    
    public static boolean cambiarBilletes(int nroTotalaCambiar, int denominacion){

        return ((nroTotalaCambiar % denominacion) == 0);
        
    }

    public static String totalDeBilletesYMondeas(int cantidad){

        int[] denominaciones = {500, 200, 100, 50, 20, 10, 5, 2, 1};
        String resultado="";
        int restante = cantidad;
        for (int valor:denominaciones){
            int cantidadBilletes = restante / valor; //Cuántas unidades de este valor caben en restante

            if (cantidadBilletes > 0){
                restante = restante % valor; //Lo que sobra para seguir calculando

                //Decidir si es bille o moneda según el valor
                String tipo = (valor >= 20) ? "billetes(s)" : "moneda(s)";

                resultado += cantidadBilletes + " " + tipo + " de " +valor + ",";

            }
        }
        return resultado.substring(0,resultado.length() - 1);
    }
}


