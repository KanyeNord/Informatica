package it.edu.iisgubbio.animali.cani;

public class Canile {

	public static void main(String[] args) {
		Cane caneGiulia;
		caneGiulia = new Cane("Athena", 2021);
		caneGiulia.razza="Bovaro del bernese";
		System.out.println(caneGiulia);
		System.out.println(caneGiulia.annoNascita);

	}
}