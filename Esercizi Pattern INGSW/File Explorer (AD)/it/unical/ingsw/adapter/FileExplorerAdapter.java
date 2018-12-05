package it.unical.ingsw.adapter;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TreeItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FileExplorerAdapter extends TreeItem<String> {
	public static Image fileIcon = new Image(ClassLoader.getSystemResourceAsStream("images/file-icon.png"));
	public static Image folderIcon = new Image(ClassLoader.getSystemResourceAsStream("images/folder-icon.png"));
	private String fullPath;
	private boolean isDir;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public FileExplorerAdapter(Path file) {
		super(file.toString());
		this.fullPath = file.toString();
		if(Files.isDirectory(file)) {
			this.isDir = true;
			this.setGraphic(new ImageView(folderIcon));
		} else {
			this.isDir = false;
			this.setGraphic(new ImageView(fileIcon));
		}
		
		if(!fullPath.endsWith(File.separator)) {
			String value = file.toString();
			int index = value.lastIndexOf(File.separator);
			if(index > 0) {
				this.setValue(value.substring(index + 1));
			} else {
				this.setValue(value);
			}
		}
		
		this.addEventHandler(TreeItem.branchExpandedEvent(), new EventHandler() {

			@Override
			public void handle(Event e) {
				FileExplorerAdapter source = (FileExplorerAdapter) e.getSource();
				try{
					if(source.getChildren().isEmpty()){
						Path path = Paths.get(source.getFullPath());
						BasicFileAttributes attribs = Files.readAttributes(path,BasicFileAttributes.class);
						if(attribs.isDirectory()){
							DirectoryStream<Path> dir = Files.newDirectoryStream(path);
							for(Path file : dir){
								FileExplorerAdapter treeNode = new FileExplorerAdapter(file);
								source.getChildren().add(treeNode);
							}
						}
					}
				}catch(IOException e1){
					e1.printStackTrace();
				}
			}
		});
	}
	
	public String getFullPath() {
		return fullPath;
	}
	
	public boolean isDirectory() {
		return isDir;
	}

}
