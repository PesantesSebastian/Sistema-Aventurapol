package entidades;

import base.Atraccion;
import base.GestionableAtraccion;

// Hereda de Empleado y firma el contrato de la interfaz
public class Administrador extends Empleado implements GestionableAtraccion {

    public Administrador(String cedula, String nombre, Double sueldo) {
        super(cedula, nombre, sueldo, "Administrador"); 
    }

    @Override
    public void cambiarEstadoAtraccion(Atraccion a, Boolean estado) {
        if (a == null) {
            throw new IllegalArgumentException("Error: La atracción no existe.");
        }
        a.setOperativa(estado);
        String txtEstado = estado ? "OPERATIVA" : "FUERA DE SERVICIO";
        System.out.println("El Administrador " + getNombre() + " cambió el estado de '" + a.getNombre() + "' a: " + txtEstado);
    }
}