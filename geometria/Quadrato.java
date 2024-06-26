package it.edu.iisgubbio.geometria;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Quadrato extends Application {

	Label eLato = new Label("lato");
	TextField cLato = new TextField(); 
	Button pArea = new Button("area");
	Label eArea = new Label();
	GridPane griglia = new GridPane();
	Button pPerimetro = new Button("perimetro");
	Label ePerimetro = new Label(); 
	public void start(Stage finestra) throws Exception {	
		griglia.add(eLato, 0, 0);
		griglia.add(cLato, 1, 0);
		griglia.add(pArea, 0, 1);
		griglia.add(eArea, 1, 1);
		griglia.add(pPerimetro, 0, 2);
		griglia.add(ePerimetro, 1, 2);
		
		cLato.setPromptText("Inserire lato");
	    pArea.setOnAction(e -> area());
	    pPerimetro.setOnAction(e -> perimetro());
	    
		griglia.setPadding( new Insets(10,10,10,10));
		griglia.setHgap(5);
		griglia.setVgap(5);
		
		Scene scena = new Scene (griglia);
		finestra.setTitle("Quadrato");
		finestra.setScene(scena);
		finestra.show();
	}
	  public void area() {
		  String latoStringa;
		  int lato;
		  int area;
		  latoStringa = cLato.getText();
		  lato = Integer.parseInt(latoStringa);
		  area = lato* lato;
		  eArea.setText(""+area);
	  }
	  public void perimetro() {
		  String latoStringa;
		  int lato;
		  int perimetro;
		  latoStringa = cLato.getText();
		  lato = Integer.parseInt(latoStringa);
		  perimetro = lato * 4;
		  ePerimetro.setText(""+perimetro);
	  }
	public static void main(String[] args) {
		launch(args);
	}
}