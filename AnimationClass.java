package graphicsstuff;

import java.awt.*;
import javax.swing.*;
import java.util.Random;



public class AnimationClass {
	/* main class for creating the drawing */
	
	private static int WIDTH = 960;			// size of the window
	private static int HEIGHT = 540;
	
	private static int num_grass = 15000;	// number of objects in lists
	private static int num_flowers = 20;
	private static int num_bees = 4;
	
	private static Random R;				// random number generator
	
	private static grass[] lawn;			// lists of objects
	private static flower[] poppies;
	private static MovingBee[] swarm;
	
	
	public static void main(String[] args) {
		/* main method for the drawing app */
		R = new Random();					// create random number generator object
		
		//----------make the grass-----------------------------------------------
		lawn = new grass[num_grass];
		make_lawn();
		
		//----------make the flowers----------------------------------------------
		poppies = new flower[num_flowers];
		make_flowers();
		
		//----------make the bees-------------------------------------------------
		swarm = new MovingBee[num_bees];
		make_bees();
		
		//----------create the scene----------------------------------------------
		Scene s = new Scene(swarm,lawn,poppies,WIDTH,HEIGHT);
		
		//----------create the frame and start app--------------------------------
		JFrame f = new JFrame("Flying to work");			// frame object		
		f.add(s, BorderLayout.CENTER);
		f.setSize(WIDTH,HEIGHT);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	
	//-----------------------------------helper functions to create objects-------
	public static void make_lawn() {
		/* function to create the grass objects in the lawn */
		int i = 0;
		int x,y;
		
		while (i<num_grass) { 							// loop to create grass
			x = R.nextInt(WIDTH);						// random x-position
			
			y = 2*HEIGHT/3 + R.nextInt(HEIGHT/3);		// random y-position in lower 1/3
			
			lawn[i] = new grass(x,y);					// create grass object
			
			i += 1;
		}
	}
	
	public static void make_flowers() {
		/* function to create the flower objects in the poppies list */
		int i = 0;
		int x,y;
		int yold = 2*HEIGHT/3;
		
		while (i<num_flowers) { 							// loop to create grass
			
			x = 2*WIDTH/3 + R.nextInt(WIDTH/4);				// random x-position
			
			y = yold + R.nextInt(25);						// random y-position in lower 1/3
			while (y < yold || y > HEIGHT - 25) {			// make sure they draw from top down
				y = yold + R.nextInt(25);					// generate a new y-value otherwise
			}
			
			poppies[i] = new flower(x,y);					// create grass object
			
			i += 1;
			yold = y;
		}
	}
	
	public static void make_bees() {
		/* function to create the MovingBee objects in the bee list swarm */
		int i = 0;
		int x,y,dx,dy;
		
		while (i<num_bees) {
			x = R.nextInt(WIDTH/4);			// random position
			y = R.nextInt(HEIGHT/3);			
			dx = 5 - R.nextInt(10);			// random velocity
			dy = 5 - R.nextInt(10);
			
			swarm[i] = new MovingBee(x,y,dx,dy);
			
			
			i += 1;
		}
	}
}
