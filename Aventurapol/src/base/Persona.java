package base;

public abstract class Persona {
    protected String cedula;
    protected String nombre;

    public Persona(String cedula, String nombre) {
        // Validación defensiva básica solicitada
        if (cedula == null || cedula.trim().isEmpty() || nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("La cédula y el nombre no pueden estar vacíos.");
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

    // Método abstracto que obligará a las hijas a mostrar su propia info
    public abstract void mostrarInformacion();
}