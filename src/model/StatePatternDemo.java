package model;

public class StatePatternDemo{
	 public static void main(String[] args) {
	      Context context =  Context.getInstance();

	      MasterState startState =  MasterState.getinstance();
	      startState.doAction(context);

	      System.out.println(context.getState().toString());

	      BeginnerState stopState =  BeginnerState.getinstance();
	      stopState.doAction(context);

	      System.out.println(context.getState().toString());
	   }

	}
