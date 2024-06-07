package it.edu.iisgubbio.vivaio;

public class Container {
	private double volumeMassimo;
	private double volumeDisponibile;
	private Imballabile scatole[]= new Imballabile[100];
	private int contatore=0;
	public Container(double volumeMassimo) {
		super();
		this.volumeMassimo=volumeMassimo;
		volumeDisponibile=getVolumeMassimo();
	}
	
	public double getVolumeMassimo() {
		return volumeMassimo;
	}

	public void setVolumeMassimo(double volumeMassimo) {
		this.volumeMassimo = volumeMassimo;
	}
	public boolean add(Imballabile scatola) {
		if(volumeDisponibile<scatola.getVolumeImballo()) {
			scatole[contatore]=scatola;
			contatore++;
			volumeDisponibile-=scatola.getVolumeImballo();
			return true;
		} else {
			return false;
		}
	}
	public int getDozzine() {
		int dozzine=0;
		for(int i=0;i<=contatore; i++) {
			dozzine+=scatole[i].dozzine();
		}
		return dozzine;
	}
}