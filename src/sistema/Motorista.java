package sistema;

public class Motorista {

    private String nome;
    private String status;
    private Corrida corridaAtual;

    public Motorista(String nome) {
        this.nome = nome;
        this.status = "disponivel";
        this.corridaAtual = null;
    }

    public String getStatus() {
        return status;
    }

    public String getNome() {
        return nome;
    }

    public Corrida getCorridaAtual() {
        return corridaAtual;
    }

    public void aceitarCorrida(Filacorridas fila) {

        if (!status.equals("disponivel")) {
            return;
        }

        Corrida corrida = fila.pegarCorridaDisponivel();

        if (corrida != null) {

            this.corridaAtual = corrida;
            this.status = "rodando";
            corrida.iniciarCorrida(this);

            System.out.println(nome + " pegou corrida de " + corrida.getPassageiro());

            // THREAD simulando corrida
            new Thread(() -> {
                try {
                    Thread.sleep(5000); // tempo da corrida
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                finalizarCorrida();

            }).start();

        }
    }

    public void finalizarCorrida() {

        if (corridaAtual != null) {

            corridaAtual.finalizarCorrida();

            System.out.println(nome + " finalizou corrida de " + corridaAtual.getPassageiro());

            corridaAtual = null;
            status = "disponivel";
        }
    }
}