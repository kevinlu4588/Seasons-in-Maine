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
        size(1800,1100);
    }

    float[] heights = {120,160,200,240,280,320,360};
    float[] function1 = new float[21];
    float[] function2 = new float[21];
    float[] function3 = new float[21];
    float lift = 0;
    int i;
    int x;

    public void setup() {
      colorMode(RGB,100);
      background(75);
      for (i = 0; i < 7; i++) {
      function1[3*i] = (float) ((1-0.1*i)*random(50,55));
      function1[3*i+1] = random((float)0.009,(float)0.015);
      function1[3*i+2] = random(-100,100);
    }
      
      for (i = 0; i < 7; i++) {
        function2[3*i] = (float) ((1-0.1*i)*random(25,30));
        function2[3*i+1] = random((float)0.01,(float)0.02);
        function2[3*i+2] = random(-100,100);
      }
      
      for (i = 0; i < 7; i++) {
        function3[3*i] = (float) ((1-0.1*i)*random(10,15));
        function3[3*i+1] = random((float)0.02,(float)0.08);
        function3[3*i+2] = random(-100,100);
      }
      
      function1[2] = 5;
      function1[5] = 5;
      function2[0] = 0;
    }

    public void draw() {
    	//translate(320, 150);
      background(0);
      noStroke();
      fill(95);
      ellipse(250 + lift, 175 - lift, 200 - lift/10, 200 - lift/10);
      for (int i = 0; i < 8; i++) {
    		
        fill(60-8*i);
        for (x = -500; x < 1250; x = x + 9) {
          float sy1 = heights[i] + (function1[3*i] * sin(function1[3*i+1] * x + function1[3*i+2])) + (function2[3*i] * sin(function2[3*i+1] * x + function2[3*i+2])) + (function3[3*i] * sin(function3[3*i+1] * x + function3[3*i+2]));
          float sy2 = heights[i] + (function1[3*i] * sin(function1[3*i+1] * (x+10) + function1[3*i+2])) + (function2[3*i] * sin(function2[3*i+1] * (x+10) + function2[3*i+2])) + (function3[3*i] * sin(function3[3*i+1] * (x+10) + function3[3*i+2]));
    			float ccc = (float) (x + (0.02+0.08*i)*(250-mouseX));
          quad(x + (float)(0.02+0.08*i)*(250-mouseX), sy1 + (float)(0.02+0.02*i)*(250-mouseY), x+10 + (float)(0.02+0.08*i)*(250-mouseX), sy2 + (float)(0.02+0.02*i)*(250-mouseY), x+10 + (float)(0.02+0.08*i)*(250-mouseX), 500, x + (float)(0.02+0.08*i)*(250-mouseX), 500);
        }
        fill(12);
    		rect(-width / 3, (float)(height*.6), (float)(width*1.3), height);		
      }
    	lift += .2;
    }
}