package sistema;

public class Corrida {
	private String passageiro;
	private Motorista motorista;
	private String status;
	private int valor;
	
	public Corrida(String passageiro,Motorista motorista,String status, int valor) {
		this.passageiro = passageiro;
		this.motorista = motorista;
		this.status = status;
		this.valor = valor;
	}
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

	
	public String getPassageiro() {
		return passageiro;
	}
	public Motorista getMotorista() {
		return motorista;
	}
	public String getStatus() {
		return status;
	}
	public int getvalor() {
		return valor;
	}
	
	@Override
	public String toString() {
		return "Passageiro: " + passageiro + " Motorista: " + motorista + "Status: " + status + " Valor: " + valor;
	}

}
