package com.acloudysky.player;

import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.util.Duration;
import javafx.geometry.Insets;

public class MediaBar extends HBox {

	Slider time = new Slider();
	Slider vol = new Slider();
	
	Button playButton = new Button("||");
	
	Label volume  = new Label("volume: ");
	
	MediaPlayer player;
	
	public MediaBar(MediaPlayer play){
		player = play;
		
		setAlignment(Pos.CENTER);
		
		Insets value = new Insets(5,10,5,10);
		setPadding(value);
		
		vol.setPrefWidth(70);
		vol.minWidth(30);
		vol.setValue(100);
		HBox.setHgrow(time, Priority.ALWAYS);
		
		playButton.setPrefWidth(30);
		
		getChildren().add(playButton);
		getChildren().add(time);
		getChildren().add(volume);
		getChildren().add(vol);
		
		
			
			
		playButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Status status = player.getStatus();
				
				if (status == Status.PLAYING) {
					
					Duration duration = player.getTotalDuration(); 
					Duration currentTime = player.getCurrentTime();
					
					if (currentTime.greaterThanOrEqualTo(duration)) {
						player.seek(player.getStartTime());
						player.play();
					}
					else {
						player.pause();
						playButton.setText(">");
					}
				}
				
				if (status == Status.PAUSED || 
					status == Status.HALTED || 
					status == Status.STOPPED) {
					
					player.play();
					playButton.setText("||");
					
				}
			}
		});
		
		player.currentTimeProperty().addListener(new InvalidationListener(){

			@Override
			public void invalidated(Observable arg0) {
				
				updateValues();
			}
		
		});
		
		time.valueProperty().addListener(new InvalidationListener() {

			@Override
			public void invalidated(Observable observable) {
				if (time.isPressed()) {
					Duration duration = player.getMedia().getDuration();
					Duration value = duration.multiply(time.getValue()/100);
					player.seek(value);
				}
				
			}
			
		});
		
		vol.valueProperty().addListener(new InvalidationListener() {

			@Override
			public void invalidated(Observable observable) {
				if (vol.isPressed()){
					player.setVolume(vol.getValue()/100);
				}
				
			}
			
		});
		
	}
	
	protected void updateValues() {
		Platform.runLater(new Runnable(){
			public void run(){
				double currentTime = player.getCurrentTime().toMillis();
				double duration = player.getTotalDuration().toMillis(); 
				double value = currentTime/duration * 100;
				time.setValue(value);
			}
		});
		
	}
		
	
}
