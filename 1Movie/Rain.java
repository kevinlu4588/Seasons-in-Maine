import processing.core.PApplet;
import processing.core.PShape;

import java.util.ArrayList;

import processing.core.*;
public class Rain extends PApplet {
	ArrayList<Drop> drops = new ArrayList<Drop>();
	ArrayList<Raindrop> raindrops = new ArrayList<Raindrop>(); 


    int fall = 0;
    // The argument passed to main must match the class name
    public static void main(String[] args) {
        PApplet.main("Rain");
    }

    // method used only for setting the size of the window
    public void settings(){
        size(1400,900);
    }
    asdfasdfas

    public void setup(){
      //noStroke();
      frameRate(60);
      for(int i = 1; i < 6; i++) {
    	 for(int j = 1; j < 4; j++) {
    		  drops.add(new Drop(i*random(400), j*random(150)+150, this));
    	  }
      }      

      
     // System.out.println(width);
    }

    public void draw()
    {
      frameRate(60);
      background(20);
      fill(100);
      noStroke();
      for(int i = drops.size()-1; i >= 0; i--) {
    	 drops.get(i).move();
    	 drops.get(i).show();
    	 if(drops.get(i).fallen()) {
    		 //System.out.println("fall");
    		  if(drops.get(i).fallen) {
        		  raindrops.add(new Raindrop(drops.get(i).x,drops.get(i).y + 80,0,this));
        		  drops.get(i).fallen = false;
        		  drops.get(i).reset();
    		  }
    		//  drops.remove(drops.get(i));
    		  
    	 }
      }
      noFill();
      strokeWeight(3);
      
     for(Raindrop raindrop: raindrops){
     	 raindrop.show(180,210,255);
     	 raindrop.life-= 2;
     }
     for(int j = raindrops.size()-1; j >=0; j--) {
    	 if(raindrops.get(j).life < 0) {
    		 raindrops.remove(j);
    	 }
     }
      }
      
    }//class

