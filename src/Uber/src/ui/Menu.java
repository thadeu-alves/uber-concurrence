package ui;

import java.util.Scanner;


public class Menu{

    private Scanner sc = new Scanner(System.in);
    private CorridaService service = new CorridaService();

    public void iniciar() {
        int opcao;

        do {
            System.out.println("\n==== MENU ====");
            System.out.println("1 - Solicitar corrida");
            System.out.println("2 - Ver corridas");
            System.out.println("3 - Atender próxima corrida");
            System.out.println("0 - Sair");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    criarCorrida();
                    break;

                case 2:
                    service.listarCorridas();
                    break;

                case 3:
                    atenderCorrida();
                    break;
            }

        } while (opcao != 0);
    }

    private void criarCorrida() {
        System.out.print("Nome do passageiro: ");
        String nome = sc.nextLine();

        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        System.out.print("Origem: ");
        String origem = sc.nextLine();

        System.out.print("Destino: ");
        String destino = sc.nextLine();

        Passageiro p = new Passageiro(nome, telefone);
        Corrida corrida = new Corrida(origem, destino, p);

        service.solicitarCorrida(corrida);

        System.out.println("Corrida criada com sucesso!");
    }

    private void atenderCorrida() {
        Corrida corrida = service.proximaCorrida();

        if (corrida == null) {
            System.out.println("Nenhuma corrida disponível.");
            return;
        }

        corrida.aceitarCorrida();
        System.out.println("Corrida aceita:");
        System.out.println(corrida.getResumo());

        corrida.finalizarCorrida();
        System.out.println("Corrida finalizada!");
    }
}
















