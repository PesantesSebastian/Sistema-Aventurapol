package entidades;

import base.Atraccion;
import base.GestionableAtraccion;

// Hereda de Empleado y firma el contrato de la interfaz
public class Tecnico extends Empleado implements GestionableAtraccion {
    private String especialidad;

    public Tecnico(String cedula, String nombre, Double sueldo, String especialidad) {
        super(cedula, nombre, sueldo, "Técnico");
        
        if (especialidad == null || especialidad.trim().isEmpty()) {
            throw new IllegalArgumentException("Error: La especialidad no puede estar vacía.");
        }
        this.especialidad = especialidad;
    }

    @Override
    public void cambiarEstadoAtraccion(Atraccion a, Boolean estado) {
        if (a == null) {
            throw new IllegalArgumentException("Error: La atracción no existe.");
        }
        a.setOperativa(estado);
        String txtEstado = estado ? "OPERATIVA" : "MANTENIMIENTO";
        System.out.println("El Técnico (" + especialidad + ") " + getNombre() + " cambió el estado de '" + a.getNombre() + "' a: " + txtEstado);
    }
}