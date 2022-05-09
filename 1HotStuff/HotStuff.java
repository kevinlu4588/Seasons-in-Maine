import processing.core.PApplet;
import processing.core.PShape;
import processing.core.*;
public class HotStuff extends PApplet {

    // The argument passed to main must match the class name
    public static void main(String[] args) {
        PApplet.main("HotStuff");
    }
    public int count = 0;
    // method used only for setting the size of the window
    public void settings(){
        size(1800,1100);
    }

    public float xOffset = 0;       // Perlin x-offset
    public float yOffset = 0;       // Perlin y-offset
    public float offsetInc = (float) 0.006; // Perlin offset increment
    public float inc = 1;           // Perin increment
    public float s = 1;             // Start size of perlin ring
    public float m = (float) 1.005;         // Size multiplier
    public float r = 100;
    public float g = 100;
    public float b = 100;
    public float opacity = 3;
    public void setup() {
      background(0);
      blendMode(ADD);
     noFill();
    }

    public void draw() {
    	stroke(r,g,b,opacity);
      translate(width * (float)0.5, height * (float)0.5);

      if (s < 2000) {
    	  if(s > 150) {
    		  opacity = 50;
    	  }
        // Create a series of perlin rings from big to small
        for (int nTimes = 0; nTimes < 10; nTimes++) {

          // Less points for smaller rings
         var nPoints = (2 * PI * s);
          nPoints = min(nPoints, 500);

          // Create ring
         
          /*beginShape();
          for (var i = 0; i < nPoints; i++) {
            //	System.out.println("asdf");

            var a = i / nPoints * TAU;
            PVector p = PVector.fromAngle(a);
            var n = noise(xOffset + p.x * inc, yOffset + p.y * inc) * s;
            p.mult(n);
            System.out.println(p.x);
            System.out.println(p.y);

            vertex(p.x, p.y);
          }
          endShape(CLOSE);
          /*
           * 
           */
          beginShape();
          
          for (var i = 0; i < nPoints; i++) {
            //	System.out.println("asdf");

            var a = i / nPoints * PI*2;
            PVector p = PVector.fromAngle(a);
            var n = noise(xOffset + p.x * inc, yOffset + p.y * inc) * s;
            p.mult(n);
           // System.out.println(p.x);
            //System.out.println(p.y);

            vertex(p.x, p.y);
          }
          endShape(CLOSE);

          // Increment perlin offset for next ring
          xOffset += offsetInc;
          yOffset += offsetInc;

          // Reduce size for next ring
          s *= m;
        }
      } 
      else {
    	  s = 1;
    	 
 
    
    	 opacity = 3;
      	  if(count == 0) {
    		  r = 34; 
    		g = 139; 
    		b = 42;
    	  }
    	  else if(count == 1) {
    		  r = 255;
    		  g = 64;
    		  b = 8;
    	  }
    	  else {
    		  r = 111;
    		  g = 78;
    		  b = 55;
    		  opacity = 10;
    		  count = -1;
    		  
    	  }
    	 count++;
    	//  stroke(255, 64, 8, 128);
      }
      /*else {
        noLoop();
      }
      */
    }
    public void mousePressed() {
    	s = 1;
    }
}