package Ejercicio01;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Jardin> jardines = new ArrayList<>();
        List<Jardinero> jardineros = new ArrayList<>();

        for (int i = 1; i <= 10; i++){
            jardines.add(new Jardin(i));
        }


        for (int i = 0; i < 3; i++){
            jardineros.add(new Jardinero(jardines));
        }

        jardineros.forEach(Jardinero::start);

        try {
            for (Jardinero jardinero : jardineros) {
                jardinero.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (Jardinero jardinero : jardineros) {
            System.out.println("El jardinero " + jardinero.getId() + " ha trabajado " + jardinero.getDias() + " jardines");
        }


    }
}
