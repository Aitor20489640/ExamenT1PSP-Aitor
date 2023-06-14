package Ejercicio02;

import java.util.List;

public class Ciudadano extends Thread {

    private final List<Jardin> jardines;
    private int limite = 0;

    private final ThreadSafeList listaQueja;

    public Ciudadano(List<Jardin> jardines, ThreadSafeList listaQueja) {
        this.jardines = jardines;
        this.listaQueja = listaQueja;
    }

    @Override
    public void run() {
        int num;
        Jardin jardin;
        while (limite < 30) {
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            num = (int) (Math.random() * 10);

            jardin = jardines.get(num);

            if (jardin.getUltimoDiaTrabajado() - limite > 2) {
                listaQueja.add("El jardin " + jardin.getId() + " está en mal estado.");
            }
            try {
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            limite++;
        }
    }
}
