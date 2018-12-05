package it.unical.ingsw.factorys;

import javafx.collections.FXCollections;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.Chart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class BarChartFactory extends ChartFactory {
	
	@SuppressWarnings("unchecked")
	@Override
	public Chart makeChart() {
		CategoryAxis xAxis = new CategoryAxis();
		xAxis.setCategories(FXCollections.observableArrayList(
			new String("Type 1"),
			new String("Type 2"),
			new String("Type 3"),
			new String("Type 4"),
			new String("Type 5")
		));
		xAxis.setLabel("Types");
		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("Score");
		
		BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
		barChart.setTitle("Bar Chart");
		
		XYChart.Series<String, Number> ciccio = new XYChart.Series<>();
		ciccio.setName("Ciccio Pasticcio");
		ciccio.getData().add(new XYChart.Data<>("Type 1", 1.0));
		ciccio.getData().add(new XYChart.Data<>("Type 2", 3.0));
		ciccio.getData().add(new XYChart.Data<>("Type 3", 2.0));
		ciccio.getData().add(new XYChart.Data<>("Type 4", 5.0));
		ciccio.getData().add(new XYChart.Data<>("Type 5", 7.8));
		
		XYChart.Series<String, Number> renata = new XYChart.Series<>();
		renata.setName("Renata Limbranata");
		renata.getData().add(new XYChart.Data<>("Type 1", 1.3));
		renata.getData().add(new XYChart.Data<>("Type 2", 3.6));
		renata.getData().add(new XYChart.Data<>("Type 3", 2.9));
		renata.getData().add(new XYChart.Data<>("Type 4", 9.4));
		renata.getData().add(new XYChart.Data<>("Type 5", 6.9));
		
		XYChart.Series<String, Number> silvestro = new XYChart.Series<>();
		silvestro.setName("Silvestro Sottocanestro");
		silvestro.getData().add(new XYChart.Data<>("Type 1", 0.4));
		silvestro.getData().add(new XYChart.Data<>("Type 2", 1.7));
		silvestro.getData().add(new XYChart.Data<>("Type 3", 3.8));
		silvestro.getData().add(new XYChart.Data<>("Type 4", 2.5));
		silvestro.getData().add(new XYChart.Data<>("Type 5", 4.9));
		
		barChart.getData().addAll(ciccio, renata, silvestro);
		return barChart;
	}
	
}
