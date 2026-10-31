package entidades;

import base.Entrada;

public class EntradaGeneral extends Entrada {

    public EntradaGeneral(String codigoBoleto, Double precioBase, Integer usosDisponibles) {
        super(codigoBoleto, precioBase, usosDisponibles);
    }

    
    @Override
    public Double calcularCostoTotal() {
        return this.precioBase; 
    }
}