package entidades;

import base.Persona;

public abstract class Empleado extends Persona {
    protected Double sueldo;
    protected String cargo;

    public Empleado(String cedula, String nombre, Double sueldo, String cargo) {
        super(cedula, nombre);

        if (sueldo == null || sueldo <= 0) {                    
            throw new IllegalArgumentException("Error: El sueldo debe ser mayor a cero.");
        }
        if (cargo == null || cargo.trim().isEmpty()) {
            throw new IllegalArgumentException("Error: El cargo no puede estar vacio.");
        }

        this.sueldo = sueldo;
        this.cargo = cargo;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("--- EMPLEADO ---");
        System.out.println("Cedula: " + getCedula());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Cargo: " + cargo);
        System.out.println("Sueldo: $" + sueldo);
    }
}