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
        size(1800,600);
    }
    public void draw() {
    	for(int i = 0; i < 20; i++) {
    		fill(255,255,0);
    		rect(50*6,i*45*2, 10, 30); 
    		rect(50*6 + 20,i*45*2, 10, 30); 

    	}
    }
    public void setup() {
    int x1 = 0;
    int y1 = 0;
    int x2 = 1800;
    int y2 = 0;

    int R1 = 19;
    int G1 = 19;
    int B1 = 81;

    // The initial dark blue color
    stroke(R1,G1,B1);
    // This loops draws 100 horizontal lines
    for (int x=0; x<=1800; x++){
      stroke(R1,G1,B1);
      line(x1,y1,x2,y2);
      y1++;
      y2++;
      if(y1%6==0){
      G1+= 1;
      }

    }

    // Variables for the star loop
    int x = 0;
    float randomX;
    float randomY;

    // DRAW SOME STARS

    stroke(255);
    strokeWeight(2);

    // Creates a loop to draw 50 stars to the background
    for (int i=0;i<50;i++){
      randomX = random(0,1800);
      randomY = random(0,1100);
      point(randomX,randomY);
    }
    // MOON!!
    stroke(200,200,200);
    fill(200,200,200);
    ellipseMode(CENTER);
    smooth();
    ellipse(40*6,20*6,15*6,15*6);

    // Initialization for the buildings
    // Each building is hand coded. Perhaps in the future I can create a procedurally generated skyline.
    stroke(0);
    strokeWeight(2);
    smooth();

    // black buildings
    fill(0);

    //building 1
    rect(0*6,120*2,20*6,60*6);

    //building 2
    rect(20*6,140*2,25*6,60*6);

    //building 3
    rect(45*6,50*6,30*6,50*6);
    rect(50*6,45*6,20*6,10*6);
    triangle(55*6,45*6,65*6,45*6,60*6,30*6);

    //building 4
    rect(80*6,80*6,10*6,20*6);
    rect(85*6,60*6,10*6,40*6);

    //building 5
    rect(95*6,30*6, 30*6, 70*6);
    rect(100*6,25*6,20*6,5*6);

    //building 6
    rect(125*6, 60*6, 40*6, 40*6);

    //building 7
    rect(165*6,40*6,25*6,60*6);
    triangle(170*6,40*6,175*6,40*6, 172*6,30*6);
    triangle(182*6,40*6,187*6,40*6, 185*6,30*6);

    //building 8
    rect(190*6,80*6,10*6,20*6);
    rect(195*6,20*6,20*6,80*6);
    rect(215*6,30*6,10*6,70*6);
    rect(225*6,40*6,5*6,60*6);

    //building 9
    rect(230*6,90*6,70*6,10*6);
    rect(235*6,85*6,10*6,10*6);
    rect(250*6,75*6,40*6,30*6);
    rect(260*6,20*6,20*6,80*6);
    rect(265*6,10*6,10*6,10*6);
    triangle(268*6,10*6,272*6,10*6,270*6,0*6);
    }

}