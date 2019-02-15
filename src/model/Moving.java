package model;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import controller.Controller;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import model.Maze;

public class Moving {
	
	static int Health=100;
	static int small=5;
	static int big=25;
	static int score=0;
	static int Amo=6;
	Bullet bullet;

	static Score s= Score.getInstance();
	static Health h=new Health();
	private static String direction="down";
	Timer myTimer=new Timer();
	private static int startY=1;
	private static int startX=0;
	private static GridPane panee;
	static DirectionContext dc= DirectionContext.getInstance();

	public static void setXYDirection
	(int x,int y,String d)
	{
		startX=x; startY=y; direction=d;
	}
	@SuppressWarnings("incomplete-switch")
	public static void update(KeyCode keyCode,GridPane pane){
		Maze maze=Maze.getInstance();
		int [][]ground =maze.getMaze();

		switch(keyCode){
		
		case LEFT :

		      LeftState leftState =  new LeftState();
		      leftState.doAction(dc);
		      dc.getState().updateInfo(pane, Bullet.getInstance(),startX,startY,direction);
		      dc.getState().updateDirection();
		      direction="left";

			break;
		/*	if(startY>0&&ground[startX][startY-1]==1)
			{
				maze.setElement(startX, startY, 1);
				maze.setElement(startX, startY-1, 88);
				Pane last=getNodeByRowColumnIndex(startY, startX, pane);
				Pane playerPane=(Pane) last.getChildren().get(0);
				playerPane.getChildren().clear();
				last.getChildren().remove(Player.getInstance().getImageView(direction));
				playerPane.getChildren().add(Player.getInstance().getImageView("left"));
				
				
				getNodeByRowColumnIndex(--startY, startX, pane).getChildren().add(playerPane)	;
				direction="left";
			}
			else if (startY>0&&ground[startX][startY-1]==777)//monster dead
			{
				Controller c=new Controller();
					try {
						c.setScene("Lose","Albert has eaten you!");
					} catch (IOException e) {}
			}
			else if(startY>0&&ground[startX][startY-1]==0)
			{
				getNodeByRowColumnIndex(startY, startX, pane).getChildren().clear();
				getNodeByRowColumnIndex(startY, startX, pane).getChildren().add(new Pane(Player.getInstance().getImageView("left")));

				direction="left";

			}
				
			else if(startY>0&&ground[startX][startY-1]==5 )
			{

				maze.setElement(startX, startY, 1);
				maze.setElement(startX, startY-1, 88);
				Pane next=getNodeByRowColumnIndex(startY-1, startX, pane);

				next.getChildren().clear();
				Pane p=getNodeByRowColumnIndex(startY, startX, pane);
				Pane playerPane=(Pane) p.getChildren().get(0);
				playerPane.getChildren().clear();
				p.getChildren().clear();
				playerPane.getChildren().add(Player.getInstance().getImageView("left"));
				
				getNodeByRowColumnIndex(--startY, startX, pane).getChildren().add(playerPane)	;
				maze.setElement(startX, startY, 1);
				direction="left";
				
				
				Events e=new Events();
				e.addObserver(h);
				e.notifyAllObservers(Type.positive);
				
				
			} 
			else if(startY>0&&ground[startX][startY-1]==6 )
			{

				maze.setElement(startX, startY, 1);
				maze.setElement(startX, startY-1, 88);
				Pane next=getNodeByRowColumnIndex(startY-1, startX, pane);

				next.getChildren().clear();   //delete object
				Pane p=getNodeByRowColumnIndex(startY, startX, pane);
				Pane player=(Pane) p.getChildren().get(0);
				player.getChildren().clear();
				p.getChildren().clear();
				player.getChildren().add(Player.getInstance().getImageView("left"));
				
				getNodeByRowColumnIndex(--startY, startX, pane).getChildren().add(player)	;
				maze.setElement(startX, startY, 1);
				direction="left";
				
				
				Events e=new Events();
				e.addObserver(s);
				e.notifyAllObservers(Type.positive);
				
			}
			
			else if(startY>0&&ground[startX][startY-1]==7 )
			{

				maze.setElement(startX, startY, 1);
				maze.setElement(startX, startY-1, 88);
				Pane next=getNodeByRowColumnIndex(startY-1, startX, pane);

				next.getChildren().clear();   //delete object
				Pane p=getNodeByRowColumnIndex(startY, startX, pane);
				Pane player=(Pane) p.getChildren().get(0);
				player.getChildren().clear();
				p.getChildren().clear();
				player.getChildren().add(Player.getInstance().getImageView("left"));
				
				getNodeByRowColumnIndex(--startY, startX, pane).getChildren().add(player)	;
				maze.setElement(startX, startY, 1);
				direction="left";
	
				
				Events e=new Events();
				e.addObserver(s);
				e.notifyAllObservers(Type.albert);
				
				
			} 

			else if(startY>0&&ground[startX][startY-1]==4 )
			{

				maze.setElement(startX, startY, 1);
				maze.setElement(startX, startY-1, 88);
				Pane next=getNodeByRowColumnIndex(startY-1, startX, pane);

				next.getChildren().clear();   //delete object
				Pane p=getNodeByRowColumnIndex(startY, startX, pane);
				Pane player=(Pane) p.getChildren().get(0);
				player.getChildren().clear();
				p.getChildren().clear();
				player.getChildren().add(Player.getInstance().getImageView("left"));
				
				getNodeByRowColumnIndex(--startY, startX, pane).getChildren().add(player)	;
				maze.setElement(startX, startY, 1);
				direction="left";
				Events e= new Events();
				Bullet b= Bullet.getInstance();
				b.setProperties(startX, startY, direction);
				e.addObserver(b);
			e.setUpdate(Type.increase);
				
			} 
			break;*/
			
		case DOWN :

		      DownState downState =  new DownState();
		      downState.doAction(dc);
		      dc.getState().updateInfo(pane, Bullet.getInstance(),startX,startY,direction);
		      dc.getState().updateDirection();
		      direction="down";

			break;
			
			/*

			if(startY>0&&ground[startX+1][startY]==1)
			{
				maze.setElement(startX, startY, 1);
				maze.setElement(startX+1, startY, 88);
				Pane last=getNodeByRowColumnIndex(startY, startX, pane);
				Pane playerPane=(Pane) last.getChildren().get(0);
				playerPane.getChildren().clear();
				last.getChildren().remove(Player.getInstance().getImageView(direction));
				playerPane.getChildren().add(Player.getInstance().getImageView("down"));
				
				
				getNodeByRowColumnIndex(startY, ++startX, pane).getChildren().add(playerPane)	;
				direction="down";
			}
			else if (startY>0&&ground[startX+1][startY]==777)//monster dead
			{
				Controller c=new Controller();
					try {
						c.setScene("Lose","Albert has eaten you!");
					} catch (IOException e) {}
			}
			else if(startY>0&&ground[startX+1][startY]==0)
			{
				getNodeByRowColumnIndex(startY, startX, pane).getChildren().clear();
				getNodeByRowColumnIndex(startY, startX, pane).getChildren().add(new Pane(Player.getInstance().getImageView("down")));

				direction="down";

			}
				
			else if(startY>0&&ground[startX+1][startY]==5 )
			{

				maze.setElement(startX, startY, 1);
				maze.setElement(startX+1, startY, 88);
				Pane next=getNodeByRowColumnIndex(startY, startX+1, pane);

				next.getChildren().clear();
				Pane p=getNodeByRowColumnIndex(startY, startX, pane);
				Pane playerPane=(Pane) p.getChildren().get(0);
				playerPane.getChildren().clear();
				p.getChildren().clear();
				playerPane.getChildren().add(Player.getInstance().getImageView("down"));
				
				getNodeByRowColumnIndex(startY, ++startX, pane).getChildren().add(playerPane)	;
				maze.setElement(startX, startY, 1);
				direction="down";
				
				
				Events e=new Events();
				e.addObserver(h);
				e.notifyAllObservers(Type.positive);
				
				
			} 
			else if(startY>0&&ground[startX+1][startY]==6 )
			{

				maze.setElement(startX, startY, 1);
				maze.setElement(startX+1, startY, 88);
				Pane next=getNodeByRowColumnIndex(startY, startX+1, pane);

				next.getChildren().clear();   //delete object
				Pane p=getNodeByRowColumnIndex(startY, startX, pane);
				Pane player=(Pane) p.getChildren().get(0);
				player.getChildren().clear();
				p.getChildren().clear();
				player.getChildren().add(Player.getInstance().getImageView("down"));
				
				getNodeByRowColumnIndex(startY, ++startX, pane).getChildren().add(player)	;
				maze.setElement(startX, startY, 1);
				direction="down";
				
				
				Events e=new Events();
				e.addObserver(s);
				e.notifyAllObservers(Type.positive);
				
			}
			
			else if(startY>0&&ground[startX+1][startY]==7 )
			{

				maze.setElement(startX, startY, 1);
				maze.setElement(startX+1, startY, 88);
				Pane next=getNodeByRowColumnIndex(startY, startX+1, pane);

				next.getChildren().clear();   //delete object
				Pane p=getNodeByRowColumnIndex(startY, startX, pane);
				Pane player=(Pane) p.getChildren().get(0);
				player.getChildren().clear();
				p.getChildren().clear();
				player.getChildren().add(Player.getInstance().getImageView("down"));
				
				getNodeByRowColumnIndex(startY, ++startX, pane).getChildren().add(player)	;
				maze.setElement(startX, startY, 1);
				direction="down";
	
				
				Events e=new Events();
				e.addObserver(s);
				e.notifyAllObservers(Type.albert);
				
				
			} 

			else if(startY>0&&ground[startX+1][startY]==4 )
			{

				maze.setElement(startX, startY, 1);
				maze.setElement(startX+1, startY, 88);
				Pane next=getNodeByRowColumnIndex(startY, startX+1, pane);

				next.getChildren().clear();   //delete object
				Pane p=getNodeByRowColumnIndex(startY, startX, pane);
				Pane player=(Pane) p.getChildren().get(0);
				player.getChildren().clear();
				p.getChildren().clear();
				player.getChildren().add(Player.getInstance().getImageView("down"));
				
				getNodeByRowColumnIndex(startY, ++startX, pane).getChildren().add(player)	;
				maze.setElement(startX, startY, 1);
				direction="down";
				Events e= new Events();
				Bullet b= Bullet.getInstance();
				b.setProperties(startX, startY, direction);
				e.addObserver(b);
			e.setUpdate(Type.increase);
				break;
			} 
			
		
		
			else if(ground[startX+1][startY]==100)
				{
					Controller controller=new Controller();
					try {controller.setScene("Win",null);} catch (IOException e) {}
				
				break;}
			else if(ground[startX+1][startY]==10)
			{
			
				Events e= new Events();
		    	
		    	e.addObserver(h);
		    	
		    	e.setUpdate(Type.negative);
		    	System.out.println(" Health = "+h.getHealth());
		   
			
			}	
			break;
			*/
			
		case UP : 
			 UpState upState =  new UpState();
			 upState.doAction(dc);
		      dc.getState().updateInfo(pane, Bullet.getInstance(),startX,startY,direction);
		      dc.getState().updateDirection();
		      direction="up";


/*			
			if(startY>0&&ground[startX-1][startY]==1)
			{
				maze.setElement(startX, startY, 1);
				maze.setElement(startX-1, startY, 88);
				Pane last=getNodeByRowColumnIndex(startY, startX, pane);
				Pane playerPane=(Pane) last.getChildren().get(0);
				playerPane.getChildren().clear();
				last.getChildren().remove(Player.getInstance().getImageView(direction));
				playerPane.getChildren().add(Player.getInstance().getImageView("up"));
				
				
				getNodeByRowColumnIndex(startY, --startX, pane).getChildren().add(playerPane)	;
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
				getNodeByRowColumnIndex(startY, startX, pane).getChildren().clear();
				getNodeByRowColumnIndex(startY, startX, pane).getChildren().add(new Pane(Player.getInstance().getImageView("up")));

				direction="up";

			}
				
			else if(startY>0&&ground[startX-1][startY]==5 )
			{

				maze.setElement(startX, startY, 1);
				maze.setElement(startX+1, startY, 88);
				Pane next=getNodeByRowColumnIndex(startY, startX-1, pane);

				next.getChildren().clear();
				Pane p=getNodeByRowColumnIndex(startY, startX, pane);
				Pane playerPane=(Pane) p.getChildren().get(0);
				playerPane.getChildren().clear();
				p.getChildren().clear();
				playerPane.getChildren().add(Player.getInstance().getImageView("up"));
				
				getNodeByRowColumnIndex(startY, --startX, pane).getChildren().add(playerPane)	;
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
				Pane next=getNodeByRowColumnIndex(startY, startX-1, pane);

				next.getChildren().clear();   //delete object
				Pane p=getNodeByRowColumnIndex(startY, startX, pane);
				Pane player=(Pane) p.getChildren().get(0);
				player.getChildren().clear();
				p.getChildren().clear();
				player.getChildren().add(Player.getInstance().getImageView("up"));
				
				getNodeByRowColumnIndex(startY, --startX, pane).getChildren().add(player)	;
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
				Pane next=getNodeByRowColumnIndex(startY, startX-1, pane);

				next.getChildren().clear();   //delete object
				Pane p=getNodeByRowColumnIndex(startY, startX, pane);
				Pane player=(Pane) p.getChildren().get(0);
				player.getChildren().clear();
				p.getChildren().clear();
				player.getChildren().add(Player.getInstance().getImageView("up"));
				
				getNodeByRowColumnIndex(startY, --startX, pane).getChildren().add(player)	;
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
				Pane next=getNodeByRowColumnIndex(startY, startX-1, pane);

				next.getChildren().clear();   //delete object
				Pane p=getNodeByRowColumnIndex(startY, startX, pane);
				Pane player=(Pane) p.getChildren().get(0);
				player.getChildren().clear();
				p.getChildren().clear();
				player.getChildren().add(Player.getInstance().getImageView("up"));
				
				getNodeByRowColumnIndex(startY, --startX, pane).getChildren().add(player)	;
				maze.setElement(startX, startY, 1);
				direction="up";
				Events e= new Events();
				Bullet b= Bullet.getInstance();
				b.setProperties(startX, startY, direction);
				e.addObserver(b);
			e.setUpdate(Type.increase);
				break;
			} 
			
		
		
			else if(ground[startX-1][startY]==100)
				{
					Controller controller=new Controller();
					try {controller.setScene("Win",null);} catch (IOException e) {}
				
				break;}
			else if(ground[startX-1][startY]==10)
			{
			
				Events e= new Events();
		    	
		    	e.addObserver(h);
		    	
		    	e.setUpdate(Type.negative);
		   
			
			}*/	
			break;
			case RIGHT : 
			      RightState rightState =  new RightState();
			      rightState.doAction(dc);
			      dc.getState().updateInfo(pane, Bullet.getInstance(),startX,startY,direction);
			      dc.getState().updateDirection();
			      direction="right";
			      break;
				/*if(startY>0&&ground[startX][startY+1]==1)
				{
					maze.setElement(startX, startY, 1);
					maze.setElement(startX, startY+1, 88);
					Pane last=getNodeByRowColumnIndex(startY, startX, pane);
					Pane playerPane=(Pane) last.getChildren().get(0);
					playerPane.getChildren().clear();
					last.getChildren().remove(Player.getInstance().getImageView(direction));
					playerPane.getChildren().add(Player.getInstance().getImageView("right"));
					
					
					getNodeByRowColumnIndex(++startY, startX, pane).getChildren().add(playerPane)	;
					direction="right";
				}
				else if (startY>0&&ground[startX][startY+1]==777)//monster dead
				{
					Controller c=new Controller();
						try {
							c.setScene("Lose","Albert has eaten you!");
						} catch (IOException e) {}
				}
				else if(startY>0&&ground[startX][startY+1]==0)
				{
					getNodeByRowColumnIndex(startY, startX, pane).getChildren().clear();
					getNodeByRowColumnIndex(startY, startX, pane).getChildren().add(new Pane(Player.getInstance().getImageView("right")));

					direction="right";

				}
					
				else if(startY>0&&ground[startX][startY+1]==5 )
				{

					maze.setElement(startX, startY, 1);
					maze.setElement(startX+1, startY, 88);
					Pane next=getNodeByRowColumnIndex(startY+1, startX, pane);

					next.getChildren().clear();
					Pane p=getNodeByRowColumnIndex(startY, startX, pane);
					Pane playerPane=(Pane) p.getChildren().get(0);
					playerPane.getChildren().clear();
					p.getChildren().clear();
					playerPane.getChildren().add(Player.getInstance().getImageView("right"));
					
					getNodeByRowColumnIndex(++startY,startX, pane).getChildren().add(playerPane)	;
					maze.setElement(startX, startY, 1);
					direction="right";
					
					
					Events e=new Events();
					e.addObserver(h);
					e.notifyAllObservers(Type.positive);
					
					
				} 
				else if(startY>0&&ground[startX][startY+1]==6 )
				{

					maze.setElement(startX, startY, 1);
					maze.setElement(startX, startY+1, 88);
					Pane next=getNodeByRowColumnIndex(startY+1, startX, pane);

					next.getChildren().clear();   //delete object
					Pane p=getNodeByRowColumnIndex(startY, startX, pane);
					Pane player=(Pane) p.getChildren().get(0);
					player.getChildren().clear();
					p.getChildren().clear();
					player.getChildren().add(Player.getInstance().getImageView("right"));
					
					getNodeByRowColumnIndex(++startY, startX, pane).getChildren().add(player)	;
					maze.setElement(startX, startY, 1);
					direction="right";
					
					
					Events e=new Events();
					e.addObserver(s);
					e.notifyAllObservers(Type.positive);
					
				}
				
				else if(startY>0&&ground[startX][startY+1]==7 )
				{

					maze.setElement(startX, startY, 1);
					maze.setElement(startX, startY+1, 88);
					Pane next=getNodeByRowColumnIndex(startY+1, startX, pane);

					next.getChildren().clear();   //delete object
					Pane p=getNodeByRowColumnIndex(startY, startX, pane);
					Pane player=(Pane) p.getChildren().get(0);
					player.getChildren().clear();
					p.getChildren().clear();
					player.getChildren().add(Player.getInstance().getImageView("right"));
					
					getNodeByRowColumnIndex(++startY, startX, pane).getChildren().add(player)	;
					maze.setElement(startX, startY, 1);
					direction="right";
		
					
					Events e=new Events();
					e.addObserver(s);
					e.notifyAllObservers(Type.albert);
					
					
				} 

				else if(startY>0&&ground[startX][startY+1]==4 )
				{

					maze.setElement(startX, startY, 1);
					maze.setElement(startX, startY+1, 88);
					Pane next=getNodeByRowColumnIndex(startY, startX+1, pane);

					next.getChildren().clear();   //delete object
					Pane p=getNodeByRowColumnIndex(startY, startX, pane);
					Pane player=(Pane) p.getChildren().get(0);
					player.getChildren().clear();
					p.getChildren().clear();
					player.getChildren().add(Player.getInstance().getImageView("right"));
					
					getNodeByRowColumnIndex(++startY, startX, pane).getChildren().add(player)	;
					maze.setElement(startX, startY, 1);
					direction="right";
					Events e= new Events();
					Bullet b= Bullet.getInstance();
					b.setProperties(startX, startY, direction);
					e.addObserver(b);
				e.setUpdate(Type.increase);
					break;
				} 
				
			
			
				else if(ground[startX][startY+1]==100)
					{
						Controller controller=new Controller();
						try {controller.setScene("Win",null);} catch (IOException e) {}
					
					break;}
				else if(ground[startX][startY+1]==10)
				{
				
					Events e= new Events();
			    	
			    	e.addObserver(h);
			    	
			    	e.setUpdate(Type.negative);
			   
				
				}	
				break;*/
				case SPACE:
	


			Bullet b= Bullet.getInstance();

			
			Amo=b.getNumberOfBullets();
			panee=pane;
			if(Amo!=0) {

				b.setProperties(startX, startY, direction);		
			Moving m=new Moving();
			m.bullet=b;
			m.start();
			Events e= new Events();
			e.addObserver(b);
			e.notifyAllObservers(Type.decrease);
			}
			break;
			
		case ESCAPE:
			Controller c=new Controller();
			c.setWindowFull();
			break;
		}
		}

