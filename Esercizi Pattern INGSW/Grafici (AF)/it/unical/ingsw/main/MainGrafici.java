package it.unical.ingsw.main;

import it.unical.ingsw.factorys.AreaChartFactory;
import it.unical.ingsw.factorys.BarChartFactory;
import it.unical.ingsw.factorys.ChartFactory;
import it.unical.ingsw.factorys.PieChartFactory;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.Chart;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MainGrafici extends Application {
	ChartFactory chart;
	PieChartFactory pieFactory = new PieChartFactory();
	BarChartFactory barFactory = new BarChartFactory();
	AreaChartFactory areaFactory = new AreaChartFactory();
	Button pieChart = new Button("Pie Chart");
	Button barChart = new Button("Bar Chart");
	Button areaChart = new Button("Area Chart");
	BorderPane root = new BorderPane();
	
	@Override
	public void start(Stage stage) throws Exception {
		HBox box = new HBox();
		box.getChildren().addAll(pieChart, barChart, areaChart);
		BorderPane.setAlignment(box, Pos.TOP_CENTER);
		root.setTop(box);
		
		initEH();
		
		Scene scene = new Scene(root, 600, 400);
		stage.setTitle("Charts");
		stage.setScene(scene);
		stage.show();
	}
	
	private void initEH() {
		pieChart.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				chart = new PieChartFactory();
				Chart pie = chart.makeChart();
				root.setCenter(pie);
			}
		});
		
		barChart.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				chart = new BarChartFactory();
				Chart bar = chart.makeChart();
				root.setCenter(bar);
			}
		});
		
		areaChart.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				chart = new AreaChartFactory();
				Chart area = chart.makeChart();
				root.setCenter(area);
			}
		});
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
