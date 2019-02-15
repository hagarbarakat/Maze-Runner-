package model;

import controller.Controller;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bullet implements Observer {

	private static int counter;
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		Bullet.counter = counter;
	}
	private int locationX,locationY,dx,dy; 
	private ImageView iconMaster=new ImageView(new Image("/fire.png"));
	private ImageView iconBeginner=new ImageView(new Image("/chicken-leg (1).png"));
	private static Bullet instance=null;
	
	private  Bullet()
	{
	
	}
	
	public void setProperties(int x, int y,String direction)
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
		locationX=y;
		locationY=x;
		if(direction=="start")counter=6;
	}
	
	@Override
	
	public void update(Type type) {

		if(type==Type.increase)
			{counter=6;
			}
	else if(type==Type.decrease)
		 counter--;
			
		
		Controller.setBulletsLabel(((counter)));

		
	}
	public void updateLocation ()
	{
		locationX+=dx;
		locationY+=dy;
	}
	public int getNumberOfBullets() {return counter;}
	public int getX() {return locationX;}
	public int getY() {return locationY;}
	public ImageView getIcon() {
		
		if(x==1)
		{
			return iconBeginner;
		}else
		{
			return iconMaster;
		}
		
	}
	public static Bullet getInstance() {
		if(instance==null)
		{
		instance=new Bullet();
		}
		
		return instance;
	}
	private int x;
	public void setX(int x)
	{
		this.x=x;
	}

}
