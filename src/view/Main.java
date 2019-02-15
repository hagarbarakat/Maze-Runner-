package view;
	
import java.io.File;

import controller.Controller;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import model.Moving;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Main extends Application {

	static Stage primaryStage;
	static Sounds sound;	
	static FXMLLoader loader;
	public void start(Stage primaryStage) {
		try {
			this.primaryStage=primaryStage;
			Main.loader= new FXMLLoader(getClass().getResource("out.fxml"));
			Parent root;
			root = loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		
            
            sound.playLoopSound();

			} catch(Exception e) {
			e.printStackTrace();
		}
		String musicFile = "Tension3.mp3";     // For example
		Media sound = new Media(new File(musicFile).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
	
	public static void main(String[] args) {
		launch(args);
	}
	@FXML
	public void newgame(ActionEvent e)
	{
		Main.loader= new FXMLLoader(getClass().getResource("Main.fxml"));

		Controller.startGame(loader, primaryStage,"new");
		Controller.wakeAlbert();
		Controller.wakeMucho();

	}	
	@FXML
	public void load(ActionEvent e)
	{
		Main.loader= new FXMLLoader(getClass().getResource("Main.fxml"));

		Controller.startGame(loader, primaryStage,"load");
		Controller.wakeAlbert();
		Controller.wakeMucho();

	}
}
