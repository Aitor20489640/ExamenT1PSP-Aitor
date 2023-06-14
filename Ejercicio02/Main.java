package Ejercicio02;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Jardin> jardines = new ArrayList<>();
        List<Jardinero> jardineros = new ArrayList<>();
        List<Ciudadano> ciudadanos = new ArrayList<>();
        ThreadSafeList listaQueja = new ThreadSafeList();

        for (int i = 1; i <= 10; i++){
            jardines.add(new Jardin(i));
        }

        for (int i = 0; i < 3; i++){
            jardineros.add(new Jardinero(jardines));
        }

        for (int i = 0; i < 3; i++){
            ciudadanos.add(new Ciudadano(jardines, listaQueja));
        }

        jardineros.forEach(Jardinero::start);
        ciudadanos.forEach(Ciudadano::start);

        try {
            for (Jardinero jardinero : jardineros) {
                jardinero.join();
            }
            for (Ciudadano ciudadano : ciudadanos) {
                ciudadano.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Trabajadores:");
        for (Jardinero jardinero : jardineros) {
            System.out.println("El jardinero " + jardinero.getId() + " ha trabajado " + jardinero.getDias() + " jardines");
        }
        System.out.println("\nQuejas recibidas:");

        listaQueja.forEach();


    }
}
