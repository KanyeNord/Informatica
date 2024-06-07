package it.edu.iisgubbio.oggetti.tempo;

public class Orario {
	private int ora;
	private int minuto;
	private int secondo;
	public Orario(int ora, int minuto, int secondo) {
		this.ora = ora;
		this.minuto = minuto;
		this.secondo = secondo;
	}
	public String toString() {
		String orario="";
		if(ora<10) {
			orario+="0"+ora+":";
		} else {
			orario+=ora+":";
		}
		if(minuto<10) {
			orario+="0"+minuto+":";
		} else {
			orario+=minuto+":";
		}
		if(secondo<10) {
			orario+="0"+secondo;
		} else {
			orario+=secondo+":";
		}
		return orario;
	}
	public void addOre(int ora) {
		this.ora+=ora;
	}
	public void addMinuti(int minuto) {
		this.minuto+=minuto;
		if(this.minuto>=60) {
			ora+=1;
			this.minuto=this.minuto%60;
		}
	}
	public void addSecondi(int secondo) {
		this.secondo+=secondo;
		if(this.secondo>=60) {
			addMinuti(this.secondo/60);
			this.secondo=this.secondo%60;
		}
	}
	public void addOrario(Orario daAggiungere) {
		addSecondi(daAggiungere.secondo);
		addMinuti(daAggiungere.minuto);
		ora+=daAggiungere.ora;
	}
	public void tick() {
		addSecondi(1);
	}
}