package it.edu.iisgubbio.mobilita;

public class Motoslitta extends Terrestre{
	private double temperaturaMinima;
	public Motoslitta(String nome, double costo, double velocità ) {
		super();
		setNome(nome);
		setCosto(costo);
		setVelocità(velocità);
	}
	@Override
	public String toString() {
		return "Motoslitta: " + nome + " funziona fino a " + temperaturaMinima + "°C";
	}
	public boolean puòFunzionare(int temp) {
		return temp>temperaturaMinima;
	}
	public double getTemperaturaMinima() {
		return temperaturaMinima;
	}
	public void setTemperaturaMinima(double temperaturaMinima) {
		this.temperaturaMinima = temperaturaMinima;
	}
}