package GestionReservasHotel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        hotel.agregarHabitacion(new Habitacion(1, "Individual", 50.0));
        hotel.agregarHabitacion(new Habitacion(2, "Doble", 80.0));
        hotel.agregarHabitacion(new Habitacion(3, "Suite", 150.0));

        Scanner scanner = new Scanner(System.in);
        String opcion = "";

        while (!opcion.equalsIgnoreCase("salir")) {
            System.out.println("\n--------Sistema de Reservas-----------");
            System.out.println("1. Crear reserva");
            System.out.println("2. Consultar disponibilidad");
            System.out.println("3. Cancelar reserva");
            System.out.println("Escriba 'salir' para terminar el programa.");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Nombre del cliente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Cédula: ");
                    String cedula = scanner.nextLine();
                    System.out.print("Fecha de reserva (Por ejemplo: 2025-05-25): ");
                    String fecha = scanner.nextLine();

                    hotel.mostrarHabitacionesDisponibles();

                    System.out.print("Número de habitación que desea reservar: ");
                    int numeroReserva = Integer.parseInt(scanner.nextLine());

                    if (hotel.crearReserva(nombre, cedula, fecha, numeroReserva)) {
                        System.out.println("Reserva creada correctamente.");
                    } else {
                        System.out.println("No se pudo crear la reserva. La habitación está ocupada o no existe.");
                    }
                    break;

                case "2":
                    System.out.print("Número de habitación: ");
                    int numeroConsulta = Integer.parseInt(scanner.nextLine());

                    if (hotel.consultarDisponibilidad(numeroConsulta)) {
                        System.out.println("La habitación está disponible.");
                    } else {
                        System.out.println("La habitación no está disponible o no existe.");
                    }
                    break;

                case "3":
                    System.out.print("Número de habitación a cancelar: ");
                    int numeroCancelacion = Integer.parseInt(scanner.nextLine());

                    if (hotel.cancelarReserva(numeroCancelacion)) {
                        System.out.println("La reserva fue cancelada correctamente.");
                    } else {
                        System.out.println("No se encontró una reserva con ese número de habitación.");
                    }
                    break;

                case "salir":
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    break;
            }

            System.out.println("\n---------Reservas actuales--------");
            hotel.mostrarReservas();
        }

        scanner.close();
    }
}
