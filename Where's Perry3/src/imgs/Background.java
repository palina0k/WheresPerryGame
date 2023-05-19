package imgs;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;


public class Background {
	
	private int x,y; //location attributes
	private Image img; 	
	private AffineTransform tx;
	private BufferedImage color;
	private int clr; 
		
	//default constructor
	public Background() {
		img = getImage("/imgs/homepage.png");  //load the image
		tx = AffineTransform.getTranslateInstance(x,y);
		//initialize the location of the image, use your variables
		x = 0;
		y = 0;
	}
		
	//constructor that allows specifying the file name of the image
	//sets fileName of the image to use
	public Background(String fileName) {
		img = getImage("/imgs/" + fileName);
		tx = AffineTransform.getTranslateInstance(x,y);
		init(x,y);
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
		tx.scale(8,8);
	}
	
	/*
	public boolean getclr(int x, int y) {
		boolean check = false;
	
		int clr = color.getRGB(x, y);
        int red =   (clr & 0x00ff0000) >> 16;
        int green = (clr & 0x0000ff00) >> 8;
        int blue =   clr & 0x000000ff;
        System.out.println("Red Color value = " + red);
        System.out.println("Green Color value = " + green);
        System.out.println("Blue Color value = " + blue);
		if(red == 61 && blue == 32 && green == 6) {
			//return true;
			//System.out.println("yas");
			check = true;
		}

		
		System.out.println("Red Color value = " + red);
        System.out.println("Green Color value = " + green);
        System.out.println("Blue Color value = " + blue);
        
		return check;
	}
	*/
		
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(8,8);
		
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Background.class.getResource(path);
			color = ImageIO.read(imageURL);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}
