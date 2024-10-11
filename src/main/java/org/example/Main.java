package org.example;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Administrador admin = new Administrador();

        // Crear algunos vehículos
        Vehiculo vehiculo1 = new Vehiculo("Vehiculo01", "Toyota", "Corolla", 40.0);
        Vehiculo vehiculo2 = new Vehiculo("Vehiculo02", "Honda", "Civic", 45.0);
        Vehiculo vehiculo3 = new Vehiculo("Vehiculo03", "Toyota", "txl", 50.0);

        // Añadir vehículos a la flota del administrador
        admin.añadirVehiculo(vehiculo1);
        admin.añadirVehiculo(vehiculo2);
        admin.añadirVehiculo(vehiculo3);

        // Verificar la disponibilidad de un vehículo en un rango de fechas
        LocalDate fechaInicio = LocalDate.of(2024, 10, 10);
        LocalDate fechaFin = LocalDate.of(2024, 10, 15);
        boolean disponible = admin.verificarDisponibilidad(vehiculo1, fechaInicio, fechaFin);
        System.out.println("El vehículo " + vehiculo1.getModelo() + " está disponible: " + disponible);

        // Mostrar la lista de vehículos disponibles
        admin.mostrarVehiculosDisponibles();

        System.out.println("//////////////////////////////////////////////////////////////////////////////////////////////////////////////////");

        // Crear  cliente
        Cliente cliente1 = new Cliente("C01", "Juan peña");

//        // Definir las fechas de alquiler
//        LocalDate fechaInicio = LocalDate.of(2024, 10, 10);
//        LocalDate fechaFin = LocalDate.of(2024, 10, 15); // 5 días de alquiler

        // El cliente intenta reservar el primer vehículo con seguro y GPS
        cliente1.reservarVehiculo(vehiculo3, fechaInicio, fechaFin, true, true);



        // Ver las reservas del cliente
        for (Reserva reserva : cliente1.getReservas()) {
            System.out.println("Reserva ID: " + reserva.getIdReserva() + " - Vehículo: " + reserva.getVehiculo().getModelo() + " - Costo total: $" + reserva.getCostoTotal());
        }
    }
}