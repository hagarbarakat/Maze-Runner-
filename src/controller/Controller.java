package controller;

import java.io.IOException;
import java.util.Random;


import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Albert;
import model.BeginnerState;
import model.Bullet;
import model.Caretaker;
import model.Checkpoint;
import model.Context;
import model.LoadData;
import model.MasterState;
import model.Maze;
import model.Moving;
import model.Mucho;
import model.Originator;
import model.Player;
import model.Save;
import javafx.scene.input.KeyEvent;

public class Controller {
    static Context context =  Context.getInstance();

   static MasterState masterState =  MasterState.getinstance();


    static BeginnerState beginnerState =  BeginnerState.getinstance();
	@FXML 
	private static GridPane pane;	
	@FXML 
	private static Pane rootPane,lose,win,playerPane=new Pane(),out,start,main;
	//ALL_PANES[9]=playerPane;
	private static Stage primaryStage;
		
	@FXML 
	private static Label bulletLabel,scoreLabel,healthLabel,coinLabel;
	@FXML
	public void save(ActionEvent e)
	{
		Save s=new Save();
		Checkpoint c=(Originator.getInstance().restoreFromMemento(Caretaker.getInstance().getMemento(0)));

		
		s.savefile(c.getMaze(),c.getBullets(),c.getHealth(),c.getScore()  );
		
	}
	@FXML
	public void pause(ActionEvent e)
	{
		
	}
	
	public   void setScene(String sc, String string) throws IOException
	{
		if(sc.equals("Win")) {
			 win =  FXMLLoader.load(getClass().getResource("/view/Win.fxml"));
			 rootPane.getChildren().clear();

			rootPane.getChildren().addAll(win);
					}else if(sc.equals("Lose"))
					{
						 lose =  FXMLLoader.load(getClass().getResource("/view/Lose.fxml"));

						 rootPane.getChildren().clear();
			
						rootPane.getChildren().addAll(lose);
						
		}else if(sc.equals("start"))
		{
			 start =  FXMLLoader.load(getClass().getResource("/view/Start.fxml"));

			 rootPane.getChildren().clear();

			rootPane.getChildren().addAll(start);
			
}
		else if(sc.equals("out"))
		{
			 out =  FXMLLoader.load(getClass().getResource("/view/out.fxml"));

			rootPane.getChildren().clear();

			rootPane.getChildren().addAll(out);
			
}
		else if(sc.equals("main"))
		{
			 main =  FXMLLoader.load(getClass().getResource("/view/Main.fxml"));

			 rootPane.getChildren().clear();

			rootPane.getChildren().addAll(main);
			
}

		
		
		
	}
	
	
	@FXML private void what (ActionEvent e) throws IOException {
		setScene("first", null);
		
		
	}
	
	@FXML private void playGame (ActionEvent e) throws IOException {
		setScene("second", null);
		
		
	}
	
	
	
	public static void setBulletsLabel(int i)
	{
		bulletLabel.setText(Integer.toString(i));;
		
	}
		
	public static javafx.scene.control.Label getHealthlabel()
	{
		
		return healthLabel;
		
	}
	
