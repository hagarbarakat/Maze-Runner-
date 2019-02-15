package model;



public class Shoot {
	Bullet bullet=null;

	
		
	public Shoot(int startX,int startY,String direction)
	{

		Bullet b= Bullet.getInstance();
		b.setProperties(startX, startY, direction);		
		this.bullet=bullet;
		
		
	}
	public Bullet getBullet() {
		return bullet;
	}
}
