package it.edu.iisgubbio.mobilita;

public class Bicicletta extends AMuscoli{
	private int numeroDiRapporti;
	private double peso;
	public Bicicletta(double costo, double peso) {
		super("bicicletta", costo, "quadricipiti");
		this.peso = peso;
	}
	public boolean leggera() {
		return peso<10;
	}
	@Override
	public String toString() {
		String bicicletta="";
		bicicletta+="Bicicletta:  pesa " + peso + "kg ";
		if(leggera()) {
			bicicletta+="(leggera) ";
		}
		bicicletta+="costa " + costo + "€ (ha " + numeroDiRapporti + " rapporti)";
		return bicicletta;
	}
	public int getNumeroDiRapporti() {
		return numeroDiRapporti;
	}
	public void setNumeroDiRapporti(int numeroDiRapporti) {
		this.numeroDiRapporti = numeroDiRapporti;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
}
