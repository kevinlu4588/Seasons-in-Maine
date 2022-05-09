import processing.core.*;
public class Drop {
	Rain rain;
	float x;
	float y;
	double fall = 4;
	float scale = (float)7;
	float initY;
	boolean fallen = true;
	public Drop(float x, float y, Rain rain) {
		this.initY = y;
		this.rain = rain;
		this.x = x;
		this.y = y;
		fall= rain.random(5) + 1;
		

	}
	public void move() {
		y+= fall;
	}
	public void show() {
		
		for (int i = 2; i < 8; i++ ) {
			//x += k;
			
			rain.fill(0,100+i*15,255-i);
		    rain.ellipse(x, (float) (y + i*scale*1.3), (float)(i*scale),(float)(i*scale)); 
		    
		    }
		/*
		for(int j = 0; j < 6; j++) {
			rain.fill(255,255,255);
			rain.ellipse(x+j*scale*2, (float) (y + j*scale*1.3), (float)(j*scale/7), (float)(j*scale/7));
		}
		*/
		if(scale < 1) {
			reset();
		}
		//System.out.println(y);

	//	y+= fall;
	     
	}
	public void falling() {
		
	}
	public  void reset() {
		y = 0;
        initY = y;
        fall = rain.random(5) + 1;
        fallen = true;
	}
	public Boolean fallen() {
		if(Math.abs(initY - y) > rain.random(500)+300) {
			
			return true;
		}
		else {
			return false;
		}
	}
}
