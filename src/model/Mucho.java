package model;


import controller.Controller;
import javafx.scene.image.Image;

public class Mucho extends Monster{
	//Steal tha player

	Controller c= new Controller();
	private int health;
	private static Mucho instance=null;
	public static Mucho getInstance()
	{
		if(instance==null)
		{
			instance=new Mucho();
		
		}
		return instance;
	}
	private  Mucho()
	{
		locationX=10;
		locationY=20;
		this.setName("Mucho");
		this.setLocationX(10);
		this.setLocationY(20);
		this.setIcon(new Image("ghost.png"));
		health=2;
	}
	@Override
	public void claim() {

		//Steal the player
		

		
	}

	@Override
	public void ammo() {
		
		health--;
		if(health==0)
		{
			//Remove Mucho
		}
	}

	public int getHealth() {
		return health;
	}

	private int locationX,locationY,dx,dy; 
	


	public void updateLocation ()
	{
		locationX+=dx;
		locationY+=dy;
	}
	public int getX() {return locationX;}
	public int getY() {return locationY;}

	
	
	public void setDirection(String direction)
	{
		if(direction.equals("left"))
		{
			dx=-1;
			dy=0;
		}else if(direction.equals("right"))
		{
			dx=1;
			dy=0;
		}
		else if(direction.equals("up"))
		{
			dx=0;
			dy=-1;
		}
		else if(direction.equals("down"))
		{
			dx=0;
			dy=1;
		}
	}


	
	
	
}
