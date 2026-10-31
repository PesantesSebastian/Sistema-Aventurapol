package entidades;

import base.Entrada;

public class EntradaVIP extends Entrada {
    private Double recargoPaseRapido;

    public EntradaVIP(String codigoBoleto, Double precioBase, Integer usosDisponibles, Double recargoPaseRapido) {
        super(codigoBoleto, precioBase, usosDisponibles);
        
        if (recargoPaseRapido == null || recargoPaseRapido < 0) {
            throw new IllegalArgumentException("Error: El recargo VIP no puede ser negativo.");
        }
        this.recargoPaseRapido = recargoPaseRapido;
    }

    
    @Override
    public Double calcularCostoTotal() {
        return this.precioBase + this.recargoPaseRapido;
    }
}