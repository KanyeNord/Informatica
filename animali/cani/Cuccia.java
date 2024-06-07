package it.edu.iisgubbio.animali.cani;

public class Cuccia {
	private boolean interno;
	private double prezzo;
	private int posti;
	private String colore;
	public Cuccia(Boolean interno, double prezzo, int posti, String colore) {
		super();
		this.interno = interno;
		this.prezzo = prezzo;
		this.posti = posti;
		this.colore = colore;
	}
	public Cuccia(Boolean interno, double prezzo) {
		this.interno = interno;
		this.prezzo = prezzo;
	}
	public String toString() {
		String s= "Cuccia " + colore + ", ";
		if (interno) {
			s+="da interno";
		} else {
			s+="da esterno";
		}
		s+=", costa " + prezzo;
		s+=", posti " + posti;
		return s;
	}
	public boolean isInterno() {
		return interno;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public int getPosti() {
		return posti;
	}
	public int setPosti(int posti) {
		if(posti>2) {
			this.posti = 2;
		} else {
			this.posti = posti;
		}
		return this.posti;
	}
	public String getColore() {
		return colore;
	}
	public void setColore(String colore) {
		this.colore = colore;
	}
}