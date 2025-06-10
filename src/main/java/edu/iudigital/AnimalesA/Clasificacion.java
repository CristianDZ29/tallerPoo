package edu.iudigital.AnimalesA;

import java.util.*;

public class Clasificacion {
    private List<Animales> animales = new ArrayList<>();
    private Map<String, List<Animales>> clasificacion = new TreeMap<>();

    public void cargarAnimales() {

        animales.add(new Animales("Oso", "terrestre", "masculino"));
        animales.add(new Animales("Perro", "terrestre", "masculino"));
        animales.add(new Animales("Ballena", "acuático", "femenino"));
        animales.add(new Animales("Tiburón", "acuático", "masculino"));
        animales.add(new Animales("Paloma", "aéreo", "femenino"));
        animales.add(new Animales("Buitre", "aéreo", "masculino"));


        for (Animales animal : animales) {
            clasificacion.computeIfAbsent(animal.getTipo(), k -> new ArrayList<>()).add(animal);
        }
    }

    public void mostrarClasificacion() {
        System.out.println("\nClasificación de animales:");
        for (Map.Entry<String, List<Animales>> entry : clasificacion.entrySet()) {
            String tipo = entry.getKey();
            List<Animales> lista = entry.getValue();
            System.out.println((tipo));
            for (Animales a : lista) {
                System.out.println("  - " + a.getNombre());
            }
        }
    }
}
