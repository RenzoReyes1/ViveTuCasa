package Entidad;

public class Cliente {
    private int clienteId;
    private String nombreCompleto;
    private String tipoDocumento;
    private String numeroDocumento;
    private String direccion;
    private String telefono;
    private String correoElectronico;
    private int estado; 

    public Cliente() {}

    public Cliente(int clienteId, String nombreCompleto, String tipoDocumento, String numeroDocumento, 
                   String direccion, String telefono, String correoElectronico, int estado) {
        this.clienteId = clienteId;
        this.nombreCompleto = nombreCompleto;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.estado = estado;
    }

    // Getters y Setters
    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
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

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
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

    public boolean esActivo() {
        return this.estado == 1;
    }

    
    public String toString() {
        return "Cliente { " +
                "ID: " + clienteId +
                ", Nombre Completo: '" + nombreCompleto + '\'' +
                ", Documento: '" + tipoDocumento + " - " + numeroDocumento + '\'' +
                ", Dirección: '" + direccion + '\'' +
                ", Teléfono: '" + telefono + '\'' +
                ", Correo Electrónico: '" + correoElectronico + '\'' +
                ", Estado: " + (estado == 1 ? "Activo" : "Inactivo") +
                " }";
    }
}

