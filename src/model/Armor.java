package model;

import java.util.Timer;
import java.util.TimerTask;

public class Armor extends NewPlayerDecorator {
	private boolean isShielded;
	Timer timer;
	  public boolean isShielded() {
		return isShielded;
	}
	public void setShielded(boolean isShielded) {
		this.isShielded = isShielded;
	}


	    public Armor(PlayerDecorator newPlayer) {
	       super(newPlayer);
		}
	    public void getarmor(int seconds) {
	    	System.out.println("done");
	    	
	    	timer = new Timer();
	    
	    	TimerTask t= new TimerTask() {

				@Override
				public void run() {
					   //timer.cancel(); //Terminate the timer thread
					   
			              System.out.println("finished");
				}
					};
	    	timer.schedule(t,seconds*1000);
        /*timer.schedule(new RemindTask(), seconds*1000);
        //isShielded=false;
        System.out.println("done");
	    }
	    class RemindTask extends TimerTask {
	        public void run() {
	            timer.cancel(); //Terminate the timer thread
              isShielded=false;
              System.out.println("finished");
	        }
	 
	    }*/

	
}
}
