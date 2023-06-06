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

public class Levers {
	private int x,y; //location attributes
	private Image img; 	 	
	private AffineTransform tx;
	private BufferedImage color;
	int ct = 0; 
		
	//constructor that allows specifying the file name of the image
	//sets fileName of the image to use
	public Levers(int initx, int inity) {
		img = getImage("/imgs/" + "LeverUnchanged.png");//load the image
		tx = AffineTransform.getTranslateInstance(x,y);
		x = initx;
		y = inity;
	}
		
		
	public void changePicture(int initx, int inity) {
		img = getImage("/imgs/" + "LeverChanged.png");
		x = initx;
		y = inity;
	}
	
	public void changeBack(int initx, int inity) {
		img = getImage("/imgs/" + "LeverUnchanged.png");
		x = initx;
		y = inity;
	}
	
	public int getCt() {
		return ct;
	}
	
	public void setCt(int val) {
		ct = val;
	}
		
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		update();
		g2.drawImage(img, tx, null);

	}
	
	public boolean getclr(int x, int y) {
		boolean check = false;
		Color c = new Color(color.getRGB(x, y));
	
	
		if(c.getRed() == 48 && c.getGreen() == 31 && c.getBlue() == 23) {
			//return true;
			check = true;
			//return true;
		}
		return check;	
	}
		
	//update the picture variable location
	private void update() {
		tx.setToTranslation(x, y);
		tx.scale(1.25,1.25);
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1,1);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Level.class.getResource(path);
			color = ImageIO.read(imageURL);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
}
