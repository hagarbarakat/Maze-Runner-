package model;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import model.Maze;

public class destructible extends Bombs{
	@FXML 
	private static GridPane pane;	
	private Image icon;

	
	Player p1= Player.getInstance();
	public destructible() {
		icon=new Image("/normBomb.png");
		
	}

	@Override
	public void claim() {
		
		/*Pane p= Moving.getNodeByRowColumnIndex(Moving.startX,Moving.startY,pane);
		Pane bomb=(Pane) p.getChildren().get(0);
		bomb.getChildren().clear();
	
		p.getChildren().clear();*/
		
		
	}

	@Override
	public void ammo() {
		// TODO Auto-generated method stub
		
	}

}