	TimerTask task= new TimerTask()
		{
			boolean firstTime=true;
			int prevx, prevy;

			@Override
			public void run() {

	            Platform.runLater(() -> {
	          
				Maze maze=Maze.getInstance();
				int ground [][]=maze.getMaze();

				if(ground[bullet.getY()][bullet.getX()]==1||ground[bullet.getY()][bullet.getX()]==88) {
					System.out.println("fire");
					
					if(!firstTime)
					{
						Pane p=getNodeByRowColumnIndex(prevx,prevy, panee);
						p.getChildren().clear();
						
					}
					firstTime=false;

					
					bullet.updateLocation();
					Pane p=getNodeByRowColumnIndex(bullet.getX(), bullet.getY(), panee);
					ImageView iv=(bullet.getIcon());
					p.getChildren().add(iv);
					prevx=bullet.getX();
					prevy=bullet.getY();
					

				}else if(ground[bullet.getY()][bullet.getX()]==2) {
					ground[bullet.getY()][bullet.getX()]=1;
					
					//Amo--;
					//System.out.println(Amo);
				}
				else if	(ground[bullet.getY()][bullet.getX()]==777) {//Albert
					Controller.sleepAlbert();

					getNodeByRowColumnIndex(bullet.getY(),bullet.getX(), panee).getChildren().clear();;		
					getNodeByRowColumnIndex(bullet.getY()-1,bullet.getX(), panee).getChildren().clear();;		
					getNodeByRowColumnIndex(bullet.getY()+1,bullet.getX(), panee).getChildren().clear();;		
					getNodeByRowColumnIndex(bullet.getY(),bullet.getX()-1, panee).getChildren().clear();;	
					getNodeByRowColumnIndex(bullet.getY(),bullet.getX()+1, panee).getChildren().clear();;		
			
					
					Events e=new Events();
					
					e.addObserver(s);
					e.notifyAllObservers(Type.albert);
					maze.setElement(bullet.getX(), bullet.getY(), 1);
					myTimer.cancel();
					}
				else if	(ground[bullet.getY()][bullet.getX()]==999) {//Mucho
					Controller.sleepMucho();

					getNodeByRowColumnIndex(bullet.getY(),bullet.getX(), panee).getChildren().clear();;		
					getNodeByRowColumnIndex(bullet.getY()-1,bullet.getX(), panee).getChildren().clear();;		
					getNodeByRowColumnIndex(bullet.getY()+1,bullet.getX(), panee).getChildren().clear();;		
					getNodeByRowColumnIndex(bullet.getY(),bullet.getX()-1, panee).getChildren().clear();;	
					getNodeByRowColumnIndex(bullet.getY(),bullet.getX()+1, panee).getChildren().clear();;		
			
					
					Events e=new Events();
					
					e.addObserver(s);
					e.notifyAllObservers(Type.mucho);
					maze.setElement(bullet.getX(), bullet.getY(), 1);
					myTimer.cancel();
					}

				else
					{
					getNodeByRowColumnIndex(bullet.getX(),bullet.getY(),panee).getChildren().remove(bullet.getIcon());
					getNodeByRowColumnIndex(bullet.getX(),bullet.getY(),panee).getChildren().remove(bullet.getIcon());
			
					
					System.out.print("Stop bullet ");
					myTimer.cancel();
					}
			
			  });
			}
		};
	
	public void start()
	{
		myTimer.schedule(task,10,10);
	}
	@SuppressWarnings("static-access")
	public static Pane getNodeByRowColumnIndex (final int column, final int row, GridPane gridPane) {
	    Node result = null;
	    ObservableList<Node> childrens = gridPane.getChildren();

	    for (Node node : childrens) {
	    	
	        if(gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
	            result = node;
	            break;
	        }
	    }

	    return (Pane)result;
	}
/**For Monsters**/


}
  