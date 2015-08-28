package exercise1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Negation {
	public String negate() {
		BufferedImage image = null;
		File f = null;
		String out="";
		try {
		
			f = new File("images/test1.jpg");
			image = ImageIO.read(f);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		int width = image.getWidth();
		int height = image.getHeight();
		
		for(int y = 0;y < height;y++) {
			for(int x = 0;x < width;x++) {
				int p = image.getRGB(x, y);
				
				
				int a = (p>>24)&0xff;
				
				int r = (p>>16)&0xff;
				int g = (p>>8)&0xff;
				int b = p&0xff;
				
				r = 255-r;
				g = 255-g;
				b = 255-b;
				
				p = (a<<24) | (r<<16) | (g<<8) | b;
				image.setRGB(x, y, p);
			}
		}
		try {
			out = "images/outputN.jpg";
			f = new File(out);
			ImageIO.write(image, "jpg", f);
		}
		catch (IOException e) {
			e.printStackTrace();
			
		}
		return out;
		
	}
	public static void main(String[]args) {
		Negation negation = new Negation();
		negation.negate();
	}

}
