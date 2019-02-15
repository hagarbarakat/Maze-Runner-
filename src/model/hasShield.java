package model;


public class hasShield implements ShieldState{
	ShieldControl control;
	
	public hasShield() {
		control.Shield = true;
	}

	@Override
	public void hasShield() {
		System.out.println("Already Shielded");
		
	}

	@Override
	public void hasNotShield() {
		control.setShieldState(control.getNoShield());
		
	}

}
