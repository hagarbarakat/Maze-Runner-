package model;

import controller.Controller;

public class Health implements Observer {

    private int health;

    public Health() {
        this.health = 100;
    }



	@Override
	public void update(Type type) {

		if(type==Type.minus&&health>9)
		{
			this.health-=10;
		}
		else if(type==Type.plus)
		{
			this.health+=10;
		}else if(type==Type.dead)
		{
			this.health=0;
		}
		else if (type==Type.fixed) {
			setHealth(this.health);
		
	}
	Controller.setHealthLabel(((health)));
	}
	public void setHealth(int health) {
		this.health = health;
	}



	public int getHealth()
	{
		return this.health;
	}
}
