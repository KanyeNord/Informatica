package it.edu.iisgubbio.animazioni;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RacchetteOriginali extends Application{
	final int LUNGHEZZA_AREA_GIOCO = 300;
	final int LARGHEZZA_AREA_GIOCO = 500;
	final int LUNGHEZZA_RETTANGOLO = 100;
	final int LARGHEZZA_RETTANGOLO = 15;
	final int RAGGIO_PALLINA = 10;
	
	Circle pallino = new Circle(RAGGIO_PALLINA);
	Rectangle rettangoloS = new Rectangle(LARGHEZZA_RETTANGOLO, LUNGHEZZA_RETTANGOLO);
	Rectangle rettangoloD = new Rectangle(LARGHEZZA_RETTANGOLO, LUNGHEZZA_RETTANGOLO);
	int x=20;
	int y=20;
	
	Timeline timeline = new Timeline(new KeyFrame(
			Duration.millis(10),
			x -> aggiornaTimer()));
	
	boolean destra = true;
	boolean sopra = true;
	public void start(Stage finestra) throws Exception {

		Pane pannello = new Pane();
		pannello.setPrefSize(LARGHEZZA_AREA_GIOCO, LUNGHEZZA_AREA_GIOCO);
		Scene scena = new Scene (pannello);
		scena.setOnKeyPressed(e -> pigiato(e));
		
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();

		pallino.setFill(Color.ORANGE);
		pannello.getChildren().add(pallino);
		pallino.setCenterX(0);
		pallino.setCenterY(LUNGHEZZA_AREA_GIOCO/2);

		pannello.getChildren().add(rettangoloS);
		rettangoloS.setX(100);
		rettangoloS.setY(LUNGHEZZA_AREA_GIOCO/2);
		rettangoloS.setFill(Color.BLUE);
		
		pannello.getChildren().add(rettangoloD);
		rettangoloD.setX(LARGHEZZA_AREA_GIOCO - 100 - LARGHEZZA_RETTANGOLO);
		rettangoloD.setY(LUNGHEZZA_AREA_GIOCO/2);
		rettangoloD.setFill(Color.BLUE);
		

		finestra.setTitle("Racchette");
		finestra.setScene(scena);
		finestra.show();
	}
	private void pigiato(KeyEvent evento) {
		if(evento.getText().equals("w")) {
			if (rettangoloS.getY()>0) {
				rettangoloS.setY( rettangoloS.getY() -2 );
			}
		}
		if(evento.getText().equals("s")) {
			if (rettangoloS.getY()<200) {
				rettangoloS.setY( rettangoloS.getY() +2 );
			}
		}
		if(evento.getCode() == KeyCode.UP ) {
			if (rettangoloD.getY()>0) {
				rettangoloD.setY( rettangoloD.getY() -2 );
			}
		}
		if(evento.getCode() == KeyCode.DOWN ) {
			if (rettangoloD.getY()<200) {
				rettangoloD.setY( rettangoloD.getY() +2 );
			}
		}


	}
	private void aggiornaTimer(){
		if (x==10) {
			destra=true;
		} 
		if (x==LARGHEZZA_AREA_GIOCO-10) {
			destra=false;
		}

		if (y==10) {
			sopra=true;
		} 
		if (y==LUNGHEZZA_AREA_GIOCO-10) {
			sopra=false;
		}

		if (destra) {
			pallino.setCenterX(x++);
		} else {
			pallino.setCenterX(x--);
		}

		if (sopra) {
			pallino.setCenterY(y++);
		} else {
			pallino.setCenterY(y--);
		}
		if (x==rettangoloS.getX()+LARGHEZZA_RETTANGOLO+(RAGGIO_PALLINA/2)) {
			if (rettangoloS.getY()<y && y<rettangoloS.getY()+LUNGHEZZA_RETTANGOLO) {
				destra=true;
			}
		} 
		if (x==rettangoloD.getX()-(RAGGIO_PALLINA/2)) {
			if (rettangoloD.getY()<y && y<rettangoloD.getY()+LUNGHEZZA_RETTANGOLO) {
					destra=false;
				}
		}
		if (x==LARGHEZZA_AREA_GIOCO-10) {
			destra=false;
		}
		if (y==10) {
			sopra=true;
		} 
		if (y==LUNGHEZZA_AREA_GIOCO-10) {
			sopra=false;
		}
	}

	public static void main(String args[]){
		launch();
	}
}