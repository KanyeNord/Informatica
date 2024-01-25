package it.edu.iisgubbio.matematica;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Equazione2 extends Application {

	TextField cA = new TextField();
	TextField cB = new TextField();
	TextField cC = new TextField();
	Label eSoluzione = new Label();
	Button pCalcola = new Button("calcola soluzioni");


	public void start(Stage finestra) throws Exception {

		GridPane griglia = new GridPane();

		Label eA = new Label("x²+");
		Label eB = new Label("x+");
		Label eC = new Label("=0");

		griglia.setGridLinesVisible(false);


		griglia.add(cA, 0, 0);
		griglia.add(eA, 1, 0);
		griglia.add(cB, 2, 0);
		griglia.add(eB, 3, 0);
		griglia.add(cC, 4, 0);
		griglia.add(eC, 5, 0);
		griglia.add(pCalcola, 0, 1, 6, 1);
		griglia.add(eSoluzione, 0, 2, 6, 1);

		pCalcola.setMaxWidth(500);

		eSoluzione.setMaxWidth(500);

		pCalcola.setOnAction(e -> calcola());

		griglia.setPadding( new Insets(10,10,10,10));
		griglia.setHgap(5);
		griglia.setVgap(5);

		Scene scena = new Scene (griglia);
		finestra.setTitle("Equazione di secondo grado");
		finestra.setScene(scena);
		finestra.show();

	}

	public void calcola() {
		Image immagine = new Image(getClass().getResourceAsStream("Gato.png"));
		ImageView visualizzatoreImmagine = new ImageView(immagine);
		visualizzatoreImmagine.setFitHeight(20);
		visualizzatoreImmagine.setPreserveRatio(true);
		pCalcola.setGraphic(visualizzatoreImmagine);

		double a, b, c, delta, deltaR, x1,x2;
		String tipo="";
		if (cA.getText()=="") {
			cA.setText("0");
		}
		if (cB.getText()=="") {
			cB.setText("0");
		}
		if (cC.getText()=="") {
			cC.setText("0");
		}
		a = Double.parseDouble(cA.getText());
		b = Double.parseDouble(cB.getText());
		c = Double.parseDouble(cC.getText());
		delta = (b*b)-4*a*c;
		deltaR = Math.sqrt(delta);

		if (a==0) {
			tipo = "non è possibile"; 
		} else {
			if (a!=0 && b==0 && c==0) {
				tipo="è monomia";
			} else {
				if (a!=0 && b!=0 && c==0) {
					tipo="è spuria";
				} else {
					if (a!=0 && b==0 && c!=0) {
						tipo="è pura";
					} else {
						if (a!=0 && b!=0 && c!=0) {
							tipo="è completa";
						}
					}
				}
			}
		}
		if (delta>0 && tipo!="non è possibile") {
			x1 = (-(b) + deltaR)/(2*a);
			x2 = (-(b) - deltaR)/(2*a);
			eSoluzione.setText("l'equazione " + tipo + " e ammette 2 soluzioni reali distinte: " + x1 + " e " + x2); 
		} else {
			if (delta==0 && tipo!="non è possibile") {
				x1 = (-b)/(2*a);
				eSoluzione.setText("l'equazione " + tipo + " e ammette 2 soluzioni reali coincidenti: "+ tipo + x1 + " e " + x1); 
			} else {
				if (delta<0 && tipo!="non è possibile") {
					eSoluzione.setText("l'equazione " + tipo + " e non ammette soluzioni");
				} else {
					eSoluzione.setText("l'equazione " + tipo);
				}
			}	
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}