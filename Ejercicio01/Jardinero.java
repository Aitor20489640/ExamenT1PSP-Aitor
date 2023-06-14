package Ejercicio01;

import java.util.List;

public class Jardinero extends Thread{
    List<Jardin> jardines;
    int dias;

    public Jardinero(List<Jardin> jardines) {
        this.jardines = jardines;
        dias = 0;
    }

    public int getDias() {
        return dias;
    }

    @Override
    public void run() {
        int num;
        Jardin jardin;
        while (dias < 30){
            num = (int) (Math.random() * 10);
            jardin = jardines.get(num);
            if (!jardin.isBusy()){
                jardin.setBusy(true);
                System.out.println("El jardinero " + this.getId() + " ha empezado a trabajar en el jardín " + jardin.getId());
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
