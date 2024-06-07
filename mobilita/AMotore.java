package it.edu.iisgubbio.mobilita;

public class AMotore extends MezzoDiTrasporto{
	private double rumorosità;
	private String carburante;
	public AMotore(){
		super();
	}
	public AMotore(String nome, double costo, double rumorosità, String carburante) {
		super(nome, costo);
		this.rumorosità = rumorosità;
		this.carburante = carburante;
	}
	@Override
	public String toString() {
		return "Mezzo motorizzato: " + nome + "(" + costo + "€) che emette " + rumorosità + "db di rumore, consuma " + carburante;
	}
	public boolean possibileCentriAbitati() {
		return rumorosità<68;
	}
	public double getRumorosità() {
		return rumorosità;
	}
	public void setRumorosità(double rumorosità) {
		this.rumorosità = rumorosità;
	}
	public String getCarburante() {
		return carburante;
	}
	public void setCarburante(String carburante) {
		this.carburante = carburante;
	}
}