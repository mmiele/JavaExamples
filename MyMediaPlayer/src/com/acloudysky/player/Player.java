package com.acloudysky.player;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class Player extends BorderPane {

	Media media;
	MediaPlayer player;
	MediaView view;
	MediaBar bar;
	
	// Media pane
	Pane mpane;
	
	
	public Player(String file){
		media = new Media(file);
		player = new MediaPlayer(media);
		view = new MediaView(player);
		
		view.setFitWidth(600);
		view.setFitHeight(425);
		
//		view.setTranslateX(view.getFitWidth() / 2  - 200); 
//		view.setTranslateY(view.getFitHeight() / 2  - 200);
//		view.setScaleX(2); view.setScaleY(1);
		
		mpane = new Pane();
		mpane.getChildren().add(view);
	
		mpane.setMaxSize(600, 425);
		
		setCenter(mpane);
		
		bar = new MediaBar(player);
		
		setBottom(bar);
		setStyle("fx-background-color: #bfc2c7");
		player.play();
	}
}
