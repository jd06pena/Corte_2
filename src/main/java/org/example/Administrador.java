package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Administrador {
    private List<Vehiculo> flotaVehiculos; // Lista de vehículos administrados por el administrador

    // Constructor
    public Administrador() {
        this.flotaVehiculos = new ArrayList<>();
    }

    // Método para agregar un nuevo vehículo a la flota
    public void añadirVehiculo(Vehiculo vehiculo) {
        flotaVehiculos.add(vehiculo);
        System.out.println("Vehículo añadido a la flota: " + vehiculo.getMarca() + " " + vehiculo.getModelo());
    }

    // disponibilidad de un vehículo en un rango de fechas
    public boolean verificarDisponibilidad(Vehiculo vehiculo, LocalDate fechaInicio, LocalDate fechaFin) {
        // Verificar si el vehículo está reservado
        return vehiculo.estaDisponible(fechaInicio, fechaFin);
    }

    // Método para listar todos los vehículos disponibles
    public List<Vehiculo> listarVehiculosDisponibles() {
        List<Vehiculo> vehiculosDisponibles = new ArrayList<>();

        // Recorremos la flota y añadimos los vehículos que están disponibles
        for (Vehiculo vehiculo : flotaVehiculos) {
            if (!vehiculo.estaReservado()) {
                vehiculosDisponibles.add(vehiculo);
            }
        }

        return vehiculosDisponibles;
    }

    // Método para mostrar la lista de vehículos disponibles
    public void mostrarVehiculosDisponibles() {
        List<Vehiculo> disponibles = listarVehiculosDisponibles();
        if (disponibles.isEmpty()) {
            System.out.println("No hay vehículos disponibles.");
        } else {
            System.out.println("Vehículos disponibles:");
            for (Vehiculo vehiculo : disponibles) {
                System.out.println(vehiculo.getMarca() + " " + vehiculo.getModelo() + " - Precio por día: $" + vehiculo.getPrecioPorDia());
            }
        }
    }
}



