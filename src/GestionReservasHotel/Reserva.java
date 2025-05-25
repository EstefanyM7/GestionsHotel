package GestionReservasHotel;

public class Reserva {

    private final String nombreCliente;
    private final String cedula;
    private final String fecha;
    private final Habitacion habitacion;

    public Reserva(String nombreCliente, String cedula, String fecha, Habitacion habitacion) {
        this.nombreCliente = nombreCliente;
        this.cedula = cedula;
        this.fecha = fecha;
        this.habitacion = habitacion;
        this.habitacion.reservar();
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getCedula() {
        return cedula;
    }

    public String getFecha() {
        return fecha;
    }

    public int getNumeroHabitacion() {
        return habitacion.getNumero();
    }

    public String getTipoHabitacion() {
        return habitacion.getTipo();
    }

    public double getPrecioHabitacion() {
        return habitacion.getPrecio();
    }

    @Override
    public String toString() {
        return "Cliente: " + nombreCliente + ", Cédula: " + cedula + ", Fecha: " + fecha +
                ", Habitación: " + habitacion.getNumero() + " (" + habitacion.getTipo() + ")";
    }
}
