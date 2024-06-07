package it.edu.iisgubbio.fattoria;

public class Prodotto {
	protected String nome;
	protected double prezzoKg;
	public Prodotto(String nome, double prezzoKg) {
		this.nome = nome;
		this.prezzoKg = prezzoKg;
	}
	public Prodotto() {
		
	}
	@Override
	public String toString() {
		return  nome + ", prezzo al Kg: " + prezzoKg;
	}
	public double calcolaPrezzo(double peso) {
		double prezzo=prezzoKg*peso;
		return prezzo;
	}
	
}