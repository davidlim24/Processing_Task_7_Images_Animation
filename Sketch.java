import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {

  PImage imgBackground;
  PImage imgMarmot;

  float marmotX = 50;
  float marmotY = 100;
  float marmotXSpeed = random(1, 5);
  float marmotYSpeed = random(1, 5);

  int black = color(0);
  int white = color(255);
  int magenta = color(255, 0, 255);

  float ballX = 400;
  float ballY = 300;
  float ballSpeedX = random(-5, 5);
  float ballSpeedY = random(-5, 5);

  public void settings() {
    size(800, 600);
  }

  public void setup() {
    imgBackground = loadImage("360_F_249687268_Yl4AswCdwBQS7NA6hczKq0pfnjQs02UP (1).jpg");
    imgBackground.resize(width, height);

    imgMarmot = loadImage("alpine-marmot-vnwMNE2-600-removebg-preview.png");
    imgMarmot.resize(imgMarmot.width/3, imgMarmot.height/3); // resize the image
  }

  public void draw() {
    background(imgBackground);

    // Draw and move marmot
    image(imgMarmot, marmotX, marmotY);
    marmotX += marmotXSpeed;
    marmotY += marmotYSpeed;

    // Basic edge collision detection for marmot
    if (marmotX > width - imgMarmot.width || marmotX < 0) {
      marmotXSpeed *= -1;
    }
    if (marmotY > height - imgMarmot.height || marmotY < 0) {
      marmotYSpeed *= -1;
    }

    // Ensure the marmot is always visible
    image(imgMarmot, marmotX, marmotY);

    // Draw and move a bouncing ball
    fill(magenta);
    ellipse(ballX, ballY, 50, 50);

    ballX += ballSpeedX;
    ballY += ballSpeedY;

    // Basic edge collision detection for the ball
    if (ballX > width - 25 || ballX < 25) {
      ballSpeedX *= -1;
    }

    if (ballY > height - 25 || ballY < 25) {
      ballSpeedY *= -1;
    }
  }
}
