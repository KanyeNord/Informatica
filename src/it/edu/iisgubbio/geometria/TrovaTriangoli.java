package it.edu.iisgubbio.geometria;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TrovaTriangoli extends Application {

	TextField cLato1 = new TextField();
	TextField cLato2 = new TextField();
	TextField cLato3 = new TextField();
	Label eTipoTriangolo = new Label("?");


	public void start(Stage finestra) throws Exception {
	
		GridPane griglia = new GridPane();
		Button pTrovaTipo = new Button("trova tipo");
		
		griglia.setGridLinesVisible(false);
		
		
		griglia.add(cLato1, 0, 0);
		griglia.add(cLato2, 1, 0);
		griglia.add(cLato3, 2, 0);
		griglia.add(pTrovaTipo, 0, 1, 3, 1);
		griglia.add(eTipoTriangolo, 0, 2, 3, 1);
		
		pTrovaTipo.setMaxWidth(300);
		
		eTipoTriangolo.setMaxWidth(300);

	    pTrovaTipo.setOnAction(e -> trova());
	    
		griglia.setPadding( new Insets(10,10,10,10));
		griglia.setHgap(5);
		griglia.setVgap(5);
		
		Scene scena = new Scene (griglia);
		finestra.setTitle("TriangoloRettangolo");
		finestra.setScene(scena);
		finestra.show();
		
	}

	public void trova() {
		double lato1, lato2, lato3;
		String risposta="";
		lato1 = Double.parseDouble(cLato1.getText());
		lato2 = Double.parseDouble(cLato2.getText());
		lato3 = Double.parseDouble(cLato3.getText());
		if((lato1+lato2)>lato3 && (lato2+lato3)>lato1 && (lato1+lato3)>lato2) {
			if (((lato1*lato1)+(lato2*lato2))==(lato3*lato3)) {
				risposta="rettangolo ";
			}
			if(lato1==lato2 && lato2==lato3) {
				eTipoTriangolo.setText("il triangolo è equilatero");
			} else {
				if(lato1!=lato2 && lato2!=lato3) {
					eTipoTriangolo.setText("il triangolo è " + risposta + "scaleno");
				} else {
					eTipoTriangolo.setText("il triangolo è " + risposta + " isoscele");
				}
			}
		} else {
			eTipoTriangolo.setText("il triangolo non è un triangolo");
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}

