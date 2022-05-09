import processing.core.PApplet;
import processing.core.PShape;
import processing.core.*;
public class Template extends PApplet {

    // The argument passed to main must match the class name
    public static void main(String[] args) {
        PApplet.main("Template");
    }

    // method used only for setting the size of the window
    public void settings(){
        size(1400,900);
    }
    public int gradientSteps = 7;
   // public int halfCanvasSize = width/2;
    
    public void setup(){
    	
    	background(100);
    	noStroke();
    	ellipseMode(CENTER);
    	// sky background
    	fill(135, 206, 235, 180);
    	rect(0, 0, width, width);

    	/*var from = color(69, 103, 108);
    	var to = color(240, 220, 180);
    	for (var i = gradientSteps; i > 0; --i) {
    		var size = map(i, gradientSteps, 0, width + 50, width/2);
    		fill(lerpColor(from, to, 1 - i / gradientSteps));
    		ellipse(width/2, width/2, size, size);
    	}
    	*/
    	var from = color(255, 229, 110);
    	var to = color(252, 240, 182);
    	for (var i = gradientSteps; i > 0; --i) {
    		var size = map(i, gradientSteps, 0, width/2, 0);
    		fill(lerpColor(from, to, 1 - i / gradientSteps));
    		ellipse(width/2, width/2-200, size, size);
    	}

    }


    public void draw()
    {
      for(int i = 0; i < 10; i++) {
    	  
      }
  //    background(135, 206, 235, 180);
   //   ellipse 
    }
}