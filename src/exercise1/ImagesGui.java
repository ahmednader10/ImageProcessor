package exercise1;

import java.awt.GridLayout;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImagesGui extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Blending blending = new Blending();
	private Negation negation = new Negation();
	private JPanel output;
	private JLabel i1 , i2 , i3 , i4;
	public ImagesGui() {
		
		ImageIcon image1 = new ImageIcon("images/test1.jpg");
		ImageIcon image2 = new ImageIcon("images/test2.jpg");
		
		setBounds(100, 100, 820, 620);
		output = new JPanel(null);
		output.setLayout(new GridLayout(2, 2));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("DMET501 Image Processor! ");
		
		i1 = new JLabel();
		i2 = new JLabel();
		i3 = new JLabel();
		i4 = new JLabel();
		
	
		i1.setIcon(image1);
		output.add(i1);
		
		i2.setIcon(image2);
		output.add(i2);
		
		
		String negative = negation.negate();
		ImageIcon image3 =  new ImageIcon(negative);
		String blended = blending.blend();
		ImageIcon image4 = new ImageIcon(blended);
		i3.setIcon(image3);
		output.add(i3);
		
		i4.setIcon(image4);
		output.add(i4);
		
		this.add(output);
	}
	public static void main(String[]args) {
		ImagesGui window = new ImagesGui();
		window.setVisible(true);
	}

}
