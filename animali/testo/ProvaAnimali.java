package it.edu.iisgubbio.animali.testo;

import it.edu.iisgubbio.animali.cani.Cane;
import it.edu.iisgubbio.animali.cani.Cuccia;

public class ProvaAnimali {
		public static void main(String[] args) {
			Cane caneGiulia;
			caneGiulia = new Cane("Athena", 2021);
			caneGiulia.setRazza("Bovaro del bernese");
			caneGiulia.setAnnoNascita(caneGiulia.getAnnoNascita() + 1);
			caneGiulia.setAnnoNascita(caneGiulia.getAnnoNascita()+1);
			System.out.println(caneGiulia);
			System.out.println(caneGiulia.getAnnoNascita());
			Cuccia cucciaAthena = new Cuccia(true, 12.3, 2, "bianca");
			System.out.println(cucciaAthena.getPosti());
			cucciaAthena.setPosti(8);
			System.out.println(cucciaAthena);
			Cuccia cucciaAlbanese = new Cuccia(true, 12.3, 1, "bianca");
			System.out.println(cucciaAlbanese);
		}
	}