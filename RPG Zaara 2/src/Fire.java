import javax.swing.ImageIcon;

public class Fire extends Character{
	
	public Fire() {
		super();
	}

	public Fire (int x,int y) {
		super(x,y,300,300, new ImageIcon("fire.png"), new Fireball(x,y), new Firewall (x,y));
	}
	
}
