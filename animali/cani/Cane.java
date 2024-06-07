package it.edu.iisgubbio.animali.cani;

public class Cane {
	String nome;
	String razza;
	int annoNascita;
	int cibo;
	String nomeProprietario;
	public Cane(String nome, int annoNascita) {
		this.nome=nome;
		this.annoNascita=annoNascita;
	}
	public Cane() {
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String x) {
		nome = x;
	}
	public String getRazza() {
		return razza;
	}
	public void setRazza(String razza) {
		this.razza = razza;
	}
	public int getAnnoNascita() {
		return annoNascita;
	}
	public void setAnnoNascita(int annoNascita) {
		this.annoNascita = annoNascita;
	}
	public int getCibo() {
		return cibo;
	}
	public void setCibo(int cibo) {
		this.cibo = cibo;
	}
	public String getNomeProprietario() {
		return nomeProprietario;
	}
	public void setNomeProprietario(String nomeProprietario) {
		this.nomeProprietario = nomeProprietario;
	}
	public String toString() {
		return nome + "("+razza+")";
	}
}