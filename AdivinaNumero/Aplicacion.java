import java.util.ArrayList;

import clases.AdivinaNumero;


public class Aplicacion {
    public static void main(String[] args) {
        System.out.print("Por favor ingresa el numero entre 1 - 100 para adivinar: ");
        String linea = System.console().readLine();
        int num = Integer.parseInt(linea);
        int numAleatorio = (int)(Math.random() * 100) + 1;
        ArrayList<Integer> intentos = new ArrayList<Integer>();
        String resultado = "";
        boolean adivina = false;
        do {
            intentos.add(num);
            resultado = AdivinaNumero.compararNumeros(num, numAleatorio);
            if(resultado.equals("Has conseguido adivinar el numero.")){
                adivina = true;
            }else{
                System.out.println(resultado);
                linea = System.console().readLine();
                num = Integer.parseInt(linea);
            }
            
        }while (!adivina);
        System.out.println(resultado);
        System.out.println("Te tomo " + intentos.size() + " veces adivinar el numero");
        // Recorremos el ArrayList para imprimir los elementos separados por espacios
        for (int intento : intentos){
            System.out.print(intento + " ");
        }
        
    }
    
}
