package base;

public abstract class Persona {
    protected String cedula;
    protected String nombre;

    public Persona(String cedula, String nombre) {
        if (cedula == null || cedula.trim().isEmpty()) {
            throw new IllegalArgumentException("Error: La cédula no puede estar vacía ni ser nula.");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("Error: El nombre no puede estar vacío ni ser nulo.");
        }
        this.cedula = cedula;
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract void mostrarInformacion();
}