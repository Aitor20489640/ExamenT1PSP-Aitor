package Ejercicio02;

import java.util.List;

public class Jardinero extends Thread{
    private List<Jardin> jardines;
    private int dias;

    public Jardinero(List<Jardin> jardines) {
        this.jardines = jardines;
        dias = 0;
    }

    public int getDias() {
        return dias;
    }

    @Override
    public void run() {
        Jardin jardin = null;
        while (dias < 30){
            int random = (int) (Math.random() * 10);
            int minimo = jardines.get(random).getUltimoDiaTrabajado();
            jardin=jardines.get(random);
            for (Jardin jardin1 : jardines) {
                if (jardin1.getUltimoDiaTrabajado() < minimo) {  //jardin en el que lleva más tiempo sin trabajar
                    minimo = jardin1.getUltimoDiaTrabajado();
                    jardin = jardin1;
                }
            }
            if (!jardin.isBusy()){
                jardin.setBusy(true);
                System.out.println("El jardinero " + this.getId() + " ha empezado a trabajar en el jardín " + jardin.getId() + " dias: " + dias);
                jardin.setUltimoDiaTrabajado(dias);
                try{
                    sleep(1000);
                }
                catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("El jardinero " + this.getId() + " ha terminado de trabajar en el jardín " + jardin.getId());
                jardin.setBusy(false);
                dias++;
            }

        }
    }
}
