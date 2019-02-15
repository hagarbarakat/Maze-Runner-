package game;

public class Armor extends PlayerArmorDecorator {

	public Armor(Player newPlayer) {
		super(newPlayer);
		// TODO Auto-generated constructor stub
		System.out.println("Adding New player");
		System.out.println("Adding Armor");
	}

	 public String doit(){
		
		 return tempPlayer.doit() + ", ARMOOOOR";
	}
	
}
