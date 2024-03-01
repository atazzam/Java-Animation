package graphicsstuff;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;



public class MovingBee {
	/* class for moving bees */
	
	private int x;				// position of the bee (x,y)
	private int y;
	
	private int dx;				// velocity of the bee v = <dx,dy>
	private int dy;
	
	private boolean flap;
	private static Random R;
	
	
	public MovingBee(int x_pos, int y_pos) {
		/* constructor for stationary bees */
		x = x_pos;
		y = y_pos;
		dx = 0;
		dy = 0;
		flap = false;
		R = new Random();
	}
	
	public MovingBee(int x_pos, int y_pos, int vel_x, int vel_y) {
		/* constructor for flying bees */
		x = x_pos;
		y = y_pos;
		dx = vel_x;
		dy = vel_y;
		flap = true;
		
		// set speed to zero
		dx = 0;
		dy = 0;
		R = new Random();
	}
	
	public void update(int width, int height) {
		/* code for the animation */
		if ( x > width || x < 0) dx *= -1;			// check for edge
		if ( y > height || y < 0) dy *= -1;
	
		
		//if (dx != 0 || dy != 0) {
		if (flap) flap = false;					// swap wing flapping
		else flap = true;
		//}
		
		x = R.nextInt(width);			// random position
		y = R.nextInt(height/3);
		
		
		//x = x + dx;									// move bee
		//y = y + dy;
		
	}
	
	public void draw(Graphics g) {
		/* code to decide which way to face */
		if (dx > 0) drawright(g);
		else drawleft(g);
	}
	
	public void drawright(Graphics g) {
		/* code to draw the bee using Java awt graphics */
		g.setColor(Color.gray);								// rear wings
		if (flap) g.fillOval(x + 35, y - 35, 20, 40);
		//else g.fillOval(x + 40, y - 15, 40, 20);
		
		g.setColor(Color.black);
		if (flap) g.drawOval(x + 35, y - 35, 20, 40);
		//else g.drawOval(x + 40, y - 15, 40, 20);
		
		
		
		g.setColor(Color.gray);
		if (flap) g.fillOval(x + 45, y - 25, 20, 40);
		//else g.fillOval(x + 50, y - 5, 40, 20);
		
		g.setColor(Color.black);
		if (flap) g.drawOval(x + 45, y - 25, 20, 40);
		//else g.drawOval(x + 50, y - 5, 40, 20);
		
		
		
		
		
		
		g.setColor(Color.black);							// stinger
		g.drawLine(x - 15, y + 30, x + 10, y + 10);
		
		g.setColor(Color.black);							// tail
		g.fillOval(x, y, 50, 50);
		g.setColor(Color.yellow);
		g.fillOval(x + 10, y, 50, 50);
		g.setColor(Color.black);
		g.fillOval(x + 20, y, 50, 50);
		g.setColor(Color.yellow);
		g.fillOval(x + 30, y, 50, 50);
		
		
		g.setColor(Color.gray);								// front wings
		if (flap) g.fillOval(x + 25, y - 25, 20, 40);
		//else g.fillOval(x + 10, y - 5, 40, 20);
		
		g.setColor(Color.black);
		if (flap) g.drawOval(x + 25, y - 25, 20, 40);
		//else g.drawOval(x + 10, y - 5, 40, 20);
		
		g.setColor(Color.gray);
		if (flap) g.fillOval(x + 35, y - 15, 20, 40);
		//else g.fillOval(x + 20, y + 5, 40, 20);
		
		g.setColor(Color.black);
		if (flap) g.drawOval(x + 35, y - 15, 20, 40);
		//else g.drawOval(x + 20, y + 5, 40, 20);
		
		
		
		
		g.setColor(Color.black);							// head
		g.fillOval(x + 40, y, 50, 40);
		
		g.setColor(Color.yellow);							// face
		g.fillOval(x + 55, y + 15, 8, 8);
		g.fillOval(x + 70, y + 15, 8, 8);
		g.drawArc(x + 55, y + 10, 24, 24, -20, -140);
	}
	
	public void drawleft(Graphics g) {
		/* code to draw the bee using Java awt graphics */
		g.setColor(Color.gray);								// rear wings
		if (flap) g.fillOval(x - 25, y - 35, 20, 40);
		//else g.fillOval(x - 30, y - 15, 40, 20);
		g.setColor(Color.black);
		if (flap) g.drawOval(x - 25, y - 35, 20, 40);
		//else g.drawOval(x - 30, y - 15, 40, 20);
		g.setColor(Color.gray);
		if (flap) g.fillOval(x - 35, y - 25, 20, 40);
		//else g.fillOval(x - 40, y - 5, 40, 20);
		g.setColor(Color.black);
		if (flap) g.drawOval(x - 35, y - 25, 20, 40);
		//else g.drawOval(x - 40, y - 5, 40, 20);
		
		g.setColor(Color.black);							// stinger
		g.drawLine(x + 45, y + 10, x + 55, y + 30);
		
		g.setColor(Color.black);							// tail
		g.fillOval(x, y, 50, 50);
		g.setColor(Color.yellow);
		g.fillOval(x - 10, y, 50, 50);
		g.setColor(Color.black);
		g.fillOval(x - 20, y, 50, 50);
		g.setColor(Color.yellow);
		g.fillOval(x - 30, y, 50, 50);
		
		g.setColor(Color.gray);								// front wings
		if (flap) g.fillOval(x - 15, y - 25, 20, 40);
		//else g.fillOval(x, y - 5, 40, 20);
		g.setColor(Color.black);
		if (flap) g.drawOval(x - 15, y - 25, 20, 40);
		//else g.drawOval(x, y - 5, 40, 20);
		g.setColor(Color.gray);
		if (flap) g.fillOval(x - 25, y - 15, 20, 40);
		//else g.fillOval(x - 10, y + 5, 40, 20);
		g.setColor(Color.black);
		if (flap) g.drawOval(x - 25, y - 15, 20, 40);
		//else g.drawOval(x - 10, y + 5, 40, 20);
		
		g.setColor(Color.black);							// head
		g.fillOval(x - 40, y, 50, 40);
		
		g.setColor(Color.yellow);							// face
		g.fillOval(x - 10, y + 15, 8, 8);
		g.fillOval(x - 25, y + 15, 8, 8);
		g.drawArc(x - 25, y + 10, 24, 24, -20, -140);
	}
}

