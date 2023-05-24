

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

import imgs.Lava;

public class Player{
	private Image img; 	
	private AffineTransform tx;
	private int x,y;
	private double vx, vy;
	private int floor= 700;
	private int Lwall= 0;
	private int Rwall= 700;
	private double gravity = 0.1;
	

	public Player(String fileName) {
		img = getImage("/imgs/"+fileName); //load the image for Phineas
		x = 0;
		y = 0;
		tx = AffineTransform.getTranslateInstance(x, y); 
		
	}
	
	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		init(0, 0);
	}
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
		update();
		g.drawRect((int) x+15, (int) y, 20, 80);
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a,b);
		tx.scale(.05, .05);
	}
	
	public void restart() {
		x = 0;
		y = 0;
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
		vx = -1.5;
	
		img = getImage("/imgs/Phinflip.png");
	}
	
	public void moveLeft(){
		vx = 3;
		img = getImage("/imgs/Phineas.png");
		
		
	}
	
	public void jump() {
		if(y == floor) {
			vy = -5;
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
	
	public void update() {
		tx = AffineTransform.getTranslateInstance(x, y);
		tx.scale(0.75,0.75);
		x += vx;
		y += vy;
		vy += gravity;
		
		
		
		if (y >= floor) {
			y = floor;
			vy =0;
		} else {
			vy+= gravity;
		}
		
		if(x <= Lwall) {
			x = Lwall;
		}
		if(x >= Rwall) {
			x = Rwall;
		}
		
		//System.out.println("X location " + getX() + ", Y location " + getY());

	}
	public void dissapear(Image img) {
		this.img = img;
	}
	
	public double getHeight() {
		return y;
	}		
	
	public boolean crossedLava(Lava l) {
		boolean crossed = false;
		
		//represent the mouse as a rectangle object
		Rectangle lava = new Rectangle(l.getX()+60, l.getY()+105, 80, 20);
					
		//level press box
		Rectangle player = new Rectangle(x+15, y, 20, 80);
		
		if(player.intersects(lava)) {
			crossed = true;
		}
		
		
		return crossed;
	}
	
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Player.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);//"phineas.png");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	
	
	
	
	
	

}