	public static void setHealthLabel(int i)
	{
		healthLabel.setText(Integer.toString(i));;

		
	}
	public static void setScoreLabel(int i)
	{
		scoreLabel.setText(Integer.toString(i));;
		
	}
	

	
	public static void startGame(FXMLLoader loader,Stage primaryStagee, String string)
	{
		primaryStage=primaryStagee;
		Parent root;
		try {
			beginnerState.doAction(context);
			context.getState().updatePlayer();
			
			root = loader.load();
			pane=(GridPane)loader.getNamespace().get("pane");  
			rootPane=(Pane)loader.getNamespace().get("rootPane");  
			buildMaze(string);
			Scene scene = new Scene(root);
			scene.addEventFilter(KeyEvent.KEY_PRESSED,e ->Moving.update(e.getCode(), pane));
			bulletLabel=(Label)loader.getNamespace().get("bulletLabel") ;
			setBulletsLabel(6 );
			scoreLabel=(Label)loader.getNamespace().get("scoreLabel") ;
			setScoreLabel(0 );
			healthLabel=(Label)loader.getNamespace().get("healthLabel") ;
			setHealthLabel(100 );


			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public static void buildMaze(String string)
	{
		Bullet b=Bullet.getInstance();
		b.setProperties(0, 0, "start");
		Maze grid=Maze.getInstance();
		//Moving.run();
		int x[][]=grid.getMaze();
		
		
		if(string.equals("load"))
		{
			x=LoadData.loadData();
			
		}
		for(int j=0;j<30;j++)
			for(int i=0;i<30;i++)
			{
				
				if(x[i][j]==1||x[i][j]==100)
				{
					Pane p=new Pane();
					p.setMinSize(30, 30);
					p.setStyle("-fx-background-image: url(\"flower.png\") " );		
					pane.add(p, j, i);
				}
				else if (x[i][j]==0)
				{
					Pane p=new Pane();
					p.setMinSize(30, 30);
					p.setStyle("-fx-background-image: url(\"wall22.jpg\")");
					pane.add(p, j, i);
				}

				else if (x[i][j]==2)
				{
					Pane p=new Pane();
					p.setMinSize(30, 30);
					p.getChildren().add(new ImageView(new Image("/tree5.png")));
					p.setStyle("-fx-background-image: url(\"flower.png\")");
					pane.add(p, j, i);
				}
				else if (x[i][j]==4)
				{
					Pane p=new Pane();
					p.setMinSize(30, 30); 
					p.getChildren().add(new ImageView(new Image("/bullet11.gif")));
					p.setStyle("-fx-background-image: url(\"flower.png\")");
					pane.add(p, j, i);
					
				}
				else if (x[i][j]==15)
				{
					Pane p=new Pane();
					p.setMinSize(30, 30);
					p.getChildren().add(new ImageView(new Image("view/exclaimedBomb.png")));
					p.setStyle("-fx-background-image: url(\"flower.png\")");
					pane.add(p, j, i);
				}
				else if (x[i][j]==10)
				{
					Pane p=new Pane();
					p.setMinSize(30, 30);
					p.getChildren().add(new ImageView(new Image("/exclaimedBomb.png")));
					p.setStyle("-fx-background-image: url(\"flower.png\")");
					pane.add(p, j, i);
				}
				else if(x[i][j]==99) {
					
					Pane p=new Pane();
					p.setMinSize(30, 30); 
					p.getChildren().add(new ImageView(new Image("/bomb.jpg")));
					p.setStyle("-fx-background-image: url(\"flower.png\")");
					pane.add(p, j, i);
					
				}
				else if (x[i][j]==5)
				{
					Pane p=new Pane();
					p.setMinSize(30, 30); 
					p.getChildren().add(new ImageView(new Image("/heart.gif")));
					p.setStyle("-fx-background-image: url(\"flower.png\")");
					pane.add(p, j, i);
					
				}
				
				else if (x[i][j]==6)
				{
					Pane p=new Pane();
					p.setMinSize(30, 30); 
					p.getChildren().add(new ImageView(new Image("/small.gif")));
					p.setStyle("-fx-background-image: url(\"flower.png\")");
					pane.add(p, j, i);
					
				}
				
				else if (x[i][j]==7)
				{
					Pane p=new Pane();
					 p.setMinSize(30, 30); 
					p.getChildren().add(new ImageView(new Image("/big.gif")));
					p.setStyle("-fx-background-image: url(\"flower.png\")");
					pane.add(p, j, i);
					
				}
				else if (x[i][j]==25)
				{
					Pane p=new Pane();
					 p.setMinSize(30, 30); 
					p.getChildren().add(new ImageView(new Image("/flag.png")));
					p.setStyle("-fx-background-image: url(\"flower.png\")");
					pane.add(p, j, i);
				}
				else if (x[i][j]==17) {
					
					
					Pane p=new Pane();
					 p.setMinSize(30, 30); 
					p.getChildren().add(new ImageView(new Image("/shield.gif")));
					p.setStyle("-fx-background-image: url(\"flower.png\")");
					pane.add(p, j, i);
				}
				
				
			}
				
				//Player p1=  Player.getInstance();
		//Pane player=new Pane();
		
				playerPane.setMinSize(20, 20);
				playerPane.getChildren().add(new ImageView(new Image("/down.png")));
		Pane meh=Moving.getNodeByRowColumnIndex(1,0,pane);
		meh.getChildren().add(playerPane);

		Albert albert=Albert.getInstance();
		Pane albertCell=Moving.getNodeByRowColumnIndex(albert.getLocationY(),albert.getLocationX(),pane);
		albertCell.getChildren().add(new ImageView(albert.getIcon()));
		
		Mucho mucho=Mucho.getInstance();
		Pane muchoCell=Moving.getNodeByRowColumnIndex(mucho.getLocationY(),mucho.getLocationX(),pane);
		muchoCell.getChildren().add(new ImageView(mucho.getIcon()));
		

    		
       
    			

	}

	public void setWindowFull() {
		//primaryStage.setFullScreen(true);
		}

	private static AnimationTimer timerAlbert;
	public static void wakeAlbert() {


		timerAlbert=new AnimationTimer() {
		boolean firstTime=true;
		//int prevx, prevy;
		private long last=0;

		
		@Override
		public void handle(long now) {
			
			Maze maze=Maze.getInstance();

			if((now-last)<200_109_000) {
				
			}else {
				last=now;
         			Albert albert=Albert.getInstance();
					//maze.setElement(albert.getX(), albert.getY(), 1);

	            	if(firstTime)
					{
							Pane p=Moving.getNodeByRowColumnIndex(albert.getY(),albert.getX(), pane);
							p.getChildren().clear();
							

						
						}else
						{
							Pane p=Moving.getNodeByRowColumnIndex(albert.getPrevx(),albert.getPrevy(), pane);
							maze.setElement(albert.getPrevy(), albert.getPrevx(), 1);

							p.getChildren().clear();
						
						}
					firstTime=false;
		            	Random r= new Random();
		            	int i;


         			int meh;
         			boolean heh=true;
					do {
						meh=0;
						


	            	 i=r.nextInt(4);

	            	 try {
		            	 
		            	 //which direction the monster will move
		            	 if(i==0)//up
		            	 {
		            			albert.setDirection("up");
		            			meh=maze.getMaze()[albert.getPrevy()-1][albert.getPrevx()];

		            			if(meh==1)break;

		            	 }else if (i==2)//down
		            	 {
            			albert.setDirection("down");
		            			meh=maze.getMaze()[albert.getPrevy()+1][albert.getPrevx()];

		            			if(meh==1)break;

		            	 }else if(i==1)//left
	            	 {
	            			albert.setDirection("left");
	            			meh=maze.getMaze()[albert.getPrevy()][albert.getPrevx()-1];

	            			if(meh==1)break;

		            	 }else if(i==3)//right
		            	 {
	            			albert.setDirection("right");
            			meh=maze.getMaze()[albert.getPrevy()][albert.getPrevx()+1];
		            	 }
            			if(meh==1)break;
            			if(meh==88)
            				{
            				Controller c=new Controller();
            				c.setScene("Lose","Albert has eaten you !");
            				}
		            	 
	            	 }catch(Exception e) {}
         			}while(heh);
					albert.updateLocation();

			           /// System.out.println("!heh albert= "+albert.getX()+" "+albert.getY()+" "+albert.getPrevx()+" "+albert.getPrevy());


						
					playerPane=Moving.getNodeByRowColumnIndex(albert.getX(), albert.getY(), pane);
						ImageView iv=new ImageView(albert.getIcon());
						playerPane.getChildren().add(iv);
						albert.setPrevx(albert.getX());
						albert.setPrevy(albert.getY());
						maze.setElement(albert.getPrevy(), albert.getPrevx(), 777);

					
		            }
					
					
		}
 



					
				
		
			};
	 timerAlbert.start();

	
	 
}
	 static AnimationTimer timer;
	public static void wakeMucho()
	{



		timer=new AnimationTimer() {
				boolean firstTime=true;
			int prevx, prevy;
			private long last=0;


			@Override
			public void handle(long now) {
				
				// TODO Auto-generated method stub
				Maze maze=Maze.getInstance();

				if((now-last)<200_109_0_000) {
					
				}else {
					System.out.println();

					last=now;
	         			Mucho mucho=Mucho.getInstance();
						//maze.setElement(albert.getX(), albert.getY(), 1);

		            	if(firstTime)
						{
								Pane p=Moving.getNodeByRowColumnIndex(mucho.getY(),mucho.getX(), pane);
								p.getChildren().clear();
								

							
							}else
							{
								Pane p=Moving.getNodeByRowColumnIndex(prevx,prevy, pane);
								maze.setElement(prevy, prevx, 1);

								p.getChildren().clear();
							
							}
						firstTime=false;
			            	Random r= new Random();
			            	int i;


	         			int meh;
	         			boolean heh=true;
						do {
							meh=0;
							


		            	 i=r.nextInt(4);

		            	 try {
			            	 
			            	 //which direction the monster will move
			            	 if(i==0)//up
			            	 {
			            			mucho.setDirection("up");
			            			meh=maze.getMaze()[prevy-1][prevx];

			            			if(meh==1)break;

			            	 }else if (i==2)//down
			            	 {
	            			mucho.setDirection("down");
			            			meh=maze.getMaze()[prevy+1][prevx];

			            			if(meh==1)break;

			            	 }else if(i==1)//left
		            	 {
		            			mucho.setDirection("left");
		            			meh=maze.getMaze()[prevy][prevx-1];

		            			if(meh==1)break;

			            	 }else if(i==3)//right
			            	 {
		            			mucho.setDirection("right");
	            			meh=maze.getMaze()[prevy][prevx+1];
			            	 }
	            			if(meh==1)break;
	            			if(meh==88)
	            				{
 
	            				reMaze(Originator.getInstance().restoreFromMemento(Caretaker.getInstance().getMemento(0)));
	            				Maze.getInstance().setElement(prevx, prevy, 1);
	            				this.stop();
	            				}
			            	 
		            	 }catch(Exception e) {}

	         			}while(heh);
			
							mucho.updateLocation();
							
							Pane p=Moving.getNodeByRowColumnIndex(mucho.getX(), mucho.getY(), pane);
							ImageView iv=new ImageView(mucho.getIcon());
							p.getChildren().add(iv);
							prevx=mucho.getX();
							prevy=mucho.getY();
							maze.setElement(prevy, prevx, 999);

						
			            }
						
						
			}
	 



						
					
			
				};
				
		 timer.start();

		

	}
	public static void sleepAlbert()
	{
		timerAlbert.stop();
	}	public static void sleepMucho()
	{
		timer.stop();
	}
	
	public static void reMaze(Checkpoint cp)
	{
		System.out.println("REMAZE====================================");
		int [][]x=cp.getMaze();
		for(int i=0;i<30;i++)
		{
			System.out.print("{");
			for(int j=0;j<30;j++)
			{
				System.out.print(x[i][j]+" ");
				
				
				
			}
			System.out.println("}");

		}
		//pane= new GridPane();
		
		for(int j=0;j<30;j++)
			for(int i=0;i<30;i++)
			{
				Moving.getNodeByRowColumnIndex(j,i, pane).getChildren().clear();
				
				Maze.getInstance().setElement(i, j, x[i][j]);
				if(x[i][j]==1||x[i][j]==100)
				{
					Pane p=new Pane();
					p.setMinSize(30, 30);
					p.setStyle("-fx-background-image: url(\"flower.png\") " );		
					pane.add(p, j, i);
				}
				else if (x[i][j]==0)
				{
					 Pane p=new Pane();
					p.setMinSize(30, 30);
					p.setStyle("-fx-background-image: url(\"wall22.jpg\")");
					pane.add(p, j, i);
				}

				else if (x[i][j]==2)
				{
					Pane p=new Pane();
					p.setMinSize(30, 30);
					p.getChildren().add(new ImageView(new Image("/tree5.png")));
					p.setStyle("-fx-background-image: url(\"flower.png\")");
					pane.add(p, j, i);
				}
				else if (x[i][j]==4)
				{
					Pane p=new Pane();
					p.setMinSize(30, 30); 
					p.getChildren().add(new ImageView(new Image("/bullet11.gif")));
					p.setStyle("-fx-background-image: url(\"flower.png\")");
					pane.add(p, j, i);
					
				}
				else if (x[i][j]==15)
				{
					Pane p=new Pane();
					p.setMinSize(30, 30);
					p.getChildren().add(new ImageView(new Image("view/exclaimedBomb.png")));
					p.setStyle("-fx-background-image: url(\"flower.png\")");
					pane.add(p, j, i);
				}
				else if (x[i][j]==10)
				{
					Pane p=new Pane();
					p.setMinSize(30, 30);
					p.getChildren().add(new ImageView(new Image("/exclaimedBomb.png")));
					p.setStyle("-fx-background-image: url(\"flower.png\")");
					pane.add(p, j, i);
				}
				else if (x[i][j]==5)
				{
					Pane p=new Pane();
					p.setMinSize(30, 30); 
					p.getChildren().add(new ImageView(new Image("/heart.gif")));
					p.setStyle("-fx-background-image: url(\"flower.png\")");
					pane.add(p, j, i);
					
				}
				
				else if (x[i][j]==6)
				{
					Pane p=new Pane();
					p.setMinSize(30, 30); 
					p.getChildren().add(new ImageView(new Image("/small.gif")));
					p.setStyle("-fx-background-image: url(\"flower.png\")");
					pane.add(p, j, i);
					
				}
				
				else if (x[i][j]==7)
				{
					Pane p=new Pane();
					p.setMinSize(30, 30); 
					p.getChildren().add(new ImageView(new Image("/big.gif")));
					p.setStyle("-fx-background-image: url(\"flower.png\")");
					pane.add(p, j, i);
					
				}
				else if (x[i][j]==25)
				{
					Pane p=new Pane();
					p.setMinSize(30, 30); 
					p.getChildren().add(new ImageView(new Image("/flag.png")));
					p.setStyle("-fx-background-image: url(\"flower.png\")");
					pane.add(p, j, i);
				}
				else if(x[i][j]==88)
				{
					Maze.getInstance().setElement(i, j, 1);
					j++;
				Pane player=new Pane();
				player.setMinSize(20, 20);
				player.getChildren().add(Player.getInstance().getImageView("right"));
				Pane meh=Moving.getNodeByRowColumnIndex(j,i,pane);
				meh.getChildren().add(player);
				
				}
				else if(x[i][j]==777)
				{					

					Albert.getInstance().setPrevx(Albert.getInstance().getX());
					Albert.getInstance().setPrevy(Albert.getInstance().getY());
					Albert.getInstance().setLocationX(i);
					Albert.getInstance().setLocationY(j);
					Moving.getNodeByRowColumnIndex(j, i, pane).getChildren().add(new ImageView(Albert.getInstance().getIcon()));
//					wakeAlbert().timerAlbert.updatePrev();					
				}
	

				
				
		
			}
		
		
				

	}
//	@FXML
//	private void print(ActionEvent e) {
//		Maze m=Maze.getInstance();
//		for(int[] i: m.getMaze())
//		{
//			for(int j: i)
//			{
//				System.out.print(j);
//			}
//			System.out.println("");
//		
//	}
//	}
}
