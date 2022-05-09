
public class Snowflakes extends Winter{
public Winter winter;
public int x;
public int y;
int size;
int t;
public int speed;

	/**
 * @param winter
 * @param x
 * @param y
 * @param size
 * @param t
 */
public Snowflakes(Winter winter, int x, int y, int size, int t) {
	super();
	this.x = x;
	this.y = y;
	this.size = size - (int) random(1,10);
	this.t = t;
	this.winter = winter;
	speed = (int) winter.random(1,4);
}
public void reset() {
	speed = (int) winter.random(1,4);
	this.size = size - (int) random(1,10);
	x = (int) random(0, width);
	y = (int) random(0, 200);
}
public void move() {
	this.y += speed;
}

	public void snowflake() {
		winter.push();
		winter.translate(x,y);
		  var angle = winter.PI/3;
		  if (t==1) {
		    branch(size);
		    winter.rotate(angle);
		    branch(size);
		    winter.rotate(angle);
		    branch(size);
		  } 
		  winter.pop();  
		}
	
	
	public void branch(int size){
		winter.fill(255,255,255);
		winter.stroke(255,255,255);
		winter.strokeWeight((float) 3.5);
	  float angle = PI/4;
	  int s = size;
	  float l=s/4;
	  winter.line(-s/2,0,s/2,0);
	  winter.line(s/3,0,s/3+l*cos(angle),l*sin(angle));
	  winter.line(s/3,0,s/3+l*cos(angle),-l*sin(angle));
	  winter.  line(-s/3,0,-s/3-l*cos(angle),-l*sin(angle));
	  winter.line(-s/3,0,-s/3-l*cos(angle),l*sin(angle));
	  l=s/6;
	  angle = PI/4;
	  winter. line(-s/6,0,-s/6-l*cos(angle),-l*sin(angle));
	  winter. line(s/6,0,s/6+l*cos(angle),l*sin(angle));
	  winter.line(s/6,0,s/6+l*cos(angle),-l*sin(angle));
	  winter.line(-s/6,0,-s/6-l*cos(angle),l*sin(angle)); 
	}	
	
}//class


