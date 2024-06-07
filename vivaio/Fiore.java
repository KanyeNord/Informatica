package it.edu.iisgubbio.vivaio;

public class Fiore extends Pianta implements Imballabile{
	private double volume;
	private int pezziImballo;
	private String colore;
	private int stagioneFioritura;
	public Fiore(String n, double c, String colore, String s) {
		super(n, c);
		this.colore=colore;
		setStagioneFioritura(s);
	}
	public String getColore() {
		return colore;
	}
	public void setColore(String colore) {
		this.colore = colore;
	}
	public String getStagioneFioritura() {
		switch(stagioneFioritura) {
		case 1:
			return "Primavera";
		case 2:
			return "Estate";
		case 3:
			return "Aututnno";
		case 4:
			return "Inverno";
		default:
			return "Errore";
		}	
	}
	public void setStagioneFioritura(String stagioneFioritura) {
		switch(stagioneFioritura) {
		case "Primavera":
			this.stagioneFioritura=1;
			break;
		case "Estate":
			this.stagioneFioritura=2;
			break;
		case "Autunno":
			this.stagioneFioritura=3;
			break;
		case "Inverno":
			this.stagioneFioritura=4;
			break;
		}
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public int getPezziImballo() {
		return pezziImballo;
	}
	public void setPezziImballo(int pezziImballo) {
		this.pezziImballo = pezziImballo;
	}
	public void setStagioneFioritura(int stagioneFioritura) {
		this.stagioneFioritura = stagioneFioritura;
	}
	@Override
	public double getVolumeImballo() {
		return volume*pezziImballo;
	}
	@Override
	public int getPezziPerImballo() {
		return pezziImballo;
	}
	@Override
	public int dozzine() {
		return getPezziPerImballo()/12;
	}	
}