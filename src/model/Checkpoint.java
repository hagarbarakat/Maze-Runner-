package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Checkpoint {

	private int [][]  maze=new int [30][30]; 
	private String time;
	private int bullets,health,score;
	private ImageView icon=new ImageView(new Image("/flag.png"));
	public Checkpoint(int [][]maze,int b,int health,int s,String time)
	{
		for(int i=0;i<30;i++)
		{
			for(int j=0;j<30;j++)this.maze[i][j]=maze[i][j];
		}
		this.time=time;
		this.score=s;
		this.health=health;
		this.bullets=b;
		
		
				
	}
	


	public int getBullets() {
		return bullets;
	}


	public void setBullets(int bullets) {
		this.bullets = bullets;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public int [][] getMaze() {
		return maze;
	}


	public void setMaze(int [][] maze) {
		this.maze = maze;
	}


	public ImageView getIcon() {
		return icon;
	}


	public void setIcon(ImageView icon) {
		this.icon = icon;
	}



	public int getHealth() {
		return health;
	}



	public void setHealth(int health) {
		this.health = health;
	}



	public int getScore() {
		return score;
	}



	public void setScore(int score) {
		this.score = score;
	}
	

}
