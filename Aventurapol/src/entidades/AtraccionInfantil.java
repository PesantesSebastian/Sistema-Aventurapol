package entidades;

import base.Atraccion;

public class AtraccionInfantil extends Atraccion {
    private Double estaturaMaxima;

    public AtraccionInfantil(String nombre, Double estaturaMaxima) {
        super(nombre);
        
        if (estaturaMaxima == null || estaturaMaxima <= 0.0) {
            throw new IllegalArgumentException("Error: La estatura maxima es invalida.");
        }
        this.estaturaMaxima = estaturaMaxima;
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
        
        if (v.getEstatura() <= estaturaMaxima) {
            return true;
        } else {
            System.out.println(v.getNombre() + " supera la estatura maxima para " + getNombre() + ".");
            return false;
        }
    }
}