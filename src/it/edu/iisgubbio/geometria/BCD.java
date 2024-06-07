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

public class BCD extends Application {
	TextField cNumero = new TextField();
	Button pCalcola = new Button("calcola");
	Label eRisultato = new Label();
	Hashtable<Character, String> dizBinario = new Hashtable<Character, String>();
	public void start(Stage finestra) throws Exception {
		GridPane griglia = new GridPane();
		Label eNumero = new Label("Numero:");
		Label eNumeroConvertito = new Label("BCD:");

		griglia.add(eNumero, 0, 0);
		griglia.add(cNumero, 1, 0);
		griglia.add(pCalcola, 0, 1, 2, 1);
		griglia.add(eNumeroConvertito, 0, 2);
		griglia.add(eRisultato, 1, 2);
		dizBinario.put('0', "0000");
		dizBinario.put('1', "0001");
		dizBinario.put('2', "0010");
		dizBinario.put('3', "0011");
		dizBinario.put('4', "0100");
		dizBinario.put('5', "0101");
		dizBinario.put('6', "0110");
		dizBinario.put('7', "0111");
		dizBinario.put('8', "1000");
		dizBinario.put('9', "1001");
		pCalcola.setMaxWidth(300);
		pCalcola.setOnAction(e -> calcola());

		griglia.setPadding( new Insets(10,10,10,10));
		griglia.setHgap(5);
		griglia.setVgap(5);

		Scene scena = new Scene (griglia);
		finestra.setTitle("Conversioni Numeriche");
		finestra.setScene(scena);
		finestra.show();

	}
	public void calcola() {
		String numero="";
		for(int i=0; i<cNumero.getText().length(); i++) {
			numero+=dizBinario.get(cNumero.getText().charAt(i))+" ";
		}
		eRisultato.setText(numero);
	}
	public static void main(String[] args) {
		launch(args);
	}
}
