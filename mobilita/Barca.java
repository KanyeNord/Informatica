package it.edu.iisgubbio.mobilita;

public class Barca extends AMuscoli{
	private int numeroDiRemi;
	private boolean singoloRemo;
	public Barca(String nome, double costo, int numeroDiRemi, boolean singoloRemo) {
		super(nome, costo, "bicipiti");
		this.numeroDiRemi = numeroDiRemi;
		this.singoloRemo = singoloRemo;
	}
	public int numeroVogatori() {
		int nVogatori;
		if(singoloRemo) {
			nVogatori=numeroDiRemi;
		} else {
			nVogatori=numeroDiRemi/2;
		}
		return nVogatori;
	}
	@Override
	public String toString() {
		String Barca="";
		Barca+="Barca: " + nome + " con " + numeroDiRemi + " remi";
		if(singoloRemo==false) {
			Barca+=" (due per vogatore)";
		}
		return  Barca;
	}
}