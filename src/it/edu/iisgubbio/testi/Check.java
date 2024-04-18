package it.edu.iisgubbio.testi;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Check extends Application {

	TextField cfrase = new TextField();
	Button pCheck = new Button("controlla:");
	Label eRisultato = new Label();

	public void start(Stage finestra) throws Exception {
		GridPane griglia = new GridPane();
		Label eFrase = new Label("frase");

		griglia.add(eFrase, 0, 0);
		griglia.add(cfrase, 0, 1);
		griglia.add(pCheck, 0, 2);
		griglia.add(eRisultato, 0, 3);

		pCheck.setOnAction(e -> correttore());
		pCheck.setMaxWidth(300);

		griglia.setPadding( new Insets(10,10,10,10));
		griglia.setHgap(5);
		griglia.setVgap(5);

		Scene scena = new Scene (griglia);
		finestra.setTitle("Lettere");
		finestra.setScene(scena);
		finestra.show();
	}

	public void correttore() {
		String frase=(cfrase.getText()).toLowerCase();
		char x[]=frase.toCharArray();
		if (x[0]>='A' && x[0]<='Z') {
		} else {
			x[0]=(char)(x[0]-32);
		}

		for(int i = 0, punto;i<x.length;i++) {
			punto=frase.indexOf('.', i);
			if (x[punto+2]>='A' && x[punto+2]<='Z') {
			} else {
				x[punto+2]=(char)(x[punto+2]-32);
			}
		}
		String testo= new String(x);
		eRisultato.setText(testo);
	}
	public static void main(String[] args) {
		launch(args);
	}
}