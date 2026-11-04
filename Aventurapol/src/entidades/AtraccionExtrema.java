package entidades;

import base.Atraccion;
public class AtraccionExtrema extends Atraccion {
    private Double estaturaMinima;
    private Integer edadMinima;

    public AtraccionExtrema(String nombre, Double estaturaMinima, Integer edadMinima) {
        super(nombre);
        
        if (estaturaMinima == null || estaturaMinima <= 0.0) {
            throw new IllegalArgumentException("Error: La estatura minima es invalida.");
        }
        if (edadMinima == null || edadMinima < 0) {
            throw new IllegalArgumentException("Error: La edad minima es invalida.");
        }
        
        this.estaturaMinima = estaturaMinima;
        this.edadMinima = edadMinima;
    }

    @Override
    public Boolean validarIngreso(Visitante v) {
        if (v == null) {
            throw new IllegalArgumentException("Error: Visitante no valido.");
        }
        
        if (!isOperativa()) {
            System.out.println(getNombre() + " se encuentra fuera de servicio.");
            return false;
        }
        
        if (v.getEstatura() >= estaturaMinima && v.getEdad() >= edadMinima) {
            return true;
        } else {
            System.out.println(v.getNombre() + " no cumple con los requisitos minimos para " + getNombre() + ".");
            return false;
        }
    }
}