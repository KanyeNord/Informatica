package it.edu.iisgubbio.mobilita;

public class AMuscoli extends MezzoDiTrasporto{
	private String muscoliCoinvolti;
	public AMuscoli() {
		super();
	}
	public AMuscoli(String nome, double costo, String muscoliCoinvolti) {
		super(nome,costo);
		this.muscoliCoinvolti = muscoliCoinvolti;
	}
	public boolean parteAlta() {
		if(muscoliCoinvolti.equals("bicipiti") || muscoliCoinvolti.equals("addominali") || muscoliCoinvolti.equals("pettorale") || muscoliCoinvolti.equals("tricipiti")) {
			return true;
		} else {
			return false;
		}
	}
	@Override
	public String toString() {
		return "Veicolo a muscoli: " + nome + ", " + costo + "€ (usa " + muscoliCoinvolti + ")";
	}
	public String getMuscoliCoinvolti() {
		return muscoliCoinvolti;
	}
	public void setMuscoliCoinvolti(String muscoliCoinvolti) {
		if(this.muscoliCoinvolti.toLowerCase().equals(this.muscoliCoinvolti)) {
			this.muscoliCoinvolti = muscoliCoinvolti;
		}
	}
}