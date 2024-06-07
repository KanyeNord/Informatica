package it.edu.iisgubbio.geometria;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.*;

public class ConversioniNumeriche extends Application {
	TextField cNumero = new TextField();
	TextField cBase = new TextField();
	Button pCalcola = new Button("calcola");
	Button pInverso = new Button("inverso");
	Label eRisultato = new Label();
	Hashtable<String, String> dizionarioString = new Hashtable<String, String>();
	Hashtable<Character, Integer> dizionarioChar = new Hashtable<Character, Integer>();
	public void start(Stage finestra) throws Exception {
		GridPane griglia = new GridPane();
		Label eNumero = new Label("Numero:");
		Label eBase = new Label("Base:");
		Label eNumeroConvertito = new Label("numero convertito:");

		griglia.add(eNumero, 0, 0);
		griglia.add(cNumero, 1, 0);
		griglia.add(eBase, 0, 1);

		griglia.add(cBase, 1, 1);
		griglia.add(pCalcola, 0, 2, 2, 1);
		griglia.add(pInverso, 0, 3, 2, 1);
		griglia.add(eNumeroConvertito, 0, 4);
		griglia.add(eRisultato, 1, 4);

		dizionarioString.put("10", "A");
		dizionarioString.put("11", "B");
		dizionarioString.put("12", "C");
		dizionarioString.put("13", "D");
		dizionarioString.put("14", "E");
		dizionarioString.put("15", "F");

		dizionarioChar.put('0', 0);
		dizionarioChar.put('1', 1);
		dizionarioChar.put('2', 2);
		dizionarioChar.put('3', 3);
		dizionarioChar.put('4', 4);
		dizionarioChar.put('5', 5);
		dizionarioChar.put('6', 6);
		dizionarioChar.put('7', 7);
		dizionarioChar.put('8', 8);
		dizionarioChar.put('9', 9);
		dizionarioChar.put('A', 10);
		dizionarioChar.put('B', 11);
		dizionarioChar.put('C', 12);
		dizionarioChar.put('D', 13);
		dizionarioChar.put('E', 14);
		dizionarioChar.put('F', 15);
		

		
		pCalcola.setMaxWidth(300);
		pCalcola.setOnAction(e -> calcola());
		pInverso.setMaxWidth(300);
		pInverso.setOnAction(e -> inverso());

		griglia.setPadding( new Insets(10,10,10,10));
		griglia.setHgap(5);
		griglia.setVgap(5);

		Scene scena = new Scene (griglia);
		finestra.setTitle("Conversioni Numeriche");
		finestra.setScene(scena);
		finestra.show();

	}
	String daVettoreATesto(int[] numeriDaStampare) {
		String stampa="";
		for(int pos = 0;pos<numeriDaStampare.length;pos++) {
			stampa+=numeriDaStampare[pos] + " ";
		}
		return stampa;
	}
	public void calcola() {
		int numero = Integer.parseInt(cNumero.getText());
		int base = Integer.parseInt(cBase.getText());
		String risultato[]= new String[10];
		int resto;
		String restoStringa="";
		String stampa="";

		for (int i=0;i<risultato.length;i++) {
			risultato[i]="0";
		}
		for (int i=risultato.length-1; numero!=0; i--) {
			resto=numero%base;
			if (resto>=10) {
				String resto2 = Integer.toString(resto);
				System.out.println(resto2);
				restoStringa=dizionarioString.get(resto2);
				System.out.println(restoStringa);
				risultato[i]=restoStringa;
			} else {
				restoStringa=resto+"";
				risultato[i]=restoStringa;
			}
			numero=numero/base;
		}
		for (int i=0;i<risultato.length;i++) {
			stampa=stampa+risultato[i];
		}
		eRisultato.setText(stampa);
	}
	
	public void inverso() {
		String numero = eRisultato.getText();
		int decimale=0;
		
		for (int i=0; i<10; i++) {
			decimale=decimale+dizionarioChar.get(numero.charAt(i));
		}
		eRisultato.setText(decimale+"");
	}
	public static void main(String[] args) {
		launch(args);
	}
}
