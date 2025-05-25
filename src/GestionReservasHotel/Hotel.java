package GestionReservasHotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private final List<Habitacion> habitaciones;
    private final List<Reserva> reservas;

    public Hotel() {
        this.habitaciones = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public void agregarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
    }

    public boolean consultarDisponibilidad(int numeroHabitacion) {
        for (Habitacion h : habitaciones) {
            if (h.getNumero() == numeroHabitacion) {
                return h.estaDisponible();
            }
        }
        return false;
    }

    public boolean crearReserva(String cliente, String cedula, String fecha, int numeroHabitacion) {
        for (Habitacion h : habitaciones) {
            if (h.getNumero() == numeroHabitacion && h.estaDisponible()) {
                reservas.add(new Reserva(cliente, cedula, fecha, h));
                return true;
            }
        }
        return false;
    }

    public void mostrarReservas() {
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas.");
            return;
        }

        for (Reserva r : reservas) {
            System.out.println("--------");
            System.out.println("Cliente: " + r.getNombreCliente());
            System.out.println("Cédula: " + r.getCedula());
            System.out.println("Fecha: " + r.getFecha());
            System.out.println("Habitación: " + r.getNumeroHabitacion());
            System.out.println("Tipo: " + r.getTipoHabitacion());
            System.out.println("Precio: $" + r.getPrecioHabitacion());
        }
    }

    public void mostrarHabitacionesDisponibles() {
        System.out.println("Habitaciones disponibles:");
        for (Habitacion h : habitaciones) {
            if (h.estaDisponible()) {
                System.out.println("Habitación " + h.getNumero() + " - " + h.getTipo() + " - $" + h.getPrecio());
            }
        }
    }

public boolean cancelarReserva(int numeroHabitacion) {
        for (Reserva r : reservas) {
            if (r.getNumeroHabitacion() == numeroHabitacion) {
                reservas.remove(r);
                for (Habitacion h : habitaciones) {
                    if (h.getNumero() == numeroHabitacion) {
                        h.liberar();
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
