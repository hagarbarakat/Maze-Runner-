package model;


public class ShieldControl {
	ShieldState hasShield;
	ShieldState hasNotShield;
	
	ShieldState itsState;
	Boolean Shield = false;
	
	public ShieldControl() {
		hasShield = new hasShield();
		hasNotShield = new hasNotShield();
		
		itsState = hasNotShield;
		
		if(Shield == true) {
			itsState = hasShield;
		}
	}
	
	void setShieldState(ShieldState newState) {
		itsState = newState;
		
	}
	public void makeShielded() {
		Shield = true;
	}
	
	
	public void hasShield() {
		itsState.hasShield();
	}
	public void hasNotShield() {
		itsState.hasNotShield();
	}
	public ShieldState getHasShield() {
		return hasShield;
	}
	public ShieldState getNoShield() {
		return hasNotShield;
	}


}
