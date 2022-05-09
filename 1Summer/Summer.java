import processing.core.PApplet;
import processing.core.PShape;

import java.util.ArrayList;

import processing.core.*;
public class Summer extends PApplet{
	  //sound taken near a pond in a park, Aug. 2021
	 public ArrayList<Ripple> rp = new ArrayList<Ripple>();  
	  public int rp_count = 0;
	  public float rp_max = 22;

	  public float xx;
	  public float yy;
	  public float sp_x;
	  public float sp_y;
	  public float count = 0;
	  public float co_max;

	  // A sound file object
	  public float song;
	  public float analyzer;


    // The argument passed to main must match the class name
    public static void main(String[] args) {
        PApplet.main("Summer");
    }

    // method used only for setting the size of the window
    public void settings(){
        size(1800,1100);
    }




  public void setup() {
  	xx = random(width);
  	yy = random(height);
  	sp_x = random(-5, 5);
  	sp_y = 0;
  	co_max = 1;
  	
  	for (int i = 0; i < rp_max; i++) {
  		rp.add(new Ripple(this));
  	}
  	
  }

  public void draw() {
  	background(0, 50, 50, 200);
  	
  	rp.get(rp_count).set(xx, yy, 0);
  	rp_count++;
  	if (rp_count >= rp_max) {
  		rp_count = 0;
  	}
  	
  	for (int i = 0; i < rp_max; i++) {
  		rp.get(i).draw();
  	}
  	
  	float v = map(sp_x, 0, 20, 0, (float) 0.3);
  	// vol = constrain(vol, 0, 1);
  	v = abs(v);
  	// song.amp(0.1);

  	float s = map(sp_x, 0, 20, 0, 5);
  	s = abs(s);
  	
  	if (count > co_max){
  		sp_x = random(-20, 20);
  		count = 0;
  		co_max = random(10, 80);
  	}
  	count++;
  	// text(count, 30, 30);
  	// text(co_max, 30, 60);
  	
  	sp_y = random(-10, 10);
  	
  	xx = xx + sp_x;
  	yy = yy + sp_y;
  	
  	if (yy > height){
  		yy = 0;
  	}
  	if (yy < 0){
  		yy = height;
  	}
  	if (xx > width){
  		xx = 0;
  	}
  	if (xx < 0){
  		xx = width;
  	}
  }//draw




  class Ripple {
	public float hx;
	public float hy;
	public float hs;
	public Summer summer;
  	public Ripple(Summer summer) {
  		this.hx = -1000;
  		this.hy = -1000;
  		this.hs = 0;
  		this.summer = summer;
  	}
  	public void draw() {
  		float m = max(summer.width, summer.height);

//   		strokeWeight(0.5);
//   		fill(200, 160, 200, 12);
//   		stroke(55, 255, 200, 255 * (1.0 - this.hs));
//   		ellipse(this.hx, this.hy, this.hs * m, this.hs * m);
  		
//   		fill(160, 200, 200, 12);
//   		stroke(255, 55, 200, 255 * (1.0 - this.hs));
//   		ellipse((width-this.hx), (height-this.hy), this.hs * m, this.hs * m);
  		
  		summer.strokeWeight((float) 2.2);
  		summer.fill(80, 220, 120, 12);
  		summer.stroke(220, 140, 80, (float) (255 * (1.0 - this.hs)));
  		summer.ellipse(this.hx, this.hy, this.hs * m, this.hs * m);
  		
  		summer.fill(220, 140, 80, 12);
  		summer.stroke(80, 220, 140, (float) (255 * (1.0 - this.hs)));
  		summer.ellipse((width-this.hx), (height-this.hy), this.hs * m, this.hs * m);
  		
  		this.hs += 0.05;
  	}
  	public void set(float _x,float _y, float _s) {
  		this.hx = _x;
  		this.hy = _y;
  		this.hs = _s;
  	}
  }
}

