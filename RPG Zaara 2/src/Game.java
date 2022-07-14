import javax.swing.*; 
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.event.*; 
import java.util.Queue;
import java.util.LinkedList;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;


public class Game  extends JPanel implements Runnable, KeyListener{

	
	private BufferedImage back; 
	private int key; 
	private String filename;
	private ArrayList <Character> selectList;
	private int count;
	private int type;
	private int screenchange; 
	private Character player;
private ArrayList <Weapon> weaponlist;
private ArrayList <Specials> specialist;
private ArrayList <Smoke> enemyP;
	private Weapon pw;
	private Enemy e;
	private Smoke sm;
	private Background b;
	private Queue <Enemy> enemies;
	private Boolean down;
	private Boolean up;
	private Boolean right;
	private Boolean left;
	private Boolean display;
	private Boolean shoot;
	private String s;
	private String x;
	private String d;
	private String f;
	private String g;
	private int words;
	private int collisione;
	private int collisionp;
	private Boolean lose;
	private ImageIcon background1;
	private ImageIcon background2;
	private ImageIcon  winscreen;
	private ImageIcon  losescreen;
	private int livese;
	private int lives;
	private int score;
	private File file;
	private Boolean spec2;
	private Special2 special2;
private Boolean win, playmusicOnce;
private Player p;
private int livesleft;
private Boolean savefile;

//private ArrayList <Special2> specialist2;
	
	
	
	
	
	
	public Game() {
		new Thread(this).start();	
		this.addKeyListener(this);
		key =-1; 
		selectList=setSelectlist();
//	weaponlist=setWeaponlist();
		count=0;
		filename="saveFile.txt";
		file= new File(filename);
		type=0;
		words=0;
		s="POLLUTION IS TAKING";
		screenchange=0; 
		player=null;
		pw= null;
		e=new Enemy();
		sm=new Smoke();
	     b= new Background();
	     down=false;
	     up=false;
	     right=false;
	     left=false;
	     display=false;
	     shoot=false;
	     background1= new ImageIcon("background1.png");
	     background2=new ImageIcon("background3.png");
	     winscreen= new ImageIcon("winscreen.png");
	     losescreen= new ImageIcon("losescreen.png");
	    // weaponlist=new ArrayList <Weapon> ();
	     enemies= new LinkedList<>();
		addEs();
		weaponlist= new ArrayList <Weapon>();
		specialist= new ArrayList <Specials>();
		enemyP=new ArrayList <Smoke> ();
		collisione=0;
		collisionp=0;
		lose=false;
		livese=5;
		lives=5;
		score=0;
		spec2=false;
		special2=new Special2();
		win=false;
		//specialist2= new ArrayList <Special2>();
		p= new Player();
		playmusicOnce=true;
		savefile=false;
		
	}
	
	public void createFile() {
		//this creates the file 
		File file = new File(filename);
		try {
			if(file.createNewFile()) {
				
			}
			else {
				
			}
		}
		catch(IOException e) {
			
			e.printStackTrace();
		}
	}
	public void readFile() {
		File file = new File(filename);
		try {
		Scanner sc= new Scanner(file);
		
		while(sc.hasNext()){
			
			if(sc.next().equals("win")){
				System.out.println("won"); 
			}
			else {
				
				System.out.println(sc.next());
				livesleft=sc.nextInt();

			}
			
		}
		
	
		
		
		}
		
		catch(Exception e) {
	
		}
		
		System.out.println("livesleft "+ livesleft);
		System.out.println("finished ");
	}
	public void writetoFile() {
		
		try {
			FileWriter myWriter= new FileWriter(filename); 
			
			
			if(!enemies.isEmpty()) {
				myWriter.write("Pollution left: "+livese+ "\n");
				
				
			}
			else {
				myWriter.write("win");
			}
				myWriter.close(); 
				System.out.println("successfully wrote.");
		}
		catch (IOException e){
	    	System.out.println("An error occured.");
			e.printStackTrace();
		}
	}
	
	
	public void addEs() {
	enemies.add(new Enemy(2000,500));
	enemies.add(new Enemy(1000,500));
	enemies.add(new Enemy(1000,500));
	enemies.add(new Enemy(1000,500));
	enemies.add(new Enemy(1000,500));
	enemies.add(new Enemy(1000,500));
	
		
	}

