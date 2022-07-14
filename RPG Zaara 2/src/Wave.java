import javax.swing.ImageIcon;

public class Wave extends Specials{
	
	
		 public Wave() {
			 super();
		 }
		 public String toString() {
			 return "Wave";
		 }
		 public Wave(int x, int y) {
				super(x,400,100,100,new ImageIcon("waves.gif"));
			}
		 public void move() { 
				setX(getX()+getdx());
				
			}
}
