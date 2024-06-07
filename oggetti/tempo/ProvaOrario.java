package it.edu.iisgubbio.oggetti.tempo;

public class ProvaOrario {

	public static void main(String[] args) {
		Orario adesso = new Orario(8, 58, 23);
		System.out.println(adesso);
		adesso.addOre(8);
		adesso.tick();
		System.out.println(adesso);
	}

}
