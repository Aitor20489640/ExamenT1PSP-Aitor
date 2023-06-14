package Ejercicio01;

public class Jardin {
    private boolean busy = false;
    private final int id;

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
}
