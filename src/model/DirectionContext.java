package model;

public class DirectionContext {
	   private DirectionState state;

	   private static DirectionContext instance=null;
	   public static DirectionContext getInstance()
	   {
		   if(instance==null)
		   {
			   instance=new DirectionContext();
		   }
		   return instance;
	   }
	   private DirectionContext(){
	      state = null;
	   }

	   public void setState(DirectionState state){
	      this.state = state;		
	   }

	   public DirectionState getState(){
	      return state;
	   }

}
