import processing.core.PApplet;
import processing.core.PShape;

import java.util.ArrayList;

import processing.core.*;
public class Rain extends PApplet {
	ArrayList<Drop> drops = new ArrayList<Drop>();
	ArrayList<Raindrop> raindrops = new ArrayList<Raindrop>(); 
	public boolean stop = false;
	public int count = 0;
    int fall = 0;
    // The argument passed to main must match the class name
    public static void main(String[] args) {
        PApplet.main("Rain");
    }

    // method used only for setting the size of the window
    public void settings(){
        size(1800,1100);
    }

    public void setup(){
      //noStroke();
      frameRate(60);
    /*  for(int i = 1; i < 10; i++) {
    	 for(int j = 1; j < 10; j++) {
    		  drops.add(new Drop(i*random(800)+150, j*random(150)+150, this));
    	  }
    	  
      }   
      */   

      
     // System.out.println(width);
    }

    public void draw()
    {
      if (count%4 == 0 && !stop) {
      drops.add(new Drop(random(1600)+100, -100, this));
      }
      count++;
      frameRate(30);
      background(20);
      fill(100);
      noStroke();
      
      for(int i = drops.size()-1; i >= 0; i--) {
    	  
    	 drops.get(i).move();
    	 drops.get(i).show();
    	 if(drops.get(i).fallen()) {
    		 drops.get(i).falling();
    		 drops.get(i).fall = 1;
    		 if(!drops.get(i).dropped) {
   		  raindrops.add(new Raindrop(drops.get(i).x,drops.get(i).y + 120,0,this));
   		  drops.get(i).dropped = true;
    		 }
    		 //System.out.println("fall");
    		  if(drops.get(i).fallen) {
        		  drops.get(i).fallen = false;
        		
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
    public void mousePressed() {
    	stop = true;
    }
      
    }//class

