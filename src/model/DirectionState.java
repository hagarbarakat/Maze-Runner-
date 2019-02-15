package model;

import javafx.scene.layout.GridPane;

public interface DirectionState {
	   public void doAction(DirectionContext context);
	   public void updateDirection();
	   public void updateInfo(	GridPane pane,Bullet b,int startX,int startY,String d);

}
