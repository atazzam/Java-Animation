package graphicsstuff;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;



public class flower {
	/* class for flower objects */
	
	private int x;			// position
	private int y;
	
	private Random R;		// random object
	private int shift;		// horizontal direction
	private int height;		// vertical
	
	private Color green;	// custom colors
	private Color red;
	
	
	public flower(int x_pos, int y_pos) {
		/* constructor for flower class */
		x = x_pos;
		y = y_pos;
		R = new Random();
		shift = 20 - R.nextInt(40);
		height = 50 + R.nextInt(25);
		set_color();
		red = new Color(228,49,43);
	}

	public void set_color() {
		/* creates a randomized Green color-----Grass Green: 124, 252, 0 */
		int r = 110 + R.nextInt(14);		// randomize red shade
		int g = 120 + R.nextInt(35);	// randomize green shade
		green = new Color(r, g, 0);		// random color
	}
	
	public void draw(Graphics g) {
		/* draws one flower on screen at position (x,y) */
		int top_x = x + shift;
		int top_y = y - height;
		
		g.setColor(green);								// draw stem
		g.drawLine(x, y, top_x, top_y);
		g.drawLine(x+1, y, top_x+1, top_y);
		g.drawLine(x+2, y, top_x+2, top_y);
		g.drawLine(x+3, y, top_x+3, top_y);
		
		g.setColor(new Color(20, 153, 84));				// draw leaves
		int A[] = {top_x,top_x + 15,top_x + 17,top_x + 30, top_x + 25, top_x + 30, top_x + 15};
		int B[] = {top_y,top_y - 20,top_y - 15,top_y - 25,top_y - 5,top_y - 5,top_y + 7};
		g.fillPolygon(A, B, 7);
		
		
		int C[] = {top_x,top_x + 30,top_x + 35,top_x + 20};
		int D[] = {top_y,top_y + 10,top_y + 25,top_y + 10};
		g.fillPolygon(C, D, 4);
		
		
		int E[] = {top_x,top_x - 20,top_x - 25,top_x};
		int F[] = {top_y,top_y + 20,top_y + 40,top_y + 10};
		g.fillPolygon(E, F, 4);
		
		
		int X[] = {0,-5,-20,-20,-5};						// locations for petals
		int Y[] = {0,-10,-8,+8,+10};
		
		int i = 0;
		while (i < 5) {
			g.setColor(red);								// draw petals (in red)
			g.fillOval(top_x + X[i], top_y + Y[i], 25, 25);
			
			g.setColor(Color.black);						// edge of petal (in black)
			g.drawOval(top_x + X[i], top_y + Y[i], 24, 24);
			
			i += 1;
		}
		
		g.setColor(Color.white);							// draw center of poppy
		g.fillOval(top_x - 6, top_y + 3, 18, 18);
		g.setColor(Color.black);
		g.fillOval(top_x - 5, top_y + 5, 15, 15);
	}
}
