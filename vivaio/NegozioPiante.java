package it.edu.iisgubbio.vivaio;

import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NegozioPiante extends Application{
	ListView<Pianta> articoli = new ListView<>();
	ListView<Pianta> carrello = new ListView<>();
	Label eTotale = new Label("Totale: ");
	Label cTotale = new Label();
	Label eTipi = new Label("Tipi: ");
	Label cTipi = new Label();

	int contaFiori=0;
	int contaBonsai=0;
	public void start(Stage finestra) throws Exception {
		GridPane griglia = new GridPane();

		griglia.add(articoli, 0, 0);
		griglia.add(carrello, 1, 0);
		griglia.add(eTotale, 0, 1);
		griglia.add(cTotale, 1, 1);
		griglia.add(eTipi, 0, 2);
		griglia.add(cTipi, 1, 2);

		Fiore rosa= new Fiore("Rosa", 4, "rosso", "Primavera");
		articoli.getItems().add(rosa);

		Fiore tulipano= new Fiore("Tulipano", 2, "giallo", "Estate");
		articoli.getItems().add(tulipano);

		Bonsai acero= new Bonsai("Acero", 100, 40);
		articoli.getItems().add(acero);

		Bonsai pino= new Bonsai("pino", 500, 20);
		articoli.getItems().add(pino);

		articoli.addEventHandler(MouseEvent.MOUSE_CLICKED, e-> aggiungi(e));
		carrello.addEventHandler(MouseEvent.MOUSE_CLICKED, e-> rimuovi(e));
		griglia.setPadding( new Insets(10,10,10,10));
		griglia.setHgap(5);
		griglia.setVgap(5);
		Scene scena = new Scene (griglia);
		finestra.setTitle("Bonsai & Fiori");
		finestra.setScene(scena);
		finestra.show();
	}
	public void aggiungi(MouseEvent e) {
		Pianta	articoloSelezionato=articoli.getSelectionModel().getSelectedItem();
		carrello.getItems().add(articoloSelezionato);
		if(articoloSelezionato instanceof Fiore) {
			contaFiori++;
	}
		if(articoloSelezionato instanceof Bonsai) {
			contaBonsai++;
	}
		cTipi.setText(contaFiori+"/"+contaBonsai);
		cTotale.setText(totale()+"€");
	}
	public void rimuovi(MouseEvent e) {
		if(e.getClickCount()==2) {
			int indexNome=carrello.getSelectionModel().getSelectedIndex();
			carrello.getItems().remove(indexNome);
			if(carrello.getSelectionModel().getSelectedItem() instanceof Fiore) {
				contaFiori--;
		}
			if(carrello.getSelectionModel().getSelectedItem() instanceof Bonsai) {
				contaBonsai--;
		}
			cTipi.setText(contaFiori+"/"+contaBonsai);
			cTotale.setText(totale()+"€");
		}
	}
	public double totale() {
		double somma=0;
		for (int i=0;i<carrello.getItems().size();i++) {
			somma+=carrello.getItems().get(i).getCosto();
		}
//		for (Pianta x : carrello.getItems()) {
//			somma+=x.getCosto();
//		}
		return somma;
	}
	public static void main(String[] args) {
		launch(args);
	}
}