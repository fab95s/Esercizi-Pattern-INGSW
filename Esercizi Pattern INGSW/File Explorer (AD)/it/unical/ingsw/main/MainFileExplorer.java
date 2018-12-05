package it.unical.ingsw.main;

import java.net.InetAddress;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import it.unical.ingsw.adapter.FileExplorerAdapter;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainFileExplorer extends Application {
	private TreeView<String> tree;
	private Image pc = new Image(ClassLoader.getSystemResourceAsStream("images/pc-icon.png"));

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox box = new VBox();
		box.setPadding(new Insets(10, 10, 10, 10));
		box.setSpacing(10);
		String host = InetAddress.getLocalHost().getHostName();
		TreeItem<String> rootNode = new TreeItem<>(host, new ImageView(pc));
		Iterable<Path> directorys = FileSystems.getDefault().getRootDirectories();
		for(Path name : directorys) {
			FileExplorerAdapter node = new FileExplorerAdapter(name);
			rootNode.getChildren().add(node);
		}
		rootNode.setExpanded(true);
		tree = new TreeView<>(rootNode);
		box.getChildren().add(tree);
		VBox.setVgrow(tree, Priority.ALWAYS);
		
		primaryStage.setTitle("File Explorer Adapter");
		StackPane root = new StackPane();
		root.getChildren().add(box);
		primaryStage.setScene(new Scene(root, 500, 500));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
