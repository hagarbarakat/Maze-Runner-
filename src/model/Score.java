package model;

import controller.Controller;

public class Score implements Observer {

    private int score;

    public static Score getInstance()
    {
    	if(instance==null)
    	{
    		instance=new Score();
    		
    	}
    	return instance;
    }
    private static Score instance=null;
    private Score() {
        this.score = 0;
    }


	@Override
	
	public void update(Type type) {
		 if(type==Type.albert )
		{
				this.score+=100;
		}else if(type==Type.positive)

		{
			this.score+=10;

			
		}
		else if(type==Type.mucho)
		{
			this.score+=50;
		}
		 
		 if(score>200)
		 {
			 Context c= Context.getInstance();
			 MasterState ms= MasterState.getinstance();
			 ms.doAction(c);
			 c.getState().updatePlayer();
			
		 }
			Controller.setScoreLabel(((score)));

		
	}
	public int getScore()
	{
		return this.score;
	}



}
