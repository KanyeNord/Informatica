package it.edu.iisgubbio.animazioni;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RacchetteDefinitivo extends Application{
	Pane pannello = new Pane();
	Circle pallino = new Circle(9);
	Label puntiG1 = new Label("PUNTI 0");
	Label puntiG2 = new Label("PUNTI 0");
	Label spazio = new Label("premi SPAZIO");
	GridPane griglia = new GridPane();
	Rectangle rettangoloS = new Rectangle(15,100);
	Rectangle rettangoloD = new Rectangle(15,100);
	int x=200;
	int y=150;
	int p2=0;
	int p1=0;
	Timeline timeline = new Timeline(new KeyFrame(
			Duration.millis(9),
			x -> aggiornaTimer()));

	boolean destra = true;
	boolean sopra = true;

	final int LARGHEZZA_SCHERMO = 400;
	final int ALTEZZA_SCHERMO = 300;

	public void start(Stage finestra) throws Exception {
		Label Titolo = new Label("     PONG!");
		Label giocatore1 = new Label("Giocatore 1");
		Label giocatore2 = new Label("Giocatore 2");
		Titolo.setAlignment(Pos.CENTER);

		griglia.add(Titolo, 2, 0);
		griglia.add(giocatore1, 0, 1);
		griglia.add(giocatore2, 4, 1);
		griglia.add(puntiG1, 0, 2);
		griglia.add(puntiG2, 4, 2);
		griglia.add(pannello, 0, 5, 5,5);
		griglia.add(spazio, 2, 11);
		griglia.setHgap(10); 
		griglia.setVgap(10);
		griglia.setPadding(new Insets(10, 10, 10, 10));

		spazio.setVisible(true);
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.stop();
		pallino.setCenterX(200);
		pallino.setCenterY(150);
		pannello.setPrefSize(LARGHEZZA_SCHERMO, ALTEZZA_SCHERMO);
		pallino.setFill(Color.rgb(0, 128, 255));
		pannello.getChildren().add(pallino);

		pannello.getChildren().add(rettangoloS);
		rettangoloS.setX(10);
		rettangoloS.setY(100);
		rettangoloS.setFill(Color.rgb(0, 128, 255));

		pannello.getChildren().add(rettangoloD);
		rettangoloD.setX(400); 
		rettangoloD.setY(100);
		rettangoloD.setFill(Color.rgb(0, 128, 255));

		griglia.setId("griglia");
		pannello.setId("pannello");

		Scene scena = new Scene (griglia);
		finestra.setTitle("PONG!");
		scena.getStylesheets().add("it/edu/iisgubbio/animazioni/RacchetteDefinitivo.css");
		finestra.setScene(scena);
		scena.setOnKeyPressed(e -> pigiato(e));
		finestra.show();
	}
	private void pigiato(KeyEvent evento) {
		if(evento.getCode()==KeyCode.SPACE) {
			timeline.play();
			spazio.setVisible(false);
		}
		if(evento.getText().equals("w")) {
			if (rettangoloS.getY()>0) {
				rettangoloS.setY( rettangoloS.getY() -5 );
			}
		}
		if(evento.getText().equals("W")) {
			if (rettangoloS.getY()>0) {
				rettangoloS.setY( rettangoloS.getY() -5 );
			}
		}
		if(evento.getText().equals("s")) {
			if (rettangoloS.getY()<200) {
				rettangoloS.setY( rettangoloS.getY() +5 );
			}
		}
		if(evento.getText().equals("S")) {
			if (rettangoloS.getY()<200) {
				rettangoloS.setY( rettangoloS.getY() +5 );
			}
		}
		if(evento.getCode() == KeyCode.UP ) {
			if (rettangoloD.getY()>0) {
				rettangoloD.setY( rettangoloD.getY() -5 );
			}
		}
		if(evento.getCode() == KeyCode.DOWN ) {
			if (rettangoloD.getY()<200) {
				rettangoloD.setY( rettangoloD.getY() +5 );
			}
		}
	}

	private void aggiornaTimer() {
		//conteggio punti
		if (x<=10) {
			destra=true;
			pallino.setCenterX(x=200);
			pallino.setCenterY(y=150);
			timeline.stop();
			p2+=1;
			puntiG2.setText("PUNTI "+p2);
			spazio.setVisible(true);
			int range = 255 - 100;
			int r=(int)(Math.random() * range);
			int g=(int)(Math.random() * range);
			int b=(int)(Math.random() * range);
			pallino.setFill(Color.rgb(r,g,b ));
		} 
		if (x>=LARGHEZZA_SCHERMO+15) {
			destra=false;
			pallino.setCenterX(x=200);
			pallino.setCenterY(y=150);
			timeline.stop();
			p1+=1;
			puntiG1.setText("PUNTI "+p1);
			spazio.setVisible(true);
			int range = 255 - 100;
			int r=(int)(Math.random() * range);
			int g=(int)(Math.random() * range);
			int b=(int)(Math.random() * range);
			pallino.setFill(Color.rgb(r,g,b ));
		}
		//movimento
		if (y==10) {
			sopra=true;
		} 
		if (y==ALTEZZA_SCHERMO-10) {
			sopra=false;
		}
		if (destra) {
			pallino.setCenterX(x++);
		}
		else {
			pallino.setCenterX(x--);
		}

		if (sopra) {
			pallino.setCenterY(y++);
		} else {
			pallino.setCenterY(y--);
		}
		//collisioni
		Bounds b1 = rettangoloD.getBoundsInParent();
		Bounds b2 = rettangoloS.getBoundsInParent();
		Bounds b3 = pallino.getBoundsInParent();
		if(b1.intersects(b3)) {
			destra=false;
		}
		if(b2.intersects(b3)) {
			destra=true;
		}
	}

	public static void main(String args[]){
		launch();
	}
}