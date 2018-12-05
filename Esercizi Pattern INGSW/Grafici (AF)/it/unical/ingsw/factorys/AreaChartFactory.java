package it.unical.ingsw.factorys;

import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.Chart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class AreaChartFactory extends ChartFactory {
	
	@SuppressWarnings("unchecked")
	@Override
	public Chart makeChart() {
		CategoryAxis xAxis = new CategoryAxis();
		xAxis.setLabel("Types");
		NumberAxis yAxis = new NumberAxis(0, 15, 2.5);
		yAxis.setLabel("Score");
		
		AreaChart<String, Number> areaChat = new AreaChart<>(xAxis, yAxis);
		areaChat.setTitle("Area Chart");
		
		XYChart.Series<String, Number> ciccio = new XYChart.Series<>();
		ciccio.setName("Ciccio Pasticcio");
		ciccio.getData().add(new XYChart.Data<>("Type 1", 4));
		ciccio.getData().add(new XYChart.Data<>("Type 2", 6));
		ciccio.getData().add(new XYChart.Data<>("Type 3", 3.5));
		ciccio.getData().add(new XYChart.Data<>("Type 4", 2.7));
		ciccio.getData().add(new XYChart.Data<>("Type 5", 7.8));
		
		XYChart.Series<String, Number> renata = new XYChart.Series<>();
		renata.setName("Renata Limbranata");
		renata.getData().add(new XYChart.Data<>("Type 1", 2.3));
		renata.getData().add(new XYChart.Data<>("Type 2", 4.7));
		renata.getData().add(new XYChart.Data<>("Type 3", 3.8));
		renata.getData().add(new XYChart.Data<>("Type 4", 6.2));
		renata.getData().add(new XYChart.Data<>("Type 5", 8.1));
		
		XYChart.Series<String, Number> silvestro = new XYChart.Series<>();
		silvestro.setName("Silvestro Sottocanestro");
		silvestro.getData().add(new XYChart.Data<>("Type 1", 6.0));
		silvestro.getData().add(new XYChart.Data<>("Type 2", 5.2));
		silvestro.getData().add(new XYChart.Data<>("Type 3", 7.9));
		silvestro.getData().add(new XYChart.Data<>("Type 4", 8.3));
		silvestro.getData().add(new XYChart.Data<>("Type 5", 7.6));
		
		areaChat.getData().addAll(ciccio, renata, silvestro);
		
		return areaChat;
	}
	
}
