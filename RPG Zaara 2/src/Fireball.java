import javax.swing.ImageIcon;

public class Fireball extends Weapon {
 public Fireball() {
	 super();
 }
 public String toString() {
	 return "Fireball";
 }
 public Fireball(int x, int y) {
		super(x,400,60,60,new ImageIcon("fireball.png"));
	}
 public void move() { 
		setX(getX()+getdx());
		
	}
}
