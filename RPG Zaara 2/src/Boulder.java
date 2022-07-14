import javax.swing.ImageIcon;

public class Boulder extends Weapon {
public Boulder() {
	super();
}
public String toString() {
	 return "Boulder";
}
public Boulder(int x, int y) {
	super(x,400,60,60,new ImageIcon("boulder.png"));
}
public void move() { 
	setX(getX()+getdx());
	
}
}
