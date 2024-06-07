package it.edu.iisgubbio.fattoria;

public class ProvaProdotto {
	public static void main(String[] args) {
		Ortaggio pomodoro = new Ortaggio("pomodoro", 2, true);
		Prodotto carota = new Prodotto("carota", 2.5);
		Formaggio caciotta = new Formaggio("caciotta", 2.5, 5);
		Formaggio taleggio = new Formaggio("taleggio", 25, 1, true);
		Formaggio ricotta = new Formaggio("ricotta", 4, 0);
		Muffato gorgonzola = new Muffato("gorgonzola", 20, "Penicillium roqueforti", true);
		System.out.println(carota.calcolaPrezzo(4));
		System.out.println(pomodoro);
		System.out.println(pomodoro.calcolaPrezzo(0.5));
		System.out.println(caciotta);
		System.out.println(taleggio);
		System.out.println(ricotta);
		System.out.println(gorgonzola);
	}
}