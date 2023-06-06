import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import imgs.Background;
import imgs.Level;
import imgs.Buttons;
import imgs.Door;
import imgs.Gems;
import imgs.Lava;
import imgs.Levers;
import imgs.Platform;
import imgs.RestartMenu;
import imgs.Candace;


public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	
	double start;
	double finish;
	double time;
	double Tottime;
	Player p = new Player("Phin.png");
	Player p2 = new Player("Ferb.png");
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
	Levers lev1 = new Levers(670, 75);
	Levers lev2 = new Levers(530, 370);
	Platform pl = new Platform("platform.png", 50,480);
	Platform pl2 = new Platform("platform2.png",200,410);
	
	//setting up the visual backgrounds and maze contents of levels
	Background back = new Background("background.png");
	Level first = new Level("level1.png");
	boolean firstStart = false;
	Level second = new Level("level2.png");
	boolean secondStart = false;
	Level third = new Level("level3.png");
	boolean thirdStart = false;
	
	//attributes of the menu pop-up
	RestartMenu restartMenu = new RestartMenu();
	Candace candace = new Candace();
	boolean canRestart = false;
	Buttons restart = new Buttons("restart.png", 330, 420);
	boolean tryagain = false;
	Buttons menu = new Buttons("menu.png", 460, 420);
	
	//keep track of started or not
	boolean started = false;
	
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
	
	//counter for gems collected (each type and each level)
	
	//doors in each level
	Door d1 = new Door(-9,20);
	boolean touchd1 = false;
	Door d2 = new Door(-9, 554);
	boolean touchd2 = false;
	Door d3 = new Door(-9, 530);
	boolean touchd3 = false;
	
	//perry in each level
	Perry perry1 = new Perry(40,100);
	Perry perry2 = new Perry(40,620);
	Perry perry3 = new Perry(40,615);
	
	
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

		Font plainFont = new Font ("Press Start 2P", Font.BOLD, 30);
        g.setFont(plainFont);
        g.setColor(Color.black);

		//level1 GEMS
		level1Gems.add(new Gems("gearGEM2t.gif", x1+170, y1+120));
		level1Gems.add(new Gems("hammerGEM1t.gif", x1+580, y1+120));
		level1Gems.add(new Gems("gearGEM2t.gif", x1+430, y1+350));
		level1Gems.add(new Gems("hammerGEM1t.gif", x1+280, y1+350));
		level1Gems.add(new Gems("gearGEM2t.gif", x1+200, y1+724));
		level1Gems.add(new Gems("hammerGEM1t.gif", x1+460, y1+724));

		//level2 LAVAS
		level2.add(new Lava("ferbLavat.gif", x1+630, y1+445));
		level2.add(new Lava("phineasLavat.gif", x1+460, y1+652));
		level2.add(new Lava("phineasLavat.gif", x1+500, y1+652));
		level2.add(new Lava("ferbLavat.gif", x1+590, y1+652));
		level2.add(new Lava("ferbLavat.gif", x1+630, y1+652));
		level2.add(new Lava("phineasLavat.gif", x1+140, y1+652));

		//level2 GEMS
		level2Gems.add(new Gems("gearGEM2t.gif", x1+170, y1+100));
		level2Gems.add(new Gems("hammerGEM1t.gif", x1+370, y1+100));
		level2Gems.add(new Gems("gearGEM2t.gif", x1+280, y1+264));
		level2Gems.add(new Gems("hammerGEM1t.gif", x1+430, y1+264));
		level2Gems.add(new Gems("gearGEM2t.gif", x1+550, y1+400));
		level2Gems.add(new Gems("hammerGEM1t.gif", x1+715, y1+510));
		
		//level3 LAVAS
		level3.add(new Lava("phineasLavat.gif", x1+100 , y1+210 ));
		level3.add(new Lava("ferbLavat.gif", x1+440 , y1+130));
		level3.add(new Lava("phineasLavat.gif", x1+370 , y1+260 ));
		level3.add(new Lava("ferbLavat.gif", x1+130 , y1+652 ));
		level3.add(new Lava("ferbLavat.gif", x1+170 , y1+652 ));
		level3.add(new Lava("phineasLavat.gif", x1+260 , y1+652 ));
		level3.add(new Lava("phineasLavat.gif", x1+300 , y1+652 ));
		level3.add(new Lava("ferbLavat.gif", x1+390 , y1+652 ));
		level3.add(new Lava("ferbLavat.gif", x1+430 , y1+652 ));
		level3.add(new Lava("phineasLavat.gif", x1+620 , y1+652 ));
		
		//level3 GEMS
		level3Gems.add(new Gems("gearGEM2t.gif", x1+185, y1+275));
		level3Gems.add(new Gems("hammerGEM1t.gif", x1+525, y1+200));
		level3Gems.add(new Gems("gearGEM2t.gif", x1+455, y1+335));
		level3Gems.add(new Gems("hammerGEM1t.gif", x1+290, y1+630));
		
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
			
			//perry is drawn
			perry1.paint(g);
			//door is drawn over perry
			d1.paint(g);
			
			//set players at bottom left screen
			p.paint(g);
			p2.paint(g);
			
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
			level1Gems.get(2).paint(g);//gear
			level1Gems.get(3).paint(g);//hammer
			level1Gems.get(4).paint(g);//gear
			level1Gems.get(5).paint(g);//hammer
			
			//set players at bottom left screen
			p.paint(g);
			p2.paint(g);

			if(!started) {
				start = System.currentTimeMillis();
				started = true;
			}
			time = (System.currentTimeMillis() - start)/1000.0;
			g.drawString("Time: " + time,300,40);
			g.drawString("Stand at lever + press space to move",200,100);


			//checking where phineas can walk (i.e. actual ground) and setting up his body's left and right bounds
			if(first.getclr(p.getX() + 25,p.getY()+67) && first.getclr(p.getX()+25, p.getY()+62)==false /*|| first.getclr(p.getX()+15,p.getY()+30) || first.getclr(p.getX()+20, p.getY()+30)*/ ){
				p.setFlor(p.getY());
			} else {
				p.setFlor(795);
			}
			if(first.getclr(p.getX()+15, p.getY()+60)) {
				p.stop();
			}
			if(first.getclr(p.getX()+50, p.getY()+60)) {
				p.stop();
			}
			if(first.getclr(p.getX()+15, p.getY())){
				p.setCeil(p.getY());
			}else {
				p.setCeil(10);
			}
			
			//checking when ferb can walk(i.e. actual ground) and setting up his body's left and right bounds
			if(first.getclr(p2.getX() + 25,p2.getY()+67) && first.getclr(p2.getX()+25, p2.getY()+62)==false) {
				p2.setFlor(p2.getY());
			} else {
				p2.setFlor(795);
			}
			if(first.getclr(p2.getX()+15, p2.getY()+60)) {
				p2.stop();
			}
			if(first.getclr(p2.getX()+50, p2.getY()+60)) {
				p2.stop();
			}
			if(first.getclr(p2.getX()+15, p2.getY())){
				p2.setCeil(p2.getY());
			}else {
				p2.setCeil(10);
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

			//did players reach the door together
			if (p.touchDoor(d1) && p2.touchDoor(d1)) {
				d1.changePicture("");
				touchd1 = true;
				canRestart = true;
			}

		}
		if (secondStart) {//checking if button to play level 2 has been pressed/'hit'
			
			home = false;//homepage is erased
			
			back.paint(g);
			second.paint(g);
			pause.paint(g);

			//perry is drawn
			perry2.paint(g);
			//door is drawn over perry
			d2.paint(g);
			
			//characters are drawn
			p.paint(g);
			p2.paint(g);
			
			//lavas are drawn
			level2.get(0).paint(g);//green
			level2.get(1).paint(g);//orange
			level2.get(2).paint(g);//orange
			level2.get(3).paint(g);//green
			level2.get(4).paint(g);//green
			level2.get(5).paint(g);//orange

			//gems are drawn
			level2Gems.get(0).paint(g);//gear
			level2Gems.get(1).paint(g);//hammer
			level2Gems.get(2).paint(g);//gear
			level2Gems.get(3).paint(g);//hammer
			level2Gems.get(4).paint(g);//gear
			level2Gems.get(5).paint(g);//hammer
			
			pl2.paint(g);
			lev2.paint(g);
			if(!started) {
				start = System.currentTimeMillis();
				started = true;
			}
			time = (System.currentTimeMillis() - start)/1000.0;
			g.drawString("Time: " + time,300,40);
			g.drawString("Stand at lever + press space to move",200,100);
			//if button has been pressed, draw the corresponding level and its components
			
			//checking where phineas can walk (i.e. actual ground) and setting up his body's left and right bounds
			if(second.getclr(p.getX() + 25,p.getY()+67) && second.getclr(p.getX()+25, p.getY()+62)==false){
				p.setFlor(p.getY());
			} else {
				p.setFlor(795);
			}
			if(second.getclr(p.getX()+15, p.getY()+60)) {
				p.stop();
			}
			if(second.getclr(p.getX()+50, p.getY()+60)) {
				p.stop();
			}
			if(second.getclr(p.getX()+15, p.getY())){
				p.setCeil(p.getY());
			}else {
				p.setCeil(10);
			}
			
			//checking when ferb can walk(i.e. actual ground) and setting up his body's left and right bounds
			if(second.getclr(p2.getX() + 25,p2.getY()+67) && second.getclr(p2.getX()+25, p2.getY()+62)==false) {
				p2.setFlor(p2.getY());
			} else {
				p2.setFlor(795);
			}
			if(second.getclr(p2.getX()+15, p2.getY()+60)) {
				p2.stop();
			}
			if(second.getclr(p2.getX()+50, p2.getY()+60)) {
				p2.stop();
			}
			if(second.getclr(p2.getX()+15, p2.getY())){
				p2.setCeil(p2.getY());
			}else {
				p2.setCeil(10);
			}
			
			//checking if phineas stepped into green in level 2
			if(p.crossedLava(level2.get(0)) || p.crossedLava(level2.get(3)) || p.crossedLava(level2.get(4))){
				p.dissapear(null);
				p2.dissapear(null);
				canRestart = true;
			}
			//checking if ferb stepped into orange in level 2
			if(p2.crossedLava(level2.get(1)) || p2.crossedLava(level2.get(2)) || p2.crossedLava(level2.get(5))){
				p2.dissapear(null);
				p.dissapear(null);;
				canRestart = true;
			}
			
			//did players reach the door together
			if(p.touchDoor(d2) && p2.touchDoor(d2)) {
				d2.changePicture("");
				touchd2 = true;
				canRestart = true;
			}
			
        }
		if (thirdStart) {//checking if button to play level 3 has been pressed/'hit'
			
			home = false;//homepage is erased
			
			back.paint(g);
			third.paint(g);
			pause.paint(g);
		
			//perry is drawn
			perry3.paint(g);
			//door is drawn over perry
			d3.paint(g);
			
			//characters are drawn
			p.paint(g);
			p2.paint(g);
						
			//levers are drawn
			lev1.paint(g);
			pl.paint(g);
			//start = System.currentTimeMillis();
			//finish = System.currentTimeMillis();
			//long timeElapsed = finish - start;
			if(!started) {
				start = System.currentTimeMillis();
				started = true;
			}
			time = (System.currentTimeMillis() - start)/1000.0;
			g.drawString("Time: " + time,300,40);
			//if button has been pressed, draw the corresponding level and its components
						
			//lavas are drawn
			level3.get(0).paint(g);//orange
			level3.get(1).paint(g);//green
			level3.get(2).paint(g);//orange
			level3.get(3).paint(g);//green
			level3.get(4).paint(g);//green
			level3.get(5).paint(g);//orange
			level3.get(6).paint(g);//orange
			level3.get(7).paint(g);//green
			level3.get(8).paint(g);//green
			level3.get(9).paint(g);//orange

			//gems are drawn
			level3Gems.get(0).paint(g);//gear
			level3Gems.get(1).paint(g);//hammer
			level3Gems.get(2).paint(g);//gear
			level3Gems.get(3).paint(g);//hammer


			//checking where phineas can walk (i.e. actual ground) and setting up his body's left and right bounds
			if(third.getclr(p.getX() + 25,p.getY()+67) && third.getclr(p.getX()+25, p.getY()+62)==false){
				p.setFlor(p.getY());
			} else {
				p.setFlor(795);
			}
			if(third.getclr(p.getX()+15, p.getY()+60)) {
				p.stop();
			}
			if(third.getclr(p.getX()+50, p.getY()+60)) {
				p.stop();
			}
			if(third.getclr(p.getX()+15, p.getY())){
				p.setCeil(p.getY());
			}else {
				p.setCeil(10);
			}
			
			//checking when ferb can walk(i.e. actual ground) and setting up his body's left and right bounds
			if(third.getclr(p2.getX() + 25,p2.getY()+67) && third.getclr(p2.getX()+25, p2.getY()+62)==false) {
				p2.setFlor(p2.getY());
			} else {
				p2.setFlor(795);
			}
			if(third.getclr(p2.getX()+15, p2.getY()+60)) {
				p2.stop();
			}
			if(third.getclr(p2.getX()+50, p2.getY()+60)) {
				p2.stop();
			}
			if(third.getclr(p2.getX()+15, p2.getY())){
				p2.setCeil(p2.getY());
			}else {
				p2.setCeil(10);
			}
			
			
			//checking if phineas stepped into green in level 3
			if(p.crossedLava(level3.get(1)) || p.crossedLava(level3.get(3)) || p.crossedLava(level3.get(4)) || p.crossedLava(level3.get(7)) || p.crossedLava(level3.get(8))){
				p.dissapear(null);
				p2.dissapear(null);
				canRestart = true;
			}
			
			//checking if ferb stepped into orange in level 3
			if(p2.crossedLava(level3.get(0)) || p2.crossedLava(level3.get(2)) || p2.crossedLava(level3.get(5)) || p.crossedLava(level3.get(6)) || p.crossedLava(level3.get(9))){
				p2.dissapear(null);
				p.dissapear(null);;
				canRestart = true;
			}
			
			//did players reach the door together
			if(p.touchDoor(d3) && p2.touchDoor(d3)) {
				d3.changePicture("");
				touchd3 = true;
				canRestart = true;
			}
		}
		
		if(tryagain) {//user chose to restart same  level they were on before
		
			canRestart = false;
			if (firstStart) {//checking if button to play level 1 has been pressed/'hit'
				back.paint(g);
				first.paint(g);
				pause.paint(g);
				
				//perry is drawn
				perry1.paint(g);
				//door is drawn over perry
				d1.paint(g);
				
				//characters are redrawn
				p.paint(g);
				p2.paint(g);
				
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
				level1Gems.get(0).paint(g);//gear
				level1Gems.get(1).paint(g);//hammer
				level1Gems.get(2).paint(g);//gear
				level1Gems.get(3).paint(g);//hammer
				level1Gems.get(4).paint(g);//gear
				level1Gems.get(5).paint(g);//hammer
				

				if(!started) {
					start = System.currentTimeMillis();
					started = true;
				}
				time = (System.currentTimeMillis() - start)/1000.0;
				g.drawString("Time: " + time,300,40);
				g.drawString("Stand at lever + press space to move",200,100);

				
				//checking where phineas can walk (i.e. actual ground) and setting up his body's left and right bounds
				if(first.getclr(p.getX() + 25,p.getY()+67) && first.getclr(p.getX()+25, p.getY()+62)==false){
					p.setFlor(p.getY());
				} else {
					p.setFlor(795);
				}
				if(first.getclr(p.getX()+15, p.getY()+60)) {
					p.stop();
				}
				if(first.getclr(p.getX()+50, p.getY()+60)) {
					p.stop();
				}
				if(first.getclr(p.getX()+15, p.getY())){
					p.setCeil(p.getY());
				}else {
					p.setCeil(10);
				}
				
				//checking when ferb can walk(i.e. actual ground) and setting up his body's left and right bounds
				if(first.getclr(p2.getX() + 25,p2.getY()+67) && first.getclr(p2.getX()+25, p2.getY()+62)==false ) {
					p2.setFlor(p2.getY());
				} else {
					p2.setFlor(795);
				}
				if(first.getclr(p2.getX()+15, p2.getY()+58)) {
					p2.stop();
				}
				if(first.getclr(p2.getX()+50, p2.getY()+58)) {
					p2.stop();
				}
				if(first.getclr(p2.getX(), p2.getY())){
					p2.setCeil(p2.getY());
				}else {
					p2.setCeil(10);
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
				
				//did players reach the door together level 1
				if (p.touchDoor(d1) && p2.touchDoor(d1)) {
					d1.changePicture("");
					touchd1=true;
					canRestart = true;
				}
				
				tryagain = false;
				
			}else if (secondStart) {//checking if button to play level 2 has been pressed/'hit'
				back.paint(g);
				second.paint(g);
				pause.paint(g);
				//if button has been pressed, draw the corresponding level and its components

				//perry is drawn
				perry2.paint(g);
				//door is drawn over perry
				d2.paint(g);
				
				//characters are drawn
				p.paint(g);
				p2.paint(g);

				//lavas are dresetrawn
				level2.get(0).paint(g);//green
				level2.get(1).paint(g);//orange
				level2.get(2).paint(g);//orange
				level2.get(3).paint(g);//green
				level2.get(4).paint(g);//green
				level2.get(5).paint(g);//orange

				//gems are reset
				level2Gems.get(0).paint(g);//gear
				level2Gems.get(1).paint(g);//hammer
				level2Gems.get(2).paint(g);//gear
				level2Gems.get(3).paint(g);//hammer
				level2Gems.get(4).paint(g);//gear
				level2Gems.get(5).paint(g);//hammer

				pl2.paint(g);
				lev2.paint(g);
				if(!started) {
					start = System.currentTimeMillis();
					started = true;
				}
				time = (System.currentTimeMillis() - start)/1000.0;
				g.drawString("Time: " + time,300,40);
				g.drawString("Stand at lever + press space to move",200,100);
				//if button has been pressed, draw the corresponding level and its components
			

				//checking where phineas can walk (i.e. actual ground) and setting up his body's left and right bounds
				if(second.getclr(p.getX() + 25,p.getY()+67) && second.getclr(p.getX()+25, p.getY()+62)==false){
					p.setFlor(p.getY());
				} else {
					p.setFlor(795);
				}
				if(second.getclr(p.getX()+15, p.getY()+60)) {
					p.stop();
				}
				if(second.getclr(p.getX()+50, p.getY()+60)) {
					p.stop();
				}
				if(second.getclr(p.getX()+15, p.getY())){
					p.setCeil(p.getY());
				}else {
					p.setCeil(10);
				}
				
				//checking when ferb can walk(i.e. actual ground) and setting up his body's left and right bounds
				if(second.getclr(p2.getX() + 25,p2.getY()+67) && second.getclr(p2.getX()+25, p2.getY()+62)==false ) {
					p2.setFlor(p2.getY());
				} else {
					p2.setFlor(795);
				}
				if(second.getclr(p2.getX()+15, p2.getY()+58)) {
					p2.stop();
				}
				if(second.getclr(p2.getX()+50, p2.getY()+58)) {
					p2.stop();
				}
				if(second.getclr(p2.getX(), p2.getY())){
					p2.setCeil(p2.getY());
				}else {
					p2.setCeil(10);
				}
				
				//checking if phineas stepped into green in level 1
				if(p.crossedLava(level2.get(0)) || p.crossedLava(level2.get(3)) || p.crossedLava(level2.get(4))){
					p.dissapear(null);
					p2.dissapear(null);
					canRestart = true;
				}
				//checking if ferb stepped into orange in level 1
				if(p2.crossedLava(level2.get(1)) || p2.crossedLava(level2.get(2)) || p2.crossedLava(level2.get(5))){
					p2.dissapear(null);
					p.dissapear(null);;
					canRestart = true;
				}
				
				//did players reach door
				if (p.touchDoor(d2) && p2.touchDoor(d2)) {
					d2.changePicture("");
					touchd2 = true;
					canRestart = true;
				}
				
				tryagain = false;
			}else if (thirdStart) {//checking if button to play level 3 has been pressed/'hit'
				back.paint(g);
				third.paint(g);
				pause.paint(g);
				//if button has been pressed, draw the corresponding level and its components
				
				//perry is drawn
				perry3.paint(g);
				//door is drawn over perry
				d3.paint(g);
				
				//characters are drawn
				p.paint(g);
				p2.paint(g);

				
				//lavas are reset
				level3.get(0).paint(g);//orange
				level3.get(1).paint(g);//green
				level3.get(2).paint(g);//orange
				level3.get(3).paint(g);//green
				level3.get(4).paint(g);//green
				level3.get(5).paint(g);//orange
				level3.get(6).paint(g);//orange
				level3.get(7).paint(g);//green
				level3.get(8).paint(g);//green
				level3.get(9).paint(g);//orange

				//gems are reset
				level3Gems.get(0).paint(g);//gear
				level3Gems.get(1).paint(g);//hammer
				level3Gems.get(2).paint(g);//gear
				level3Gems.get(3).paint(g);//hammer
				
				//levers are drawn
				lev1.paint(g);
				pl.paint(g);
				//start = System.currentTimeMillis();
				//finish = System.currentTimeMillis();
				//long timeElapsed = finish - start;
				if(!started) {
					start = System.currentTimeMillis();
					started = true;
				}
				time = (System.currentTimeMillis() - start)/1000.0;
				g.drawString("Time: " + time,300,40);
				//if button has been pressed, draw the corresponding level and its components
			

				//checking where phineas can walk (i.e. actual ground) and setting up his body's left and right bounds
				if(third.getclr(p.getX() + 25,p.getY()+67) && third.getclr(p.getX()+25, p.getY()+62)==false){
					p.setFlor(p.getY());
				} else {
					p.setFlor(795);
				}
				if(third.getclr(p.getX()+15, p.getY()+60)) {
					p.stop();
				}
				if(third.getclr(p.getX()+50, p.getY()+60)) {
					p.stop();
				}
				if(third.getclr(p.getX()+15, p.getY())){
					p.setCeil(p.getY());
				}else {
					p.setCeil(10);
				}
				
				//checking when ferb can walk(i.e. actual ground) and setting up his body's left and right bounds
				if(third.getclr(p2.getX() + 25,p2.getY()+67) && third.getclr(p2.getX()+25, p2.getY()+62)==false) {
					p2.setFlor(p2.getY());
				} else {
					p2.setFlor(795);
				}
				if(third.getclr(p2.getX()+15, p2.getY()+60)) {
					p2.stop();
				}
				if(third.getclr(p2.getX()+50, p2.getY()+60)) {
					p2.stop();
				}
				if(third.getclr(p2.getX()+15, p2.getY())){
					p2.setCeil(p2.getY());
				}else {
					p2.setCeil(10);
				}
				
				//checking if phineas stepped into green in level 3
				if(p.crossedLava(level3.get(1)) || p.crossedLava(level3.get(3)) || p.crossedLava(level3.get(4)) || p.crossedLava(level3.get(7)) || p.crossedLava(level3.get(8))){
					p.dissapear(null);
					p2.dissapear(null);
					canRestart = true;
				}
				
				//checking if ferb stepped into orange in level 3
				if(p2.crossedLava(level3.get(0)) || p2.crossedLava(level3.get(2)) || p2.crossedLava(level3.get(5)) || p.crossedLava(level3.get(6)) || p.crossedLava(level3.get(9))){
					p2.dissapear(null);
					p.dissapear(null);;
					canRestart = true;
				}
				
				//did players reach the door together
				if(p.touchDoor(d3) && p2.touchDoor(d3)) {
					d3.changePicture("");
					touchd3 = true;
					canRestart = true;
				}
				
				tryagain = false;
			}
		}
		
		
		//did corresponding player collect their gem in level 1
		if(p.grabbedGem(level1Gems.get(0))) {//phineas collected
			level1Gems.get(0).restart("");
		}
		if(p2.grabbedGem(level1Gems.get(1))) {//ferb collected
			level1Gems.get(1).restart("");
		}
		if(p.grabbedGem(level1Gems.get(2))) {//phineas collected
			level1Gems.get(2).restart("");
		}
		if(p2.grabbedGem(level1Gems.get(3))) {//ferb collected
			level1Gems.get(3).restart("");
		}
		if(p.grabbedGem(level1Gems.get(4))) {//phineas collected
			level1Gems.get(4).restart("");
		}
		if(p2.grabbedGem(level1Gems.get(5))) {//ferb collected
			level1Gems.get(5).restart("");
		}
		
		
		//did corresponding player collect their gem in level 2
		if(p.grabbedGem(level2Gems.get(0))) {//phineas collected
			level2Gems.get(0).restart("");
		}
		if(p2.grabbedGem(level2Gems.get(1))) {//ferb collected
			level2Gems.get(1).restart("");
		}
		if(p.grabbedGem(level2Gems.get(2))) {//phineas collected
			level2Gems.get(2).restart("");
		}
		if(p2.grabbedGem(level2Gems.get(3))) {//ferb collected
			level2Gems.get(3).restart("");
		}
		if(p.grabbedGem(level2Gems.get(4))) {//phineas collected
			level2Gems.get(4).restart("");
		}
		if(p2.grabbedGem(level2Gems.get(5))) {//ferb collected
			level2Gems.get(5).restart("");
		}
		
		//did corresponding player collect their gem in level 3
		if(p.grabbedGem(level3Gems.get(0))) {//phineas collected
			level3Gems.get(0).restart("");
		}
		if(p2.grabbedGem(level3Gems.get(1))) {//ferb collected
			level3Gems.get(1).restart("");
		}
		if(p.grabbedGem(level3Gems.get(2))) {//phineas collected
			level3Gems.get(2).restart("");
		}
		if(p2.grabbedGem(level3Gems.get(3))) {//ferb collected
			level3Gems.get(3).restart("");
		}

		if (canRestart) {//checking if pause button was clicked 
			candace.paint(g);
			restartMenu.paint(g);
			menu.paint(g);
			if (touchd1==false && touchd2==false && touchd3==false) {
				restart.paint(g);
			}
			finish = time;
			//g.drawString("Total time: " ,300,500);
			started = false;
			//pause menu components are drawn (menu button and restart the level button			
			if (touchd1 || touchd2 || touchd3) {
				g.setColor( new Color(13, 169, 189));
				g.fillRect(315, 390, 220, 30);
				g.setColor(Color.WHITE);
				Font f1 = new Font("Times New Roman", Font.ITALIC , 16);
				g.setFont(f1);
				g.drawString("Congratulations you found Perry!", 320, 410);
			}
			
			touchd1 = false;
			touchd2 = false;
			touchd3 = false;
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
		Timer t = new Timer(13, this);
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
			p.restart("Phin.png", 30,690);//30,690
			p2.restart("Ferb.png", 30,690);//30,690
			d1.changePicture("door.png");
		}
		if(two.hit(arg0)) {
			canRestart = false;
			secondStart = true;
			firstStart = false;
			thirdStart = false;
			p.restart("Phin.png", 30, 20);
			p2.restart("Ferb.png", 30, 20);
			d2.changePicture("door.png");
		}
		if(three.hit(arg0)) {
			canRestart = false;
			thirdStart = true;
			firstStart = false;
			secondStart = false;
			p.restart("Phin.png", 380, 20);
			p2.restart("Ferb.png", 380, 20);
			d3.changePicture("door.png");
		}
		if(pause.hit(arg0)) {
			canRestart = true;
		}
		if(menu.hit(arg0)) {
			home = true;
			canRestart = false;
			
			//restarting players
			if(firstStart) {
				p.restart("Phin.png", 30, 690);
				p2.restart("Ferb.png", 30, 690);
				d1.changePicture("door.png");
			}else if(secondStart) {
				p.restart("Phin.png", 30, 20);
				p2.restart("Ferb.png", 30, 20);
				d2.changePicture("door.png");
			}else if(thirdStart) {
				p.restart("Phin.png", 380, 20);
				p2.restart("Ferb.png", 380, 20);
				d3.changePicture("door.png");
			}
			
			//restarting all gems
			level1Gems.get(0).restart("gearGEM2t.gif");
			level1Gems.get(1).restart("hammerGEM1t.gif");
			level1Gems.get(2).restart("gearGEM2t.gif");
			level1Gems.get(3).restart("hammerGEM1t.gif");
			level1Gems.get(4).restart("gearGEM2t.gif");
			level1Gems.get(5).restart("hammerGEM1t.gif");
			
			//restarting all gems in level 2
			level2Gems.get(0).restart("gearGEM2t.gif");
			level2Gems.get(1).restart("hammerGEM1t.gif");
			level2Gems.get(2).restart("gearGEM2t.gif");
			level2Gems.get(3).restart("hammerGEM1t.gif");
			level2Gems.get(4).restart("gearGEM2t.gif");
			level2Gems.get(5).restart("hammerGEM1t.gif");
			
			//restarting all gems in level 3
			level3Gems.get(0).restart("gearGEM2t.gif");
			level3Gems.get(1).restart("hammerGEM1t.gif");
			level3Gems.get(2).restart("gearGEM2t.gif");
			level3Gems.get(3).restart("hammerGEM1t.gif");
			
			firstStart = false;
			secondStart = false;
			thirdStart = false;
		}
		if(restart.hit(arg0)) {
			
			//restarting players
			if(firstStart) {
				p.restart("Phin.png", 30, 690);
				p2.restart("Ferb.png", 30, 690);
				d1.changePicture("door.png");
			} else if(secondStart) {
				p.restart("Phin.png", 30, 20);
				p2.restart("Ferb.png", 30, 20);
				d2.changePicture("door.png");
			} else if(thirdStart) {
				p.restart("Phin.png", 380, 20);
				p2.restart("Ferb.png", 380, 20);
				d3.changePicture("door.png");
			}
			
			
			//restarting all gems in level 1
			level1Gems.get(0).restart("gearGEM2t.gif");
			level1Gems.get(1).restart("hammerGEM1t.gif");
			level1Gems.get(2).restart("gearGEM2t.gif");
			level1Gems.get(3).restart("hammerGEM1t.gif");
			level1Gems.get(4).restart("gearGEM2t.gif");
			level1Gems.get(5).restart("hammerGEM1t.gif");
			
			//restarting all gems in level 2
			level2Gems.get(0).restart("gearGEM2t.gif");
			level2Gems.get(1).restart("hammerGEM1t.gif");
			level2Gems.get(2).restart("gearGEM2t.gif");
			level2Gems.get(3).restart("hammerGEM1t.gif");
			level2Gems.get(4).restart("gearGEM2t.gif");
			level2Gems.get(5).restart("hammerGEM1t.gif");
			
			//restarting all gems in level 3
			level3Gems.get(0).restart("gearGEM2t.gif");
			level3Gems.get(1).restart("hammerGEM1t.gif");
			level3Gems.get(2).restart("gearGEM2t.gif");
			level3Gems.get(3).restart("hammerGEM1t.gif");
			
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
		//System.out.println(arg0.getKeyCode());
		
		//phineas movements (up,right, and left keys)
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
		
		
		//ferb movements(A,D, and W keys)
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

		//stoping characters from moving horizontally once they dissapear
		if(canRestart) {
			p.stop();
			p2.stop();
			
		}
		
		if(p.touchLev() == true && arg0.getKeyCode() == 32 || p2.touchLev() == true && arg0.getKeyCode() == 32){
			if (lev1.getCt() == 0) {
				lev1.changePicture(670,75);
				pl.move(0,200);
				lev1.setCt(1);
				System.out.print(lev1.getCt());
			}else{
				lev1.changeBack(670,75);
				pl.move(0,-200);
				lev1.setCt(0);
				System.out.print(lev1.getCt());
			}
			
			if (lev2.getCt() == 0) {
				lev2.changePicture(530,370);
				pl2.move(400,0);
				lev2.setCt(1);
				System.out.print(lev2.getCt());
			}else{
				lev2.changeBack(530,370);
				pl2.move(-400,0);
				lev2.setCt(0);
				System.out.print(lev2.getCt());
			}
			
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