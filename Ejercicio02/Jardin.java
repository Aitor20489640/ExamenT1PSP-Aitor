package Ejercicio02;

public class Jardin {
    private boolean busy = false;
    private final int id;

    private int ultimoDiaTrabajado = 0;

    public Jardin(int id) {
        this.id = id;
    }

    public boolean isBusy() {
        return busy;
    }

    public synchronized void setBusy(boolean busy) {
        this.busy = busy;
    }

    public int getId() {
        return id;
    }

    public int getUltimoDiaTrabajado() {
        return ultimoDiaTrabajado;
    }

    public synchronized void setUltimoDiaTrabajado(int ultimoDiaTrabajado) {
        this.ultimoDiaTrabajado = ultimoDiaTrabajado;
    }

}
