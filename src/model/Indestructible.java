package model;

import java.io.IOException;

import controller.Controller;
import javafx.scene.image.Image;

public class Indestructible extends Bombs {
	
	private Image icon;
	public Indestructible() {
		icon = new Image("/exclaimedBomb.png");
		}
	@Override
	public void claim() {
		Controller controller=new Controller();
		try {controller.setScene("Lose","BOMB");} catch (IOException e) {}
		
	}

	@Override
	public void ammo() {
		// TODO Auto-generated method stub
		
	}

}
