package base;

import entidades.Visitante;

public abstract class Atraccion {
    protected String nombre;
    protected Boolean operativa;

    public Atraccion(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la atracción no puede estar vacío.");
        }
        this.nombre = nombre;
        this.operativa = true; // Por defecto nace operativa
    }

    public String getNombre() {
        return nombre;
    }

    public Boolean isOperativa() {
        return operativa;
    }

    public void setOperativa(Boolean estado) {
        this.operativa = estado;
    }

    // Método abstracto que obliga a revisar las reglas de ingreso según el tipo de atracción
    public abstract Boolean validarIngreso(Visitante v);
}