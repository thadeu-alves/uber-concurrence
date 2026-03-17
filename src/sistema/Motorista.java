package sistema;

public class Motorista {
	String nome;
	String status;
	Corrida corridaAtual;
	
	public Motorista() {
		nome = "";
		status = "";
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
	
	public void aceitarCorrida(Filacorridas fila) {
	    if(status.equalsIgnoreCase("disponivel")) {
	        Corrida corrida = fila.proximaCorrida();
	        
	        if(corrida != null) {
	            this.corridaAtual = corrida;
	            this.status = "indisponivel";
	            corrida.iniciarCorrida(this);
	        }
	    } else {
	        System.out.println("Motorista ocupado");
	    }
	}
	public void FinalizarCorrida() {
		this.corridaAtual = null;
		this.status = "disponivel";
	}
}
