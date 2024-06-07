package it.edu.iisgubbio.mobilita;

public class Deltaplano extends Volante{
	private int numeroDiPosti;
	public Deltaplano(String nome, double costo, int numeroDiPosti) {
		super(nome, costo);
		this.numeroDiPosti=numeroDiPosti;
	}
	
	@Override
	public String toString() {
		String deltaplano="Deltaplano: ";
		if(accettaPasseggero()==false) {
			deltaplano+= "monoposto";
		} else {
			deltaplano+=numeroDiPosti + " posti";
		}
		return deltaplano;
	}
	public boolean accettaPasseggero() {
		return numeroDiPosti>1;
	}
	public int getNumeroDiPosti() {
		return numeroDiPosti;
	}
	public void setNumeroDiPosti(int numeroDiPosti) {
		this.numeroDiPosti = numeroDiPosti;
	}
}
