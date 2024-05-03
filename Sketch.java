import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {

  PImage imgBackground;
  PImage imgMarmot;
  
  // marmot cordiantes x and y
  float marmotX = 50;
  float marmotY = 100;
  
  // define marmot speed variable
  float marmotXSpeed = random(1, 5);
  float marmotYSpeed = random(1, 5);
  
  // define colors
  int white = color(255, 255, 255);

  public void settings() {
    size(300, 300);
  }

  public void setup() {
    imgBackground = loadImage("360_F_249687268_Yl4AswCdwBQS7NA6hczKq0pfnjQs02UP (1).jpg");
    imgBackground.resize(width, height);
    background(imgBackground);
    
    imgMarmot = loadImage("alpine-marmot-vnwMNE2-600-removebg-preview.png");
    imgMarmot.resize(imgMarmot.width/4, imgMarmot.height/4);
  }

  public void draw() {
    background(imgBackground);

    // Draw and move marmot
    image(imgMarmot, marmotX, marmotY);
    marmotX += marmotXSpeed;
    marmotY += marmotYSpeed;

    // create bouncing
    if (marmotX > width - imgMarmot.width || marmotX < 0) {
      marmotXSpeed *= -1;
    }
    if (marmotY > height - imgMarmot.height || marmotY < 0) {
      marmotYSpeed *= -1;
    }
    image(imgMarmot, marmotX, marmotY);

    // draw a shape for moving object
    fill(white);
    ellipse(mouseX, mouseY, 50, 50);
  }
}