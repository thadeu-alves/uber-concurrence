package sistema;

public class Corrida {

    private String passageiro;
    private Motorista motorista;
    private String status;
    private int valor;

    public Corrida(String passageiro, int valor) {
        this.passageiro = passageiro;
        this.status = "pendente";
        this.motorista = null;
        this.valor = valor;
    }

    public void iniciarCorrida(Motorista motorista) {
        this.motorista = motorista;
        this.status = "em andamento";
    }

    public void finalizarCorrida() {
        this.status = "finalizada";
    }

    public String getStatus() {
        return status;
    }

    public int getValor() {
        return valor;
    }

    public String getPassageiro() {
        return passageiro;
    }

    @Override
    public String toString() {
        return "Passageiro: " + passageiro +
               " | Status: " + status +
               " | Valor: " + valor;
    }
}