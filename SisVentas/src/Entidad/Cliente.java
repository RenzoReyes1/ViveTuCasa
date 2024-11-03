package Entidad;

public class Cliente {
    int id_cliente;
    String nombres_apellidos;
    String tipo_documento;
    String nro_documento;
    String direccion;
    String telefono;
    String email;
    int estado;

    public Cliente() {
    }

    public Cliente(int id_cliente, String nombres_apellidos, String tipo_documento, String nro_documento, String direccion, String telefono, String email, int estado) {
        this.id_cliente = id_cliente;
        this.nombres_apellidos = nombres_apellidos;
        this.tipo_documento = tipo_documento;
        this.nro_documento = nro_documento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.estado = estado;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombres_apellidos() {
        return nombres_apellidos;
    }

    public void setNombres_apellidos(String nombres_apellidos) {
        this.nombres_apellidos = nombres_apellidos;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNro_documento() {
        return nro_documento;
    }

    public void setNro_documento(String nro_documento) {
        this.nro_documento = nro_documento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    
}
