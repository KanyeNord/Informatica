package it.edu.iisgubbio.geometria;


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

public class ControlloErrori extends Application{
	TextField eBinario = new TextField();
	RadioButton tipoVerificaParity = new RadioButton("parity");
	RadioButton tipoVerificaHamming = new RadioButton("hamming");
	RadioButton tipoVerificaSughino = new RadioButton("sughino");
	Label eMessaggioRis = new Label();
	Label eControlloRis = new Label();
	Label eEsitoControlloRis = new Label();
	Button pControllo = new Button();

	public void start(Stage finestra) throws Exception {
		GridPane griglia = new GridPane();
		Label eMessaggio = new Label("Messaggio: ");
		Label eControllo = new Label("Controllo: ");
		Label eEsitoControllo = new Label("Esito controllo: ");

		griglia.add(eBinario, 0, 0, 2, 1);
		griglia.add(tipoVerificaParity, 0, 1, 2, 1);
		griglia.add(tipoVerificaHamming, 0, 2, 2, 1);
		griglia.add(tipoVerificaSughino, 0, 3, 2, 1);
		griglia.add(eMessaggio, 0, 4);
		griglia.add(eControllo, 0, 5);
		griglia.add(eEsitoControllo, 0, 6);
		griglia.add(eMessaggioRis, 1, 4, 2, 1 );
		griglia.add(eControlloRis, 1, 5, 2, 1);
		griglia.add(eEsitoControlloRis, 1, 6, 2, 1);
		griglia.add(pControllo, 0, 7, 2, 1);

		 ToggleGroup controlli = new ToggleGroup();
		 tipoVerificaParity.setToggleGroup(controlli);
		 tipoVerificaHamming.setToggleGroup(controlli);
		 tipoVerificaSughino.setToggleGroup(controlli);
		 tipoVerificaParity.setSelected(true);
		 
		eBinario.setMinWidth(200);
		pControllo.setMinWidth(200);
		if( tipoVerificaParity.isSelected()) {
		pControllo.setOnAction(e -> controlloParity());
		}
		if( tipoVerificaHamming.isSelected()) {
		pControllo.setOnAction(e -> controlloHamming());
		}
		if( tipoVerificaSughino.isSelected()) {
		pControllo.setOnAction(e -> controlloSughino());
		}
		griglia.setPadding( new Insets(10,10,10,10));
		griglia.setHgap(5);
		griglia.setVgap(5);

		Scene scena = new Scene (griglia);
		finestra.setTitle("Conversioni Numeriche");
		finestra.setScene(scena);
		finestra.show();
	}
	public void controlloParity() {
		int contaPari=0;
		String messaggio="";
		char vMessaggio[]=eBinario.getText().toCharArray();
		for(int i=0;i<vMessaggio.length;i++) {
			if(vMessaggio[i]=='1') {
				contaPari++;	
			}
			if(i<vMessaggio.length-1) {
				messaggio+=vMessaggio[i];
			}
		}
		eMessaggioRis.setText(messaggio);
		eControlloRis.setText("parity");
		if(contaPari%2==0) {
			eEsitoControlloRis.setText("Ok");
		} else {
			eEsitoControlloRis.setText("Failed");
		}
	}
	public void controlloHamming() {
	}
		public void controlloSughino() {
	}
	public static void main(String[] args) {
		launch(args);
	}
}