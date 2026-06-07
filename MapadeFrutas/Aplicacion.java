import java.util.HashMap;
import java.util.Set;

public class Aplicacion {

    public static void main(String[] args) {
        HashMap<String, Integer> frutas = new HashMap<String, Integer>();

        //agregar 5 frutas con cantidades
        frutas.put("manzanas", 10);
        frutas.put("platano", 5);
        frutas.put("naranjas", 4);
        frutas.put("uva", 3);
        frutas.put("peras", 7);
        //obtener el valor de la cantidad con la clave nombre
        System.out.println(frutas.get("naranjas"));

        //recorrer un mapa de hash se usa la clase set 
        Set<String> claves = frutas.keySet();
        for(String clave:claves){
            System.out.println(clave + " " + frutas.get(clave));
        }

    }
}