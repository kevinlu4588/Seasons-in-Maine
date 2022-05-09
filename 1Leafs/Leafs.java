import processing.core.PApplet;
import processing.core.PShape;
import processing.core.*;
public class Leafs extends PApplet {
	public int size;
	public float flower_alpha =  (float) (10 + Math.floor(Math.random()*90));
	public float flower_rugosity =  (float) Math.floor(Math.random()*100);
	public float flower_hue = (float) Math.floor(Math.random()*360);
	public float flower_hue_variation = (float) (-75+Math.floor(Math.random()*150));
	
	public float heightFactor;

    // The argument passed to main must match the class name
    public static void main(String[] args) {
        PApplet.main("Leafs");
    }

    // method used only for setting the size of the window
    public void settings(){
        size(1800,1100);
    }
    

    public void setup(){
    	noFill();
    	colorMode(HSB, 360, 100, 100, 100);
    	heightFactor = height/545;

    	strokeWeight(3*height/400);
        petal(width/2, height/2, 10, (float) 100, 100);

    }

    public void petal(int x, int y, int orientation, float r0, float noiseSize) {
    	float noiseDisplacement = random(100);
    	float RUGOSITY_FACTOR = (float) 0.0001;
    	float distance = (float) 0.001;
    	float saturation = 50;
    	float brightness = 80;
    	float begin = 0; 
    	int end = 90; 
    	float transparency_factor = log(flower_alpha)/r0;
    	float color_saturation = 50;
    	float color_max_hue = 360;
    	float color_brightness = 80;
    	float angle_begin = 0;
    	float angle_end = 90;
    	float TRANSPARENCY_FACTOR = log(flower_alpha)/r0;
    	
    	//public float COLOR = {MAX_HUE:360, SATURATION: 50, BRIGHTNESS:80};
    	//public float ANGLE = {BEGIN: 0, END: 90};
    	//public float TRANSPARENCY_FACTOR = log(flower_alpha)/r0;
    	//public float STEP = {STROKE: 4*heightFactor, DISTANCE: 3*heightFactor};
    	
    	this.push();
    	this.translate(x, y);
    	this.rotate(PApplet.radians(orientation));
    	
    	/*
    	for(int ri = 0; ri < r0; ri+= distance) {
    		beginShape();
    		for(int i = 0; i < 100; i++) {
    			float theta = radians(i);
    			float r = noise(10)*100;
    			vertex(r*cos(theta), r*sin(theta));
    		}
    		endShape();

    	}
    	pop();
*/
    	
    	for (int ri = 0; ri < r0; ri += distance) {		
    		float transparency = exp(TRANSPARENCY_FACTOR*ri);
    		float deltaHue = map(ri, 0, r0, flower_hue_variation, 0);
    		float hue = (flower_hue + deltaHue + color_max_hue)%color_max_hue;
    		stroke(hue, color_saturation, color_brightness, transparency);
    		
    		beginShape();
    		for(float i = 0; i < 90; ++i) {
    			float theta = radians(i);
    			float rugosity = RUGOSITY_FACTOR*flower_rugosity*(r0-ri);
    			float rNoise = noise(noiseDisplacement + theta - rugosity);
    			rNoise = map(rNoise, 0, 1, 1-noiseSize, 1+noiseSize) ;
    			float r = ri*rNoise*cos(theta)*sin(theta);
    			vertex(r*cos(theta), r*sin(theta));
    		}
    		endShape();
    	}
    	pop();
    	
    }
}