package sistema;

import java.util.*;

public class Sistema {

    Scanner sc = new Scanner(System.in);

    List<Motorista> motoristas = new ArrayList<>();
    Filacorridas fila = new Filacorridas();

    public void Aplicativo() {

        int op;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("[1] Cadastrar motorista");
            System.out.println("[2] Criar corrida");
            System.out.println("[3] Iniciar corridas (paralelo)");
            System.out.println("[4] Listar motoristas");
            System.out.println("[5] Ver fila");
            System.out.println("[6] Finalizar corrida manual");
            System.out.println("[0] Sair");

            op = sc.nextInt();
            sc.nextLine();

            switch (op) {

                case 1:
                    motoristas.add(cadastrarMotorista());
                    break;

                case 2:
                    fila.addCorrida(cadastrarCorrida());
                    break;

                case 3:
                    iniciarCorridas();
                    break;

                case 4:
                    listarMotoristas();
                    break;

                case 5:
                    fila.mostrarFila();
                    break;

                case 6:
                    finalizarManual();
                    break;
            }

        } while (op != 0);
    }

    public void iniciarCorridas() {
        for (Motorista m : motoristas) {
            new Thread(() -> {
                m.aceitarCorrida(fila);
            }).start();
        }
    }

    public void finalizarManual() {
        for (Motorista m : motoristas) {
            if (m.getCorridaAtual() != null) {
                m.finalizarCorrida();
                return;
            }
        }
        System.out.println("Nenhuma corrida ativa");
    }

    public void listarMotoristas() {
        for (Motorista m : motoristas) {
            System.out.println(m.getNome() + " - " + m.getStatus());
        }
    }

    public Motorista cadastrarMotorista() {
        System.out.print("Nome: ");
        return new Motorista(sc.nextLine());
    }

    public Corrida cadastrarCorrida() {
        System.out.print("Passageiro: ");
        String nome = sc.nextLine();

        System.out.print("Valor: ");
        int valor = sc.nextInt();
        sc.nextLine();

        return new Corrida(nome, valor);
    }
}