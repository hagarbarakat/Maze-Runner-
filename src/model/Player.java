package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player implements Cell, PlayerDecorator{
    Context context =  Context.getInstance();

    MasterState masterState =  MasterState.getinstance();


    BeginnerState beginnerState =  BeginnerState.getinstance();

	 ImageView [] imageBeginner=new ImageView[4];
	 ImageView [] imageMaster=new ImageView[4];
	 int score=0;
	int health=100;
	int amo=6;
	String direction;
	
	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	private int x;
	public void setX(int x)
	{
		this.x=x;
	}
	
	private static Player instance=null;
	public static Player getInstance()
	{
		if(instance==null)
		{
			instance=new Player();
		
		}
		return instance;
	}
	
	private Player () {
		x=1;
	}
	public ImageView getImageView(String direction) 
	{
		System.out.println(x+"   --------    "+direction);
		switch (direction) {
		case "up":{
			  imageBeginner[1]=new ImageView(new Image("/up.png")); 
			  imageMaster[1]=new ImageView(new Image("/character.png")); 
			  
			  if(x==1)//beginner

				  {
				  return imageBeginner[1];
				  }else	if(x==2)//Master

				  {
					  return imageMaster[1];

					  
				  }
			  
			}  
		case "down":{


			  imageBeginner[0]=new ImageView(new Image("/down.png")); 
			  imageMaster[0]=new ImageView(new Image("/character.png")); 
			  
			  if(x==1)

				  {
				  return imageBeginner[0];
				  }else
				  {
					  return imageMaster[0];

					  
				  }
				}
		case "left":{

			  imageBeginner[2]=new ImageView(new Image("/left.png")); 
			  imageMaster[2]=new ImageView(new Image("/character.png")); 
			  
			  if(x==1)

				  {
				  return imageBeginner[2];
				  }else
				  {
					  return imageMaster[2];

					  
				  }
			}
		case "right":{
		  imageBeginner[3]=new ImageView(new Image("/right.png")); 
		  imageMaster[3]=new ImageView(new Image("/character.png")); 
		  
		  if(x==1)

			  {
			  return imageBeginner[3];
			  }else
			  {
				  return imageMaster[3];

				  
			  }
				}
		}
		return null;
	}

	@Override
	public void getarmor(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isShielded() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setShielded(boolean isShielded) {
		// TODO Auto-generated method stub
		
	}

}
