package it.edu.iisgubbio.fattoria;

public class Muffato extends Formaggio{
	protected String nomeMuffa;
	protected boolean muffaInterno;

	public Muffato(String nome, double prezzoKg, String nomeMuffa, boolean muffaInterno) {
		super(nome, prezzoKg, 0);
		this.nomeMuffa = nomeMuffa;
		this.muffaInterno = true;
	}

	@Override
	public String toString() {
		String muffato="";
		muffato += nome + ", prezzo al Kg: " + prezzoKg;
		if(muffaInterno==true) {
			muffato += ", muffa all'interno, ";
		} else {
			muffato += ", muffa all'esterno, ";
		}
		muffato +=nomeMuffa;
		return muffato;
	}
	
	//non stagiona muffato nome muffa e se sta fori o dentro

}
