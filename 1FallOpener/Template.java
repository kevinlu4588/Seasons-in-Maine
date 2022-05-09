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
        size(1800,800);
    }

 // Pixel-sized particles version, of 'surfs_up'.
 // Particles are now directly noise driven omitting the flow field.
 // Array[], particle, pixel, noise()
 // Mouse click to reset, mouseX adjusts background clear.

 Particle[] particles;
 float alpha;

 public void setup() {
  // size(900, 200);
   background(0);
   noStroke();
   setParticles();
 }
 public void draw() {
   frameRate(60);
   alpha = map(mouseX, 0, width, 5, 35);
   fill(15,15,150, 5);
   rect(0, 0, width, height);

   loadPixels();
   for (Particle p : particles) {
     p.move();
   }
   updatePixels();
 }

 void setParticles() {
   particles = new Particle[10000];
   for (int i = 0; i < 10000; i++) { 
     float x = random(width);
     float y = random(height);
     float adj = map(y, 0, height, 255, 0);
     int c = color(40, adj, 255);
 		
     particles[i]= new Particle(x, y, c);
   }
 }

 public void mousePressed() {
   setParticles();
 }

 class Particle extends PApplet{
   float posX, posY, incr, theta;
   int c = color(65,102,245,250);
   

   Particle(float xIn, float yIn,int  adj) {
     posX = xIn;
     posY = yIn;
     c= adj;
   }

   public void move() {
     update();
     wrap();
     display();
   }

   void update() {
     incr +=  .008;
     theta = noise(posX * (float).006, posY * (float).004, incr) * TWO_PI;
     posX += 2 * cos(theta);
     posY += 0.5 * sin(theta);
   }

   void display() {
     if (posX > 0 && posX < width && posY > 0  && posY < height) {
       pixels[(int)posX + (int)posY * width] =  c;
     }
   }

   void wrap() {
     if (posX < 0) posX = width;
     if (posX > width ) posX =  0;
     if (posY < 0 ) posY = height;
     if (posY > height) posY =  0;
   }
 }

}