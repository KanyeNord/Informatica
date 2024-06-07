package it.edu.iisgubbio.fattoria;

public class Formaggio extends Prodotto{
	protected boolean prodottoDOP;
	protected int stagionatura;

	public Formaggio(String nome, double prezzoKg, int stagionatura) {
		super(nome, prezzoKg);
		this.prodottoDOP=false;
		this.stagionatura = stagionatura;
	}



	public Formaggio(String nome, double prezzoKg, int stagionatura, boolean prodottoDOP) {
		super(nome, prezzoKg);
		this.prodottoDOP = prodottoDOP;
		this.stagionatura = stagionatura;
	}


	@Override
	public String toString() {
		String formaggio="";
		formaggio += super.toString();;
		if(stagionatura!=0) {
			formaggio += ", stagionatura: " + stagionatura;
		}
		if(prodottoDOP==true) {
			formaggio += ", DOP";
		} else {
			formaggio += ", non DOP";
		}
		return formaggio;
	}
}
