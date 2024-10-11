package org.example;

import java.time.temporal.ChronoUnit;
import java.time.LocalDate;

public class Reserva {


        private String idReserva;
        private Cliente cliente;
        private Vehiculo vehiculo;
        private LocalDate fechaInicio;
        private LocalDate fechaFin;
        private double costoTotal;

        // Constructor
        public Reserva(String idReserva, Cliente cliente, Vehiculo vehiculo, LocalDate fechaInicio, LocalDate fechaFin) {
            this.idReserva = idReserva;
            this.cliente = cliente;
            this.vehiculo = vehiculo;
            this.fechaInicio = fechaInicio;
            this.fechaFin = fechaFin;
            this.costoTotal = 0.0; // Se calculará cuando se confirme la reserva
        }

        // Getters
        public String getIdReserva() {
            return idReserva;
        }

        public Cliente getCliente() {
            return cliente;
        }

        public Vehiculo getVehiculo() {
            return vehiculo;
        }

        public LocalDate getFechaInicio() {
            return fechaInicio;
        }

        public LocalDate getFechaFin() {
            return fechaFin;
        }

        public double getCostoTotal() {
            return costoTotal;
        }

        // Método para confirmar la reserva
        public void confirmarReserva() {
            // Marcar el vehículo como reservado
            vehiculo.marcarReservado(fechaInicio, fechaFin);

            // Calcular

            long diasAlquiler = ChronoUnit.DAYS.between(fechaInicio, fechaFin);
            this.costoTotal = vehiculo.calcularPrecio(diasAlquiler);

            System.out.println("Reserva confirmada. Costo total: " + this.costoTotal);


        }

}



