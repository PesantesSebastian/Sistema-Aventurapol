package sistema;

import base.Atraccion;
import base.Entrada;
import entidades.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parque parque = new Parque();

        // 1. PRECARGAMOS ATRACCIONES
        parque.registrarAtraccion(new AtraccionExtrema("Montana Rusa", 1.50, 14));
        parque.registrarAtraccion(new AtraccionInfantil("Carrusel Magico", 1.30));

        // 2. PRECARGAMOS EMPLEADOS
        System.out.println("Iniciando sistema y registrando personal...");
        parque.registrarPersona(new Administrador("001", "Jefe Roberto", 1500.0));
        parque.registrarPersona(new Tecnico("002", "Ing. Marta", 1200.0, "Mecanica"));
        parque.registrarPersona(new PersonalLimpieza("003", "Don Carlos", 500.0, "Zona Norte"));

        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== SISTEMA DEL PARQUE \"AVENTURAPOL\" ===");
            System.out.println("1. Modulo de Visitantes");
            System.out.println("   1.1 Registrar nuevo visitante");
            System.out.println("   1.2 Listar visitantes y personal en el parque");
            System.out.println("2. Modulo de Atracciones");
            System.out.println("   2.1 Ver atracciones operativas");
            System.out.println("   2.2 Cambiar estado de atraccion (Mantenimiento)");
            System.out.println("3. Modulo Taquilla");
            System.out.println("   3.1 Vender entrada a visitante registrado");
            System.out.println("4. Control de Accesos");
            System.out.println("   4.1 Validar ingreso de visitante a atraccion");
            System.out.println("5. Reportes del Sistema");
            System.out.println("   5.1 Generar listado general de recaudacion");
            System.out.println("   5.2 Consultar detalles de un visitante");
            System.out.println("6. Salir");
            System.out.print("Escriba su opcion (ej. 1.1 o 6): > ");
            
            String opcion = scanner.nextLine(); 

            switch (opcion) {
                case "1.1": 
                    System.out.println("\n--- REGISTRAR VISITANTE ---");
                    System.out.print("Cedula: > ");
                    String cedula = scanner.nextLine();
                    System.out.print("Nombre: > ");
                    String nombre = scanner.nextLine();
                    System.out.print("Edad: > ");
                    String inEdad = scanner.nextLine();
                    if (!inEdad.matches("[0-9]+")) { System.out.println("Error: Use solo numeros enteros."); break; }
                    
                    System.out.print("Estatura (ej. 1.75): > ");
                    String inEst = scanner.nextLine();
                    if (!inEst.matches("[0-9]+(\\.[0-9]+)?")) { System.out.println("Error de formato en estatura."); break; }
                    
                    parque.registrarPersona(new Visitante(cedula, nombre, Integer.parseInt(inEdad), Double.parseDouble(inEst))); 
                    break;

                case "1.2":
                    parque.listarTodasLasPersonas();
                    break;

                case "2.1":
                    parque.listarAtracciones();
                    break;

                case "2.2":
                    System.out.println("\n--- PANEL DE MANTENIMIENTO ---");
                    System.out.print("Código del empleado autorizado: > ");
                    String cedEmp = scanner.nextLine();
                    System.out.print("Nombre de la atraccion (Ej. Montana Rusa): > ");
                    String nomAt = scanner.nextLine();
                    System.out.print("Desea (1) Abrir Juego o (2) Cerrar por Mantenimiento?: > ");
                    String accion = scanner.nextLine();
                    
                    if(accion.equals("1")) parque.gestionarMantenimiento(cedEmp, nomAt, true);
                    else if(accion.equals("2")) parque.gestionarMantenimiento(cedEmp, nomAt, false);
                    else System.out.println("Error: Opcion invalida.");
                    break;

                case "3.1":
                    System.out.println("\n--- VENTA DE ENTRADAS ---");
                    System.out.print("Cedula del visitante: > ");
                    String cedVenta = scanner.nextLine();
                    System.out.print("Entrada (1 = General, 2 = VIP): > ");
                    String tipo = scanner.nextLine();

                    if (tipo.equals("1")) parque.venderEntrada(cedVenta, new EntradaGeneral("GEN", 20.0, 5)); 
                    else if (tipo.equals("2")) parque.venderEntrada(cedVenta, new EntradaVIP("VIP", 20.0, 10, 15.0)); 
                    else System.out.println("Error: Opcion invalida.");
                    break;

                case "4.1":
                    System.out.println("\n--- CONTROL DE ACCESOS ---");
                    System.out.print("Cedula del visitante: > ");
                    String cedAcceso = scanner.nextLine();
                    System.out.print("Nombre de la Atraccion: > ");
                    parque.procesarAcceso(cedAcceso, scanner.nextLine());
                    break;

                case "5.1":
                    parque.generarReporteDiario();
                    break;

                case "5.2":
                    System.out.print("\nIngrese la cedula del visitante a consultar: > ");
                    Visitante v = parque.buscarVisitante(scanner.nextLine());
                    if (v != null) v.mostrarInformacion();
                    else System.out.println("Error: Visitante no encontrado.");
                    break;

                case "6":
                    salir = true;
                    System.out.println("Apagando el sistema. Gracias por usar Aventurapol!");
                    break;

                default:
                    System.out.println("Error: Opcion no valida. Escriba los numeros tal cual el menu (ej. 1.1).");
            }
        }
        scanner.close();
    }
}