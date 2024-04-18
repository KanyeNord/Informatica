package it.edu.iisgubbio.testi;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MinMax extends Application {

	TextField cFrase = new TextField();
	Button pMin = new Button("Min");
	Button pMax = new Button("Max");
	Label eRisultato = new Label();

	public void start(Stage finestra) throws Exception {
		GridPane griglia = new GridPane();

		griglia.add(cFrase, 0, 0, 3, 1);
		griglia.add(pMin, 0, 1);
		griglia.add(eRisultato, 1, 1);
		griglia.add(pMax, 2, 1);

		pMin.setOnAction(e -> minimo());
		pMax.setOnAction(e -> massimo());
		pMin.setPrefWidth(50);
		eRisultato.setPrefWidth(50);
		pMax.setPrefWidth(50);


		griglia.setPadding( new Insets(10,10,10,10));
		griglia.setHgap(5);
		griglia.setVgap(5);

		Scene scena = new Scene (griglia);
		finestra.setTitle("Min Max");
		finestra.setScene(scena);
		finestra.show();
	}


	int[] testoVettore(String testo) {
		String[] parti=testo.split(" ");
		int n[]= new int[parti.length];
		for(int pos = 0;pos<n.length;pos++) {
			n[pos]=Integer.parseInt(parti[pos]);
		}
		return n;
	}
	
	String daVettoreATesto(int[] numeriDaStampare) {
		String stampa="";
		for(int pos = 0;pos<numeriDaStampare.length;pos++) {
			stampa+=numeriDaStampare[pos] + " ";
		}
		return stampa;
	}
	public void minimo() {
		String t=cFrase.getText();
		int numeri[];
		numeri=testoVettore(t);
		
		int segnaPosto=0;
		for(int i=1;i<numeri.length;i++) {
		if (numeri[segnaPosto]>numeri[i]) {
			segnaPosto=i;
		}
		}
		int minimo=numeri[segnaPosto];
		eRisultato.setText(minimo+"");
		}
		

	
	public void massimo() {
		String t=cFrase.getText();
		int numeri[];
		numeri=testoVettore(t);
		int segnaPosto=0;
		for(int i=1;i<numeri.length;i++) {
		if (numeri[segnaPosto]<numeri[i]) {
			segnaPosto=i;
		}
		}
		int massimo=numeri[segnaPosto];
		eRisultato.setText(massimo+"");
		}
	public static void main(String[] args) {
		launch(args);
	}
}