import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Background {
	public int x,y,w,h,dx,dy;
	public ImageIcon img;
	
	public Background() {
		x=0;
		y=-300;
		w=7000;
		h=1000;
		dx=0;
		dy=0;
		img=new ImageIcon ("background.png");
	}

	public int getX() {
		return x;
	}
	public int getdy() {
		return dy;
	}
	public int getdx() {
		return dx;
	}

	public void setdy(int dyvalue) {
		this.dy=dyvalue;
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
	
	public void drawBackground(Graphics g2d) {
		g2d.drawImage(img.getImage(), x,y, w, h, null);
	}
	public void move() {
		
		x-=dx;
		y-=dy;
		
	}
}
