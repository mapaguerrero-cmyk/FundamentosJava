package clases;

public class Libro {
    //Atributos
        private String titulo;
        private String autor;
        private Double precioDeReemplazo;


    //Constructor
    public Libro(String titulo, String autor, Double precioDeReemplazo){
        this.titulo = titulo;
        this.autor = autor;
        this.precioDeReemplazo = precioDeReemplazo;
    }
    //Metodos de instacia

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Double getPrecioDeReemplazo() {
        return precioDeReemplazo;
    }

    public void setPrecioDeReemplazo(Double precioDeReemplazo) {
        this.precioDeReemplazo = precioDeReemplazo;
    }

    @Override
    public String toString(){
        return "titulo: " + titulo +  " | Autor: " + " | Precio Reemplazo: " + precioDeReemplazo;
    }
    
}
