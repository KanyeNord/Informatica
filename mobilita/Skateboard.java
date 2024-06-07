package it.edu.iisgubbio.mobilita;

public class Skateboard extends AMuscoli{
	private int lunghezza;

	public Skateboard(String nome, double costo, int lunghezza) {
		super(nome, costo, "polpacci");
		this.lunghezza = lunghezza;
	}
	public Skateboard(String nome, double costo) {
		this.nome = nome;
		this.costo = costo;
		lunghezza = 60;
	}
	public boolean longboard() {
		return lunghezza>80;
	}
	@Override
	public String toString() {
		String skate="";
		skate+=nome;
		if(longboard()) {
			skate+=" longboard";
		}
		skate+=": lungo " + lunghezza + "cm" + " costa " + costo + "€";

		return skate;
	}
	public int getLunghezza() {
		return lunghezza;
	}
	public void setLunghezza(int lunghezza) {
		this.lunghezza = lunghezza;
	}
}