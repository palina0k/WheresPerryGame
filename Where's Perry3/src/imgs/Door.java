package imgs;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

public class Door {
	private int x,y; //location attributes
	private Image img2; 	
	private AffineTransform tx; 
		
	//default constructor
	public Door(int x, int y) {
		img2 = getImage("/imgs/door.png");  //load the image
		tx = AffineTransform.getTranslateInstance(x,y);
		//initialize the location of the image, use your variables
		this.x = x;
		this.y = y;
	}	
		
	public void changePicture(String newFileName) {
		img2 = getImage(newFileName);
		init(x,y);
	}
		
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		update();
		g2.drawImage(img2, tx, null);

	}
		
	//update the picture variable location
	private void update() {
		tx.setToTranslation(x, y);
		tx.scale(2,2);
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(2,2);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Level.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

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
	
}
