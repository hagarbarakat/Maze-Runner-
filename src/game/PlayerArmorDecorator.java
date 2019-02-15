package game;

abstract class PlayerArmorDecorator implements Player{
	
	protected Player tempPlayer;
	
public PlayerArmorDecorator(Player newPlayer){
		
		tempPlayer = newPlayer;
		
	}
public String doit() {
	
    return tempPlayer.doit();
}


}
