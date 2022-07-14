import javax.swing.ImageIcon;

public class Air extends Character {

	public Air() {
		super();
	}

	public Air (int x,int y) {
		super(x,y,250,250, new ImageIcon("air.png"), new Tornado(x,y), new Hurricane(x,y));
	}
}
