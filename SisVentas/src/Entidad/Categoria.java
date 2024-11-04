package Entidad;

public class Categoria {
    private int categoriaId;
    private String nombre;
    private int estado; 

    public Categoria() {}

    public Categoria(int categoriaId, String nombre, int estado) {
        this.categoriaId = categoriaId;
        this.nombre = nombre;
        this.estado = estado;
    }

    // Getters y Setters
    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }


    public void activar() {
        this.estado = 1;
    }

    public void desactivar() {
        this.estado = 0;
    }

    public boolean esActiva() {
        return this.estado == 1;
    }

    
    public String toString() {
        return "Categoria { " +
                "ID: " + categoriaId +
                ", Nombre: '" + nombre + '\'' +
                ", Estado: " + (estado == 1 ? "Activo" : "Inactivo") +
                " }";
    }
}

