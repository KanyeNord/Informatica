package it.edu.iisgubbio.date;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Bisestile1Riga extends Application {


	TextField cAnno = new TextField();
	Label eBisestile = new Label();


	public void start(Stage finestra) throws Exception {

		GridPane griglia = new GridPane();
		Label eAnno = new Label("anno");
		Button pBisestile = new Button("bisestile?");



		griglia.setGridLinesVisible(false);

		griglia.add(eAnno, 0, 0);
		griglia.add(cAnno, 1, 0);
		griglia.add(pBisestile, 0, 1);
		griglia.add(eBisestile, 1, 1);


		pBisestile.setOnAction(e -> bisestile());

		griglia.setPadding( new Insets(10,10,10,10));
		griglia.setHgap(5);
		griglia.setVgap(5);

		Scene scena = new Scene (griglia);
		finestra.setTitle("TriangoloRettangolo");
		finestra.setScene(scena);
		finestra.show();

	}

	public void bisestile() {
		int anno;
		anno = Integer.parseInt(cAnno.getText());

		if(anno%4==0 && anno%100!=0 || anno%4==0 && anno%100==0 && anno%400==0) {
			eBisestile.setText(anno + " è bisestile");
		} else {
				eBisestile.setText(anno + " non è bisestile");
				}
			}

	public static void main(String[] args) {
		launch(args);
	}
}