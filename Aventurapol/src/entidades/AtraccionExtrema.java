package entidades;

import base.Atraccion;
import base.Mantenible;

// Esta clase hereda de Atraccion y, según tu UML, firma el contrato de Mantenible
public class AtraccionExtrema extends Atraccion implements Mantenible {
    private Double estaturaMinima;
    private Integer edadMinima;

    public AtraccionExtrema(String nombre, Double estaturaMinima, Integer edadMinima) {
        super(nombre);
        
        if (estaturaMinima == null || estaturaMinima <= 0.0) {
            throw new IllegalArgumentException("Error: La estatura mínima es inválida.");
        }
        if (edadMinima == null || edadMinima < 0) {
            throw new IllegalArgumentException("Error: La edad mínima es inválida.");
        }
        
        this.estaturaMinima = estaturaMinima;
        this.edadMinima = edadMinima;
    }

    // POLIMORFISMO APLICADO: Reglas de acceso estrictas por mínimo
    @Override
    public Boolean validarIngreso(Visitante v) {
        if (v == null) {
            throw new IllegalArgumentException("Error: Visitante no válido.");
        }
        
        if (!isOperativa()) {
            System.out.println(getNombre() + " se encuentra fuera de servicio.");
            return false;
        }
        
        if (v.getEstatura() >= estaturaMinima && v.getEdad() >= edadMinima) {
            return true;
        } else {
            System.out.println(v.getNombre() + " no cumple con los requisitos mínimos para " + getNombre() + ".");
            return false;
        }
    }

    // CONTRATO INTERFAZ CUMPLIDO:
    @Override
    public void iniciarMantenimiento(String motivo) {
        setOperativa(false);
        System.out.println("Mantenimiento INICIADO en '" + getNombre() + "'. Motivo: " + motivo);
    }

    @Override
    public void finalizarMantenimiento() {
        setOperativa(true);
        System.out.println("Mantenimiento FINALIZADO en '" + getNombre() + "'. Vuelve a estar operativa.");
    }
}