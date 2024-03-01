package graphicsstuff;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;



public class grass {
	/* class for grass objects */
	
	private int x;			// position
	private int y;
	private Random R;		// random object
	private int shift;		// horizontal direction
	private int height;		// vertical
	private Color c;		// custom color for grass
	
	
	public grass(int x_pos, int y_pos) {
		/* constructor for grass objects */
		x = x_pos;
		y = y_pos;
		R = new Random();
		shift = 10 - R.nextInt(10);
		height = R.nextInt(50);
		set_color();
	}
	
	public void set_color() {
		/* creates a randomized Green color-----Grass Green: 124, 252, 0 */
		int red = 100 + R.nextInt(24);		// randomize red shade
		int green = 200 + R.nextInt(55);	// randomize green shade
		c = new Color(red, green, 0);		// random color
	}
	
	public void draw(Graphics g) {
		/* draws a single blade of grass at position (x,y) */
		g.setColor(c);
		g.drawLine(x, y, x + shift, y - height);
	}
}
