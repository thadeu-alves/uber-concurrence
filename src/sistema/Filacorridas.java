package sistema;

import java.util.Queue;
import java.util.LinkedList;

public class Filacorridas {

    private Queue<Corrida> fila;

    public Filacorridas() {
        this.fila = new LinkedList<>();
    }

    public synchronized void addCorrida(Corrida corrida) {
        fila.offer(corrida);
    }

    public synchronized Corrida pegarCorridaDisponivel() {
        for (Corrida c : fila) {
            if (c.getStatus().equals("pendente")) {
                fila.remove(c);
                return c;
            }
        }
        return null;
    }

    public void mostrarFila() {
        if (fila.isEmpty()) {
            System.out.println("Fila vazia");
            return;
        }

        for (Corrida c : fila) {
            System.out.println(c);
        }
    }
}