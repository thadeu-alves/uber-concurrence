package Classes;

public class CorridaService {

    private Filacorridas fila = new Filacorridas();

    public void solicitarCorrida(Corrida corrida) {
        fila.addCorrida(corrida);
        System.out.println("Corrida adicionada à fila com sucesso.");
    }

    public Corrida proximaCorrida() {
        return fila.proximaCorrida();
    }

    public void listarCorridas() {
        fila.mostrarFila();
    }

    public boolean filaVazia() {
        return fila.verificarVazio();
    }

    public int totalCorridasPendentes() {
        return fila.tamanhoFila();
    }
}