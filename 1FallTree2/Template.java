import processing.core.PApplet;
import processing.core.PShape;
import processing.core.*;
public class Template extends PApplet {
	public boolean transitioning = false;
	public int i;
    PGraphics pg;

    // The argument passed to main must match the class name
    public static void main(String[] args) {
        PApplet.main("Template");
    }

    // method used only for setting the size of the window
    public void settings(){
        size(1800,1100);
    }


    int numFrames=100;
    PathFinder[] paths;

    public void setup() {
     frameRate(20);
      background(36);
      ellipseMode(CENTER);
      fill(255, 40);
      noStroke();
      smooth();
      pg = createGraphics(1800, 1100);
      paths = new PathFinder[1];
      paths[0] = new PathFinder();
    }

    public void draw() {

      for (int j=0; j<8; j++) {
        for (int i=0; i<paths.length; i++) {
          PVector loc = paths[i].location;
          float diam = paths[i].diameter;
          ellipse(loc.x, loc.y, diam, diam);
          paths[i].update();
        }
      }

  	if(transitioning) {
		fill(36, 36, 36, (float)0.01 + i);
		ellipse(width/2,width/2,width*2,width*2);
		i++;
		double count = frameCount;
  	int from = color(0, 0, 0, 0);
  	int to = color(255, 255, 255,1);
  	float fraction = (float) ((count%500)/500);
  	int interA = lerpColor(from, to, fraction);
  	System.out.println(fraction);
  
  	background(interA);
  	
	}
	
      //saveFrame("t###.gif");
      //if (frameCount==numFrames)
      //  exit();
    }

    public void mousePressed() {
    	transitioning = true;
    }

    class PathFinder {

      PVector location;
      PVector velocity;
      float diameter;
      
      PathFinder() {
        location = new PVector(width/2, height);
        velocity = new PVector(0, -2);
        diameter = 30;
      }
      
      PathFinder(PathFinder parent) {
        location = parent.location.get();
        velocity = parent.velocity.get();
        float area = PI*sq(parent.diameter/2);
        float newDiam = sqrt(area/2/PI)*2;
        diameter = newDiam;
        parent.diameter = newDiam;
      }

      void update() {
        if (diameter>0.25) {
          location.add(velocity);
          PVector bump = new PVector(random(-1, 1), random(-1, 1)); 
          bump.mult((float) 0.1);
          velocity.add(bump);
          velocity.normalize();
          
          if (random(0, 1)<0.025) {
        	//ellipse(location.x, location.y, 10, 10);
            paths = (PathFinder[]) append(paths, new PathFinder(this));
          }
        }
      }
    }

}//class