	public ArrayList<Character> setSelectlist(){
		ArrayList<Character>templist= new ArrayList();
		templist.add(new Fire(50,100));
		templist.add(new Earth(50,400));
		templist.add(new Water(600,100));
		templist.add(new Air(600,400));
		
	
		
		return templist;
	}
	
	
	public void run()
	   {
	   	try
	   	{
	   		while(true)
	   		{
	   		   Thread.currentThread().sleep(5);
	            repaint();
	         }
	      }
	   		catch(Exception e)
	      {
	      }
	  	}
	

	
	
	
	public void paint(Graphics g){
		
		Graphics2D twoDgraph = (Graphics2D) g; 
		if( back ==null)
			back=(BufferedImage)( (createImage(getWidth(), getHeight()))); 
		

		Graphics g2d = back.createGraphics();
	
		g2d.clearRect(0,0,getSize().width, getSize().height);
		

		count++;
	
			
		e.move();
		movement();
	
		if(screenchange==0) {
			reset();
			g2d.drawImage(background2.getImage(),0, 0, 1000,800,this);
			for(Character cl: selectList) {
			cl.drawChar(g2d);
		
				player=null;

				g2d.setFont(new Font ("Kristen ITC", Font.BOLD, 50));
				g2d.drawString("CHOOSE YOUR ELEMENT", 100, 50);
				
				g2d.setFont(new Font ("Kristen ITC", Font.BOLD, 20));
				g2d.drawString("PRESS Y TO USE SAVED PROGRESS", 300, 100);
				g2d.setFont(new Font ("Kristen ITC", Font.BOLD, 30));
				g2d.drawString("Press F for Fire", 260, 300);
				g2d.drawString("Press E for Earth", 260, 600);
				g2d.drawString("Press W for Water", 360, 170);
				g2d.drawString("Press A for Air", 360, 470);
			
				}
		}
			if(screenchange==1) {
				
					Color background= new Color (184, 162, 252);
	            g2d.setColor(background);
	            g2d.fillRect(0,0,1000,800);
				player.drawChar(g2d);
				g2d.setColor(Color.BLACK);
				g2d.setFont(new Font ("Kristen ITC", Font.BOLD, 20));
				g2d.drawString("PRESS ENTER TO CONTINUE, PRESS BACKSPACE TO CHOOSE AGAIN ", 90, 680);
				player.setX(280);
				player.setY(150);
				player.setHeight(500);
				player.setWidth(500);
				if(player==selectList.get(0)) {
					g2d.setFont(new Font ("Kristen ITC", Font.BOLD,50 ));
					g2d.drawString("YOU HAVE CHOSEN FIRE", 100, 70);
					
				}
				if(player==selectList.get(1)) {
					g2d.setFont(new Font ("Kristen ITC", Font.BOLD, 50));
					g2d.drawString("YOU HAVE CHOSEN EARTH", 70, 70);
					
				}
				if(player==selectList.get(2)) {
					g2d.setFont(new Font ("Kristen ITC", Font.BOLD, 50));
					g2d.drawString("YOU HAVE CHOSEN WATER", 70, 70);
				
				}
				if(player==selectList.get(3)) {
					g2d.setFont(new Font ("Kristen ITC", Font.BOLD, 50));
					g2d.drawString("YOU HAVE CHOSEN AIR", 100, 70);
					
				}
			
			
			}
			if(screenchange==2) {
				g2d.drawImage(background1.getImage(),0, 0, 1000,800,this);
				g2d.drawRect(150, 50, 700, 600);
				g2d.setFont(new Font ("Kristen ITC", Font.BOLD, 40));
				counterString(g2d);
				g2d.setFont(new Font ("Kristen ITC", Font.BOLD, 20));
				g2d.drawString("PRESS ENTER TO CONTINUE", 330, 680);
				
				

			
				
				
				
				
				
			}
			
			if(screenchange==3) {
				
				b.drawBackground(g2d);
			
				//player.getWeapon().drawWeapon(g2d);
					player.setX(20);
					player.setY(500);
					player.setHeight(150);
					player.setWidth(150);
					player.drawChar(g2d);
					if(!enemies.isEmpty()) {
						enemies.element().drawChar(g2d);
						enemies.element().move();
						}
					if(enemies.element().getX()==player.getX()) {
						lose=true;
					}
					if(spec2==true) {
						//for(Special2 a: specialist2) {
						player.drawSpecial2(g2d);
						//}
						
					}
					if(display!=false && player!=null) {
						//player.drawWeapon(g2d);
						for(Weapon a: weaponlist) {
							if(display) {
							a.move();
							}
							a.setdx(1);
							a.drawWeapon(g2d);
							movement();
						}
						for(Specials a: specialist) {
							//if(shoot) {
							a.move();
							a.setdx(1);
							a.drawSpecial(g2d);
							movement();
							}
							
						//}
					}
						Enemyshoot();
						for(Smoke b: enemyP) {
							b.setdx(2);
							b.drawWeapon(g2d);
							//g2d.drawImage(sm.getImg().getImage(), b.getX(),b.getY(),b.getW(),b.getH(), this);
							b.move();
							movement();
							
							}
						doSomething();
						g2d.setFont(new Font ("Kristen ITC", Font.BOLD, 20));
						g2d.drawString("LIVES:"+lives,50, 50);
						
							//livese=5;
						if(savefile==false) {
							
							g2d.drawString("POLLUTION LEFT:"+livese,650, 50);
						}
						if(savefile==true){
							g2d.drawString("POLLUTION LEFT:"+livesleft,650, 50);
						}
						
						g2d.drawString("SCORE:"+score, 50, 100);
						if(player==selectList.get(0)|| player==selectList.get(1)) {
							g2d.setColor(Color.white);
							g2d.drawString("PRESS S FOR SPECIAL POWER",200 ,50);
						}
						if(player==selectList.get(2)|| player==selectList.get(3)) {
							g2d.setColor(Color.white);
							g2d.drawString("PRESS P FOR SPECIAL POWER",200 ,50);
							g2d.setColor(Color.black);
						}
						
					}
			
if(spec2==true) {
			if(!enemyP.isEmpty()) {
	//if(!specialist2.isEmpty()) {
	for(int l=0; l<enemyP.size(); l++) {
	//	for(int m=0; m<specialist2.size(); m++) {
	if(player.getSpecial2().CollisionP(enemyP.get(l))) {
		enemyP.remove(l);
	//}
	}
		}
		}
	//}
}
	
			for(int m=0; m<weaponlist.size(); m++) {
				//for(enemies) {
					if(!weaponlist.isEmpty()) {
					if (weaponlist.get(m).Collision(enemies.element())){
						//enemies.remove();
			
						collisione++;
						score+=100;
						weaponlist.remove(m);
						if(collisione%3==0) {
							livese--;
							livesleft--;
							enemies.remove();
							if(livese==0 || livesleft==0) {
								win=true;
								p.playmusic("win.wav");
							}
								
			
						}
						//score+=25;
						
					
					}
				}
			}
			for(int m=0; m<specialist.size(); m++) {
				//for(enemies) {
					if(!specialist.isEmpty()) {
					if (specialist.get(m).Collision(enemies.element())){
						//enemies.remove();
						livese--;
						livesleft--;
						collisione++;
						score+=300;
						specialist.remove(m);
						if(collisione%1==0) {
							enemies.remove();
							if(livese==0 || livesleft==0) {
								win=true;
								p.playmusic("win.wav");
							}
						}
						//score+=25;
						
					
					}
				}
			}
	
				for(int l=0; l<enemyP.size(); l++) {
				
				if(!enemyP.isEmpty()) {
				if (enemyP.get(l).CollisionPl(player)){
					lives--;
					collisionp++;
					enemyP.remove(l);
					if(lives==0) {
						//player=null;
						lose=true;
						
					}
					//play2=true;
					}
					}
					}
				
					
				if(lose==true) {
					screenchange=4;
				}
				if(win==true) {
			screenchange=5;
				}
			
				for(int m=0; m<weaponlist.size(); m++) {
					for(int l=0; l<enemyP.size(); l++) {
				
				if(!weaponlist.isEmpty()) {
					if(!enemyP.isEmpty()) {
						
						if(weaponlist.get(m).CollisionW(enemyP.get(l))) {
							weaponlist.remove(m);
							enemyP.remove(l);
						}
					}
				}
				
					}
				}
				for(int m=0; m<specialist.size(); m++) {
					for(int l=0; l<enemyP.size(); l++) {
				
				if(!specialist.isEmpty()) {
					if(!enemyP.isEmpty()) {
						
						if(specialist.get(m).CollisionW(enemyP.get(l))) {
							specialist.remove(m);
							enemyP.remove(l);
						}
					}
				}
				
					}
				}
				
			
		
	//rangedattack();
				if (screenchange==4) {
					Color losecolor= new Color(65, 93, 138);
					g2d.setColor(losecolor);
					g2d.fillRect(0, 0, 1000, 800);
					g2d.drawImage(losescreen.getImage(),0,0,1000,800,this);
					g2d.setColor(Color.RED);
					g2d.setFont(new Font("Kristen ITC", Font.BOLD, 70));
					g2d.drawString("YOU FAILED",100,100);
				    g2d.drawString("THE MISSION!",300,200);
					g2d.setFont(new Font("Kristen ITC", Font.BOLD, 60));
					g2d.drawString("SCORE:"+ score,300, 350);
					g2d.drawString("LIVES:"+ lives,300, 460);
					if(savefile==false) {
					g2d.drawString("POLLUTION LEFT:"+ livese,160, 570);
					}
					if(savefile==true) {
						g2d.drawString("POLLUTION LEFT:"+ livesleft,160, 570);
					}
					//g2d.drawString("PRESS R TO RESTART", 300, 200);
				}
				if(screenchange==5) {
					
					Color wincolor= new Color (219, 202, 222);
					g2d.setColor(wincolor);
					g2d.fillRect(0, 0, 1000, 800);
					g2d.drawImage(winscreen.getImage(),0,0,1000,800,this);
					g2d.setColor(Color.WHITE);
					g2d.setFont(new Font("Kristen ITC", Font.BOLD, 80));
					g2d.drawString("YOU WON!",250,250);
					g2d.setFont(new Font("Kristen ITC", Font.BOLD, 30));
					g2d.drawString("THANK YOU FOR HELPING THE PLANET",100,350);
					g2d.drawString("SCORE:"+ score,400, 450);
					g2d.drawString("LIVES:"+ lives,400, 500);
					//g2d.drawString("PRESS R TO RESTART", 300, 200);
				}
		
		//g2d.drawString("KEY"+key, 550, 300);
	
		//drawScreen(g2d);
		//if we chose fire, player1=selectList.get(0);
		
	b.move();
	
	//player.getWeapon().move();
	//}
	
	if(words==7) {
		type=0;
		
	}
	
	
	
		twoDgraph.drawImage(back, null, 0, 0);

	}
	
	
	public void doSomething() {
		if(player.getWeapon() instanceof Fireball) {
			if(shoot==true) {
				if(playmusicOnce)
					p.playmusic("flames.wav");
				playmusicOnce=false;
			}
					}
		 if (player.getWeapon() instanceof Tsunami) {
			 if(shoot==true) {
					if(playmusicOnce)
					p.playmusic("wavesound.wav");
					playmusicOnce=false;
				}
				
			}
		 if(player.getWeapon() instanceof Boulder) {
				if(shoot==true) {
					if(playmusicOnce)
				p.playmusic("earthquake.wav");
					playmusicOnce=false;
				}
				
			}
			 if (player.getWeapon() instanceof Tornado) {
				 if(shoot==true) {
					 if(playmusicOnce)
						p.playmusic("wind.wav");
					 playmusicOnce=false;
					}
					
				}
		}
		
	
	public void counterString(Graphics g) {
		System.out.println("count" +count);
		if (count%20==0) {
			type++;
			if(type>=0 && type%2==0) {
			p.playmusic("typing2.wav");
			}
			System.out.println("type increase");
			
		}
		System.out.println(words);
		if(type==s.length()+1) {
			words++;
			type=0;
			
			
		}
		drawWords(g);
		
	}
	
