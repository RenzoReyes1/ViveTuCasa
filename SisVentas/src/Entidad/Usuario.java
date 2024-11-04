package Entidad;

import java.time.LocalDate;

public class Usuario {
    private int usuarioId;
    private String rolId;
    private String nombres;
    private String apellidos;
    private String tipoDocumento;
    private String numeroDocumento;
    private String telefono;
    private String correoElectronico;
    private String nombreUsuario;
    private String contrasena;
    private int estado; 
    private LocalDate fechaCreacion; 

    public Usuario() {
        this.fechaCreacion = LocalDate.now();
    }

    public Usuario(int usuarioId, String rolId, String nombres, String apellidos, String tipoDocumento, 
                   String numeroDocumento, String telefono, String correoElectronico, String nombreUsuario, 
                   String contrasena, int estado) {
        this.usuarioId = usuarioId;
        this.rolId = rolId;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.estado = estado;
        this.fechaCreacion = LocalDate.now();
    }

    public Usuario(int usuarioId) {
        this.usuarioId = usuarioId;
        this.fechaCreacion = LocalDate.now();
    }

    // Getters y Setters
    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getRolId() {
        return rolId;
    }

    public void setRolId(String rolId) {
        this.rolId = rolId;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    // Funciones adicionales
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
        return "Usuario { " +
                "ID: " + usuarioId +
                ", Rol: '" + rolId + '\'' +
                ", Nombres: '" + nombres + '\'' +
                ", Apellidos: '" + apellidos + '\'' +
                ", Documento: '" + tipoDocumento + " - " + numeroDocumento + '\'' +
                ", Teléfono: '" + telefono + '\'' +
                ", Email: '" + correoElectronico + '\'' +
                ", Usuario: '" + nombreUsuario + '\'' +
                ", Estado: " + (estado == 1 ? "Activo" : "Inactivo") +
                ", Fecha de Creación: " + fechaCreacion +
                " }";
    }
}
