package it.edu.iisgubbio.negozio;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ScontoRadio extends Application {

	TextField cPrezzoPanino = new TextField();
	TextField cNumeroPanini = new TextField();
	Label eTotale = new Label();
	RadioButton rScontoNo = new RadioButton("nessuno");
	RadioButton rSconto10 = new RadioButton("10%");
	RadioButton rSconto20 = new RadioButton("20%");
	public void start(Stage finestra) throws Exception {

		GridPane griglia = new GridPane();
		Label ePrezzoPanino = new Label("prezzo panino");
		Label eNumeroPanini = new Label("numero panini");
		Button pCalcolaTotale = new Button("calcola totale");

		griglia.setGridLinesVisible(false);

		griglia.add(ePrezzoPanino, 0, 0);
		griglia.add(eNumeroPanini, 0, 1);
		griglia.add(cPrezzoPanino, 1, 0);
		griglia.add(cNumeroPanini, 1, 1);
		griglia.add(rScontoNo, 0, 2, 2, 1);
		griglia.add(rSconto10, 0, 3, 2, 1);
		griglia.add(rSconto20, 0, 4, 2, 1);
		griglia.add(pCalcolaTotale, 0, 5, 2, 1);
		griglia.add(eTotale, 0, 6, 2, 1);

		ToggleGroup Sconti = new ToggleGroup();
		rScontoNo.setToggleGroup(Sconti);
		rSconto10.setToggleGroup(Sconti);
		rSconto20.setToggleGroup(Sconti);
		rSconto10.setSelected(true);

		pCalcolaTotale.setMaxWidth(300);
		eTotale.setMaxWidth(300);

		pCalcolaTotale.setOnAction(e -> calcola());

		griglia.setPadding( new Insets(10,10,10,10));
		griglia.setHgap(5);
		griglia.setVgap(5);

		Scene scena = new Scene (griglia);
		finestra.setTitle("ScontoRadio");
		finestra.setScene(scena);
		finestra.show();
	}

	public void calcola() {
		double prezzoPanino, numeroPanini, prezzoScontato, totale;
		prezzoPanino = Double.parseDouble(cPrezzoPanino.getText());
		numeroPanini = Double.parseDouble(cNumeroPanini.getText());

		if(rScontoNo.isSelected()) {
			totale = (prezzoPanino * numeroPanini);
		} else { if(rSconto10.isSelected()) {
			prezzoScontato = prezzoPanino-((prezzoPanino/100)*10);
			totale = (prezzoScontato * numeroPanini);
		}else {
			prezzoScontato = prezzoPanino-((prezzoPanino/100)*20);
		totale = (prezzoScontato * numeroPanini);}
		}
		eTotale.setText("totale= "+ totale + "€");
	}

	public static void main(String[] args) {
		launch(args);
	}
}