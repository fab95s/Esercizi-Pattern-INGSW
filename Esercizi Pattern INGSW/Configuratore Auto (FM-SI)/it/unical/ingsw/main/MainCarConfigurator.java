package it.unical.ingsw.main;

import it.unical.ingsw.factorys.AudiCarFactory;
import it.unical.ingsw.factorys.Component;
import it.unical.ingsw.factorys.SkodaCarFactory;
import it.unical.ingsw.factorys.VolkswagenCarFactory;
import it.unical.ingsw.interfaces.CarConfigurator;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MainCarConfigurator extends Application {
	CarConfigurator factory;
	Button audi = new Button("Audi");
	Button skoda = new Button("Skoda");
	Button volkswagen = new Button("Volkswagen");
	
	Button gearbox = new Button("Cambio Marce");
	Button seat = new Button("Sedile");
	Button bearing = new Button("Cuscinetti");
	BorderPane root = new BorderPane();
	
	@Override
	public void start(Stage stage) throws Exception {
		gearbox.setDisable(true);
		seat.setDisable(true);
		bearing.setDisable(true);
		
		HBox box1 = new HBox();
		HBox box2 = new HBox();
		box1.getChildren().addAll(audi, skoda, volkswagen);
		box2.getChildren().addAll(gearbox, seat, bearing);
		BorderPane.setAlignment(box1, Pos.TOP_CENTER);
		BorderPane.setAlignment(box2, Pos.CENTER);
		root.setTop(box1);
		root.setCenter(box2);
		
		initEH();
		
		Scene scene = new Scene(root, 300, 150);
		stage.setTitle("Car Configurator");
		stage.setScene(scene);
		stage.show();
	}
	
	private void buttonAction() {
//		audi.setDisable(true);
//		skoda.setDisable(true);
//		volkswagen.setDisable(true);
		gearbox.setDisable(false);
		seat.setDisable(false);
		bearing.setDisable(false);
	}
	
	private void initEH() {
		audi.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				factory = AudiCarFactory.getInstance();
				buttonAction();
			}
		});
		
		skoda.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				factory = SkodaCarFactory.getInstance();
				buttonAction();
			}
		});
		
		volkswagen.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				factory = VolkswagenCarFactory.getInstance();
				buttonAction();
			}
		});
		
		gearbox.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Component b = factory.makeGearbox();
				root.setBottom(new Label("Marca: " + b.getName() + "\n\rTipo: " + b.getType() + "\n\rPrezzo: " + b.getPrice() + "�"));
			}
		});
		
		seat.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Component b = factory.makeSeat();
				root.setBottom(new Label("Marca: " + b.getName() + "\n\rTipo: " + b.getType() + "\n\rPrezzo: " + b.getPrice() + "�"));
			}
		});
		
		bearing.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Component b = factory.makeBearing();
				root.setBottom(new Label("Marca: " + b.getName() + "\n\rTipo: " + b.getType() + "\n\rPrezzo: " + b.getPrice() + "�"));
			}
		});
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
