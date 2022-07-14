import javax.swing.ImageIcon;

public class Enemy extends Character {
	public Enemy() {
		super();
		
	}

	public Enemy (int x,int y) {
		super(x,y,250,250, new ImageIcon("pollution.png"),new Smoke(x,y));
	}
	public void move() {
		setX(getX()-1);
	}
	
}
