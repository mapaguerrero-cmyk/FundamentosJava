package clases;

public class AdivinaNumero {
    public static String compararNumeros(int numUsuario, int numAleatorio) {
        
        if(numUsuario == numAleatorio){
            return "Has conseguido adivinar el numero.";
        }else if(numUsuario < numAleatorio){
            return"Intenta con un numero mas grande.";
        }else{
            return "intenta con un numero mas pequeno.";
        }
    }
}
    