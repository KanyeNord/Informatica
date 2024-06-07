package it.edu.iisgubbio.vivaio;

public class Commestibile extends Pianta implements Imballabile{
	private double volumeImballo;
	private int pezziImballo;
	private int quantita;
	private int stagioneProduzione;
	public Commestibile(String n, double c) {
		super(n, c);
	}
	@Override
	public String toString() {
		return "Commestibile [quantita=" + quantita + ", stagioneProduzione=" + stagioneProduzione + ", Nome="
				+ getNome() + ", Costo=" + getCosto() + "]";
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	public int getStagioneProduzione() {
		return stagioneProduzione;
	}
	public void setStagioneProduzione(int stagioneProduzione) {
		this.stagioneProduzione = stagioneProduzione;
	}
	
	
	
	public double getVolume() {
		return volumeImballo;
	}
	public void setVolumeImballo(double volume) {
		this.volumeImballo = volume;
	}
	public int getPezziImballo() {
		return pezziImballo;
	}
	public void setPezziImballo(int pezziImballo) {
		if(pezziImballo%12==0) {
			this.pezziImballo=pezziImballo;
		}
	}
	@Override
	public double getVolumeImballo() {
		return volumeImballo;
	}
	@Override
	public int getPezziPerImballo() {
		return pezziImballo;
	}
	@Override
	public int dozzine() {
		if(getPezziPerImballo()%12==0) {
			return (int)(getPezziPerImballo()/12);
		}else {
			return 0;
		}
	}
}