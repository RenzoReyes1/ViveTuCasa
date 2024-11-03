
package Entidad;

public class Rol {
    int id_rol;
    String rol;

    public Rol() {
    }

    public Rol(int id_rol, String rol) {
        this.id_rol = id_rol;
        this.rol = rol;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
