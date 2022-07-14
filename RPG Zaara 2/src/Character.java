import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Character {

	private int x,y,width,height,dx,dy,lives;
	private ImageIcon img;
	private Weapon weapon;
	private Specials specials;
	private Smoke smoke;
	private Special2 special2;
	
	public Character() {
		x=0;
		y=0;
		width=0;
		height=0;
		dx=0;
		dy=0;
		lives=5;
		img=new ImageIcon("");
		weapon= new Weapon();
		smoke= new Smoke();
		
	}
	
	public Character(int xV, int yV, int w, int h, ImageIcon i, Weapon we, Specials spec) {
		x=xV;
		y=yV;
		width=w;
		height=h;
		dx=0;
		dy=0;
		
		img=i;
		weapon=we;
		specials=spec;
	}
	public Character(int xV, int yV, int w, int h,  ImageIcon i, Weapon we, Special2 spec2) {
		x=xV;
		y=yV;
		width=w;
		height=h;
		dx=0;
		dy=0;
		
		img=i;
		weapon=we;
		special2=spec2;
	}
	public Character(int xV, int yV, int w, int h,  ImageIcon i, Weapon we) {
		x=xV;
		y=yV;
		width=w;
		height=h;
		dx=0;
		dy=0;
		
		img=i;
		weapon=we;
	
	}
	
	/*public Character(int xV, int yV, int w, int h, int hp, ImageIcon i, Smoke sm) {
		x=xV;
		y=yV;
		width=w;
		height=h;
		dx=0;
		dy=0;
		lives=hp;
		img=i;
		smoke=sm;
	}*/


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

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public ImageIcon getImg() {
		return img;
	}

	public void setImg(ImageIcon img) {
		this.img = img;
	}
	public void drawChar(Graphics g2d) {
		g2d.drawImage(img.getImage(), x, y, width, height, null);
	
		
	}
	
	
	public Weapon getWeapon() {
		return weapon;
	}
	public Special2 getSpecial2() {
		return special2;
	}
	public Specials getSpecials() {
		return specials;
	}
	public void drawWeapon(Graphics g2d) {
		weapon.drawWeapon(g2d);
	}
	public void drawSpecial2(Graphics g2d) {
		special2.drawSpecial2(g2d);
	}
	public boolean CollisionP (Character c) {
		Rectangle player= new Rectangle (getX(), getY(), getWidth(), getHeight());
		Rectangle enemy= new Rectangle (c.getX(), c.getY(), c.getWidth(), c.getHeight());
	
		if(player.intersects(enemy)) {
			return true;
			
			
		}
		return false;
	}
	
	
	
}
