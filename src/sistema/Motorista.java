package sistema;

public class Motorista {

    private String nome;
    private String status;
    private Corrida corridaAtual;

    public Motorista() {
        nome = "";
        status = "disponivel";
        corridaAtual = null;
    }

    public Motorista(String nome, String status, Corrida corridaAtual) {
        this.nome = nome;
        this.status = status;
        this.corridaAtual = corridaAtual;
    }

    public Motorista(String nome) {
        this.nome = nome;
        this.status = "disponivel";
        this.corridaAtual = null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Corrida getCorridaAtual() {
        return corridaAtual;
    }

    public void setCorridaAtual(Corrida corridaAtual) {
        this.corridaAtual = corridaAtual;
    }

    public void aceitarCorrida(Filacorridas fila) {

        if (status.equalsIgnoreCase("disponivel")) {

            Corrida corrida = fila.proximaCorrida();

            if (corrida != null && corrida.getStatus().equals("pendente")) {

                this.corridaAtual = corrida;
                this.status = "rodando";

                corrida.iniciarCorrida(this);

                System.out.println("Corrida aceita por " + nome);

            } else {
                System.out.println("Nenhuma corrida disponível");
            }

        } else {
            System.out.println("Motorista ocupado");
        }
    }

    public void finalizarCorrida(Filacorridas fila) {

        if (corridaAtual != null) {

            corridaAtual.finalizarCorrida();

            fila.removerCorrida();

            this.corridaAtual = null;
            this.status = "disponivel";

            System.out.println("Corrida finalizada por " + nome);

        } else {
            System.out.println("Nenhuma corrida em andamento");
        }
    }
}
