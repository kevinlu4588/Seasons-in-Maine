import processing.core.PApplet;
import processing.core.PShape;
import processing.core.*;
public class Template extends PApplet {
	float x, y, theta, sz;
    int num=100;
    // The argument passed to main must match the class name
    public static void main(String[] args) {
        PApplet.main("Template");
    }

    // method used only for setting the size of the window
    public void settings(){
        size(1400,900);
    }

   
    public void setup() {
      stroke(255, 150);
      fill(0);
    }

    public void draw() {
      background(0);
      float x=width/2, y=height/2;
      float angle=0;
      float radius=30; 
      int c=0;
      for (int i=0; i<num; i++) {
        x = width/2 + sin(angle)*radius;
        y = height/2 + cos(angle)*radius;
        float sz = map(sin(theta+TWO_PI/num*i*40), -1, 1, 20, 100);
        float scal = (float) (.5+1.0/num*2*i);
        stroke(255, 200);
        ellipse(x, y, sz*scal, sz*scal);
        angle += radians(3);
        radius += .5;
        c++;
      }
      theta -= 0.0523/2;
    }

}