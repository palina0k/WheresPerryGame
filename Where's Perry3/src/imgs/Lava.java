package imgs;

import java.awt.image.BufferedImage;

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

public class Lava {
	private int x,y; //location attributes
	private Image img; 	
	private AffineTransform tx;
	private BufferedImage color;
		
	//constructor that allows specifying the file name of the image
	//sets fileName of the image to use
	public Lava(String fileName, int initx, int inity) {
		img = getImage("/imgs/" + fileName);//load the image
		tx = AffineTransform.getTranslateInstance(x,y);
		x = initx;
		y = inity;
	}
		
		
	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		init(x,y);
	}
		
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		update();
		g2.drawImage(img, tx, null);
		//g.drawRect(x+60, y+105, 80, 20);

	}
	
	//update the picture variable location
	private void update() {
		tx.setToTranslation(x, y);
		tx.scale(3,2);
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(3,2);
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Lava.class.getResource(path);
			color = ImageIO.read(imageURL);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
}
