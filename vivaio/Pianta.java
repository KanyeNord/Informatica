package it.edu.iisgubbio.vivaio;

public class Pianta {
	private String nome;
	private double costo;
	public Pianta(String n, double c) {
		nome=n;
		costo=c;
	}
	@Override
	public String toString() {
		return nome + " " + costo + "€";
	}
	public String getNome() {
		return nome;
	}
	public double getCosto() {
		return costo;
	}
}