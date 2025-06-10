package edu.iudigital.PersonaB;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Proceso proce = new Proceso();

        int opcion;
        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Ingresar persona");
            System.out.println("2. Ver Datos del persona");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    proce.ingresarPersona();
                    break;
                case 2:
                    proce.mostrarCantidadPersonas();
                    proce.mostrarPromedioEdad();
                    proce.mostrarMayoresEdad();
                    proce.mostrarNombresConA();
                    proce.mostrarApellidosConM();
                    proce.mostrarSueldosDirectoresMasculinos();
                    proce.mostrarPrimeraDesarrolladora();
                    proce.mostrarDesarrolladorMasGana();
                    proce.mostrarMujeresOrdenadasPorNombre();
                    break;
                case 0:
                    System.out.println("Hasta luego.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);
    }
}
