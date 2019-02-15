package model;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import controller.Controller;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class UpState implements DirectionState{
	static int Health=100;
	static int small=5;
	static int big=25;
	static int score=0;
	static int Amo=6;
	Bullet bullet;
    static boolean isShielded;
	static Score s=Score.getInstance();
	static Health h=new Health();
	private static String direction="left";
	Timer myTimer=new Timer();
	private static int startY;
	private static int startX;
	private static GridPane pane;
	PlayerDecorator Armor1 = new Armor(Player.getInstance());
	@Override
	public void doAction(DirectionContext context) {
	      context.setState(this);	
		
	}

	@Override
	public void updateDirection() {
		Maze maze=Maze.getInstance();
		int [][]ground =maze.getMaze();

		if(startY>0&&ground[startX-1][startY]==1)
		{
			maze.setElement(startX, startY, 1);
			maze.setElement(startX-1, startY, 88);
			Pane last=Moving.getNodeByRowColumnIndex(startY, startX, pane);
			Pane playerPane=(Pane) last.getChildren().get(0);
			playerPane.getChildren().clear();
			last.getChildren().remove(Player.getInstance().getImageView(direction));
			playerPane.getChildren().add(Player.getInstance().getImageView("up"));
			
			
			Moving.getNodeByRowColumnIndex(startY, --startX, pane).getChildren().add(playerPane)	;
			direction="up";
		}
		else if (startY>0&&ground[startX-1][startY]==777)//monster dead
		{
			Controller c=new Controller();
				try {
					c.setScene("Lose","Albert has eaten you!");
				} catch (IOException e) {}
		}
		else if(startY>0&&ground[startX-1][startY]==0)
		{
			Moving.getNodeByRowColumnIndex(startY, startX, pane).getChildren().clear();
			Moving.getNodeByRowColumnIndex(startY, startX, pane).getChildren().add(new Pane(Player.getInstance().getImageView("up")));

			direction="up";

		}
			
		else if(startY>0&&ground[startX-1][startY]==5 )
		{

			maze.setElement(startX, startY, 1);
			maze.setElement(startX+1, startY, 88);
			Pane next=Moving.getNodeByRowColumnIndex(startY, startX-1, pane);

			next.getChildren().clear();
			Pane p=Moving.getNodeByRowColumnIndex(startY, startX, pane);
			Pane playerPane=(Pane) p.getChildren().get(0);
			playerPane.getChildren().clear();
			p.getChildren().clear();
			playerPane.getChildren().add(Player.getInstance().getImageView("up"));
			
			Moving.getNodeByRowColumnIndex(startY, --startX, pane).getChildren().add(playerPane)	;
			maze.setElement(startX, startY, 1);
			direction="up";
			
			
			Events e=new Events();
			e.addObserver(h);
			e.notifyAllObservers(Type.positive);
			
			
		} 
		else if(startY>0&&ground[startX-1][startY]==6 )
		{

			maze.setElement(startX, startY, 1);
			maze.setElement(startX-1, startY, 88);
			Pane next=Moving.getNodeByRowColumnIndex(startY, startX-1, pane);

			next.getChildren().clear();   //delete object
			Pane p=Moving.getNodeByRowColumnIndex(startY, startX, pane);
			Pane player=(Pane) p.getChildren().get(0);
			player.getChildren().clear();
			p.getChildren().clear();
			player.getChildren().add(Player.getInstance().getImageView("up"));
			
			Moving.getNodeByRowColumnIndex(startY, --startX, pane).getChildren().add(player)	;
			maze.setElement(startX, startY, 1);
			direction="up";
			
			
			Events e=new Events();
			e.addObserver(s);
			e.notifyAllObservers(Type.positive);
			
		}
		
		else if(startY>0&&ground[startX-1][startY]==7 )
		{

			maze.setElement(startX, startY, 1);
			maze.setElement(startX-1, startY, 88);
			Pane next=Moving.getNodeByRowColumnIndex(startY, startX-1, pane);

			next.getChildren().clear();   //delete object
			Pane p=Moving.getNodeByRowColumnIndex(startY, startX, pane);
			Pane player=(Pane) p.getChildren().get(0);
			player.getChildren().clear();
			p.getChildren().clear();
			player.getChildren().add(Player.getInstance().getImageView("up"));
			
			Moving.getNodeByRowColumnIndex(startY, --startX, pane).getChildren().add(player)	;
			maze.setElement(startX, startY, 1);
			direction="up";

			
			Events e=new Events();
			e.addObserver(s);
			e.notifyAllObservers(Type.albert);
			
			
		} 

		else if(startY>0&&ground[startX-1][startY]==4 )
		{

			maze.setElement(startX, startY, 1);
			maze.setElement(startX-1, startY, 88);
			Pane next=Moving.getNodeByRowColumnIndex(startY, startX-1, pane);

			next.getChildren().clear();   //delete object
			Pane p=Moving.getNodeByRowColumnIndex(startY, startX, pane);
			Pane player=(Pane) p.getChildren().get(0);
			player.getChildren().clear();
			p.getChildren().clear();
			player.getChildren().add(Player.getInstance().getImageView("up"));
			
			Moving.getNodeByRowColumnIndex(startY, --startX, pane).getChildren().add(player)	;
			maze.setElement(startX, startY, 1);
			direction="up";
			Events e= new Events();
			Bullet b= Bullet.getInstance();
			b.setProperties(startX, startY, direction);
			e.addObserver(b);
		e.setUpdate(Type.increase);
		} 
		
	
	
		else if(ground[startX-1][startY]==100)
			{
				Controller controller=new Controller();
				try {controller.setScene("Win",null);} catch (IOException e) {}
			
			}
		else if(ground[startX-1][startY]==10)
		{
		
			maze.setElement(startX, startY, 1);
			maze.setElement(startX+1, startY, 88);
			Pane next=Moving.getNodeByRowColumnIndex(startY, startX-1, pane);

			next.getChildren().clear();
			Pane p=Moving.getNodeByRowColumnIndex(startY, startX, pane);
			Pane playerPane=(Pane) p.getChildren().get(0);
			playerPane.getChildren().clear();
			p.getChildren().clear();
			playerPane.getChildren().add(Player.getInstance().getImageView("up"));
			
			Moving.getNodeByRowColumnIndex(startY, --startX, pane).getChildren().add(playerPane)	;
			maze.setElement(startX, startY, 1);
			direction="up";
			  Events e= new Events();
        	  e.addObserver(h);
			 if(isShielded) {
            	
            	 e.setUpdate(Type.fixed);
            	  e.notifyAllObservers(Type.fixed);
            	  System.out.println(" Health = " + h.getHealth());

              }
			  else {

			e.notifyAllObservers(Type.minus);
			System.out.println(" Health = " + h.getHealth());
			  }}
		else if(startY>0&&ground[startX-1][startY]==17) {
			maze.setElement(startX, startY, 1);
			maze.setElement(startX+1, startY, 88);
			Pane next=Moving.getNodeByRowColumnIndex(startY, startX-1, pane);

			next.getChildren().clear();
			Pane p=Moving.getNodeByRowColumnIndex(startY, startX, pane);
			Pane playerPane=(Pane) p.getChildren().get(0);
			playerPane.getChildren().clear();
			p.getChildren().clear();
			playerPane.getChildren().add(Player.getInstance().getImageView("up"));
			
			Moving.getNodeByRowColumnIndex(startY, --startX, pane).getChildren().add(playerPane)	;
			maze.setElement(startX, startY, 1);
			direction="up";
			
			isShielded=true;
			Timer timer = new Timer();
			System.out.println("hi");
			TimerTask t= new TimerTask() 
					{

						@Override
						public void run() {
                        Armor1.getarmor(10);	
                        isShielded=false;
                        System.out.println("bye");
						}
				
					};timer.schedule(t,10*1000);
		}
			
		else if(startY>0&&ground[startX-1][startY]==99) {
			maze.setElement(startX, startY, 1);
			maze.setElement(startX-1, startY, 88);
			Pane next=Moving.getNodeByRowColumnIndex(startY, startX-1, pane);

			next.getChildren().clear();   //delete object
			Pane p=Moving.getNodeByRowColumnIndex(startY, startX, pane);
			Pane player=(Pane) p.getChildren().get(0);
			player.getChildren().clear();
			p.getChildren().clear();
			player.getChildren().add(Player.getInstance().getImageView("up"));
			
			Moving.getNodeByRowColumnIndex(startY, --startX, pane).getChildren().add(player)	;
			maze.setElement(startX, startY, 1);
			direction="up";
			  Events e= new Events();
        	  e.addObserver(h);
			 if(isShielded) {
            	
            	 e.setUpdate(Type.fixed);
            	  e.notifyAllObservers(Type.fixed);
            	  System.out.println(" Health = " + h.getHealth());

              }
			  else {

			e.notifyAllObservers(Type.dead);
			Controller c=new Controller();
			try {
				c.setScene("Lose", "bomb has exploded");
			} catch (IOException ex) {}
			System.out.println(" Health = " + h.getHealth());
			  }}
			
		
		else if(startY>0&&ground[startX-1][startY]==25)
		{

			maze.setElement(startX, startY, 1);
			maze.setElement(startX-1, startY, 88);
			Pane next=Moving.getNodeByRowColumnIndex(startY, startX-1, pane);

			next.getChildren().clear();   //delete object
			Pane p=Moving.getNodeByRowColumnIndex(startY, startX, pane);
			Pane player=(Pane) p.getChildren().get(0);
			player.getChildren().clear();
			p.getChildren().clear();
			player.getChildren().add(Player.getInstance().getImageView("up"));
			
			Moving.getNodeByRowColumnIndex(startY, --startX, pane).getChildren().add(player)	;
			maze.setElement(startX, startY, 1);
			direction="up";
			Originator org=Originator.getInstance();
			Caretaker ct=Caretaker.getInstance();
			org.set(new Checkpoint(ground, Bullet.getInstance().getCounter(), h.getHealth(),s.getScore(), null ));
			ct.addMemento(org.storeInMemento());

		}
		
		Moving.setXYDirection(startX,startY,direction);
		
	}

	@Override
	public void updateInfo(	GridPane pane,Bullet b,int startX,int startY,String d) {


		UpState.pane=pane;
		this.bullet=b;
		UpState.startX=startX;
		UpState.startY=startY;
	}
	
	

}
