import java.awt.Graphics;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Special2 {

	private int x,y,width,height;
	private ImageIcon img;
	
	
	
	
	public Special2() {
		x=300;
		y=500;
		width=0;
		height=0;
		img=new ImageIcon("");
		
		
	}
	
	
	
public Special2(int xv, int yv, int wv, int hv, ImageIcon image) {
	x=xv;
	y=yv;
width=wv;
	height=hv;
	img=image;
	
}
public Special2(int xv, int yv) {
	x=xv;
	y=yv;
}


	public int getX() {
		return x;
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

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	

	

	
	public ImageIcon getImg() {
		return img;
	}

	public void setImg(ImageIcon img) {
		this.img = img;
	}
	

	public void drawSpecial2(Graphics g2d) {
		g2d.drawImage(img.getImage(), x, y, width,height,null);
	}
	
	
	public boolean CollisionP (Weapon c) {
		Rectangle player= new Rectangle (getX(), getY(), getWidth()-50, getHeight()-50);
		Rectangle enemy= new Rectangle (c.getX(), c.getY(), c.getW(), c.getH());
	
	if(player.intersects(enemy)) {
			return true;
			
			
		}
		return false;
	}
	
	
	
}
