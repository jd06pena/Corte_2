package org.example;


import java.time.LocalDate;

public class Vehiculo {
    private String idVehiculo;
    private String marca;
    private String modelo;
    private double precioPorDia;
    private boolean reservado;
    private boolean tieneSeguro;
    private boolean tieneGPS;

    // Constructor
    public Vehiculo(String idVehiculo, String marca, String modelo, double precioPorDia) {
        this.idVehiculo = idVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.precioPorDia = precioPorDia;
        this.reservado = false;
        this.tieneSeguro = false;
        this.tieneGPS = false;
    }

    // Getters
    public String getIdVehiculo() {
        return idVehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getPrecioPorDia() {
        return precioPorDia;
    }

    public boolean estaReservado() {
        return reservado;
    }

    public boolean tieneSeguro() {
        return tieneSeguro;
    }

    public boolean tieneGPS() {
        return tieneGPS;
    }

    // Método para marcar el vehículo como reservado
    public void marcarReservado(LocalDate fechaInicio, LocalDate fechaFin) {
        this.reservado = true;
        System.out.println("Vehículo " + idVehiculo + " reservado desde " + fechaInicio + " hasta " + fechaFin);
    }

    // vehículo está disponible
    public boolean estaDisponible(LocalDate fechaInicio, LocalDate fechaFin) {

        return !reservado;
    }

    // Método para agregar seguro al vehículo
    public void agregarSeguro() {
        this.tieneSeguro = true;
        System.out.println("Seguro agregado al vehículo " + idVehiculo);
    }

    // Método para agregar GPS al vehículo
    public void agregarGPS() {
        this.tieneGPS = true;
        System.out.println("GPS agregado al vehículo " + idVehiculo);
    }

    // Método para calcular el precio total de la reserva
    public double calcularPrecio(long diasAlquiler) {
        double costoTotal = diasAlquiler * precioPorDia;

        // Añadir el costo adicional si el cliente selecciona seguro o GPS
        if (tieneSeguro) {
            costoTotal += diasAlquiler * precioPorDia * 0.10; // Costo adicional por seguro
        }

        if (tieneGPS) {
            costoTotal += diasAlquiler * 5; // Costo adicional por GPS
        }

        return costoTotal;
    }
}

