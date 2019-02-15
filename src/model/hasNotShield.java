package model;


public class hasNotShield implements ShieldState{
	ShieldControl control;
	
	public hasNotShield() {
		control.Shield = false;
	}

	@Override
	public void hasShield() {
		control.setShieldState(control.getHasShield());
		
	}

	@Override
	public void hasNotShield() {
		System.out.println("Already Not Shielded");
		
	}
	
}
