package Entidad;

public class Categoria {
    int id_categoria;
    String nombre_categoria;
    int estado;

    public Categoria() {
    }

    public Categoria(int id_categoria, String nombre_categoria, int estado) {
        this.id_categoria = id_categoria;
        this.nombre_categoria = nombre_categoria;
        this.estado = estado;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    
}
