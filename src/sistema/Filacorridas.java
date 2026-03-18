package sistema;

import java.util.Queue;
import java.util.LinkedList;

public class Filacorridas {
	Queue<Corrida> fila;
	
	public Filacorridas() {
		this.fila = new LinkedList<>();
	}
	
	public boolean verificarVazio() {
		return fila.isEmpty();
	}
	public void addCorrida(Corrida corrida) {
		this.fila.offer(corrida);
	}
	public Corrida proximaCorrida() {

	    if (fila.isEmpty()) {
	        return null;
	    }

	    for (Corrida c : fila) {
	        if (c.getStatus().equals("pendente")) {
	            return c;
	        }
	    }
	    return null;
	}
	public void removerCorrida() {
	    if (!fila.isEmpty()) {
	        fila.poll();
	    }
	}
	public int tamanhoFila() {
		return fila.size();
	}
	public void mostrarFila() {
		if(!verificarVazio()) {
			System.out.print("\nFila Atual: \n");
			int i = 1;
			for(Corrida atual:fila) {
				System.out.println(i+" - " + atual);
				i++;
			}
			return;
		}
		System.out.print("Fila Vazia\n");
	}
	
}
