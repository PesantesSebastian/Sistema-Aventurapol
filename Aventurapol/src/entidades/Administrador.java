package entidades;

import base.Atraccion;
import entidades.Empleado;
import base.GestionableAtraccion;

public class Administrador extends Empleado implements GestionableAtraccion {

    public Administrador(String cedula, String nombre, Double sueldo) {
        super(cedula, nombre, sueldo, "Administrador");
    }

    @Override
    public void cambiarEstadoAtraccion(Atraccion a, Boolean estado) {
        // Validación mejorada solicitada por Adriana
       if (a == null) {
    throw new IllegalArgumentException("Error: La atracción no existe.");
       }
        
        a.setOperativa(estado);
        // Operador ternario solicitado
        String txtEstado = estado ? "OPERATIVA" : "FUERA DE SERVICIO (Mantenimiento)";
        
        System.out.println("El Administrador [" + this.nombre + "] ha cambiado el estado de la atracción '" 
                           + a.getNombre() + "' a: " + txtEstado);
    }
}