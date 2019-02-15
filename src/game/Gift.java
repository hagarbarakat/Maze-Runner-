package game;

public  abstract class Gift {
	private String name;
	private double amtgift;
	
	
	public String getName()
	{
		return name; 
	}
	
	public void setName(String newName)
	{
		name = newName; 
	}
	
	public double getgift()
	{
		return amtgift;
	}
	
	public void setgift(double newamtgift)
	{
		amtgift = newamtgift; 
	}
	
	
	public void displayGift()
	{
		System.out.println(" the player won: " + getName()  );		
    }
	
}
