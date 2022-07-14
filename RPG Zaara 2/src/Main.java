import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Main extends JFrame {
	
	private static final int WIDTH =1000;
	private static final int HEIGHT=800;
	
	
	public Main(){
		super("RPG- Zaara Bilal");
		setSize(WIDTH,HEIGHT); 
		Game play = new Game(); 
		
		((Component)play).setFocusable(true);
		Color background= new Color (100,237,180);
		setBackground(background);
		
		getContentPane().add(play);
		
		setVisible(true);
		
		addWindowListener(new WindowListener()
				{

					@Override
					public void windowActivated(WindowEvent e) {
						// TODO Auto-generated method stub
						
						
					}

					@Override
					public void windowClosed(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowClosing(WindowEvent e) {
						// TODO Auto-generated method stub
						System.out.println("closing");
						play.writetoFile();
						System.exit(-1);
						
					}

					@Override
					public void windowDeactivated(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowDeiconified(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowIconified(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowOpened(WindowEvent e) {
						// TODO Auto-generated method stub
						play.createFile();
						play.readFile();
					}});

					
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		
		
		
	
	public static void main(String[] args) {
		
		Main run = new Main(); 
		
	}

	
	
	
}