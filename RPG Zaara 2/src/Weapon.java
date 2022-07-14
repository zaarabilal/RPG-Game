import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Weapon {
	private int x,y,w,h,dy,dx;
	private ImageIcon img;
	
	public Weapon() {
		x=400;
		y=300;
		w=100;
		h=100;
		dy=0;
		dx=0;
		img= new ImageIcon("");
	}
	public Weapon(int xV, int yV, int width, int height,ImageIcon i) {
		x=xV;
		y=yV;
		w=width;
		h=height;
		img=i;
		
		
	}
	public Weapon(int xV, int yV, int width, int height,ImageIcon i, int dxs) {
		x=xV;
		y=yV;
		w=width;
		h=height;
		img=i;
		dx=dxs;
		
	}
	
	public Weapon(int xV, int yV) {
		x=xV;
		y=yV;
	}
	
	public void changeBg(int b) {
		y+=(b/2);
		//x+=(b);
	}
	public void changeBgx(int b) {
		x+=(b/2);
		//x+=(b);
	}

public String toString() {
	return "Weapon";
}
	public int getX() {
		return x;
	}
public int getdy() {
	return dy;
}
public void setdy(int dyvalue) {
	this.dy=dyvalue;
}
public int getdx() {
	return dx;
}
public void setdx(int dxvalue) {
	this.dx=dxvalue;
}
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public ImageIcon getImg() {
		return img;
	}

	public void setImg(ImageIcon img) {
		this.img = img;
	}
	public void move() {
		x+=dx;
	}
	public void drawWeapon(Graphics g2d) {
		g2d.drawImage(img.getImage(), x, y, 100,100,null);
	}
	public boolean Collision (Character c) {
		Rectangle player= new Rectangle (getX(), getY(), getW(), getH());
		Rectangle enemy= new Rectangle (c.getX(), c.getY(), c.getWidth(), c.getHeight());
	
		if(player.intersects(enemy)) {
			return true;
			
			
		}
		return false;
	}
	public boolean CollisionPl (Character c) {
		Rectangle player= new Rectangle (getX(), getY(), getW(), getH());
		Rectangle enemy= new Rectangle (c.getX(), c.getY(), c.getWidth()-50, c.getHeight()-50);
	
		if(player.intersects(enemy)) {
			return true;
			
			
		}
		return false;
	}
	public boolean CollisionW (Weapon c) {
		Rectangle player= new Rectangle (getX(), getY(), getW(), getH());
		Rectangle enemy= new Rectangle (c.getX(), c.getY(), c.getW(), c.getH());
	
		if(player.intersects(enemy)) {
			return true;
			
			
		}
		return false;
	}
	

	
}

