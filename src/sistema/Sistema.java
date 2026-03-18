package sistema;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;



public class Sistema {
	Scanner sc = new Scanner(System.in);
	String usuario = "";
	Queue<Motorista> motoristas;
	Filacorridas filaCorrida = new Filacorridas();
	public Sistema() {
	    this.motoristas = new LinkedList<>();
	}
	
	public void Aplicativo() {
	    int op;

	    do {
	        System.out.println("\n=== MENU ===");
	        System.out.println("[1] Cadastrar motorista");
	        System.out.println("[2] Criar corrida");
	        System.out.println("[3] Aceitar corrida");
	        System.out.println("[4] Listar motoristas");
	        System.out.println("[5] Ver fila de corridas");
	        System.out.println("[6] Finalizar corrida");
	        System.out.println("[0] Sair");
	        System.out.print("Opção: ");

	        op = sc.nextInt();
	        sc.nextLine();

	        switch (op) {

	            case 1: adicionarMotorista(this.cadastrarMotorista());break;
	            case 2: filaCorrida.addCorrida(this.cadastrarCorrida());;break;

	            case 3:this.aceitarCorrida();break;

	            case 4: this.listarMotoristas();break;
	            case 5:filaCorrida.mostrarFila();break;
	            case 6: finalizarCorrida();break;
	            case 0:System.out.println("Encerrando sistema...");break;

	            default:
	                System.out.println("Opção inválida!");
	        }

	    } while (op != 0);
	}
	
	public void adicionarMotorista(Motorista m) {
		motoristas.offer(m);
	}
	public void removerMotorista(Motorista m) {
		if(motoristas.isEmpty()) {
			motoristas.poll();
			return;
		}
		System.out.print("\n não tem motoristas disponivel\n");
	}
	public Motorista getMotoristaDisponivel() {
	    for (Motorista motoristaAux : motoristas) {
	        if (motoristaAux.getStatus().equals("disponivel")) {
	            return motoristaAux;
	        }
	    }
	    return null;
	}
	public void listarMotoristas() {
		if(this.motoristas.size()>=1) {
			int i = 1;
			for (Motorista motoristaAux : motoristas) {
		        System.out.println( i +" - "+motoristaAux.getNome() + " - " + motoristaAux.getStatus());
		        i ++;
			}
		}
		else {
	        System.out.println("não tem motorista disponivel");

		}
	    
	}
	public Motorista cadastrarMotorista() {
		Motorista motoristaAux = new Motorista();
		Scanner sc = new Scanner(System.in);
        System.out.println("nome do motorista: ");
        motoristaAux.setNome(sc.nextLine());
        return motoristaAux;
	}
	public Corrida cadastrarCorrida() {
		Scanner sc = new Scanner(System.in);
		Scanner scvalor = new Scanner(System.in);
        System.out.println("nome do passageiro: ");
        String nome = sc.nextLine();
        System.out.println("preço da corrida: ");
        int valor = scvalor.nextInt();
        return new Corrida(nome,valor);
	}
	public void finalizarCorrida() {

	    Motorista emCorrida = null;

	    for (Motorista m : motoristas) {
	        if (m.getStatus().equals("rodando")) {
	            emCorrida = m;
	            break;
	        }
	    }

	    if (emCorrida != null) {
	        emCorrida.finalizarCorrida(filaCorrida);
	    } else {
	        System.out.println("Nenhuma corrida em andamento");
	    }
	}
	public void aceitarCorrida() {

	    for (Motorista motoristaAux : motoristas) {
	    	if(motoristaAux.getStatus().equals("disponivel")){
	    		motoristaAux.aceitarCorrida(filaCorrida);
	    		return;
	    	}
	    }
	    System.out.println("não tem motorista disponivel");


	}
	
}
