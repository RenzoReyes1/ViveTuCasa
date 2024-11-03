package Entidad;

public class Marca {
    int id_marca;
    String nombre_marca;
    int estado;

    public Marca() {
    }

    public Marca(int id_marca, String nombre_marca, int estado) {
        this.id_marca = id_marca;
        this.nombre_marca = nombre_marca;
        this.estado = estado;
    }

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public String getNombre_marca() {
        return nombre_marca;
    }

    public void setNombre_marca(String nombre_marca) {
        this.nombre_marca = nombre_marca;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    
}