	public void drawWords(Graphics g) {
		((Graphics2D)g).setStroke(new BasicStroke(5));
		

		switch(words) {
		case 7:
		
			g.drawString("POLLUTION IS TAKING", 220, 90);
			g.drawString("OVER THE CITY", 340, 175);
			g.drawString("AND THE WORLD", 300, 260);
			g.drawString("NEEDS YOUR HELP!", 300, 345);
			g.drawString("USE THE POWER OF", 270, 430);
			g.drawString("NATURE TO RID THE", 270, 515);
			g.drawString("CITY OF THE ENEMIES!", 250, 600);
			p.playmusic("stop");
		case 6:
			g.drawString("POLLUTION IS TAKING", 220, 90);
			g.drawString("OVER THE CITY", 340, 175);
			g.drawString("AND THE WORLD", 300, 260);
			g.drawString("NEEDS YOUR HELP!", 300, 345);
			g.drawString("USE THE POWER OF", 270, 430);
			g.drawString("NATURE TO RID THE", 270, 515);
			
			
			s="CITY OF THE ENEMIES!";
			g.drawString(s.substring(0,type),250,600);
		
		case 5:
			//type=0;
			g.drawString("POLLUTION IS TAKING", 220, 90);
			g.drawString("OVER THE CITY", 340, 175);
			g.drawString("AND THE WORLD", 300, 260);
			g.drawString("NEEDS YOUR HELP!", 300, 345);
			g.drawString("USE THE POWER OF", 270, 430);
			s="NATURE TO RID THE";
			g.drawString(s.substring(0,type),270,515);
		case 4:
			//type=0;
			g.drawString("POLLUTION IS TAKING", 220, 90);
			g.drawString("OVER THE CITY", 340, 175);
			g.drawString("AND THE WORLD", 300, 260);
			g.drawString("NEEDS YOUR HELP!", 300, 345);
			s="USE THE POWER OF";
			g.drawString(s.substring(0,type),270,430);
		case 3:
			//type=0;
			g.drawString("POLLUTION IS TAKING", 220, 90);
			g.drawString("OVER THE CITY", 340, 175);
			g.drawString("AND THE WORLD", 300, 260);
			s="NEEDS YOUR HELP!";
			g.drawString(s.substring(0,type),300,345);
		case 2:
			//type=0;
			g.drawString("POLLUTION IS TAKING", 220, 90);
			g.drawString("OVER THE CITY", 340, 175);
			s="AND THE WORLD";
			g.drawString(s.substring(0,type),300,260);
		case 1:
			//type=0;
			g.drawString("POLLUTION IS TAKING", 220, 90);
			s="OVER THE CITY";
			//System.out.println("type" + type);
			g.drawString(s.substring(0, type), 340, 175);
			
			break;
		case 0:
			//s=("POLLUTION IS TAKING");
			g.drawString(s.substring(0, type), 220, 90);
			
			
			break;
		default:
			
			
		}
	}
	/*public void rangedattack(){
		player.getWeapon().setX(player.getX()+player.getWidth()-259);
		
	}*/
	public void Enemyshoot() {
		
						if (count%200==0) {
							enemyP.add(new Smoke(enemies.element().getX(), enemies.element().getY()));
				//enemyP.add(new Smoke(enemies.element().getX(), enemies.element().getY(),enemies.element().getWidth(),enemies.element().getHeight(),sm.getPic(),sm.getdx()));
				System.out.println("passed");
	}
}
		
	
	public void movement() {
	if (down==true ) {
		b.setdy(2);
		//player.getWeapon().changeBg(-b.getdy());
	for(Weapon wl: weaponlist) {
		wl.changeBg(-b.getdy());
		//pw.changeBg(-b.getdy());
	}
	for (Smoke sm: enemyP) {
		sm.changeBg(-b.getdy());
	}
	}
	if (up==true ) {
		b.setdy(-2);
		for(Weapon wl: weaponlist) {
			wl.changeBg(-b.getdy());
		//player.getWeapon().changeBg(-b.getdy());
		//pw.changeBg(-b.getdy());
		}
		for (Smoke sm: enemyP) {
			sm.changeBg(-b.getdy());
		}
	}
	if (right==true) {
		b.setdx(2);
		//for(Weapon wl: weaponlist) {
			//wl.changeBgx(-b.getdx());
		//player.getWeapon().changeBgx(-b.getdx());
		//pw.changeBg(b.getdx());
		//}
		for (Smoke sm: enemyP) {
			sm.changeBgx(-b.getdx());
		}
	}
	if (left==true ) {
		b.setdx(-2);
		for(Weapon wl: weaponlist) {
			wl.changeBgx(-b.getdx());
		//player.getWeapon().changeBgx( -b.getdx());
		//pw.changeBg(-b.getdx());
		}
		for (Smoke sm: enemyP) {
			sm.changeBgx(-b.getdx());
		}
	}
	}
	//}
	public void reset() {
		selectList=setSelectlist();
		
	}





	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		key= e.getKeyCode();
		System.out.println(key);
		
