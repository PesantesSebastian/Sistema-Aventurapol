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

    // POLIMORFISMO APLICADO: Forma avanzada de calcular
    @Override
    public Double calcularCostoTotal() {
        // La entrada VIP suma el recargo al precio base
        return this.precioBase + this.recargoPaseRapido;
    }
}