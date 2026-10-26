package entidades;

import base.Atraccion;

public class AtraccionInfantil extends Atraccion {
    private Double estaturaMaxima;

    public AtraccionInfantil(String nombre, Double estaturaMaxima) {
        super(nombre);
        
        if (estaturaMaxima == null || estaturaMaxima <= 0.0) {
            throw new IllegalArgumentException("Error: La estatura máxima es inválida.");
        }
        this.estaturaMaxima = estaturaMaxima;
    }

    // POLIMORFISMO APLICADO: Reglas de acceso estrictas por máximo
    @Override
    public Boolean validarIngreso(Visitante v) {
        if (v == null) {
            throw new IllegalArgumentException("Error: Visitante no válido.");
        }
        
        if (!isOperativa()) {
            System.out.println(getNombre() + " se encuentra fuera de servicio.");
            return false;
        }
        
        if (v.getEstatura() <= estaturaMaxima) {
            return true;
        } else {
            System.out.println(v.getNombre() + " supera la estatura máxima para " + getNombre() + ".");
            return false;
        }
    }
}