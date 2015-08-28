package exercise2;

import javax.swing.*;

import java.awt.*;

public class Snowman
{  
   public static void main(String[] args)
   {  
      SnowmanFrame frame = new SnowmanFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

/**
   A frame that contains a message panel
*/
class SnowmanFrame extends JFrame
{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public SnowmanFrame()
   {
      ImageIcon logo = new ImageIcon("images/The_German_University_in_Cairo_Official_logo.jpg");
      this.setIconImage(logo.getImage());
      setTitle("Snowman at the GUC!");
      setBounds(600,300,DEFAULT_WIDTH, DEFAULT_HEIGHT);
      setResizable(false);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      SnowmanPanel panel = new SnowmanPanel();
      getContentPane().add(panel);
   }
   public static final int DEFAULT_WIDTH = 500;
   public static final int DEFAULT_HEIGHT = 290;  
}

class SnowmanPanel extends JPanel
{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//-----------------------------------------------------------------
   //  Draws a snowman.
   //-----------------------------------------------------------------
   public void paintComponent (Graphics page)
   {
      super.paintComponent(page);
      final int MID = 250;
      final int TOP = 50;

      setBackground (Color.cyan);

      page.setColor (Color.blue);
      page.fillRect (0, 175, 500, 110);  // ground

      page.setColor (Color.yellow);
      page.fillOval (-40, -40, 80, 80);  // sun
      page.setColor (Color.white);
      page.fillOval (MID-20, TOP, 40, 40);      // head
      page.fillOval (MID-35, TOP+35, 70, 50);   // upper torso
      page.fillOval (MID-50, TOP+80, 100, 60);  // lower torso

      page.setColor (Color.black);
      page.fillOval (MID-10, TOP+10, 5, 5);   // left eye
      page.fillOval (MID+5, TOP+10, 5, 5);    // right eye

      page.drawArc (MID-10, TOP+20, 20, 10, 190, 160);   // smile

      page.drawLine (MID-25, TOP+60, MID-50, TOP+40);  // left arm
      page.drawLine (MID+25, TOP+60, MID+55, TOP+60);  // right arm

      page.drawLine (MID-20, TOP+5, MID+20, TOP+5);  // brim of hat
      page.fillRect (MID-15, TOP-20, 30, 25);        // top of hat
   }
}

