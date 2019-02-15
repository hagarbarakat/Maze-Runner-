package model;

//Memento Design Pattern Tutorial

import java.util.ArrayList;

public class Caretaker {
	
	
	private Caretaker() {}
	private static Caretaker instance=null;
	public static Caretaker getInstance()
	{
		if(instance==null)
		{
			instance=new Caretaker();
		}
		return instance;
	}
	// Where all mementos are saved
	
	ArrayList<Memento> savedCheckpoints = new ArrayList<Memento>();


	// Adds memento to the ArrayList
	
	public void addMemento(Memento m) { 
		
		
		savedCheckpoints.add(m); }	
	
	
	public int getSize()
	{
		return savedCheckpoints.size();
	}
	public void removeMemento() { 
			
			int i=savedCheckpoints.size();
			savedCheckpoints.remove(i-1); 
			}
	
	public boolean isEmpty()
	{
		
		if(savedCheckpoints.isEmpty())
		{
			return true;
		}
		return false;
	}

	// Gets the memento requested from the ArrayList
	
	public Memento getMemento(int index) { return savedCheckpoints.get(index); }
	
	public void print()
	{
		for(int i=0;i<savedCheckpoints.size();i++)
		{
			System.out.print(" "+savedCheckpoints.get(i));
		}
	}

} 
