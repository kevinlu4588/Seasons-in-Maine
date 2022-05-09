import processing.core.PApplet;

public	class Raindrop {
		  int maxWidth = 700;
		  float x, y, dropWidth;
		  int backGroundValue = 20;
		  Rain rain;
		  int life = 600;
		 public Raindrop (float tempX, float tempY, float tempWidth, Rain rain) {
		    x = tempX;
		    y = tempY;
		    dropWidth = tempWidth;
		    this.rain = rain;
		    
		  }

		  void show(int tempR, int tempG, int tempB) {
		    float dropHeight = (float) (dropWidth*0.25);
		    float zHeight = 700/(y+1);

		    if (dropWidth < maxWidth) {
		      for (int i = 1; i < 5; i++) {
		   //	  System.out.println((dropWidth/i)/zHeight);
		        rain.stroke(tempR, tempG, tempB, (255-PApplet.map(life, 600, 0, 0, 255)));
		        rain.ellipse(x, y, (dropWidth/i/2)/zHeight, (dropHeight/i/2)/zHeight);
		      }
		    }
		    dropWidth += 2;
		    life--;
		  }
		  
		}//class


/*int cols;
int rows;
float[][] current;// = new float[cols][rows];
float[][] previous;// = new float[cols][rows];
Rain rain;
float dampening = (float) ;
public Ripple(Rain rain, int width, int height) {
	  cols = width;
	  rows = height;
	  System.out.println(width);
	  current = new float[cols][rows];
	  previous = new float[cols][rows];
		 this.rain = rain;
}


void mouseDragged() {
  previous[rain.mouseX][rain.mouseY] = 500;
  System.out.println("Dragged");
}

void show(int x, int y) {
  
  previous[x][y] = 500;

  rain.background(0);
  
  rain.loadPixels();
  for (int i = 1; i < cols-1; i++) {
    for (int j = 1; j < rows-1; j++) {
      current[i][j] = (
        previous[i-1][j] + 
        previous[i+1][j] +
        previous[i][j-1] + 
        previous[i][j+1]) / 2 -
        current[i][j];
      current[i][j] = current[i][j] * dampening;
      int index = i + j * cols;
      rain.pixels[index] = rain.color(current[i][j]);
    }
  }
  rain.updatePixels();

  float[][] temp = previous;
  previous = current;
  current = temp;
}




*/