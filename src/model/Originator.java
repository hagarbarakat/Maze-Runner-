package model;

public class Originator{
	private Originator() {}
	private static Originator instance=null;
	public static Originator getInstance()
	{
		if(instance==null)
		{
			instance=new Originator();
		}
		return instance;
	}

	private Checkpoint cp;

	// Sets the value for the article
	
	public void set( Checkpoint newCp) { 
		System.out.println("From Originator: Current Version of Checkpoint\n"+newCp+ "\n");
	    this.cp = newCp; 
	}

	// Creates a new Memento with a new checkpoint
	
	public Memento storeInMemento() { 
	   // System.out.println("From Originator: Saving to Memento");
	    return new Memento(cp); 
	}
	   
	// Gets the article currently stored in memento
	
	public Checkpoint restoreFromMemento(Memento memento) {
		   
		cp =  memento.getSavedArticle(); 
	       
		System.out.println("From Originator: Previous Checkpoint Saved in Memento\n"+cp + "\n");
		
		return cp;
	   
	}
	
}