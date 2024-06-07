package it.edu.iisgubbio.albano;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * La mia prima classe
 */
public class SalutaUtente extends Application {

	Label messaggio = new Label();
	TextField nome = new TextField(); 

	Label mettiNome = new Label();
	Button eseguiSaluto = new Button();
	
  public void start(Stage finestra) {
	  GridPane griglia = new GridPane();
	  mettiNome.setText("Nome:");
	  messaggio.setText("Sono impaziente...");
	  eseguiSaluto.setText("Premi qui");
	  nome.setPromptText("Nome o nomignolo per salutarti");
	  
	  griglia.add(mettiNome, 0, 0);
	  griglia.add(nome, 1, 0);
	  griglia.add(eseguiSaluto, 1, 1);
	  griglia.add(messaggio, 1, 2);
	  
	  Scene scena = new Scene (griglia,400,400);
	  
	  eseguiSaluto.setOnAction(e -> esegui());
	  
    finestra.setTitle("Saluta utente");
    finestra.setScene(scena);
    finestra.show();
  }
  public void esegui() {
	   String utente;
	   utente = nome.getText();
	   messaggio.setText("Signor " + utente + " Le auguro buona giornata!");
	}


  public static void main(String[] args) {
    launch(args);
  }
}