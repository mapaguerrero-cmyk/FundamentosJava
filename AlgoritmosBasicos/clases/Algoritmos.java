package clases;

public class Algoritmos {
    // Metodo numero par
    public static boolean esPar(int numero){
        return numero % 2 == 0;
    }
    // Metodo para verificar si el numero es primo
    public static boolean esPrimo(int numero){
        if (numero < 2){
            return false;
        }
        //Ciclo para para revisar si alguna división es exacta 
        for(int i=2; i < numero; i++){
            if(numero % i == 0){//es division exacta?
                return false;
            }
        }
        return true;
    }
    //Metodo para invertir el orden de las letras de un String
    public static String stringEnReversa(String texto){
        String textoAlreves = "";
        for(int i=(texto.length()-1); i >= 0; i--){
            textoAlreves += texto.charAt(i);
        }
        return textoAlreves;
    }

    //Metodo para validar si un String es Palindromo
    public static boolean esPalindromo(String texto){
        String textoAlreves = stringEnReversa(texto);
        return texto.equalsIgnoreCase(textoAlreves);

    }

    //Metodo que imprime en terminal la secuencia FizzBuzz 
    public static void secuenciaFizzBuzz(int numero){
        for(int i=1; i <= numero; i++){
            if((i % 3 == 0) && (i % 5 == 0)){
                System.out.println("FizzBuzz");
            } else if(i % 3 == 0){
                System.out.println("Fizz");
            }else if(i % 5 == 0){
                System.out.println("Buzz");
            }else 
                System.out.println(i);
        }
    }

}
