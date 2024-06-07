package it.edu.iisgubbio.prove;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PrimaInterfaccia extends Application {

	TextField tCasellaSx = new TextField();
	Button pUnisci = new Button();
	TextField tCasellaDx = new TextField();
	Button pCopiaSx = new Button();
	Label eUnisci = new Label();
	Button pCopiaDx = new Button();
	Label eCopiaSx = new Label();
	Button pPulisci = new Button();
	Label eCopiaDx = new Label();
	GridPane griglia = new GridPane();
	public void start(Stage finestra) {

		griglia.add(tCasellaSx, 0, 0);
		griglia.add(pUnisci, 1, 0);
		griglia.add(tCasellaDx, 2, 0);
		griglia.add(pCopiaSx, 0, 1);
		griglia.add(eUnisci, 1, 1);
		griglia.add(pCopiaDx, 2, 1);
		griglia.add(eCopiaSx, 0, 2);
		griglia.add(pPulisci, 1, 2);
		griglia.add(eCopiaDx, 2, 2);
		
		griglia.setPadding( new Insets(10,10,10,10));
		griglia.setHgap(20);
		griglia.setVgap(20);
		pCopiaSx.setMaxWidth(200);
		pCopiaDx.setMaxWidth(200);
		pUnisci.setMaxWidth(200);
		pPulisci.setMaxWidth(200);
		
		

		pUnisci.setText("Unisci");
		pCopiaSx.setText("Copia");
		pCopiaDx.setText("Copia");
		pPulisci.setText("Pulisci");

		pUnisci.setOnAction(e -> unisci());
		pCopiaSx.setOnAction(e -> copiaSx());
		pCopiaDx.setOnAction(e -> copiaDx());
		pPulisci.setOnAction(e -> pulisci());

		Scene scena = new Scene (griglia);
		finestra.setTitle("Prima interfaccia");
		finestra.setScene(scena);
		finestra.show();
	}
	public void unisci() {
		String messaggioSx;
		String messaggioDx;
		messaggioSx = tCasellaSx.getText();
		messaggioDx = tCasellaDx.getText();
		eUnisci.setText(messaggioSx + messaggioDx);
	}

	public void copiaSx() {
		String messaggio;
		messaggio = tCasellaSx.getText();
		eCopiaSx.setText(messaggio);
	}
	public void copiaDx() {
		String messaggio;
		messaggio = tCasellaDx.getText();
		eCopiaDx.setText(messaggio);
	}
	public void pulisci() {
		eCopiaSx.setText(null);
		eCopiaDx.setText(null);
		tCasellaSx.setText(null);
		tCasellaDx.setText(null);
		eUnisci.setText(null);
	}




	public static void main(String[] args) {
		launch(args);
	}
}