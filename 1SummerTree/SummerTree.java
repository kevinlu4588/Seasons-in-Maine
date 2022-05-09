import processing.core.PApplet;
import processing.core.PShape;
import processing.core.*;
public class SummerTree extends PApplet {
	public boolean transitioning = false;
	public int i;

    // The argument passed to main must match the class name
    public static void main(String[] args) {
        PApplet.main("SummerTree");
    }

    // method used only for setting the size of the window
    public void settings(){
        size(1800,1100);
    }
     pathfinder[] paths;

   public void setup() {
	  frameRate(100);
      background(160, 220, 255);
      ellipseMode(CENTER);
      noStroke();
      smooth();
      paths = new pathfinder[1];
      paths[0] = new pathfinder(this);
    
      //background
      fill(30, 120, 0);
      rect(0, height-100, width, height);
    }
   
   
   class pathfinder {
	      SummerTree SummerTree;
	      PVector location;
	      PVector velocity;
	      float diameter;
	       
	      pathfinder(SummerTree SummerTree) {
	    	this.SummerTree = SummerTree;
	        location = new PVector(SummerTree.random((float)(width*.33), (float)(width*.66)), random(height-100, height - 50));
	        velocity = new PVector(0, -1);
	        diameter = 32;
	      }
	      
	      //calculates new diameter for branch(consists of many ellipses)
	      pathfinder(pathfinder parent) {
	        location = parent.location.get();
	        velocity = parent.velocity.get();
	        float area = PI*sq(parent.diameter/2);
	        float newDiam = sqrt(area/2/PI)*2;
	        diameter = newDiam;
	        parent.diameter = newDiam;
	      }
	      
	      void update() {
	        
	        if (diameter>0.5) {
	          location.add(velocity);
	          
	          
	          //prevents tree from cross outside of screen
	          //stops growing if pathfinder hits edge when branches are thin
	          if (location.x > width) {
	            if (diameter > 20){
	            PVector bump = new PVector(random(-20, -1), random(-5, -1));
	            bump.mult((float) 0.1);
	            velocity.add(bump);
	            velocity.normalize();
	            }
	            
	            else {
	              velocity.set(0, 0, 0); 
	            }
	          }
	          
	          else {
	            PVector bump = new PVector(random(-1, 1), random(-1, 1));
	            bump.mult((float) 0.1);
	            velocity.add(bump);
	            velocity.normalize();
	          }
	          
	         //splits existing branch to create new branches 2% of the time
	          if (random(0, 1)<0.02) {
	            paths = (pathfinder[]) append(paths, new pathfinder(this));
	          }
	        }
	      }
	    }//end pathfinder

    public void draw() {
    	//iterates through paths array
      for (int i=0;i<paths.length;i++) {
        PVector loc = paths[i].location;
        float diam = paths[i].diameter;
    	//draw branch circle
        fill(10 + i/paths.length*90, 10 + i/paths.length*80, 0);
        ellipse(loc.x, loc.y, diam, diam);
        
        //extends original branches and appends new ones
        paths[i].update();
    	
        
        //draw sakura leaves (randomized pink or white)
        if (i > paths.length * .99){
    			
    		  fill (255,190+random(20),220+random(20), 200);
    		  if(random(0,100) < 10) {
    			  fill(255,255,255,255);
    		  }
          ellipse(loc.x + random (-10, 10), loc.y + random(-10, 10), random(4,8)+4, random(4,8)+4);
    		}
    		
    		
    		
    		
    		
    		
    		
      }
      
      
      
    }

  //SpringTree Class
    
   


}