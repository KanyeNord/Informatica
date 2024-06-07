package it.edu.iisgubbio.verifica;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ScarabottaAlessioLettere extends Application {
	TextField cStringa1 = new TextField();
	TextField cStringa2 = new TextField();
	Button bComuni = new Button("in comune");
	Label eRisultato = new Label();

	@Override
	public void start(Stage finestra) {
		GridPane griglia = new GridPane();
		griglia.add(cStringa1, 0, 0);
		griglia.add(cStringa2, 0, 1);
		griglia.add(bComuni, 1, 0, 1, 2);
		griglia.add(eRisultato, 0, 2, 2, 1);


		bComuni.setMaxWidth(300);
		bComuni.setMaxHeight(300);
		bComuni.setOnAction(e -> comuni());

		griglia.setPadding( new Insets(10,10,10,10));
		griglia.setHgap(5);
		griglia.setVgap(5);

		Scene scena = new Scene (griglia);
		finestra.setTitle("Lettere");
		finestra.setScene(scena);
		finestra.show();
	}

	public void comuni() {
		String stringa1=cStringa1.getText();
		String stringa2=cStringa2.getText();
		char Parola1[];
		char Parola2[];
		String risultato="";
		Parola1= stringa1.toCharArray();
		Parola2= stringa2.toCharArray();

		for(int pos = 0 ;pos<Parola1.length;pos++) {
			risultato+=Parola1[pos];
			for(int i = 1 ;i<Parola2.length;i++) {
				if(Parola1[pos]==Parola2[i]) {
					risultato+=Parola1[pos];
				}
			}
		}
			for(int pos = 0 ;pos<Parola2.length;pos++) {
			if(risultato.charAt(pos)==Parola2[pos]) {
				
			} else {
				risultato+=Parola2[pos];
			}
			
			
		}
	
		eRisultato.setText(risultato);
	}
	public static void main(String[] args) {
		launch(args);
	}
}