package exercise1;

import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Blending {
	public String blend() {
		BufferedImage image1 = null;
		File f1 = null;
		String out = "";
		try {
		
			f1 = new File("images/test1.jpg");
			image1 = ImageIO.read(f1);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		int width1 = image1.getWidth();
		int height1 = image1.getHeight();
		
		BufferedImage image2 = null;
		File f2 = null;
		try {
		
			f2 = new File("images/test2.jpg");
			image2 = ImageIO.read(f2);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		for(int y = 0;y < height1;y++) {
			for(int x = 0;x < width1;x++) {
				int p1 = image1.getRGB(x, y);
				int a1 = (p1>>24)&0xff;
				double r1 = (p1>>16)&0xff;
				double g1 = (p1>>8)&0xff;
				double b1 = p1&0xff;
				
				int p2 = image2.getRGB(x, y);
				
				double r2 = (p2>>16)&0xff;
				double g2 = (p2>>8)&0xff;
				double b2 = p2&0xff;
				
				double r3 = (0.8*r1)+(0.2*r2);
				double g3 = (0.8*g1)+(0.2*g2);
				double b3 = (0.8*b1)+(0.2*b2);
				
				int outputR = (int)r3;
				int outputG = (int)g3;
				int outputB = (int)b3;
				
				int p = (a1 << 24) | (outputR << 16) | (outputG << 8) | outputB;
				image1.setRGB(x, y, p);
				
			}
		
		}
		try {
				out = "images/outputB.jpg";
				f2 = new File(out);
				ImageIO.write(image1, "jpg", f2);
			}
			catch (IOException e) {
				e.printStackTrace();
				
			}
			return out;
	}
	
	public static void main(String[]args) {
		Blending blending = new Blending();
		blending.blend();
	}

}
