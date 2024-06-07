package it.edu.iisgubbio.Rimessa;

import it.edu.iisgubbio.mobilita.AMotore;
import it.edu.iisgubbio.mobilita.AMuscoli;
import it.edu.iisgubbio.mobilita.Aereo;
import it.edu.iisgubbio.mobilita.Automobile;
import it.edu.iisgubbio.mobilita.Barca;
import it.edu.iisgubbio.mobilita.Bicicletta;
import it.edu.iisgubbio.mobilita.Deltaplano;
import it.edu.iisgubbio.mobilita.MezzoDiTrasporto;
import it.edu.iisgubbio.mobilita.Motocicletta;
import it.edu.iisgubbio.mobilita.Motoslitta;
import it.edu.iisgubbio.mobilita.Skateboard;
import it.edu.iisgubbio.mobilita.Terrestre;
import it.edu.iisgubbio.mobilita.Volante;

public class MezziRimessa {
	public static void main(String[] args) {
		MezzoDiTrasporto shuttle = new MezzoDiTrasporto("Space shuttle", 1000000.0);
		System.out.println(shuttle);
		System.out.println(shuttle.importoRata(5));
		
		AMuscoli triciclo = new AMuscoli("triciclo", 150, "addominali");
		System.out.println(triciclo);
		triciclo.setMuscoliCoinvolti("bicipiti");
		System.out.println(triciclo);
		System.out.println(triciclo.parteAlta());
		
		AMotore elicottero = new AMotore("elicottero", 50000, 210, "gasolio");
		System.out.println(elicottero);
		System.out.println(elicottero.possibileCentriAbitati());
		
		Skateboard skateboard = new Skateboard("Skateboard", 50000, 210);
		System.out.println(skateboard);
		System.out.println(skateboard.longboard());
		
		Bicicletta bicicletta = new Bicicletta(340, 18);
		bicicletta.setNumeroDiRapporti(1);
		System.out.println(bicicletta);
		System.out.println(bicicletta.leggera());
		
		Barca barca = new Barca("canoa", 20000, 8, false);
		System.out.println(barca.numeroVogatori());
		System.out.println(barca);
		
		Terrestre motocarro = new Terrestre();
		motocarro.setNome("motocarro di luigi");
		motocarro.setCarburante("bambini");
		motocarro.setVelocità(130);
		System.out.println(motocarro);
		
		Motocicletta motoGuzzi = new Motocicletta("MotoGuzzi 345 di Giovanni", 15000, 345);
		motoGuzzi.setNumeroPosti(2);
		System.out.println(motoGuzzi.puoTrasportare(1));
		System.out.println(motoGuzzi);
		
		Automobile maserati = new Automobile("Maserati di Mario", 50000, 5);
		maserati.setTarga("BF5567UU");
		System.out.println(maserati);
		
		Motoslitta motoslitta = new Motoslitta("motoslitta di Mark", 15000, 20);
		motoslitta.setTemperaturaMinima(-30);
		System.out.println(motoslitta);
		
		Volante volante = new Volante("elicottero",50000);
		System.out.println(volante);
		
		Deltaplano deltaplano = new Deltaplano("deltaplano",16000, 2);
		System.out.println(deltaplano);
		
		Aereo aereo = new Aereo("A340");
		aereo.setDistanzaMassima(4500); 
		System.out.println(aereo);
	}
}
