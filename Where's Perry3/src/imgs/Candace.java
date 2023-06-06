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

public class Candace {
	private int x,y; //location attributes
	private Image img2; 	
	private AffineTransform tx;
		
	//default constructor
	public Candace() {
		img2 = getImage("/imgs/Candace.png");  //load the image
		tx = AffineTransform.getTranslateInstance(x,y);
		//initialize the location of the image, use your variables
		x = 300;
		y = 100;
	}
		
	//constructor that allows specifying the file name of the image
	//sets fileName of the image to use
	public Candace(String fileName) {
		img2 = getImage("/imgs/" + fileName);
		tx = AffineTransform.getTranslateInstance(x,y);
		init(x,y);
	}
		
		
	public void changePicture(String newFileName) {
		img2 = getImage(newFileName);
		init(0, 0);
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
		tx.scale(3, 3);
	}
		
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(3, 3);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = RestartMenu.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
}
