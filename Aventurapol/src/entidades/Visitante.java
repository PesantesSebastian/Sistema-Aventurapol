package entidades;

import base.Persona;
import base.Entrada;

public class Visitante extends Persona {
    // Uso de Wrappers tal como indica el UML
    private Integer edad;
    private Double estatura;
    private Entrada ticket;

    public Visitante(String cedula, String nombre, Integer edad, Double estatura) {
        super(cedula, nombre); // Llama al constructor de Persona
        
        // Validaciones con IllegalArgumentException
        if (edad == null || edad < 0 || edad > 120) {
            throw new IllegalArgumentException("Error: La edad debe ser un número lógico entre 0 y 120.");
        }
        if (estatura == null || estatura <= 0.0 || estatura > 2.50) {
            throw new IllegalArgumentException("Error: La estatura ingresada no es válida.");
        }
        
        this.edad = edad;
        this.estatura = estatura;
        this.ticket = null; // Inicia sin ticket hasta que compre uno
    }

    public void asignarTicket(Entrada ticket) {
        if (ticket == null) {
            throw new IllegalArgumentException("Error: El ticket no puede ser nulo.");
        }
        this.ticket = ticket;
    }

    public Entrada getTicket() {
        return ticket;
    }

    public Integer getEdad() {
        return edad;
    }

    public Double getEstatura() {
        return estatura;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("--- VISITANTE ---");
        System.out.println("Cédula: " + getCedula());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Edad: " + edad + " años");
        System.out.println("Estatura: " + estatura + " m");
        if (ticket != null) {
            System.out.println("Ticket: Asignado (" + ticket.getUsosDisponibles() + " usos restantes)");
        } else {
            System.out.println("Ticket: Ninguno");
        }
    }
}