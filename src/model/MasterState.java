package model;

public class MasterState implements State {

	private MasterState() {}
	private static MasterState instance=null;
	public static MasterState getinstance()
	{
		if(instance==null)
		{
			instance=new MasterState();
		}
		return instance;
	}

	   public void doAction(Context context) {
	      context.setState(this);	
	   }

	   public void updatePlayer()
	   {
		   Player.getInstance().setX(2);
		   Bullet.getInstance().setX(2);

	   }
	  
	}