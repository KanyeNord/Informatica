package it.edu.iisgubbio.laboratorio;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ScarabottaAlessio extends Application{
TextField cN = new TextField();
TextField cM = new TextField();
Label eSomma = new Label();
Label eNPrimi = new Label();
Label eFattoriale = new Label();


public void start(Stage finestra) throws Exception {
	Button pSomma = new Button("somma");
	Button pNPrimi = new Button("numeri primi");
	Button pFattoriale = new Button("fattoriale");
	GridPane griglia = new GridPane();

	griglia.setGridLinesVisible(false);

	griglia.add(cN, 0, 0);
	griglia.add(cM, 2, 0);
	griglia.add(pSomma, 0, 1);
	griglia.add(eSomma, 0, 2);
	griglia.add(pNPrimi, 1, 1);
	griglia.add(eNPrimi, 1, 2);
	griglia.add(pFattoriale, 2, 1);
	griglia.add(eFattoriale, 2, 2);

	pSomma.setOnAction(e -> somma());
	pNPrimi.setOnAction(e -> nPrimi());
	pFattoriale.setOnAction(e -> fattoriale());
	
	pSomma.setMinWidth(150);
	eSomma.setMinWidth(150);
	pNPrimi.setMinWidth(150);
	eNPrimi.setMinWidth(150);
	pFattoriale.setMinWidth(150);
	eFattoriale.setMinWidth(150);
	

	cN.setPromptText("n / il Maggiore");
	cM.setPromptText("m / il Minore");

	Scene scena = new Scene (griglia);
	griglia.setId("griglia");
	griglia.getStylesheets().add("it/edu/iisgubbio/laboratorio/ScarabottaAlessio.css");
	finestra.setTitle("Verifica");
	finestra.setScene(scena);
	finestra.show();

}

public void somma() {
	int n, m, somma=0;
	n = Integer.parseInt(cN.getText());
	m = Integer.parseInt(cM.getText());
	for ( int contatore=m; contatore<=n; contatore++) {
		somma= somma+contatore;
	}
	eSomma.setText(""+somma);
	}

public void nPrimi() {
	int n, m, contaDiv = 0, contaPrimi = 0;
	n = Integer.parseInt(cN.getText());
	m = Integer.parseInt(cM.getText());
	for ( int contatore1=m; contatore1<=n; contatore1++) {

		for(int contatore2=1; contatore2<=contatore1; contatore2++) {
			if (contatore1%contatore2==0) {
				contaDiv = contaDiv +1;
			}
		}
		if (contaDiv==2) {
			contaPrimi= contaPrimi+1;
		}
		contaDiv = 0;
	}
	eNPrimi.setText(contaPrimi+"");
}

public void fattoriale() {
	int n, m, differenza, risultato;
	long fattorialeN = 1, fattorialeD = 1;
	n = Integer.parseInt(cN.getText());
	m = Integer.parseInt(cM.getText());
	differenza = n-m;
	for ( int contatore=2; contatore<=n; contatore++) {
		fattorialeN = fattorialeN*contatore;
	}
	for ( int contatore=2; contatore<=differenza; contatore++) {
		fattorialeD = fattorialeD*contatore;
	}
	risultato = (int) (fattorialeN/fattorialeD);
	eFattoriale.setText(risultato+ "");
}
public static void main(String[] args) {
	launch(args);
}
}