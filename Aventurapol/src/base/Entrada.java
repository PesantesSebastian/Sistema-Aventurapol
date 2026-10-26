package base;

public abstract class Entrada {
    protected String codigoBoleto;
    protected Double precioBase;
    protected Integer usosDisponibles;

    public Entrada(String codigoBoleto, Double precioBase, Integer usosDisponibles) {
        if (codigoBoleto == null || precioBase < 0 || usosDisponibles < 0) {
            throw new IllegalArgumentException("Datos de entrada inválidos (precio o usos negativos).");
        }
        this.codigoBoleto = codigoBoleto;
        this.precioBase = precioBase;
        this.usosDisponibles = usosDisponibles;
    }

    public Boolean descontarUso() {
        if (this.usosDisponibles > 0) {
            this.usosDisponibles--;
            return true;
        }
        return false;
    }
    
    public Integer getUsosDisponibles() {
        return usosDisponibles;
    }

    // Método abstracto para el Polimorfismo
    public abstract Double calcularCostoTotal();
}