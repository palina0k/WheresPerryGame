package imgs;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Buttons{
	
	private int x,y; //location attributes
	private Image img; 	
	private AffineTransform tx;
		
	//default constructor
	public Buttons() {
		img = getImage("/imgs/level1logo.png");  //load the image
		tx = AffineTransform.getTranslateInstance(x,y);
		//initialize the location of the image, use your variables
		x = 0;
		y = 0;
	}
		
	//constructor that allows specifying the file name of the image
	//sets fileName of the image to use
	public Buttons(String fileName, int initx, int inity) {
		img = getImage("/imgs/" + fileName);
		tx = AffineTransform.getTranslateInstance(x,y);
		x = initx;
		y = inity;
	}
		
		
	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		init(0, 0);
	}
		
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		update();
		g2.drawImage(img, tx, null);

	}
		
	//update the picture variable location
	private void update() {
		tx.setToTranslation(x, y);
		tx.scale(0.75, 0.75);
	}
		
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(0.75, 0.75);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Buttons.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	
	//helper method for pressing button on home page
	public boolean hit(MouseEvent mouse) {
		//represent the mouse as a rectangle object
		Rectangle m = new Rectangle(mouse.getX(), mouse.getY(), 50, 50);
			
		//level press box
		Rectangle d = new Rectangle(x,y, 75, 75);
			
		//check if the two boxes overlap
		if(m.intersects(d)) {
				
			//changePicture("/imgs/santa.png");
			//instead of changing level picture, call to another class to pull the correct level
			System.out.println("Pressed Button successfully");
			return true;
		}else {
			System.out.println("Unsuccessful Press");
		}
			
			return false;
		}

}
