package it.edu.iisgubbio.testi;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Spazi extends Application{
	TextField tTesto = new TextField();
	TextField tSpazi = new TextField();
	public void start(Stage finestra) {
		GridPane griglia = new GridPane();

		Label lTesto = new Label("testo");
		Label lSpazi = new Label("spazi");
		Button bTrasforma= new Button("trasforma");

		griglia.add(lTesto, 0, 0);
		griglia.add(tTesto, 1, 0);
		griglia.add(lSpazi, 0, 1);
		griglia.add(tSpazi, 1, 1);
		griglia.add(bTrasforma, 2, 0, 2, 2);

		griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setHgap(22); 
		griglia.setVgap(10);

		bTrasforma.setMaxWidth(100);
		bTrasforma.setMaxHeight(100);
		tSpazi.setPrefWidth(300);
		bTrasforma.setOnAction(e -> trasforma());

		Font courierFont = new Font("Courier New", 12);
		tTesto.setFont(courierFont);
		tSpazi.setFont(courierFont);

		Scene scene = new Scene(griglia);
		finestra.setTitle("Spazi"); 
		finestra.setScene(scene);
		finestra.show();



	}
	String daVettoreATesto(char[] numeriDaStampare) {
		String stampa="";
		for(int pos = 0;pos<numeriDaStampare.length;pos++) {
			stampa+=numeriDaStampare[pos] + "";
		}
		return stampa;
	}
	public void trasforma(){
		char testo[]=tTesto.getText().toCharArray();
		char testoSpaziato[]=new char[20];
		int vuoto=20-testo.length;
		int contaSpazi = 0;
		int spaziPerPezzo;

		for(int pos = 0;pos<testo.length;pos++) {
			if (testo[pos]==' ') {
				contaSpazi++;		
			}
		}
		if (vuoto%contaSpazi==0) {
			spaziPerPezzo=vuoto/contaSpazi;
		} else {
			spaziPerPezzo=(vuoto/contaSpazi)+vuoto%contaSpazi;
		}
		
		for (int posSpazi=0, posTesto=0; posSpazi<20;posSpazi++, posTesto++) {
			testoSpaziato[posSpazi]=testo[posTesto];
			if (testo[posTesto]==' ') {
				for (int spaziAggiunti=0;spaziAggiunti<spaziPerPezzo; spaziAggiunti++, posSpazi++) {
					testoSpaziato[posSpazi]='-';
				}
			}
		}
		tSpazi.setText(daVettoreATesto(testoSpaziato));
	}
	public static void main(String args[]){
		launch();
	}
}