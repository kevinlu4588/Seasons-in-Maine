import processing.core.PApplet;
import processing.core.PShape;

import java.util.ArrayList;

import processing.core.*;
public class Template extends PApplet {
	ArrayList<Swirl> swirls = new ArrayList<Swirl>();
    // The argument passed to main must match the class name
    public static void main(String[] args) {
        PApplet.main("Template");
    }

    // method used only for setting the size of the window
    public void settings(){
        size(1800,1100);
    }

  public void setup(){
    //	size(1400,900);
	  frameRate(90);
    	  background(0);
    	  for(int i = 0; i < 10; i++) {
      		for(int j = 0; j < 5; j++) {
      			swirls.add(new Swirl(i*200 + 100, j*200 + 100, this));
      		}
      		}
    	}

    public void draw(){
    	for(Swirl swirl: swirls) {
    		swirl.show();
    	}
    	}
	
    class Swirl{
    	public int x;
    	public int y;
    	public Template template;
    	
    	/**
		 * @param x
		 * @param y
		 * @param template
		 */
		public Swirl(int x, int y, Template template) {
			super();
			this.x = x;
			this.y = y;
			this.template = template;
			System.out.println(x);
			System.out.println(y);
		
		}

		public void show() {
    		//translate(width/2, height/2);
	    	  //fill(255);
	    	  //noStroke();
	    	  float mag = 100;
	    	  float wave1 = map(sin(radians((float) (2*0.8*frameCount))),-1,1,-mag,mag);
	    	  float wave2 = map(cos(radians(2*frameCount)),-1,1,-mag,mag);
	    	  noStroke();
	    	  fill(215,215,215,100);
	    	  ellipse(wave1+ x , wave2 + y, 10,10);

    	}
    }
    	
}