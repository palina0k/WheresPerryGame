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

public class Perry{
	
	private Image img; 	
	private AffineTransform tx;
	private int x,y;
	

	public Perry() {
		img = getImage("/imgs/perry.png"); //load the image for Perry
		x = 30;//change for each level
		y = 30;//change for each level
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
		
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a,b);
		tx.scale(.05, .05);
	}
	public void update() {
		tx = AffineTransform.getTranslateInstance(x, y);
		tx.scale(0.65,0.65);
	
	}
	
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Perry.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	

}