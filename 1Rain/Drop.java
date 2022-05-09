import processing.core.*;
public class Drop {
	Rain rain;
	float x;
	float y;
	double fall = 10;
	float scale = (float)3.5;
	float initY;
	boolean fallen = false;
	public int opacity = 255;
	public boolean dropped = false;
	public Drop(float x, float y, Rain rain) {
		this.initY = y;
		this.rain = rain;
		this.x = x;
		this.y = y;
		

	}
	public void move() {
		System.out.println("code changed");
		y+= fall;
	}
	public void show() {
		
		for (int i = 2; i < 8; i++ ) {
			//x += k;
			
			rain.fill(0,100+i*15,255-i, opacity);
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
		opacity -= 30;
		if(opacity < 10) {
			System.out.println("dead");
			fallen = true;
		}
		
	}
	public  void reset() {
		y = 0;
		fall = 10;
		x = rain.random(1000) + 150;
        initY = y;
        fallen = false;
        opacity = 255;
        dropped = false;
	}
	public Boolean fallen() {
		if(Math.abs(initY - y) > rain.random(700)+500) {
			
			return true;
		}
		else {
			return false;
		}
	}
}
