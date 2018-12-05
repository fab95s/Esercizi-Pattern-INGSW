package it.unical.ingsw.factorys;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

public class PieChartFactory extends ChartFactory {
	
	@Override
	public PieChart makeChart() {
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
			new PieChart.Data("Type 1", 10),
			new PieChart.Data("Type 2", 20),
			new PieChart.Data("Type 3", 30),
			new PieChart.Data("Type 4", 40),
			new PieChart.Data("Type 5", 50)
		);
		PieChart pieChart = new PieChart(pieChartData);
		pieChart.setTitle("Pie Chart");
		pieChart.setClockwise(true);
		pieChart.setStartAngle(180);
		return pieChart;
	}
	
}
