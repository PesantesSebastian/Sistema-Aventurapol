package sistema;

import base.Persona;
import base.Atraccion;
import base.Entrada;
import entidades.Visitante;

import java.util.ArrayList;

public class Parque {
    private ArrayList<Persona> listaPersonas;
    private ArrayList<Atraccion> listaAtracciones;
    private Double recaudacionDiaria;

    public Parque() {
        this.listaPersonas = new ArrayList<>();
        this.listaAtracciones = new ArrayList<>();
        this.recaudacionDiaria = 0.0;
    }

    public void registrarAtraccion(Atraccion a) {
        listaAtracciones.add(a);
    }

    public void registrarPersona(Persona p) {
        // VALIDACIÓN: Verificación de unicidad (Regla de negocio)
        for (Persona personaRegistrada : listaPersonas) {
            if (personaRegistrada.getCedula().equals(p.getCedula())) {
                System.out.println("Error: Ya existe una persona registrada con la cedula " + p.getCedula());
                return; // Cortamos la ejecución para que no se agregue
            }
        }
        
        listaPersonas.add(p);
        System.out.println("> " + p.getNombre() + " registrado exitosamente en el sistema.");
    }

    public Visitante buscarVisitante(String cedula) {
        for (Persona personaEncontrada : listaPersonas) {
            if (personaEncontrada.getCedula().equals(cedula)) {
                if (personaEncontrada instanceof Visitante) {
                    return (Visitante) personaEncontrada; 
                }
            }
        }
        return null; 
    }
    // SOBRECARGA DE MÉTODO
    // Útil si en el futuro queremos buscar un visitante pasando el objeto directamente.
    public Visitante buscarVisitante(Visitante visitante) {
        if (visitante == null) return null;
        return buscarVisitante(visitante.getCedula());
    }

        public void venderEntrada(String cedula, Entrada e) {
        Visitante v = buscarVisitante(cedula);
        if (v != null) {
            v.asignarTicket(e); 
            
            Double costoFinal = e.calcularCostoTotal();
            
            // REGLA DE NEGOCIO: Tarifas preferenciales para menores de 12 o mayores de 65
            if (v.getEdad() < 12 || v.getEdad() > 65) {
                System.out.println("> Aplica tarifa preferencial (50% de descuento en el precio base).");
                costoFinal = costoFinal - (costoFinal * 0.50);
            }
            
            this.recaudacionDiaria += costoFinal; 
            System.out.println("> Venta exitosa. Ticket asignado a " + v.getNombre() + ". Total a pagar: $" + costoFinal);
        } else {
            System.out.println("Error: Visitante no encontrado.");
        }
    }

    public void procesarAcceso(String cedula, String nombreAtraccion) {
        Atraccion atraccionDestino = null;
        for (Atraccion a : listaAtracciones) {
            if (a.getNombre().equalsIgnoreCase(nombreAtraccion)) { atraccionDestino = a; break; }
        }

        if (atraccionDestino == null) { System.out.println("Error: Atraccion no existe."); return; }

        Visitante v = buscarVisitante(cedula);
        if (v == null) { System.out.println("Error: Visitante no registrado o es un empleado."); return; }
        if (v.getTicket() == null || v.getTicket().getUsosDisponibles() <= 0) { System.out.println("Error: Ticket invalido o sin usos."); return; }

        if (atraccionDestino.validarIngreso(v)) {
            v.getTicket().descontarUso(); 
            System.out.println("> Acceso concedido a " + v.getNombre() + "!");
        }
    }

    public void generarReporteDiario() {
        System.out.println("\n========== REPORTE DE RECAUDACION ==========");
        System.out.println("Recaudacion Total Taquilla: $" + this.recaudacionDiaria);
        System.out.println("============================================");
    }

    // =========================================================================
    // NUEVOS METODOS PARA LUCIR EL UML (EMPLEADOS E INTERFACES)
    // =========================================================================

    // Modulo 1.2: Lista a TODOS mostrando el polimorfismo del metodo mostrarInformacion()
    public void listarTodasLasPersonas() {
        System.out.println("\n--- VISITANTES Y EMPLEADOS EN EL PARQUE ---");
        for(Persona p : listaPersonas) {
            p.mostrarInformacion(); 
            System.out.println("---------------------------");
        }
    }

    // Modulo 2.1: Ver atracciones
    public void listarAtracciones() {
        System.out.println("\n--- ESTADO DE ATRACCIONES ---");
        for(Atraccion a : listaAtracciones) {
            String estado = a.isOperativa() ? "OPERATIVA" : "EN MANTENIMIENTO";
            System.out.println("- " + a.getNombre() + " -> " + estado);
        }
    }

    // Modulo 2.2: Aqui brilla el UML (Interfaces, Empleados, Downcasting)
    public void gestionarMantenimiento(String cedulaEmpleado, String nombreAtraccion, boolean nuevoEstado) {
        Persona empleado = null;
        for (Persona p : listaPersonas) {
            if (p.getCedula().equals(cedulaEmpleado)) { empleado = p; break; }
        }
        if (empleado == null) { System.out.println("Error: Persona no encontrada."); return; }

        // Validamos si la persona tiene la interfaz (O sea, si es Admin o Tecnico)
        if (!(empleado instanceof base.GestionableAtraccion)) {
            System.out.println("ALERTA DE SEGURIDAD: " + empleado.getNombre() + " no tiene permisos para alterar juegos.");
            return;
        }

        Atraccion juego = null;
        for (Atraccion a : listaAtracciones) {
            if (a.getNombre().equalsIgnoreCase(nombreAtraccion)) { juego = a; break; }
        }
        if (juego == null) { System.out.println("Error: Atraccion no encontrada."); return; }

        // DOWNCASTING DE INTERFAZ: Forzamos al empleado a actuar como el gestor que es
        base.GestionableAtraccion encargado = (base.GestionableAtraccion) empleado;
        encargado.cambiarEstadoAtraccion(juego, nuevoEstado);

        // Si el juego cerro y resulta que es Extremo (Mantenible), disparamos su metodo
        if (juego instanceof base.Mantenible) {
            base.Mantenible juegoExtremo = (base.Mantenible) juego;
            if (!nuevoEstado) {
                juegoExtremo.iniciarMantenimiento("Revision tecnica ordenada por " + empleado.getNombre());
            } else {
                juegoExtremo.finalizarMantenimiento();
            }
        }
    }
}