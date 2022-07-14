

	import javax.swing.ImageIcon;

public class Smoke extends Weapon {
 public Smoke() {
	 super();
 }
 public String toString() {
	 return "Fireball";
 }
 public Smoke(int x, int y) {
		super(x,y,60,60,new ImageIcon("smoke.png"));
	}
 public void move() { 
		setX(getX()-getdx());
		//setY(getY()-getdy());
	}
}


/*import java.awt.Graphics;

import javax.swing.ImageIcon;

	public class Smoke {
		private int  x, y, dx, dy, width, height;
		private ImageIcon image;
		private boolean reverse;
		private boolean reversey;
		private boolean moveup;
		private boolean moveright;
		
		public Smoke() {
			
			x=0;
			y=0;
			dx=1;
			dy=0;
			width=50;
			height=50;
			image= new ImageIcon("smoke.png");
			reverse=false;
			reversey=false;
			moveup=false;
			moveright=false;
		}
		public Smoke(int xv, int yv) {
			x=xv;
			y=yv;
		}
	public Smoke(int xv, int yv, int wv, int hv, ImageIcon img, int dxv) {
		x=xv;
		y=yv;
		width=wv;
		height=hv;
		image=img;
		dx=dxv;
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getW() {
		return width;
	}
	public int getH() {
		return height;
	}
	public void setdx(int dx1) {
		dx=dx1;
	}
	public int getdy() {
		return dy;
	}
	public int getdx() {
		return dx;
	}
	public void setdy(int dy1) {
		dy=dy1;
	}
	public void setX(int xv1) {
		x=xv1;
	}
	
	public void setY(int yv1) {
		y=yv1;
	}
	public ImageIcon getPic() {
		return image;
	}
	public void move() {
		setX(getX()-getdx());
		//y+=dy;
		//x+=dx;
	}
	public void drawSmoke(Graphics g2d) {
		g2d.drawImage(image.getImage(), x, y, width,height,null);
	}
	
	}*/
