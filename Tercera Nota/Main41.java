import java.util.Scanner;

public class Main41 {
    private static final int MAX_HABITACIONES = 5;
    private static String[] nombresClientes = new String[MAX_HABITACIONES];
    private static int[] numerosHabitaciones = new int[MAX_HABITACIONES];
    private static int[] nochesReservadas = new int[MAX_HABITACIONES];
    private static double[] preciosPorNoche = new double[MAX_HABITACIONES];
    private static boolean[] habitacionesOcupadas = new boolean[MAX_HABITACIONES];
    private static int contadorReservas = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Entrada de datos para las reservas
        for (int i = 0; i < MAX_HABITACIONES; i++) {
            System.out.print("Ingrese el nombre del cliente: ");
            nombresClientes[i] = input.nextLine();

            System.out.print("Ingrese el número de habitación: ");
            numerosHabitaciones[i] = input.nextInt();

            System.out.print("Ingrese el número de noches: ");
            nochesReservadas[i] = input.nextInt();

            System.out.print("Ingrese el precio por noche: ");
            preciosPorNoche[i] = input.nextDouble();
            input.nextLine(); // Limpiar el buffer

            habitacionesOcupadas[i] = true;
            contadorReservas++;
        }

        // Calcular el total a pagar por cada cliente
        calcularTotalAPagar();

        // Generar el reporte final
        generarReporte();

        // Ejemplo de cancelación de reserva
        System.out.print("\nIngrese el número de habitación a cancelar: ");
        int numeroHabitacion = input.nextInt();
        cancelarReserva(numeroHabitacion);

        // Generar el reporte final después de la cancelación
        generarReporte();
    }

    public static void calcularTotalAPagar() {
        for (int i = 0; i < contadorReservas; i++) {
            double totalAPagar = nochesReservadas[i] * preciosPorNoche[i];
            System.out.println("Cliente: " + nombresClientes[i] + " - Habitación: " + numerosHabitaciones[i] + " - Total a pagar: " + totalAPagar);
        }
    }

    public static void cancelarReserva(int numeroHabitacion) {
        for (int i = 0; i < contadorReservas; i++) {
            if (numerosHabitaciones[i] == numeroHabitacion) {
                habitacionesOcupadas[i] = false;
                System.out.println("Reserva cancelada para la habitación " + numeroHabitacion);
                return;
            }
        }
        System.out.println("Habitación no encontrada.");
    }

    public static void generarReporte() {
        System.out.println("\nReporte Final:");
        System.out.println("Habitaciones ocupadas:");
        for (int i = 0; i < contadorReservas; i++) {
            if (habitacionesOcupadas[i]) {
                System.out.println("Habitación: " + numerosHabitaciones[i] + " - Cliente: " + nombresClientes[i]);
            }
        }

        System.out.println("\nHabitaciones disponibles:");
        for (int i = 0; i < MAX_HABITACIONES; i++) {
            if (!habitacionesOcupadas[i]) {
                System.out.println("Habitación: " + (i + 101)); // Asumiendo que las habitaciones están numeradas del 101 en adelante
            }
        }
    }
}

