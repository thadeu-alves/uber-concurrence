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
	    if(verificarVazio()) {
	        System.out.println("Fila vazia");
	        return null;
	    }
	    return fila.poll();
	}
	public int tamanhoFila() {
		return fila.size();
	}
	public void mostrarFila() {
		if(!verificarVazio()) {
			System.out.print("\nFila Atual: \n");
			for(Corrida atual:fila) {
				System.out.print("[ " + atual + " ] <- ");
			}
			return;
		}
		System.out.print("Fila Vazia\n");
	}
	
}
