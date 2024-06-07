package it.edu.iisgubbio.mobilita;

public class Terrestre extends AMotore{
	private double velocità;
	public Terrestre() {
		super();
	}
	@Override
	public String toString() {
		return "Veicolo terrestre a motore: " + getNome() + ", va a " + getCarburante() + " e al massimo percorre " + velocità + " km in un'ora";
	}
	public double tempoDiPercorrenza(int distanza) {
		return distanza/velocità;
	}
	public double getVelocità() {
		return velocità;
	}
	public void setVelocità(double velocità) {
		this.velocità = velocità;
	}
}