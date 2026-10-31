package entidades;

public class PersonalLimpieza extends Empleado {
    private String zonaAsignada;

    public PersonalLimpieza(String cedula, String nombre, Double sueldo, String zonaAsignada) {
        super(cedula, nombre, sueldo, "Personal de Limpieza");
        
        if (zonaAsignada == null || zonaAsignada.trim().isEmpty()) {
            throw new IllegalArgumentException("Error: Debe asignar una zona de limpieza valida.");
        }
        this.zonaAsignada = zonaAsignada;
    }
    
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Zona Asignada: " + zonaAsignada);
    }
}