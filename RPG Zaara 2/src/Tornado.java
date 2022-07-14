import javax.swing.ImageIcon;

public class Tornado extends Weapon{
	 public Tornado() {
		 super();
	 }
	 public String toString() {
		 return "Tornado";
	 }
	 public Tornado(int x, int y) {
			super(20,500,60,60,new ImageIcon("tornado.png"));
		}
	 public void move() { 
			setX(getX()+getdx());
			
		}
}
