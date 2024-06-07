package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Piscina extends Application {
	   TextField tNumero = new TextField();
	   TextField tTempo = new TextField();
	   TextField tCoach = new TextField();
	   
	   Button pCrea = new Button("Crea Lista");
	   Button pTempi = new Button("Aggiungi tempi");
	   Button pPessimi = new Button("Trova pessimi");
	   Button pElenco = new Button("Elenca");
	   
	   Label ePessimi = new Label();
	   Label eElenco = new Label();
	   int tempi[];
	   int pos;

	   @Override
	   public void start(Stage finestra) {
		   Label eNumero = new Label("Numero");
		   Label eTempo = new Label("Tempo:");
		   Label eCoach = new Label("Coach");
		   
			GridPane griglia = new GridPane();
			
			
			griglia.add(eNumero,  0, 0);
			griglia.add(tNumero,  1, 0, 2, 1);
			griglia.add(eTempo,   0, 1);
			griglia.add(tTempo,   1, 1, 2, 1);
			griglia.add(eCoach,   0, 2);
			griglia.add(tCoach,   1, 2, 2, 1);
			griglia.add(pCrea,    0, 3);
			griglia.add(pTempi,   1, 3);
			griglia.add(pPessimi, 2, 3);
			griglia.add(ePessimi, 0, 4, 3 ,1);
			griglia.add(pElenco,  0, 5, 3, 1);
			griglia.add(eElenco,  0, 6, 3, 1);
			
			pElenco.setMaxWidth(300);
			eElenco.setMaxWidth(300);
			ePessimi.setMaxWidth(300);
			pCrea.setOnAction(e -> alloca());	
			pTempi.setOnAction(e -> inserisciTempo());
			pPessimi.setOnAction(e -> contaPessimi());
			pElenco.setOnAction(e -> elenca());

			
			Scene scena = new Scene (griglia);
			finestra.setTitle("Divisori");
			finestra.setScene(scena);
			finestra.show();
	   }

	   public void alloca() {
	      tempi = new int[Integer.parseInt(tNumero.getText())];
	      pos = 0;
	   }

	   public void inserisciTempo() {
	      if(pos < tempi.length) {
	         tempi[pos++]=Integer.parseInt(tTempo.getText());
	         tTempo.setText("");
	      }
	   }

	   public void contaPessimi() {
	      int indice, pessimi = 0;
	      int coach = Integer.parseInt(tCoach.getText());
	      for(indice = 0; indice < tempi.length; indice++) {
	         if(tempi[indice] > coach) {
	        	 pessimi=tempi[indice];
	         }
	      }
	      ePessimi.setText("" + pessimi);
	   }
		public void elenca() {
			String lista="";
			for(pos=0;pos<tempi.length;pos++) {
				if (lista.equals("")) {
					lista += "" + tempi[pos];
				} else {
					lista += "," + tempi[pos];
				}	
			}
			eElenco.setText(""+lista);
		}

public static void main(String[] args) {
	launch(args);
}
	}