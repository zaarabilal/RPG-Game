import javax.swing.ImageIcon;

public class Hurricane extends Specials {
	 public Hurricane() {
		 super();
	 }
	 public String toString() {
		 return "Wave";
	 }
	 public Hurricane(int x, int y) {
			super(x,400,60,60,new ImageIcon("hurricane.gif"));
		}
	 public void move() { 
			setX(getX()+getdx());
			
		}

}
