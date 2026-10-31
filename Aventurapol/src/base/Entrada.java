package base;

public abstract class Entrada {
    protected String codigoBoleto;
    protected Double precioBase;          
    protected Integer usosDisponibles;

    public Entrada(String codigoBoleto, Double precioBase, Integer usosDisponibles) {
        if (codigoBoleto == null || codigoBoleto.trim().isEmpty()) {
            throw new IllegalArgumentException("Error: El codigo de boleto no puede estar vacio ni ser nulo.");
        }
        if (precioBase == null || precioBase <= 0) {
            throw new IllegalArgumentException("Error: El precio de la entrada debe ser mayor a $0.");
        }
        if (usosDisponibles == null || usosDisponibles <= 0) {
            throw new IllegalArgumentException("Error: Los usos disponibles deben ser mayores a 0.");
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

    public abstract Double calcularCostoTotal();
}