package model;


public class Memento {
	
	// The article stored in memento Object
	
	private Checkpoint cp;

	// Save a new article String to the memento Object
	
	public Memento( Checkpoint  cp) { this.cp = cp; }
	
	// Return the value stored in article 
	
	public Checkpoint  getSavedArticle() { return cp; }
	
}