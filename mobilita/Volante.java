package it.edu.iisgubbio.mobilita;

public class Volante extends AMotore{
	private double quotaMassima;
	public Volante() {
		
	}
	public Volante(String nome, double costo) {
		super();
		setNome(nome);
		setCosto(costo);
		setQuotaMassima(2400);
	}
	
	@Override
	public String toString() {
		return "Mezzo volante: " + nome + " (" + costo + "€) vola fino a " + quotaMassima + "m di quota";
	}
	public boolean isNecessariaPressurizzazione() {
		return quotaMassima>300;
	}
	public double getQuotaMassima() {
		return quotaMassima;
	}
	public void setQuotaMassima(double quotaMassima) {
		this.quotaMassima = quotaMassima;
	}

	
}
