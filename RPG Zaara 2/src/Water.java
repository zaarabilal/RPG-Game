import javax.swing.ImageIcon;

public class Water extends Character {
	public Water() {
		super();
	}

	public Water (int x,int y) {
		super(x,y,400,300, new ImageIcon("water.png"), new Tsunami(x,y), new Wave(x,y));
	}
}
