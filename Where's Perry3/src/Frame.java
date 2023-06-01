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
import imgs.Levers;
import imgs.RestartMenu;


public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	
	Background homepage = new Background();
	boolean home = false;
	//setting up homepage buttons that let user access levels 1-3
	Buttons one = new Buttons("level1logo.png", 130, 275);
	Buttons two = new Buttons("level2logo.png", 230, 275);
	Buttons three = new Buttons("level3logo.png", 520, 270);
	//pause button that appears in every level
	Buttons pause = new Buttons("pause.png", 730, 0);
	
	//two player objects
	Player p = new Player("Phin.png");
	Player p2 = new Player("Ferb.png");
	
	//levers
	Levers lev1 = new Levers("LeverUnchanged.png", 670, 75);
	
	//setting up the visual backgrounds and maze contents of levels
	Background back = new Background("background.png");
	Level first = new Level("level1.png");
	boolean firstStart = false;
	Level second = new Level("level2.png");
	boolean secondStart = false;
	Level third = new Level("level3v.png");
	boolean thirdStart = false;
	
	//attributes of the menu pop-up
	RestartMenu restartMenu = new RestartMenu();
	boolean canRestart = false;
	Buttons restart = new Buttons("restart.png", 330, 420);
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
	ArrayList<Gems> level2Gems = new ArrayList<Gems>();
	ArrayList<Gems> level3Gems = new ArrayList<Gems>();
	
	//doors in each level
	
	
	//private long starttime; 

	
	public void paint(Graphics g) {
		super.paintComponent(g);
		
		//level1 LAVAS
		level1.add(new Lava("phineasLavat.gif", x1+90 , y1+51 ));
		level1.add(new Lava("phineasLavat.gif", x1+350  , y1+281 ));
		level1.add(new Lava("ferbLavat.gif", x1+500 , y1+51 ));
		level1.add(new Lava("ferbLavat.gif", x1+200 , y1+281 ));
		level1.add(new Lava("phineasLavat.gif", x1+80 , y1+655 ));
		level1.add(new Lava("phineasLavat.gif", x1+125 , y1+655 ));
		level1.add(new Lava("phineasLavat.gif", x1+155 , y1+655 ));
		level1.add(new Lava("ferbLavat.gif", x1+340 , y1+655 ));
		level1.add(new Lava("ferbLavat.gif", x1+375 , y1+655 ));
		level1.add(new Lava("ferbLavat.gif", x1+415 , y1+655 ));

		//level1 GEMS
		level1Gems.add(new Gems("gearGEM2t.gif", x1+170, y1+120));
		level1Gems.add(new Gems("hammerGEM1t.gif", x1+580, y1+120));
		//level1Gems.add(new Gems("gearGEM2t.gif", x1+170, y1+120));
		//level1Gems.add(new Gems("hammerGEM1t.gif", x1+170, y1+120));
		//level1Gems.add(new Gems("gearGEM2t.gif", x1+170, y1+120));
		//level1Gems.add(new Gems("hammerGEM1t.gif", x1+170, y1+120));

		//level2 LAVAS
		level2.add(new Lava("phineasLavat.gif", x1+200, y1+195));
		level2.add(new Lava("ferbLavat.gif", x1+350, y1+195));
		level2.add(new Lava("phineasLavat.gif", x1+460, y1+652));
		level2.add(new Lava("phineasLavat.gif", x1+500, y1+652));
		level2.add(new Lava("ferbLavat.gif", x1+590, y1+652));
		level2.add(new Lava("ferbLavat.gif", x1+630, y1+652));
		
		//level2 GEMS
		//level2Gems.add(new Gems("gearGEM2t.gif", x1+170, y1+120));
		//level2Gems.add(new Gems("hammerGEM1t.gif", x1+170, y1+120));
		
		//level3 LAVAS
		//level3.add(new Lava("phineasLavat.gif", x1+ , y1+ ));
		//level3.add(new Lava("ferbLavat.gif", x1+ , y1+ ));

		//level3 GEMS
		//level3Gems.add(new Gems("gearGEM2t.gif", x1+170, y1+120));
		//level3Gems.add(new Gems("hammerGEM1t.gif", x1+170, y1+120));
		
		//setting up the homepage of the game
		homepage.paint(g);
		one.paint(g);
		two.paint(g);
		three.paint(g);
		
		if (firstStart) {//checking if button to play level 1 has been pressed/'hit'
			
			home = false;//homepage is erased
			
			//if button has been pressed, draw the corresponding level and its components
			back.paint(g);
			first.paint(g);
			pause.paint(g);
			
			//lavas are drawn
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
			
			//gems are drawn
			level1Gems.get(0).paint(g);//gear
			level1Gems.get(1).paint(g);//hammer

			//set players at bottom left screen
			p.paint(g);
			p2.paint(g);
			
			//checking where phineas can walk (i.e. actual ground) and setting up his body's left and right bounds
			if(first.getclr(p.getX() + 25,p.getY()+67) && first.getclr(p.getX()+25, p.getY()+62)==false /*|| first.getclr(p.getX()+15,p.getY()+30) || first.getclr(p.getX()+20, p.getY()+30)*/ ){
				p.setFlor(p.getY());
			} else {
				p.setFlor(795);
			}
			if(first.getclr(p.getX()+15, p.getY()+60)) {
				p.setLwall(p.getX()+15);
			}
			if(first.getclr(p.getX()+50, p.getY()+60)) {
				p.setRwall(p.getX()+50);
			}
			if(first.getclr(p.getX()+15, p.getY())){
				p.setCeil(p.getY());
			}else {
				p.setCeil(10);
			}
			
			//checking when ferb can walk(i.e. actual ground) and setting up his body's left and right bounds
			if(first.getclr(p2.getX() + 25,p2.getY()+66) || first.getclr(p2.getX()+15,p2.getY()+30) || first.getclr(p2.getX()+20, p2.getY()+30) ) {
				p2.setFlor(p2.getY());
			} else {
				p2.setFlor(795);
			}
			if(first.getclr(p2.getX(), p2.getY())){
				p2.setCeil(p2.getY());
			}else {
				p2.setCeil(10);
			}
			if(first.getclr(p2.getX()+15, p2.getY()+58)) {
				p2.setLwall(p.getX()+15);
			}
			if(first.getclr(p2.getX()+50, p2.getY()+58)) {
				p2.setRwall(p.getX()+50);
			}
			
			/*if(first.getclr(p.getX() + 5,p.getY()+76)) {
				p.setLwall(p.getX()+5);
			}else {
				p.setLwall(10);
			}
			g.drawRect(p.getX(), p.getY()+76, 10, 10);
			if(first.getclr(p.getX()+ 40,p.getY()+76)) {
				p.setRwall(p.getX()+40);
			}else {
				p.setRwall(695);
			}
			g.drawRect(p.getX()+ 10, p.getY()+76, 10, 10);
			*/
			
			/*if(first.getclr(p2.getX() + 5,p2.getY()+76) == true) {
				p2.setLwall(p2.getX()+5);
		
			}else {
				p2.setLwall(10);
			}
			g.drawRect(p2.getX(), p2.getY()+76, 10, 10);
			if(first.getclr(p2.getX()+ 30,p2.getY()+76) == true) {
				p2.setRwall(p2.getX()+30);
			}else {
				p2.setRwall(695);
			}
			g.drawRect(p2.getX()+ 10, p2.getY()+76, 10, 10);
			*/
			

		}
		if (secondStart) {//checking if button to play level 2 has been pressed/'hit'
			
			home = false;//homepage is erased
			
			back.paint(g);
			second.paint(g);
			pause.paint(g);
			
			//characters are drawn
			p.paint(g);
			p2.paint(g);
			//if button has been pressed, draw the corresponding level and its components

			//lavas are drawn
			level2.get(0).paint(g);
			level2.get(1).paint(g);
			level2.get(2).paint(g);
			level2.get(3).paint(g);
			level2.get(4).paint(g);
			level2.get(5).paint(g);
			
			//gems are drawn
			
			//checking where phineas can walk (i.e. actual ground) and setting up his body's left and right bounds
			if(second.getclr(p.getX() + 25,p.getY()+66) || second.getclr(p.getX()+15,p.getY()+30) || second.getclr(p.getX()+20, p.getY()+30) ){
				p.setFlor(p.getY());
				/*if(first.getclr(p.getX()+15, p.getY()+58)) {
					p.setLwall(p.getX()+15);
				}
				if(first.getclr(p.getX()+50, p.getY()+58)) {
					p.setRwall(p.getX()+50);
				}*/
			} else {
				p.setFlor(795);
			}
			if(second.getclr(p.getX(), p.getY())){
				p.setCeil(p.getY());
			}else {
				p.setCeil(10);
			}	
			
			//checking when ferb can walk(i.e. actual ground) and setting up his body's left and right bounds
			if(second.getclr(p2.getX() + 25,p2.getY()+66) || second.getclr(p2.getX()+15,p2.getY()+30) || second.getclr(p2.getX()+20, p2.getY()+30) ) {
				p2.setFlor(p2.getY());
			} else {
				p2.setFlor(795);
			}
			if(second.getclr(p2.getX(), p2.getY())){
				p2.setCeil(p2.getY());
			}else {
				p2.setCeil(10);
			}
			
			
        }
		if (thirdStart) {//checking if button to play level 3 has been pressed/'hit'
			
			home = false;//homepage is erased
			
			back.paint(g);
			third.paint(g);
			pause.paint(g);
			
			//characters are drawn
			p.paint(g);
			p2.paint(g);
			lev1.paint(g);
			//if button has been pressed, draw the corresponding level and its components
			
			//lavas are drawn
			
			
			//gems are drawn
			
			
			//checking where phineas can walk (i.e. actual ground) and setting up his body's left and right bounds
			if(third.getclr(p.getX() + 25,p.getY()+66) || third.getclr(p.getX()+15,p.getY()+30) || third.getclr(p.getX()+20, p.getY()+30) ){
				p.setFlor(p.getY());
			} else {
				p.setFlor(795);
			}
			if(third.getclr(p.getX()+15, p.getY())){
				p.setCeil(p.getY());
			}else {
				p.setCeil(10);
			}
			
			//checking when ferb can walk(i.e. actual ground) and setting up his body's left and right bounds
			if(third.getclr(p2.getX() + 25,p2.getY()+66) || third.getclr(p2.getX()+15,p2.getY()+30) || third.getclr(p2.getX()+20, p2.getY()+30) ) {
				p2.setFlor(p2.getY());
			} else {
				p2.setFlor(795);
			}
			if(third.getclr(p2.getX(), p2.getY())){
				p2.setCeil(p2.getY());
			}else {
				p2.setCeil(10);
			}
			
			
		}
		
		if(tryagain) {//user chose to restart same  level they were on before
						
			if (firstStart) {//checking if button to play level 1 has been pressed/'hit'
				back.paint(g);
				first.paint(g);
				pause.paint(g);
				
				//lavas are reset
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
				
				//Gems are reset
				level1Gems.get(0).paint(g);
				level1Gems.get(1).paint(g);
				//if button has been pressed, draw the corresponding level and its components
				
				//characters are redrawn
				p.paint(g);
				p2.paint(g);
				
				//checking where phineas can walk (i.e. actual ground) and setting up his body's left and right bounds
				if(first.getclr(p.getX() + 25,p.getY()+66) /*|| first.getclr(p.getX()+15,p.getY()+30) || first.getclr(p.getX()+20, p.getY()+30)*/ ){
					p.setFlor(p.getY());
				} else {
					p.setFlor(795);
				}
				if(first.getclr(p.getX()+15, p.getY()+58)) {
					p.stop();
				}
				if(first.getclr(p.getX()+50, p.getY()+58)) {
					p.stop();
				}
				if(first.getclr(p.getX()+15, p.getY())){
					p.setCeil(p.getY());
				}else {
					p.setCeil(10);
				}
				
				//checking when ferb can walk(i.e. actual ground) and setting up his body's left and right bounds
				if(first.getclr(p2.getX() + 25,p2.getY()+66) || first.getclr(p2.getX()+15,p2.getY()+30) || first.getclr(p2.getX()+20, p2.getY()+30) ) {
					p2.setFlor(p2.getY());
				} else {
					p2.setFlor(795);
				}
				if(first.getclr(p2.getX(), p2.getY())){
					p2.setCeil(p2.getY());
				}else {
					p2.setCeil(10);
				}
				if(first.getclr(p2.getX()+15, p2.getY()+58)) {
					p2.stop();
				}
				if(first.getclr(p2.getX()+50, p2.getY()+58)) {
					p2.stop();
				}
				
				tryagain = false;
			}else if (secondStart) {//checking if button to play level 2 has been pressed/'hit'
				back.paint(g);
				second.paint(g);
				pause.paint(g);
				//if button has been pressed, draw the corresponding level and its components
				
				//lavas are reset
				
				//gems are reset
				
				
				//characters are drawn
				p.paint(g);
				p2.paint(g);
				
				//checking where phineas can walk (i.e. actual ground) and setting up his body's left and right bounds
				if(second.getclr(p.getX() + 25,p.getY()+66) || second.getclr(p.getX()+15,p.getY()+30) || second.getclr(p.getX()+20, p.getY()+30) ){
					p.setFlor(p.getY());
					/*if(first.getclr(p.getX()+15, p.getY()+58)) {
						p.setLwall(p.getX()+15);
					}
					if(first.getclr(p.getX()+50, p.getY()+58)) {
						p.setRwall(p.getX()+50);
					}*/
				} else {
					p.setFlor(795);
				}
				if(second.getclr(p.getX(), p.getY())){
					p.setCeil(p.getY());
				}else {
					p.setCeil(10);
				}	
				
				//checking when ferb can walk(i.e. actual ground) and setting up his body's left and right bounds
				if(second.getclr(p2.getX() + 25,p2.getY()+66) || second.getclr(p2.getX()+15,p2.getY()+30) || second.getclr(p2.getX()+20, p2.getY()+30) ) {
					p2.setFlor(p2.getY());
				} else {
					p2.setFlor(795);
				}
				if(second.getclr(p2.getX(), p2.getY())){
					p2.setCeil(p2.getY());
				}else {
					p2.setCeil(10);
				}
				
				
				tryagain = false;
			}else if (thirdStart) {//checking if button to play level 3 has been pressed/'hit'
				back.paint(g);
				third.paint(g);
				pause.paint(g);
				//if button has been pressed, draw the corresponding level and its components
				
				//lavas are reset
				
				//gems are reset
				
				//characters are drawn
				p.paint(g);
				p2.paint(g);
				
				//checking where phineas can walk (i.e. actual ground) and setting up his body's left and right bounds
				if(third.getclr(p.getX() + 25,p.getY()+66) || third.getclr(p.getX()+15,p.getY()+30) || third.getclr(p.getX()+20, p.getY()+30) ){
					p.setFlor(p.getY());
				} else {
					p.setFlor(795);
				}
				if(third.getclr(p.getX()+15, p.getY())){
					p.setCeil(p.getY());
				}else {
					p.setCeil(10);
				}
				
				//checking when ferb can walk(i.e. actual ground) and setting up his body's left and right bounds
				if(third.getclr(p2.getX() + 25,p2.getY()+66) || third.getclr(p2.getX()+15,p2.getY()+30) || third.getclr(p2.getX()+20, p2.getY()+30) ) {
					p2.setFlor(p2.getY());
				} else {
					p2.setFlor(795);
				}
				if(third.getclr(p2.getX(), p2.getY())){
					p2.setCeil(p2.getY());
				}else {
					p2.setCeil(10);
				}
				
				tryagain = false;
			}
		}
		
		//checking if phineas stepped into green in level 1
		if(p.crossedLava(level1.get(2)) || p.crossedLava(level1.get(3)) || p.crossedLava(level1.get(7)) || p.crossedLava(level1.get(8)) || p.crossedLava(level1.get(9))){
			p.dissapear(null);
			p2.dissapear(null);
			canRestart = true;
		}
		//checking if ferb stepped into orange in level 1
		if(p2.crossedLava(level1.get(0)) || p2.crossedLava(level1.get(1)) || p2.crossedLava(level1.get(4)) || p2.crossedLava(level1.get(5)) || p2.crossedLava(level1.get(6))){
			p2.dissapear(null);
			p.dissapear(null);;
			canRestart = true;
		}
		
		//did corresponding player collect their gem in level 1
		if(p.grabbedGem(level1Gems.get(0))) {//phineas collected
			level1Gems.get(0).restart("");
		}
		if(p2.grabbedGem(level1Gems.get(1))) {//ferb collected
			level1Gems.get(1).restart("");
		}

		if (canRestart) {//checking if pause button was clicked 
			restartMenu.paint(g);
			menu.paint(g);
			restart.paint(g);
			//pause menu components are drawn (menu button and restart the level button)
		}
		
		if(home) {//player has hit the menu button on pause menu
			canRestart = false;//erasing restart menu
			
			homepage.paint(g);
			one.paint(g);
			two.paint(g);
			three.paint(g);
			
			//user is returned to homepage, i.e. homepage is redrawn
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
			canRestart = false;
			firstStart = true;
			secondStart = false;
			thirdStart = false;
		}
		if(two.hit(arg0)) {
			canRestart = false;
			secondStart = true;
			firstStart = false;
			thirdStart = false;
		}
		if(three.hit(arg0)) {
			canRestart = false;
			thirdStart = true;
			firstStart = false;
			secondStart = false;
		}
		if(pause.hit(arg0)) {
			canRestart = true;
		}
		if(menu.hit(arg0)) {
			home = true;
			
			//restarting players
			p.restart("Phin.png", 30, 30);
			p2.restart("Ferb.png", 30, 30);
			//restarting all gems
			level1Gems.get(0).restart("gearGEM2t.gif");
			level1Gems.get(1).restart("hammerGEM1t.gif");
			
			firstStart = false;
			secondStart = false;
			thirdStart = false;
		}
		if(restart.hit(arg0)) {
			//restarting players
			p.restart("Phin.png", 30, 30);
			p2.restart("Ferb.png", 30, 30);
			//restarting all gems
			level1Gems.get(0).restart("gearGEM2t.gif");
			level1Gems.get(1).restart("hammerGEM1t.gif");
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
			p.changePicture("Phin.png");
			p.moveLeft();
		}
		if (arg0.getKeyCode() == 37) { 
			p.changePicture("Phinflip.png");
			p.moveRight();
		}
		if (arg0.getKeyCode() == 38) { 
			p.jump();
		}
		
		
		
		if (arg0.getKeyCode() == 68) { 
			p2.changePicture("Ferb.png");
			p2.moveLeft();
		}
		if (arg0.getKeyCode() == 65) { 
			p2.changePicture("Ferbflip.png");
			p2.moveRight();
		}
		if (arg0.getKeyCode() == 87) { 
			p2.jump();
		}

		if(canRestart) {
			p.stop();
			p2.stop();
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode() == 39 || arg0.getKeyCode() == 37) { 
			p.stop();
		}
		if (arg0.getKeyCode() == 68 || arg0.getKeyCode() == 65) { 
			p2.stop();
		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}