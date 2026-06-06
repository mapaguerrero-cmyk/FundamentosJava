import clases.Algoritmos;

public class Aplicacion {
    public static void main(String[] args) {
        int[] numeros = {6, 7, 12, 15};
        for(int numero:numeros){
            boolean rta1 = Algoritmos.esPar(numero);
            String resultado = rta1 ? " par" : " impar";
            System.out.println("El numero: " + numero + " es"+ resultado);
        }

        int numero2 = 23;
        boolean esNroPrimo2 = Algoritmos.esPrimo(numero2);
        String resultadoEsPrimo2= esNroPrimo2 ? "El "+ numero2 + " Es primo": "El "+ numero2 + " No es primo";
        System.out.println(resultadoEsPrimo2);
        int numero3 = 60;
        boolean esNroPrimo3 = Algoritmos.esPrimo(numero3);
        String resultadoEsPrimo3= esNroPrimo3 ? "El "+ numero3 + " Es primo": "El "+ numero3 + " No es primo";
        System.out.println(resultadoEsPrimo3);

        String TextoOriginal = "casapiedra";
        String TextoReversa = Algoritmos.stringEnReversa(TextoOriginal);
        System.out.println("casapiedra al reves es: " + TextoReversa);

        String textoValidar = "Reconocer";
        String esTextoPalindromo = Algoritmos.esPalindromo(textoValidar) ? "Es Palindromo": "No es Palindromo";
        System.out.println("La palabra: " + textoValidar +" "+esTextoPalindromo );

         String textoValidar2 = "Increible";
        String esTextoPalindromo2 = Algoritmos.esPalindromo(textoValidar2) ? "Es Palindromo": "No es Palindromo";
        System.out.println("La palabra: " + textoValidar2 +" "+esTextoPalindromo2 );


        Algoritmos.secuenciaFizzBuzz(15);
    }
    
}
