package entidades;

import base.Entrada;

public class EntradaGeneral extends Entrada {

    public EntradaGeneral(String codigoBoleto, Double precioBase, Integer usosDisponibles) {
        super(codigoBoleto, precioBase, usosDisponibles);
    }

    // POLIMORFISMO APLICADO: Forma básica de calcular
    @Override
    public Double calcularCostoTotal() {
        // La entrada general no tiene recargos, solo cuesta el precio base
        return this.precioBase; 
    }
}