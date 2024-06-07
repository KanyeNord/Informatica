package it.edu.iisgubbio.Rimessa;

import it.edu.iisgubbio.mobilita.Aereo;
import it.edu.iisgubbio.mobilita.Automobile;
import it.edu.iisgubbio.mobilita.Barca;
import it.edu.iisgubbio.mobilita.Bicicletta;
import it.edu.iisgubbio.mobilita.Deltaplano;
import it.edu.iisgubbio.mobilita.MezzoDiTrasporto;
import it.edu.iisgubbio.mobilita.Motocicletta;
import it.edu.iisgubbio.mobilita.Motoslitta;
import it.edu.iisgubbio.mobilita.Skateboard;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Garage extends Application{
	GridPane griglia = new GridPane();
	ListView<MezzoDiTrasporto> lista = new ListView<>();
	ComboBox<String> combo = new ComboBox<>();
	CheckBox checkRemo = new CheckBox();
	CheckBox checkReazione = new CheckBox();
	TextField cNome = new TextField();
	TextField cCosto = new TextField();
	TextField cParametro1 = new TextField();
	TextField cParametro2 = new TextField();
	TextField cParametro3 = new TextField();
	TextField cParametro4 = new TextField();
	TextField cParametro5 = new TextField();

	Label eNome = new Label();
	Label eCosto = new Label();
	Label eParametro1 = new Label();
	Label eParametro2 = new Label();
	Label eParametro3 = new Label();
	Label eParametro4 = new Label();
	Label eParametro5 = new Label();
	Button pAggiungi = new Button("aggiungi");
	public void start(Stage finestra) throws Exception {
		Label opzioni = new Label("scegli opzione ->");

		griglia.setGridLinesVisible(false);
		griglia.add(lista, 0, 0, 1, 11);
		griglia.add(opzioni, 1, 0);
		griglia.add(combo, 2, 0);

		griglia.add(eNome , 1, 1);
		griglia.add(cNome , 2, 1);

		griglia.add(eCosto, 1, 2);
		griglia.add(cCosto, 2, 2);

		griglia.add(eParametro1, 1, 3);
		griglia.add(cParametro1, 2, 3);

		griglia.add(eParametro2, 1, 4);
		griglia.add(cParametro2, 2, 4);

		griglia.add(eParametro3, 1, 5);
		griglia.add(cParametro3, 2, 5);
		checkRemo.setVisible(false);
		griglia.add(checkRemo, 2, 5);

		griglia.add(eParametro4, 1, 6);
		griglia.add(cParametro4, 2, 6);
		checkReazione.setVisible(false);
		griglia.add(checkReazione, 2, 6);
		
		griglia.add(eParametro5, 1, 7);
		griglia.add(cParametro5, 2, 7);

		griglia.add(pAggiungi, 2, 10);
		pAggiungi.setMaxWidth(170);
		combo.setPrefWidth(170);
		lista.setPrefHeight(220);

		combo.getItems().add("Bicicletta");
		combo.getItems().add("Barca");
		combo.getItems().add("Skateboard");
		combo.getItems().add("Automobile");
		combo.getItems().add("Motocicletta");
		combo.getItems().add("Motoslitta");
		combo.getItems().add("Deltaplano");
		combo.getItems().add("Aereo");

		combo.setOnAction(e->selezionaMezzo());
		pAggiungi.setOnAction(e -> aggiungi());

		griglia.setPadding( new Insets(10,10,10,10));
		griglia.setHgap(5);
		griglia.setVgap(5);
		Scene scena = new Scene (griglia);
		finestra.setTitle("Garage");
		finestra.setScene(scena);
		finestra.show();
	}
	public void aggiungi() {
		String mezzo = combo.getValue();
		String nome = cNome.getText();
		double costo = Double.parseDouble(cCosto.getText());
		switch (mezzo) {
		case "Bicicletta":
			Bicicletta bicicletta = new Bicicletta(costo, Double.parseDouble(cParametro3.getText()));
			bicicletta.setNome(nome);
			bicicletta.setMuscoliCoinvolti(cParametro1.getText());
			bicicletta.setNumeroDiRapporti(Integer.parseInt(cParametro2.getText()));
			lista.getItems().add(bicicletta);
			break;
		case "Barca":
			Barca barca = new Barca(nome, costo, Integer.parseInt(cParametro2.getText()), checkRemo.isSelected() );
			barca.setMuscoliCoinvolti(cParametro1.getText());
			lista.getItems().add(barca);
			break;
		case "Skateboard":
			Skateboard skateboard = new Skateboard(nome, costo, Integer.parseInt(cParametro2.getText()));
			skateboard.setMuscoliCoinvolti(cParametro1.getText());
			lista.getItems().add(skateboard);
			break;
		case "Automobile":
			Automobile automobile = new Automobile(nome, costo, Integer.parseInt(cParametro4.getText()));
			automobile.setCarburante(cParametro1.getText());
			automobile.setRumorosità(Double.parseDouble(cParametro2.getText()));
			automobile.setVelocità(Double.parseDouble(cParametro3.getText()));
			automobile.setTarga(cParametro5.getText());
			lista.getItems().add(automobile);
			break;
		case "Motocicletta":
			Motocicletta motocicletta = new Motocicletta(nome, costo, Double.parseDouble(cParametro5.getText()));
			motocicletta.setCarburante(cParametro1.getText());
			motocicletta.setRumorosità(Double.parseDouble(cParametro2.getText()));
			motocicletta.setVelocità(Double.parseDouble(cParametro3.getText()));
			motocicletta.setNumeroPosti(Integer.parseInt(cParametro4.getText()));
			lista.getItems().add(motocicletta);
			break;
		case "Motoslitta":
			Motoslitta motoslitta = new Motoslitta(nome, costo, Double.parseDouble(cParametro5.getText()));
			motoslitta.setCarburante(cParametro1.getText());
			motoslitta.setRumorosità(Double.parseDouble(cParametro2.getText()));
			motoslitta.setVelocità(Double.parseDouble(cParametro3.getText()));
			motoslitta.setTemperaturaMinima(Integer.parseInt(cParametro4.getText()));
			lista.getItems().add(motoslitta);
			break;
		case "Deltaplano":
			Deltaplano deltaplano = new Deltaplano(nome, costo, Integer.parseInt(cParametro5.getText()));
			deltaplano.setCarburante(cParametro1.getText());
			deltaplano.setRumorosità(Double.parseDouble(cParametro2.getText()));
			deltaplano.setQuotaMassima(Double.parseDouble(cParametro3.getText()));
			deltaplano.setNumeroDiPosti(Integer.parseInt(cParametro4.getText()));
			lista.getItems().add(deltaplano);
			break;
		case "Aereo":
			Aereo aereo = new Aereo(nome);
			aereo.setCosto(Double.parseDouble(cCosto.getText()));
			aereo.setCarburante(cParametro1.getText());
			aereo.setRumorosità(Double.parseDouble(cParametro2.getText()));
			aereo.setQuotaMassima(Double.parseDouble(cParametro3.getText()));
			aereo.setReazione(checkReazione.isSelected());
			aereo.setDistanzaMassima(Integer.parseInt(cParametro4.getText()));
			lista.getItems().add(aereo);
			break;
		}
	}
	public void selezionaMezzo() {
		String mezzo = combo.getValue();
		eNome.setText("nome");
		eCosto.setText("costo");
		cCosto.setDisable(true);
		cNome.setDisable(true);
		cParametro1.setDisable(true);
		cParametro2.setDisable(true);
		cParametro3.setDisable(true);
		cParametro4.setDisable(true);
		cParametro5.setDisable(true);
		switch (mezzo) {
		case "Bicicletta"://nome costo muscolicoinvolti nrapporti peso
			eParametro1.setText("muscoli coinvolti");
			eParametro2.setText("numero rapporti");
			eParametro3.setText("peso");
			eParametro4.setText("");
			eParametro5.setText("");
			cCosto.setDisable(false);
			cNome.setDisable(false);
			cParametro1.setDisable(false);
			cParametro2.setDisable(false);
			cParametro3.setVisible(true);
			checkRemo.setVisible(false);
			cParametro3.setDisable(false);
			cParametro4.setVisible(true);
			checkReazione.setVisible(false);
			cParametro4.setDisable(true);
			cParametro5.setDisable(true);
			break;
		case "Barca":	//nome costo muscolicoinvolti nremi singoloremi
			eParametro1.setText("muscoli coinvolti");
			eParametro2.setText("numero remi");
			eParametro3.setText("singolo remo");
			eParametro4.setText("");
			eParametro5.setText("");
			cCosto.setDisable(false);
			cNome.setDisable(false);
			cParametro1.setDisable(false);
			cParametro2.setDisable(false);
			checkRemo.setVisible(true);
			cParametro3.setDisable(false);
			cParametro3.setVisible(false);
			cParametro4.setVisible(true);
			checkReazione.setVisible(false);
			cParametro4.setDisable(true);
			cParametro5.setDisable(true);
			break;
		case "Skateboard"://nome costo muscoli coinvolti lunghezza 
			eParametro1.setText("muscoli coinvolti");
			eParametro2.setText("lunghezza");
			eParametro3.setText("");
			eParametro4.setText("");
			eParametro5.setText("");
			cCosto.setDisable(false);
			cNome.setDisable(false);
			cParametro1.setDisable(false);
			cParametro2.setDisable(false);
			cParametro3.setVisible(true);
			checkRemo.setVisible(false);
			cParametro3.setDisable(true);
			cParametro4.setVisible(true);
			checkReazione.setVisible(false);
			cParametro4.setDisable(true);
			cParametro5.setDisable(true);
			break;
		case "Automobile"://nome costo carburante rumorosita  velocita nporte targa
			eParametro1.setText("carburante");
			eParametro2.setText("rumorosità");
			eParametro3.setText("velocità");
			eParametro4.setText("numero porte");
			eParametro5.setText("targa");
			cCosto.setDisable(false);
			cNome.setDisable(false);
			cParametro1.setDisable(false);
			cParametro2.setDisable(false);
			cParametro3.setVisible(true);
			checkRemo.setVisible(false);
			cParametro3.setDisable(false);
			cParametro4.setVisible(true);
			checkReazione.setVisible(false);
			cParametro4.setDisable(false);
			cParametro5.setDisable(false);
			break;
		case "Motocicletta"://nome costo carburante rumorosita  velocita cilindrata nposti
			eParametro1.setText("carburante");
			eParametro2.setText("rumorosità");
			eParametro3.setText("velocità");
			eParametro4.setText("numero posti");
			eParametro5.setText("cilindrata");
			cCosto.setDisable(false);
			cNome.setDisable(false);
			cParametro1.setDisable(false);
			cParametro2.setDisable(false);
			cParametro3.setVisible(true);
			checkRemo.setVisible(false);
			cParametro3.setDisable(false);
			cParametro4.setVisible(true);
			checkReazione.setVisible(false);
			cParametro4.setDisable(false);
			cParametro5.setDisable(false);
			break;
		case "Motoslitta":	//nome costo muscolicoinvolti nremi singoloremi
			eParametro1.setText("carburante");
			eParametro2.setText("rumorosità");
			eParametro3.setText("velocità");
			eParametro4.setText("temperatura");
			eParametro5.setText("");
			cCosto.setDisable(false);
			cNome.setDisable(false);
			cParametro1.setDisable(false);
			cParametro2.setDisable(false);
			cParametro3.setVisible(true);
			checkRemo.setVisible(false);
			cParametro3.setDisable(false);
			cParametro4.setVisible(true);
			checkReazione.setVisible(false);
			cParametro4.setDisable(false);
			cParametro5.setDisable(true);
			break;
		case "Deltaplano":	//nome costo muscolicoinvolti nremi singoloremi
			eParametro1.setText("carburante");
			eParametro2.setText("rumorosità");
			eParametro3.setText("quota massima");
			eParametro4.setText("numero di posti");
			eParametro5.setText("");
			cCosto.setDisable(false);
			cNome.setDisable(false);
			cParametro1.setDisable(false);
			cParametro2.setDisable(false);
			cParametro3.setVisible(true);
			checkRemo.setVisible(false);
			cParametro3.setDisable(false);
			cParametro4.setVisible(true);
			checkReazione.setVisible(false);
			cParametro4.setDisable(false);
			cParametro5.setDisable(true);
			break;
		case "Aereo":	//nome costo muscolicoinvolti nremi singoloremi
			eParametro1.setText("carburante");
			eParametro2.setText("rumorosità");
			eParametro3.setText("quota massima");
			eParametro4.setText("reazione");
			eParametro5.setText("distanza massima");
			cCosto.setDisable(false);
			cNome.setDisable(false);
			cParametro1.setDisable(false);
			cParametro2.setDisable(false);
			cParametro3.setVisible(true);
			checkRemo.setVisible(false);
			cParametro3.setDisable(false);
			cParametro4.setVisible(false);
			checkReazione.setVisible(true);
			cParametro4.setDisable(false);
			cParametro5.setDisable(false);
			break;
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
