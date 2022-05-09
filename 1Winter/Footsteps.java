import processing.core.PApplet;

public class Footsteps extends Winter{
	
	public Winter winter;
	public int  x;
	public int y;
	public int life = 600;
	
	public Footsteps(Winter winter, int x, int y) {
		this.winter = winter;
		this.x = x;
		this.y = y;
		System.out.println(x);
		
	}
	
	void drawRightFoot() { //<-- Function to make Right foot
		  //the foot
		winter.noStroke(); //do not outline each winter.ellipse

		winter.fill(0, 0, 0, 255-PApplet.map(life, 600, 0, 0, 255)); //colour of the foot controlled by r,g,b int varibles
		    //the foot
		    winter.ellipse(x+12,y, 15,28);
		    winter.ellipse(x+8,y-4, 15,28);
		    winter.ellipse(x+8,y+10, 15,28);
		    winter.ellipse(x+4,y+18, 17,15);
		    winter.ellipse(x+6,y-13, 25,20);
		    //its toes
		    winter.ellipse(x-5,y-28, 7,13); //big toe
		    winter.ellipse(x+2,y-28, 6,11); //toe 2
		    winter.ellipse(x+8,y-28, 4,10); //toe 3
		    winter.ellipse(x+13,y-25, 4,8); //toe 4
		    winter.ellipse(x+17,y-23, 3,8); // toe 5
		    life-=2;
		}	
	public void drawLeftFoot() { // <<---- Function to make Left Foot
		winter.noStroke(); //do not outline each winter.ellipse
		winter.fill(0, 0, 0, 255-PApplet.map(life, 600, 0, 0, 255)); //colour of the foot controlled by r,g,b int varibles
		    //the foot
		    winter.ellipse(x-12,y,15,28);
		    winter.ellipse(x-8,y-4, 15,28);
		    winter.ellipse(x-8,y+10, 15,28);
		    winter.ellipse(x-4,y+20,17,15); //top part
		    winter.ellipse(x-6,y-13, 25,20); //bottom part
		    //the toes
		    winter.ellipse(x+5,y-28, 7,13); //big toe
		    winter.ellipse(x-2,y-28, 6,11); //toe 2
		    winter.ellipse(x-8,y-28, 4,10); //toe 3
		    winter.ellipse(x-13,y-25, 4,8); //toe 4
		    winter.ellipse(x-17,y-23, 3,8); // toe 5
		    life -=2;
		    
	}
}//class
