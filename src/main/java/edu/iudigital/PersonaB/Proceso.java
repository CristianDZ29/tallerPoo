package edu.iudigital.PersonaB;

import java.util.*;

public class Proceso {
    private List<Persona> personas;

    public Proceso() {
        personas = new ArrayList<>();
        personas.add(new Persona("Ana", "Morales", 25, "F", 18000, "Desarrollador"));
        personas.add(new Persona("Carlos", "Martínez", 30, "M", 20000, "Director"));
        personas.add(new Persona("Laura", "Gómez", 19, "F", 15000, "Diseñador"));
        personas.add(new Persona("Andrés", "Mejía", 40, "M", 30000, "Director"));
        personas.add(new Persona("Mariana", "López", 28, "F", 22000, "Desarrollador"));
    }

    public void ingresarPersona() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = scanner.nextInt(); scanner.nextLine();
        System.out.print("Género (M/F): ");
        String genero = scanner.nextLine();
        System.out.print("Sueldo por hora: ");
        double sueldoHora = scanner.nextDouble(); scanner.nextLine();
        System.out.print("Cargo: ");
        String cargo = scanner.nextLine();

        personas.add(new Persona(nombre, apellido, edad, genero, sueldoHora, cargo));
        System.out.println(" Persona agregada correctamente.");
    }

    public void mostrarCantidadPersonas() {
        System.out.println(" Cantidad de personas registradas: " + personas.stream().count());
    }

    public void mostrarPromedioEdad() {
        double promedio = personas.stream().mapToInt(Persona::getEdad).average().orElse(0);
        System.out.println(" Promedio de edad: " + promedio);
    }

    public void mostrarMayoresEdad() {
        long mayores = personas.stream().filter(p -> p.getEdad() >= 18).count();
        System.out.println(" Mayores de edad: " + mayores);
    }

    public void mostrarNombresConA() {
        System.out.println(" Personas con nombre que empieza con 'A':");
        personas.stream()
                .filter(p -> p.getNombre().startsWith("A"))
                .forEach(System.out::println);
    }

    public void mostrarApellidosConM() {
        System.out.println(" Personas con apellido que contiene 'M':");
        personas.stream()
                .filter(p -> p.getApellido().contains("M"))
                .forEach(System.out::println);
    }

    public void mostrarSueldosDirectoresMasculinos() {
        System.out.println(" Sueldo por 8 horas de directores masculinos:");
        personas.stream()
                .filter(p -> p.getGenero().equalsIgnoreCase("M") && p.getCargo().equalsIgnoreCase("Director"))
                .peek(p -> System.out.print("Nombre: " + p.getNombre() + " " + p.getApellido() + " "))
                .map(p -> p.getSueldoHora() * 8)
                .forEach(sueldo -> System.out.println("Sueldo por 8 horas: $" + sueldo));
    }

    public void mostrarPrimeraDesarrolladora() {
        Optional<Persona> primeraDevF = personas.stream()
                .filter(p -> p.getCargo().equalsIgnoreCase("Desarrollador") && p.getGenero().equalsIgnoreCase("F"))
                .findFirst();

        primeraDevF.ifPresent(p -> System.out.println(" Primera desarrolladora: " + p));
    }

    public void mostrarDesarrolladorMasGana() {
        Optional<Persona> masGana = personas.stream()
                .filter(p -> p.getCargo().equalsIgnoreCase("Desarrollador"))
                .max(Comparator.comparingDouble(Persona::getSueldoHora));

        if (masGana.isPresent()) {
            System.out.println(" Desarrollador que más gana por hora:");
            System.out.println(masGana.get());
        }
    }

    public void mostrarMujeresOrdenadasPorNombre() {
        System.out.println(" Mujeres ordenadas por nombre:");
        personas.stream()
                .filter(p -> p.getGenero().equalsIgnoreCase("F"))
                .sorted(Comparator.comparing(Persona::getNombre))
                .forEach(System.out::println);
    }
}
