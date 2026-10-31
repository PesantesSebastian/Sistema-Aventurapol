
# Sistema Aventurapol

Sistema de gestión de parque de atracciones desarrollado en Java para la materia de Programación Orientada a Objetos.

## Integrantes
- Pesantes Sebastián 
- Adriana Bravo
- Joselyn Daniela

## Requisitos
- Java JDK 17 o superior
- NetBeans IDE (recomendado)

## Cómo ejecutar
1. Clonar el repositorio.
2. Abrir el proyecto en NetBeans.
3. Presionar F6 (Run Project).

## Funcionalidades
- Registro de visitantes y empleados.
- Venta de entradas (General y VIP) con cálculo de descuentos.
- Control de acceso a atracciones con validación de edad y estatura.
- Gestión de mantenimiento de atracciones.
- Reportes de recaudación.

## Conceptos POO aplicados
- Herencia (Persona → Visitante/Empleado; Entrada → General/VIP; Atracción → Extrema/Infantil)
- Polimorfismo (métodos `calcularCostoTotal`, `validarIngreso`, `mostrarInformacion`)
- Interfaces (`Mantenible`, `GestionableAtraccion`)
- Encapsulamiento, colecciones (`ArrayList`), manejo de excepciones.
