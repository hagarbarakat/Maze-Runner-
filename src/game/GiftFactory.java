package game;

public class GiftFactory {

	public Gift makeGift (String newGiftType) {
		
	     Gift newGift = null;
		
		if (newGiftType.equals("S"))
		{            	
			 return new Smalllife();
	    }
		
		else if (newGiftType.equals("A"))
		{
			 return new Amo();
		}
		else return null;	
}
}