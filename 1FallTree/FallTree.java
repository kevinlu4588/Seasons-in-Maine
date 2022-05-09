import processing.core.PApplet;
import processing.core.PShape;

import java.awt.Color;

import processing.core.*;
public class FallTree extends PApplet {
	public boolean transitioning = false;
	public int i;
    PGraphics pg;

    // The argument passed to main must match the class name
    public static void main(String[] args) {
        PApplet.main("FallTree");
    }

    // method used only for setting the size of the window
    public void settings(){
        size(1800,1100);
    }

  //class
    class pathfinder {
      FallTree FallTree;
      PVector location;
      PVector velocity;
      float diameter;
       
      pathfinder(FallTree FallTree) {
    	this.FallTree = FallTree;
        location = new PVector(FallTree.random((float)(width*.33), (float)(width*.66)), random(height-100, height - 50));
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
          
          //prevents tree from growing outside of screen. It grows diagonally upward when
          //branches are thicker and stops growing if it hits the edge when branches are thin.
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
    }

    //runner
    pathfinder[] paths;

   public void setup() {
	   frameRate(100);
      background(160, 220, 255);
      ellipseMode(CENTER);
      noStroke();
      smooth();
      paths = new pathfinder[1];
      paths[0] = new pathfinder(this);
    	fill(30, 120, 0);
    	rect(0, height-140, width, height);
    }

    public void draw() {
      for (int i=0;i<paths.length;i++) {
        PVector loc = paths[i].location;
        float diam = paths[i].diameter;
    		fill(10 + i/paths.length*90, 10 + i/paths.length*80, 0);
        ellipse(loc.x, loc.y, diam, diam);
        paths[i].update();
    		if (i > paths.length * .98){
    			float colorValue = random(0,100);
    			if(colorValue < 10) {
    	    		  fill (111, 78, 55, 180);

    			}
    			else if(colorValue < 50) {
    				fill(255, 234, 0, 180);
    			}
    			else if(colorValue < 70) {
    				fill(34, 139, 34, 180);
    				
    			}
    			else if(colorValue < 800) {
    				fill(255, 95, 31, 180);
    			}
    			else {
    				fill(255,0,0,180);
    			}
    		  
          ellipse(loc.x + random (-10, 10), loc.y + random(-10, 10), random(4,8), random(4,8));
    		}
      }
     
    }
}