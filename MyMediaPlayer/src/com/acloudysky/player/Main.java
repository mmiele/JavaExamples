package com.acloudysky.player;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.scene.media.Media;


public class Main extends Application {

	Player player;
	FileChooser fileChooser;
	Media media;
	
	
	private String getDefaultMedia() {
		// Initialize player with default video.
		URL resource = Main.class.getResource("/uncazze.mp4");
		URI uri = null;
		String filePath = null;
		try {
			// Get the resources URI.
			uri = resource.toURI();
			// Get the file.
			File currentFile = Paths.get(uri).toFile();
			// Get the file path and add the prefix file for the
			// expected format.
			filePath = "file:" + currentFile.getPath();
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return filePath;
	}
	
	@Override
	public void start(final Stage primaryStage) {
		
		int frameWidth = 600;
		int frameHeight = 415;
		
		MenuItem open = new MenuItem("Open...");
		Menu file = new Menu("File");
		MenuBar menu = new MenuBar();
		
		file.getItems().add(open);
		menu.getMenus().add(file);
		
		fileChooser = new FileChooser();
		
				
		open.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent e) {
				player.player.pause();
				File file = fileChooser.showOpenDialog(primaryStage);
				if (file != null){
					try {
						player = new Player(file.toURI().toURL().toExternalForm());
						Scene scene = new Scene(player);
//						Scene scene = new Scene(player, frameWidth, frameHeight, 
//								Color.BLACK);
						
						primaryStage.setScene(scene);
					} catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		
		
		player = new Player(getDefaultMedia());
		
		player.setTop(menu);
		
		Scene scene = new Scene(player, frameWidth, frameHeight, 
				Color.BLACK);
		
		primaryStage.setScene(scene);
		
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
