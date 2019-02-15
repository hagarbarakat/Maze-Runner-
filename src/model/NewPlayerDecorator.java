package model;

public abstract class NewPlayerDecorator implements PlayerDecorator {
protected PlayerDecorator p1;
private boolean isShielded = false;
public boolean isShielded() {
	return isShielded;
}
public void setShielded(boolean isShielded) {
	this.isShielded = isShielded;
}
public NewPlayerDecorator(PlayerDecorator p1) {
	this.p1=p1;
}
public void getarmor() {
	
}
}
