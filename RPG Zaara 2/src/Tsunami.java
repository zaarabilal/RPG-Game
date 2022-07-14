import javax.swing.ImageIcon;

public class Tsunami extends Weapon{
	public Tsunami() {
		 super();
		 
	}
		 public String toString() {
			 return "Tsunami";
		 }
		 public Tsunami(int x, int y) {
				super(20,500,60,60,new ImageIcon("tsunami.png"));
			}
		 public void move() { 
				setX(getX()+getdx());
				
			}
}
