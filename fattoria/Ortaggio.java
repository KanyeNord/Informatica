package it.edu.iisgubbio.fattoria;

public class Ortaggio extends Prodotto{
	protected boolean biologico;
	public Ortaggio(String nome, double prezzoKg, boolean biologico) {
		super(nome, prezzoKg);
		this.biologico = biologico;
	}
	@Override
	public String toString() {
		String ortaggio="";
		ortaggio += nome + ", " + prezzoKg + ", ";
		if(biologico==true) {
			ortaggio += "biologico";
		} else {
			ortaggio += "non biologico";
		}
		return ortaggio;
	}
}