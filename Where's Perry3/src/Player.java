

import java.io.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import imgs.Door;
import imgs.Gems;
import imgs.Lava;

public class Player{
	private Image img; 	
	private AffineTransform tx;
	private int x,y;
	private double vx ,vy;
	private int floor= 700;
	private int Lwall= 15;
	private int Rwall= 750;
	private int ceil= 10;
	private double gravity = 0.15;
	

	public Player(String fileName) {
		img = getImage("/imgs/"+fileName); //load the image for Phineas
		x = 30;
		y = 30;
		tx = AffineTransform.getTranslateInstance(x, y); 
		
	}
	
	public void changePicture(String fileName) {
		//img = getImage("/imgs/Phinflip.png");
		img = getImage("/imgs/"+fileName);
	}
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
		update();
		
		g.drawRect((int) x, (int)y, 10, 10);

		g.drawRect((int) x+15, (int) y, 20, 80);
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a,b);
		tx.scale(.05, .05);
	}
	
	public void stop(){
		vx = 0;	
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void moveRight(){
		vx = -3;
	

	}
	
	public void moveLeft(){
		vx = 3;
		
		
	}
	
	public void jump() {
		if(y == floor) {
			vy = -6;
		}
		

	}
	
	public void setFlor(int val) {
		floor = val;
	}
	
	public void setLwall(int val) {
		Lwall = val;
	}
	
	public void setRwall(int val) {
		Rwall = val;
	}	
	
	public void setCeil(int val) {
		ceil = val;
	}
	
	public void update() {
		tx = AffineTransform.getTranslateInstance(x, y);
		tx.scale(0.65,0.65);
		x += vx;
		y += vy;
		vy += gravity;
		
		
		
		if (y >= floor) {
			y = floor;
			vy =0;
		} else {
			vy+= gravity;
		}
		
		if(y <= ceil) {
			vy = 6;
			
		}
		
		if(x <= Lwall) {
			x = Lwall;
		}
		if(x >= Rwall) {
			x = Rwall;
		}
		
		//touchLev();
	
	}
	
	public boolean touchLev() {
		//represent mouse as rectangle
		Rectangle p = new Rectangle(x,y,70,70);
		
		//lever
		Rectangle l = new Rectangle (670,75,90,90);
		
		if(p.intersects(l)) {
			System.out.println("hit");
			return true;
			
		}
		
		return false;
		//System.out.println("X location " + getX() + ", Y location " + getY());

	}
	public void restart(String filename, int initx, int inity) {
		dissapear(getImage("/imgs/"+filename));
		x = initx;
		y = inity;
		Lwall = 15;
		Rwall = 750;
		update();
		
	}
	//when steps in wrong lava
	public void dissapear(Image image) {
		img = image;
		vx = 0;
	}
	
	public double getHeight() {
		return y;
	}		
	
	//helper method to detect if player walked through wrong lava
	public boolean crossedLava(Lava l) {
		boolean crossed = false;
		
		//represent the lava as a rectangle object
		Rectangle lava = new Rectangle(l.getX()+60, l.getY()+105, 80, 20);
					
		//player rectangle box
		Rectangle player = new Rectangle(x+15, y, 20, 63);
		
		if(player.intersects(lava)) {
			crossed = true;
		}
		
		
		return crossed;
	}
	
	//helper method to detect if player picked up correct gem
	public boolean grabbedGem(Gems gem) {
		boolean didGrab = false;
		
		//represent the gem as a rectangle object
		Rectangle gems = new Rectangle(gem.getX(), gem.getY(), 35, 35);
							
		//player rectangle box
		Rectangle player = new Rectangle(x+15, y, 20, 63);
				
		if(player.intersects(gems)) {
			didGrab = true;
		}
		
		return didGrab;
	}
	
	//helper method for detecting when both players are at the door
	public boolean touchDoor(Door door) {
		//represent the door as a rectangle object
		Rectangle m = new Rectangle(door.getX(), door.getY(), 30, 30);
				
		//player rectangle
		Rectangle p = new Rectangle(x+15,y, 20, 63);
				
		//check if the two boxes overlap
		if(m.intersects(p)) {
			return true;
		}
				
			return false;
	}
	
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Player.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	
	
	
	
	
	

}