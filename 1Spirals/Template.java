import processing.core.PApplet;
import processing.core.PShape;
import processing.core.*;
public class Template extends PApplet {
	PVector spiral = new PVector(width/2, width/2);
    PVector vel = new PVector(1,1);
    // The argument passed to main must match the class name
    public static void main(String[] args) {
        PApplet.main("Template");
    }

    // method used only for setting the size of the window
    public void settings(){
        size(1400,900);

    }

    public void setup(){
   


    }


    public void draw()
    {
      translate(width/2, height/2);

      //background(0);
      spiral.x += Math.sin(vel.x);
      //spiral.y += Math.cos(vel.y);
      ellipse(spiral.x, spiral.y, 10, 10);
      
    }
}