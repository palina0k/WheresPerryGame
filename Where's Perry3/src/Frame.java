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
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
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
	int x1= 0;
	int y1 = 0;
	//level1 has 6 lavas
	ArrayList<Lava> level1 = new ArrayList<Lava>();
	//level2 has 4 lavas
	ArrayList<Lava> level2 = new ArrayList<Lava>();
	//level3 has 9 lavas
	ArrayList<Lava> level3 = new ArrayList<Lava>();
	
	//setting up arrays that contain gem objects for each level
	ArrayList<Gems> level1Gems = new ArrayList<Gems>();
	//for loop to set up gems
	ArrayList<Gems> level2Gems = new ArrayList<Gems>();
	//for loop to set up gems
	ArrayList<Gems> level3Gems = new ArrayList<Gems>();
	//for loop to set up games
	
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		
		level1.add(new Lava("phineasLavat.gif", x1+90 , y1+50 ));
		level1.add(new Lava("phineasLavat.gif", x1+350  , y1+280 ));
		level1.add(new Lava("ferbLavat.gif", x1+500 , y1+50 ));
		level1.add(new Lava("ferbLavat.gif", x1+200 , y1+280 ));
		level1.add(new Lava("phineasLavat.gif", x1+80 , y1+640 ));
		level1.add(new Lava("phineasLavat.gif", x1+125 , y1+640 ));
		level1.add(new Lava("phineasLavat.gif", x1+155 , y1+640 ));
		level1.add(new Lava("ferbLavat.gif", x1+340 , y1+640 ));
		level1.add(new Lava("ferbLavat.gif", x1+375 , y1+640 ));
		level1.add(new Lava("ferbLavat.gif", x1+415 , y1+640 ));

		//level2.add(new Lava("phineasLavat.gif", x1+ , y1+ ));
		//level2.add(new Lava("ferbLavat.gif", x1+ , y1+ ));
		
		//level3.add(new Lava("phineasLavat.gif", x1+ , y1+ ));
		//level3.add(new Lava("ferbLavat.gif", x1+ , y1+ ));

		
		//setting up the homepage of the game
		homepage.paint(g);
		one.paint(g);
		two.paint(g);
		three.paint(g);
		
		if (firstStart) {//checking if button to play level 1 has been pressed/'hit'
			back.paint(g);
			first.paint(g);
			pause.paint(g);
			level1.get(0).paint(g);//orange
			level1.get(1).paint(g);//orange
			level1.get(2).paint(g);//green
			level1.get(3).paint(g);//green
			level1.get(4).paint(g);//orange
			level1.get(5).paint(g);//orange
			level1.get(6).paint(g);//orange
			level1.get(7).paint(g);//green
			level1.get(8).paint(g);//green
			level1.get(9).paint(g);//green
			//set players at bottom left screen
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
			
			//checking if phineas stepped into green
			if(p.crossedLava(level1.get(2)) || p.crossedLava(level1.get(3)) || p.crossedLava(level1.get(7)) || p.crossedLava(level1.get(8)) || p.crossedLava(level1.get(9))){
				p.dissapear(null);
				p.stop();
				canRestart = true;
			}
			//checking if ferb stepped into orange
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
			canRestart = false;
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
		if(canRestart) {
			p.stop();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		p.stop();
		
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}