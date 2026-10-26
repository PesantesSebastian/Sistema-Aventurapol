package entidades;

public class PersonalLimpieza extends Empleado {
    private String zonaAsignada;

    public PersonalLimpieza(String cedula, String nombre, Double sueldo, String zonaAsignada) {
        super(cedula, nombre, sueldo, "Personal de Limpieza");
        
        if (zonaAsignada == null || zonaAsignada.trim().isEmpty()) {
            throw new IllegalArgumentException("Error: Debe asignar una zona de limpieza válida.");
        }
        this.zonaAsignada = zonaAsignada;
    }
    
    // Al heredar de Empleado, automáticamente cuenta con mostrarInformacion(), 
    // pero podemos sobreescribirlo si queremos mostrar la zona.
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion(); // Imprime datos básicos de empleado
        System.out.println("Zona Asignada: " + zonaAsignada);
    }
}