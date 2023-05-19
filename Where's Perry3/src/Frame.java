import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import imgs.Background;
import imgs.Level;
import imgs.Buttons;
import imgs.Gems;
import imgs.Lava;
import imgs.RestartMenu;

public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	
	Player p = new Player("Phineas.png");
	Player p2 = new Player("Ferb.png");
	Background homepage = new Background();
	boolean home = false;
	//setting up homepage buttons that let user access levels 1-3
	Buttons one = new Buttons("level1logo.png", 130, 275);
	Buttons two = new Buttons("level2logo.png", 230, 275);
	Buttons three = new Buttons("level3logo.png", 520, 270);
	//pause button that appears in every level
	Buttons pause = new Buttons("pause.png", 730, 0);
	
	//setting up the visual backgrounds and maze contents of levels
	Background back = new Background("background.png");
	Level first = new Level("level1.png");
	boolean firstStart = false;
	Level second = new Level("level2.png");
	boolean secondStart = false;
	Level third = new Level();
	boolean thirdStart = false;
	
	//attributes of the menu pop-up
	RestartMenu restartMenu = new RestartMenu();
	boolean canRestart = false;
	Buttons restart = new Buttons("restart.png",330 ,420);
	boolean tryagain = false;
	Buttons menu = new Buttons("menu.png", 460, 420);
	
	//setting up arrays that contain lava objects for each level
	ArrayList<Lava> level1 = new ArrayList<Lava>();
	/*for (int i = 0; i < 6; i ++) {
		for-loop to populate 6 level 1 lavas(3 phineas and 3 ferb)
	}*/
	ArrayList<Lava> level2 = new ArrayList<Lava>();
	/*for (int i = 0; i < 4; i ++) {
		for-loop to populate 6 level 2 lavas(2 phineas and 2 ferb)
	}*/
	ArrayList<Lava> level3 = new ArrayList<Lava>();
	/*for (int i = 0; i < _; i ++) {
		for-loop to populate _ level 3 lavas(_ phineas and _ ferb)
	}*/
	//setting up arrays that contain gem objects for each level
	ArrayList<Gems> level1Gems = new ArrayList<Gems>();
	//for loop to set up gems
	ArrayList<Gems> level2Gems = new ArrayList<Gems>();
	//for loop to set up gems
	ArrayList<Gems> level3Gems = new ArrayList<Gems>();
	//for loop to set up games
	
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		
		//setting up the homepage of the game
		homepage.paint(g);
		one.paint(g);
		two.paint(g);
		three.paint(g);
			
		if (firstStart) {//checking if button to play level 1 has been pressed/'hit'
			back.paint(g);
			first.paint(g);
			pause.paint(g);
			p.paint(g);
			//if button has been pressed, draw the corresponding level and its components
			
			if(first.getclr(p.getX()+28,p.getY()+76) == true) {
				//phineas/ferb objects search for the specific color that they're allowed to step on 
				
				//System.out.println("yas");
				p.setFlor(p.getY());
				//p.setFlor(p.getY());
			} else {
				p.setFlor(695);
			}
		}
		if (secondStart) {//checking if button to play level 2 has been pressed/'hit'
			back.paint(g);
			second.paint(g);
			pause.paint(g);
			p.paint(g);
			//if button has been pressed, draw the corresponding level and its components

			if(second.getclr(p.getX()+28,p.getY()+76) == true) {
				//phineas/ferb objects search for the specific color that they're allowed to step on 
				
				//System.out.println("yas");
				p.setFlor(p.getY());
				//p.setFlor(p.getY());
			} else {
				p.setFlor(695);
			}
		}
		if (thirdStart) {//checking if button to play level 3 has been pressed/'hit'
			back.paint(g);
			third.paint(g);
			pause.paint(g);
			p.paint(g);
			//if button has been pressed, draw the corresponding level and its components
			
			if(third.getclr(p.getX()+28,p.getY()+76) == true) {
				//phineas/ferb objects search for the specific color that they're allowed to step on 
				
				//System.out.println("yas");
				p.setFlor(p.getY());
				//p.setFlor(p.getY());
			} else {
				p.setFlor(695);
			}
		}
		if (canRestart) {//checking if pause button was clicked 
			restartMenu.paint(g);
			menu.paint(g);
			restart.paint(g);
			//pause menu components are drawn (menu button and restart the level button
		}
		if(home) {//player has hit the menu button on pause menu
			homepage.paint(g);
			one.paint(g);
			two.paint(g);
			three.paint(g);
			home = false;
			p.restart();
			//players are returned to homepage, i.e. homepage is redrawn
		}
		if(tryagain) {
			if (firstStart) {//checking if button to play level 1 has been pressed/'hit'
				back.paint(g);
				first.paint(g);
				pause.paint(g);
				p.restart(); 
				//if button has been pressed, draw the corresponding level and its components
				
				if(first.getclr(p.getX()+28,p.getY()+76) == true) {
					//phineas/ferb objects search for the specific color that they're allowed to step on 
					
					//System.out.println("yas");
					p.setFlor(p.getY());
					//p.setFlor(p.getY());
				} else {
					p.setFlor(695);
				}
			}else if (secondStart) {//checking if button to play level 2 has been pressed/'hit'
				back.paint(g);
				second.paint(g);
				pause.paint(g);
				p.restart();
				//if button has been pressed, draw the corresponding level and its components
				
				if(second.getclr(p.getX()+28,p.getY()+76) == true) {
					//phineas/ferb objects search for the specific color that they're allowed to step on 
					
					//System.out.println("yas");
					p.setFlor(p.getY());
					//p.setFlor(p.getY());
				} else {
					p.setFlor(695);
				}
			}else if (thirdStart) {//checking if button to play level 3 has been pressed/'hit'
				back.paint(g);
				third.paint(g);
				pause.paint(g);
				p.restart();
				//if button has been pressed, draw the corresponding level and its components
				
				if(third.getclr(p.getX()+28,p.getY()+76) == true) {
					//phineas/ferb objects search for the specific color that they're allowed to step on 
					
					//System.out.println("yas");
					p.setFlor(p.getY());
					//p.setFlor(p.getY());
				} else {
					p.setFlor(695);
				}
			}
			tryagain = false;
		}
		
		//System.out.println(p.getY());
		//System.out.println(third.getclr(p.getX() + 30,p.getY()+90));
		//System.out.println(homepage.getclr(p.getX()+10,p.getY()/100));
		
		/*
		if(third.getclr(p.getX()+20,p.getY()+70) == true) {
			p.setLwall(p.getX());
	
		} 
		
		/*
		
		if(third.getclr(p.getX()+30,p.getY()+70) == true) {
			p.setRwall(p.getX());
			
		} \\*/
		
	}
	
	
	public static void main(String[] arg) {
		Frame f = new Frame();
	}
	
	public Frame() {
		JFrame f = new JFrame("Wheres Perry");
		f.setSize(new Dimension(800, 800));
		f.setBackground(Color.white);
		f.add(this);
		f.setResizable(false);
		f.setLayout(new GridLayout(1,2));
		f.addMouseListener(this);
		f.addKeyListener(this);
		Timer t = new Timer(16, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		
	}
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arig0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {

		if(one.hit(arg0)) {
			firstStart = true;
		}
		if(two.hit(arg0)) {
			secondStart = true;
		}
		if(three.hit(arg0)) {
			thirdStart = true;
		}
		if(pause.hit(arg0)) {
			canRestart = true;
		}
		if(menu.hit(arg0)) {
			home = true;
			firstStart = false;
			secondStart = false;
			thirdStart = false;
			canRestart = false;
		}
		if(restart.hit(arg0)) {
			tryagain = true;
			canRestart = false;
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0.getKeyCode());
		if (arg0.getKeyCode() == 39) { 
			p.moveLeft();
		}
		if (arg0.getKeyCode() == 37) { 
			p.moveRight();
		}
		if (arg0.getKeyCode() == 38) { 
			System.out.println("jump");
			p.jump();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		p.stop();
		/*
		if (arg0.getKeyCode() == 39) { 
			p.stop();
		}
		if (arg0.getKeyCode() == 37) { 
			p.stop();
		}
		
		*/
		
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}