import javax.swing.ImageIcon;

public class Earth extends Character {
	public Earth() {
		super();
	}

	public Earth (int x,int y) {
		super(x,y,250,250, new ImageIcon("earth.png"),new Boulder(x,y), new Earthwall(x,y));
	}
}
