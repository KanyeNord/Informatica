package it.edu.iisgubbio.mobilita;

public class MezzoDiTrasporto {
	protected double costo;
	protected String nome;
	public MezzoDiTrasporto(){
		super();
	}
	public MezzoDiTrasporto(String nome, double costo) {
		this.costo = costo;
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "MezzoDiTrasporto: " + nome + ", " + costo + "€";
	}
	public double importoRata(int numeroRate) {
		double importoRate=costo/numeroRate;
		return importoRate;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}