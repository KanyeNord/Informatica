package it.edu.iisgubbio.mobilita;

public class Aereo extends Volante{
	private boolean reazione;
	private int distanzaMassima;
	public Aereo(String nome) {
		setNome(nome);
	}
	@Override
	public String toString() {
		return "Aereo: " + nome + ", percorrenza massima " + distanzaMassima + "km";
	}
	public boolean puòRaggiungere(int distanza) {
		return distanza<distanzaMassima;
	}
	public boolean isReazione() {
		return reazione;
	}
	public void setReazione(boolean reazione) {
		this.reazione = reazione;
	}
	public int getDistanzaMassima() {
		return distanzaMassima;
	}
	public void setDistanzaMassima(int distanzaMassima) {
		this.distanzaMassima = distanzaMassima;
	}
}