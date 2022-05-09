import processing.core.PApplet;
import processing.core.PShape;

import java.util.ArrayList;

import processing.core.*;
public class Winter extends PApplet {
public ArrayList<Snowflakes> flakes = new ArrayList<Snowflakes>();
public boolean walking = false;
public int amountSnow;
public ArrayList<Footsteps> feets = new ArrayList<Footsteps>();
public int stepping = 0; 
public boolean left = true;
    // The argument passed to main must match the class name
    public static void main(String[] args) {
        PApplet.main("Winter");
    }

    // method used only for setting the size of the window
    public void settings(){
        size(1800,1100);
    }

    public void setup(){
    	background(20);
     for(int i = 0; i < 150; i++) {
    	 flakes.add(new Snowflakes(this, (int) random(0, width), (int) random(0, 200), 40, 1));
     }
   /*
     for(int i = 0; i < 7; i++) {
    	  if(i%2 == 0) {
        	  feets.add(new Footsteps(this, 800, 100+i*70));
    	  }
    	  else {
        	  feets.add(new Footsteps(this, 850, 100+i*70));
    	  }
      }
      */

    }


    public void draw()
    {
      if(amountSnow >= 230) {
    	  System.out.println("full white");
    	  background(255);
    	  
      }
      else if (walking){
      	amountSnow = 0;

    	  stepping++;
		  background(255);
		  if(stepping%27 == 0) {
			  if(left) {
	        	  feets.add(new Footsteps(this, 800, 700-(feets.size()+1)*70));
	        	  left = false;
			  }
			  else {
	        	  feets.add(new Footsteps(this, 850, 700-(feets.size()+1)*70));
	        	  left = true;
			  }
			  
		  }
    	  for(int i = 0; i < feets.size(); i++) {
    		  if(i%2 == 0) {
    		  feets.get(i).drawLeftFoot();
    		  }
    		  else {
    			  feets.get(i).drawRightFoot();
    		  }
    	  }
      }
      else {
          background(20 + amountSnow);

  
      for(Snowflakes flake: flakes) {
    	  flake.snowflake();
    	  flake.move();
    	  if(flake.y > height-100) {
    		//  flake.reset();
    	  }
    	
      }
      
      amountSnow+=2;
      }
      
    }
    public void mousePressed() {
    	amountSnow = 0;
    	System.out.println("pressed");
    	walking = true;
    }
}