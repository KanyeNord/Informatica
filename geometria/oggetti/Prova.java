package it.edu.iisgubbio.geometria.oggetti;

public class Prova {

	public static void main(String[] args) {
		Cerchio cerchio = new Cerchio(5);
		System.out.println(cerchio.calcolaArea());
		Cerchio cerchioRmx = new Cerchio(10);
		System.out.println(cerchioRmx.calcolaArea());
	}

}
