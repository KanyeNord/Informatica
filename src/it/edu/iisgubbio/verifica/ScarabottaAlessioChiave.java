package it.edu.iisgubbio.verifica;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ScarabottaAlessioChiave extends Application {
	TextField cPassword = new TextField();
	Button bVerifica = new Button("Verifica");
	Label eRisultato = new Label();

	@Override
	public void start(Stage finestra) {
		GridPane griglia = new GridPane();
		Label ePassword = new Label("password:");
		griglia.add(ePassword, 0, 0);
		griglia.add(cPassword, 1, 0);
		griglia.add(bVerifica, 2, 0);
		griglia.add(eRisultato, 0, 1, 3, 1);


		bVerifica.setMaxWidth(300);
		bVerifica.setOnAction(e -> verifica());

		griglia.setPadding( new Insets(10,10,10,10));
		griglia.setHgap(5);
		griglia.setVgap(5);

		Scene scena = new Scene (griglia);
		finestra.setTitle("Chiave");
		finestra.setScene(scena);
		finestra.show();
	}
	
	public void verifica() {
		String stringa=cPassword.getText();
		boolean maiuscola=false;
		boolean minuscola=false;
		boolean carattereSpeciale=false;
		boolean lunghezza=false;
		char password[];
		password= stringa.toCharArray();
		
		if(password.length>8) {
			lunghezza=true;
		}
		for(int pos = 0 ;pos<password.length;pos++) {
			if (password[pos]>='A' && password[pos]<='Z') {
				maiuscola=true;
			}
			if (password[pos]>='a' && password[pos]<='z') {
				minuscola=true;
			}
			if ((password[pos]<'a' || password[pos]>'z') && (password[pos]<'A' || password[pos]>'Z'	)) {
				if(password[pos]<'0' || password[pos]>'9')
					carattereSpeciale=true;	
			}
		}
	if (maiuscola && minuscola && carattereSpeciale && lunghezza) {
		eRisultato.setText("La password è valida");	
	} else {
		eRisultato.setText("La password non è valida");
	}
}
public static void main(String[] args) {
	launch(args);
}
}