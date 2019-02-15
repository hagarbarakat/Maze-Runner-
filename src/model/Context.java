package model;

public class Context {
	   private State state;

	   private static Context instance=null;
	   public static Context getInstance()
	   {
		   if(instance==null)
		   {
			   instance=new Context();
		   }
		   return instance;
	   }
	   private Context(){
	      state = null;
	   }

	   public void setState(State state){
	      this.state = state;		
	   }

	   public State getState(){
	      return state;
	   }
	}