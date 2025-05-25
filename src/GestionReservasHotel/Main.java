package GestionReservasHotel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        hotel.agregarHabitacion(new Habitacion(1, "Individual", 50.0));
        hotel.agregarHabitacion(new Habitacion(2, "Doble", 80.0));
        hotel.agregarHabitacion(new Habitacion(3, "Suite", 150.0));

        Scanner scanner = new Scanner(System.in);

        System.out.println("--------Sistema de Reservas-----------");
        System.out.println("1. Crear reserva");
        System.out.println("2. Consultar disponibilidad");
        System.out.println("3. Cancelar reserva");

        String opcion = scanner.nextLine();

        if (opcion.equals("1")) {
            System.out.print("Nombre del cliente: ");
            String nombre = scanner.nextLine();
            System.out.print("Cédula: ");
            String cedula = scanner.nextLine();
            System.out.print("Fecha de reserva (Por ejemplo: 2025-05-25): ");
            String fecha = scanner.nextLine();

            hotel.mostrarHabitacionesDisponibles();

            System.out.print("Número de habitación que desea reservar: ");
            int numero = scanner.nextInt();

            if (hotel.crearReserva(nombre, cedula, fecha, numero)) {
                System.out.println("Reserva creada correctamente.");
            } else {
                System.out.println("No se pudo crear la reserva. La habitación está ocupada o no existe.");
            }
        } else if (opcion.equals("2")) {
            System.out.print("Número de habitación: ");
            int numero = scanner.nextInt();

            if (hotel.consultarDisponibilidad(numero)) {
                System.out.println("La habitación está disponible.");
            } else {
                System.out.println("La habitación no está disponible o no existe.");
            }
        } else if (opcion.equals("3")) {
            System.out.print("Número de habitación a cancelar: ");
            int numero = scanner.nextInt();

            if (hotel.cancelarReserva(numero)) {
                System.out.println("La reserva fue cancelada correctamente.");
            } else {
                System.out.println("No se encontró una reserva con ese número de habitación.");
            }
        }

        System.out.println("\n---------Reservas actuales--------");
        hotel.mostrarReservas();
    }
}
