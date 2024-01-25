package it.edu.iisgubbio.negozio;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NewLook extends Application {

	TextField cKm = new TextField();
	RadioButton rNuoto = new RadioButton("Nuoto");
	RadioButton rCorsa = new RadioButton("Corsa");
	RadioButton rBici = new RadioButton("Bici");
	CheckBox kBracciali = new CheckBox("Bracciali");
	CheckBox kCavigliere = new CheckBox("Cavigliere");
	Label eCalorie = new Label();
	public void start(Stage finestra) throws Exception {

		GridPane griglia = new GridPane();
		Label eKm = new Label("Km percorsi");
		Label eModalità = new Label("Modalità");
		Label eEquipaggiamento = new Label("Equipaggiamento");
		Button bCalcola = new Button ("Calcola Calorie");
		griglia.setGridLinesVisible(false);

		griglia.add(eKm, 0, 0);
		griglia.add(cKm, 1, 0);
		griglia.add(eModalità, 0, 1);
		griglia.add(eEquipaggiamento, 1, 1);
		griglia.add(rNuoto, 0, 2);
		griglia.add(rCorsa, 0, 3);
		griglia.add(rBici, 0, 4);
		griglia.add(kBracciali, 1, 2);
		griglia.add(kCavigliere, 1, 3);
		griglia.add(bCalcola, 0, 5, 2, 1);
		griglia.add(eCalorie, 0, 6, 2, 1);

		bCalcola.setOnAction(e -> calorie());

		
		Image iNuoto = new Image(getClass().getResourceAsStream("nuoto.png"));
		ImageView visualizzatoreImmagineNuoto = new ImageView(iNuoto);
		visualizzatoreImmagineNuoto.setFitHeight(20);
		visualizzatoreImmagineNuoto.setPreserveRatio(true);
		rNuoto.setGraphic(visualizzatoreImmagineNuoto);
		
		Image iCorsa = new Image(getClass().getResourceAsStream("corsa.png"));
		ImageView visualizzatoreImmagineCorsa = new ImageView(iCorsa);
		visualizzatoreImmagineCorsa.setFitHeight(20);
		visualizzatoreImmagineCorsa.setPreserveRatio(true);
		rCorsa.setGraphic(visualizzatoreImmagineCorsa);
		
		Image iBici = new Image(getClass().getResourceAsStream("bici.png"));
		ImageView visualizzatoreImmagineBici = new ImageView(iBici);
		visualizzatoreImmagineBici.setFitHeight(20);
		visualizzatoreImmagineBici.setPreserveRatio(true);
		rBici.setGraphic(visualizzatoreImmagineBici);
		
		ToggleGroup Modalità = new ToggleGroup();
		rNuoto.setToggleGroup(Modalità);
		rCorsa.setToggleGroup(Modalità);
		rBici.setToggleGroup(Modalità);
		rCorsa.setSelected(true);
		
		griglia.setId("griglia");

		
		Scene scena = new Scene (griglia);
		scena.getStylesheets().add("it/edu/iisgubbio/negozio/NewLook.css");
		finestra.setTitle("NewLook");
		finestra.setScene(scena);
		finestra.show();

	}

	public void calorie() {
		double totale = 0, km;
		km = Double.parseDouble(cKm.getText());

		if(rNuoto.isSelected()) {
			totale= totale+km*21;
		}
		if(rCorsa.isSelected()) {
			totale= totale+km*12;
		}
		if(rBici.isSelected()) {
			totale= totale+km*7;
		}
		if(kBracciali.isSelected()) {
			totale= totale*1.18;
		}
		if(kCavigliere.isSelected()) {
			totale= totale*1.35;
		}
		eCalorie.setText(totale+"");
	}

	public static void main(String[] args) {
		launch(args);
	}
}