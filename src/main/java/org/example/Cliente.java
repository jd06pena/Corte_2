package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String idCliente;
    private String nombre;
    private List<Reserva> reservas;

    // Constructor
    public Cliente(String idCliente, String nombre) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.reservas = new ArrayList<>();
    }

    // Getters
    public String getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    // reservar un vehículo
    public void reservarVehiculo(Vehiculo vehiculo, LocalDate fechaInicio, LocalDate fechaFin, boolean seguro, boolean gps) {
        // Verificar si el vehículo está disponible para las fechas indicadas (asumiendo que Vehiculo tiene el método correspondiente)
        if (vehiculo.estaDisponible(fechaInicio, fechaFin)) {
            // Crear una nueva reserva
            String idReserva = generarIdReserva(); // Método para generar un id único (puedes implementarlo como gustes)
            Reserva nuevaReserva = new Reserva(idReserva, this, vehiculo, fechaInicio, fechaFin);

            // Añadir servicios adicionales al vehículo si es necesario (asumiendo que Vehiculo tiene estos métodos)
            if (seguro) {
                vehiculo.agregarSeguro();
            }

            if (gps) {
                vehiculo.agregarGPS();
            }

            // Confirmar la reserva
            nuevaReserva.confirmarReserva();

            // Añadir la reserva a la lista de reservas del cliente
            reservas.add(nuevaReserva);

            System.out.println("Reserva creada exitosamente para el cliente: " + nombre);
        } else {
            System.out.println("El vehículo no está disponible en las fechas seleccionadas.");
        }
    }

    // Método auxiliar para generar un ID de reserva único (puede ser reemplazado por otro mecanismo)
    private String generarIdReserva() {
        return "R" + (reservas.size() + 1) + "-" + idCliente;
    }
}
