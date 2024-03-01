package graphicsstuff;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



@SuppressWarnings("serial")
public class Scene extends JPanel implements ActionListener{
	
	private MovingBee[] bee_list;
	private grass[] grass_list;
	private flower[] flower_list;
	private int num_bees;
	private int num_grass;
	private int num_flowers;
	private int width;
	private int height;
	private Color skyBlue;
	
	
	private Timer time = new Timer(50,this);// timer to schedule animation
	
	public Scene(MovingBee[] b, grass[] g, flower[] f, int w, int h) {
		/* constructor for the Scene */
		bee_list = b;						// list of bee objects
		grass_list = g;						// list of grass objects
		flower_list = f;
		num_bees = b.length;				// number of bees
		num_grass = g.length;				// number of blades of grass
		num_flowers = f.length;
		width = w;							// size of frame
		height = h;
		skyBlue = new Color(135, 206, 235);	// custom color for sky
		
		time.start();						// start the timer (when the Canvas is created)
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		/* main paint method for drawing the scene */
		super.paintComponent(g);
		
		g.setColor(skyBlue);							// draw the sky
		g.fillRect(0, 0, width, height);
		
		g.setColor(Color.green);						// draw the grass (background)
		g.fillRect(0, 2*height/3, width, height);

		
		int i = 0;
		while (i < num_grass) {							// draw the blades of grass
			grass l = grass_list[i];
			l.draw(g);
			i += 1;
		}
		
		i = 0;
		while (i < num_flowers) {						// draw the flowers
			flower f = flower_list[i];
			f.draw(g);
			i += 1;
		}
		
		i = 0;
		while (i < num_bees) {							// draw the bees
			MovingBee b = bee_list[i];
			b.draw(g);
			i += 1;
		}
		
		
		
	}	
	
	public void actionPerformed(ActionEvent e) {
		/* action item */
		
		int i = 0;
		while (i < num_bees) {							// draw the bees
			MovingBee b = bee_list[i];
			b.update(width,height);
			i += 1;
		}
		this.repaint();								// re-paint the Canvas
	}
}
