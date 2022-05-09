import processing.core.PApplet;
import processing.core.PShape;

import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;

import processing.core.*;


public class SnakeGame extends PApplet {

    // The argument passed to main must match the class name
    public static void main(String[] args) {
        PApplet.main("SnakeGame");
    }

    // method used only for setting the size of the window
    public void settings(){
        size(1800,1100);
    }
    ArrayList flowers = new ArrayList();
    ArrayList zOscillators = new ArrayList(); 

    public void setup() {
      frameRate(30);
      smooth();
      noStroke();
      //colorMode(HSB, TWO_PI, 1, 1, 1);
      initFlowers();
    }

    public void draw() {
      background(0);
      for(java.util.Iterator i=flowers.iterator(); i.hasNext();) {
        Flower flower = (Flower)i.next();
        flower.drawFlower();
      }

      for(java.util.Iterator i=flowers.iterator(); i.hasNext();) {
        Flower flower = (Flower)i.next();
        flower.next();
      }

      for(java.util.Iterator i=zOscillators.iterator(); i.hasNext();) {
        RandomOscillator oscillator = (RandomOscillator)i.next();
        oscillator.next();
      }
    }

    public void mouseClicked() {
      initFlowers();
    }

    public void keyPressed() {
      
      initFlowers();
      flowers.remove(0);
      flowers.remove(0);
      zOscillators.remove(0);
      zOscillators.remove(0);
    }

    void initFlowers() {
      
      float hueValue = PApplet.blendColor(255, 255, 255);
    		  //random(TWO_PI);
      addConcentricFlowers(width/2, height/2, width/10, hueValue);
      addConcentricFlowers(width/2+75, height/2+140, width/10, (hueValue+TWO_PI/3)%TWO_PI);
      addConcentricFlowers(width/2-75, height/2-140, width/10, (hueValue+TWO_PI/3*2)%TWO_PI);
    }

    void addConcentricFlowers(float x, float y, float maxRadius, float colorHue) {
      RandomOscillator zOscillator = new RandomOscillator((float) 3.5, (float) 2.5, 0);
      zOscillators.add(zOscillator);
      
      for (int i=1; i<6; i++) {
      	int randomGradient = (int) PApplet.constrain(random(100), 0, 40);
        flowers.add(new Flower(x, y, i, zOscillator, maxRadius/10*(6-i), (int)(3+random(3)), (int)(3+random(9)), this,color(random(200) + i*randomGradient,random(200)+i*randomGradient,random(50)+i*randomGradient), this) );
      }
    }

    class RandomOscillator {
      float mean;
      float amplitude;
      float value;
      float angle;
      float multiplier;
      
      RandomOscillator(float mean, float amplitude, float startValue) {
        this.mean = mean;
        this.amplitude = amplitude; 
        this.angle = random(TWO_PI);
        this.multiplier = startValue / mean;
        next();
      }
      
      float getValue() {
        return value;
      }
      
      void next(){
        angle = (angle+random(PI/20)) % TWO_PI;
        value = multiplier*(mean + amplitude*sin(angle));
        multiplier += (1-multiplier) * 0.03;
       }
    }

    class Flower {
      SnakeGame snakeGame;
      PApplet applet;
      float x;
      float y;
      float zIndex;
      RandomOscillator zOscillator;
      int petalCount;
      int pointsPerPetal;
      int clr;
      RandomOscillator oscillators[];
      
      Flower(float x, float y, float zIndex, RandomOscillator zOscillator, float meanRadius, int petalCount, int pointsPerPetal, SnakeGame snakeGame, int clr, PApplet applet) {
        this.x = x;
        this.snakeGame = snakeGame;
        this.applet = applet;
        this.y = y;
        this.zIndex = zIndex;
        this.zOscillator = zOscillator;
        this.petalCount = petalCount;  
        this.pointsPerPetal = pointsPerPetal;
        this.oscillators =  new RandomOscillator[pointsPerPetal];
        this.clr = clr;

        for (int i=0; i<pointsPerPetal; i++) {
          this.oscillators[i] = new RandomOscillator((float) meanRadius, (float) ((float) meanRadius*0.3), 0);
        }
      }
      
      void drawFlower() {
        fill(clr);
        float delta = 150 - zOscillator.getValue()*zIndex;
        float radiusMultiplier = 150/delta;
        for (float x0=x%delta-delta; x0<width+delta; x0+=delta) {
          beginShape();
          float angle = TWO_PI / petalCount / pointsPerPetal;
          for (int i=0; i<petalCount*pointsPerPetal+2; i++) {
            float alfa = angle*i;
            float radius = oscillators[i%pointsPerPetal].getValue() * radiusMultiplier;
            curveVertex(radius*sin(alfa)+x0, radius*cos(alfa)+y); 
          }
          endShape();
        }
      }
      
      void next() {
        for(int i=0; i<pointsPerPetal; i++) {
          oscillators[i].next();
        }  
      }
      
    }

}

   