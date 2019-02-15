package model;

public class BeginnerState implements State {

	private BeginnerState() {}
	private static BeginnerState instance=null;
	public static BeginnerState getinstance()
	{
		if(instance==null)
		{
			instance=new BeginnerState();
		}
		return instance;
	}
	   public void doAction(Context context) {
	      context.setState(this);	
	   }
	   
	   public void updatePlayer()
	   {
		   Player.getInstance().setX(1);
		   Bullet.getInstance().setX(1);
	   }
	   
	}