		if(key==69) {
			p.playmusic("select.wav");
			screenchange++;
			player=selectList.get(1);
			
			
			//pw=weaponlist.get(1);
		
		/*weaponlist.remove(0);
			weaponlist.remove(1);
			weaponlist.remove(1);*/
		}
		if(key==70) {
			p.playmusic("select.wav");
			screenchange++;
			player=selectList.get(0);
			pw=player.getWeapon();
			//pw=weaponlist.get(0);
		/*weaponlist.remove(1);
		weaponlist.remove(1);
		weaponlist.remove(1);*/
		}
		if(key==65) {
			p.playmusic("select.wav");
			screenchange++;
		     player=selectList.get(3);
		     pw=player.getWeapon();
		    // pw=weaponlist.get(3);
			/*weaponlist.remove(0);
			weaponlist.remove(0);
			weaponlist.remove(0);*/
		}
		if(key==87) {
			p.playmusic("select.wav");
			screenchange++;
			player=selectList.get(2);
			///pw=weaponlist.get(2);
			/*weaponlist.remove(0);
			weaponlist.remove(0);
			weaponlist.remove(1);*/
		}
		if (key==10) {
			p.playmusic("select.wav");
			screenchange++;
		}
		if (key==8) {
			p.playmusic("select.wav");
			screenchange=0;
		
		}
		if (key==32) {
			shoot=true;
			playmusicOnce=true;
			//player.getWeapon().setdx(3);
			//weaponlist.add(new Weapon(player.getWeapon(),player.getWeapon().getX(), player.getWeapon().getY()));
			//weaponlist.add(new Weapon(player.getWeapon().getX(), player.getX()));
		//	player.getWeapon().setdx(10);
		
			weaponlist.add(new Weapon(player.getX(), player.getY(),player.getWeapon().getW(),player.getWeapon().getH(),player.getWeapon().getImg(),player.getWeapon().getdx()));
			display=true;
			
			//weaponlist.add (new Weapon (player.getX(),player.getWeapon().getX()));
			
		}
		if(key==39){
			
			right=true;
		}
		if(key==38) {
			
			up=true;
		}
		if(key==40) {
			
			down=true;
		}
		if(key==37){
		left=true;
			
			
			
			
		}
		if(key==82) {
			screenchange--;
			lose=false;
		}
		if(key==80) {
			specialist.add(new Specials(player.getX(), player.getY(),player.getSpecials().getW(),player.getSpecials().getH(),player.getSpecials().getImg(),player.getSpecials().getdx()));
		}
		
		if(key==83)	{
			
				//specialist2.add(new Special2(300,500));
				//if(!specialist2.isEmpty()) {
					spec2=true;
					lives+=5;
					
				}
		if(key==89) {
			savefile=true;
		}
		if(key==78) {
			savefile=false;
			
		}
			
		}
		
//	}
	



	@Override
	public void keyReleased(KeyEvent e) {
	
		if (e.getKeyCode()==39 || e.getKeyCode()==37) {
			b.setdx(0);
		}
		if (e.getKeyCode()==38 || e.getKeyCode()==40) {
			b.setdy(0);
		}
		
		if(e.getKeyCode()==39){
			
			right=false;
		}
		if(e.getKeyCode()==38) {
			
			up=false;
		}
		if(e.getKeyCode()==40) {
			
			down=false;
		}
		if(e.getKeyCode()==37){
		left=false;
			
			
			
		}
		if(e.getKeyCode()==32){
			shoot=false;
				
				
				
			}
	
			
		
	
	
	

	
}
}
