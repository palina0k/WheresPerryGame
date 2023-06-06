package imgs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

public class Platform {
	private int x,y; //location attributes
	private Image img; 	 	
	private AffineTransform tx;
	private BufferedImage color;
		
	//constructor that allows specifying the file name of the image
	//sets fileName of the image to use
	public Platform(String name, int initx, int inity) {
		img = getImage("/imgs/" + name);//load the image
		tx = AffineTransform.getTranslateInstance(x,y);
		x = initx;
		y = inity;
	}
		
		
	public void changePicture(String newFileName) {
		img = getImage("/imgs/" + newFileName);
		init(x,y);
	}
		
	
	public void move(int Xnum, int Ynum){
		y += Ynum;
		x += Xnum;
	}
	
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		update();
		g2.drawImage(img, tx, null);

	}
	
	public boolean getPclr(int x, int y) {
		boolean check = false;
		Color c = new Color(color.getRGB(x, y));
		
	
	
		if(c.getRed() == 3 && c.getGreen() == 169 && c.getBlue() == 244) {
			//return true;
			check = true;
			//return true;
		}
		
		//System.out.println(check);
		return check;	
	}
		
	//update the picture variable location
	private void update() {
		tx.setToTranslation(x, y);
		tx.scale(0.25,0.25);
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
