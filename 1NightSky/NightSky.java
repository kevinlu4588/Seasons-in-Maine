import processing.core.PApplet;
import processing.core.PShape;

import java.util.ArrayList;

import processing.core.*;
public class NightSky extends PApplet {
	ArrayList<Particle> particles = new ArrayList<Particle>();
	public float scale = random((float) 5e2, (float)2e3);

    // The argument passed to main must match the class name
    public static void main(String[] args) {
        PApplet.main("NightSky");
    }

    // method used only for setting the size of the window
    public void settings(){
        size(1400,900);
    }

    public void setup(){
    	frameRate(60);
    	//textAlign(RIGHT, BOTTOM);
    	background(0);
    	noStroke();
    	fill(255);
    	for(int i = 0; i < 400; i ++) {
    		particles.add(new Particle(this));
    	}
    	
    	//scale = random(8e2, 2e3);
      

    }


    public void draw()
    {
    	for (Particle p : particles) p.update();
    	for (Particle p : particles) p.draw();
    	
    	//(graphics, 0, 0);
    	
    	/*textFont(fonts.bold);
    	textSize(120);
    	text(theme.name, width - 50, height - 20);
    	
    	textFont(fonts.light);
    	textSize(60);
    	text("Your theme:", width - themeWidth + 180, height - 140);
    	*/
    }
    public void keyPressed() {
    	for(Particle p: particles) p.star = true;
    }

    class Particle {
    	PVector pos;
    	PVector vel;
    	int c;
    	float r;
    	NightSky sky;
    	public boolean star = false;
    	Particle(NightSky sky) {
    	//	this.applet = applet;
    		this.sky = sky;	
    		pos = new PVector(random(-50, width + 50), random(-50, height + 50));
    		vel = new PVector(random(-10,10) + 10, random(-10, 10) + 10);
    		 c = sky.color(random(0,255), random(0,255), random(0,255), random(0,255));
    		 r = random(3, 5);
    	}
    	
    	public void update() {
    		float dir = noise(pos.x / sky.scale, this.pos.y / sky.scale) * TAU * sky.scale;
    		pos.add((float) Math.cos(dir) , (float) Math.sin(dir) );
    		if(star) {
    		pos.add(vel);
    		}
    		if(pos.x < 0 || pos.x > width || pos.y < 0 || pos.y > height) {
    			pos.set(random(0, width-100), random(0, height - 100));
    		}
    	}
    	
    	public void draw() {
    		fill(c);
    		circle(this.pos.x, this.pos.y, this.r);
    	}
    }

}