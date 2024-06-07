package it.edu.iisgubbio.mobilita;

public class Motocicletta extends Terrestre{
	private double cilindrata;
	private int numeroPosti;
	public Motocicletta(String nome, double costo, double cilindrata) {
		super();
		setNome(nome);
		setCosto(costo);
		this.cilindrata=cilindrata;
	}
	@Override
	public String toString() {
		return "Motocicletta: " + nome;
	}
	public boolean puoTrasportare(int persone) {
		return persone<=numeroPosti;
	}
	public double getCilindrata() {
		return cilindrata;
	}
	public void setCilindrata(double cilindrata) {
		this.cilindrata = cilindrata;
	}
	public int getNumeroPosti() {
		return numeroPosti;
	}
	public void setNumeroPosti(int numeroPosti) {
		this.numeroPosti = numeroPosti;
	}
}