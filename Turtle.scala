package turtlerace

import cslib.window.SimpleWindow

/** A Kojo-like Turtle class that can be used to draw shapes in a SimpleWindow.
  *
  * @param window    The window the turtle should be placed in.
  * @param position  A Point representing the turtle's starting coordinates.
  * @param angle     The angle between the turtle direction and the X-axis
  *                  measured in degrees. Positive degrees indicate a counter
  *                  clockwise rotation.
  * @param isPenDown A boolean representing the turtle's pen position. True if
  *                  the pen is down. */
class Turtle(window: SimpleWindow,
             private var position: Point,
             private var angle: Double,
             private var isPenDown: Boolean) {

  /** Rounds from Double */
  def round(value: Double): Int = if(value-value.toInt >= 0.5) value.toInt+1 else value.toInt;

  def rad = angle*math.Pi/180; // Gets angle in radians

  def x: Int = round(position.x);

  def y: Int = round(position.y);

  def jumpTo(newPosition: Point) = {
    position = newPosition;
    window.moveTo(round(position.x), round(position.y));
  }

  def forward(length: Double): Unit = {
    window.moveTo(round(position.x), round(position.y));
    position = position.translate(math.cos(rad)*length, -math.sin(rad)*length);
    if(isPenDown) window.lineTo(round(position.x), round(position.y));
  }

  def turnLeft(turnAngle: Double): Unit = angle += turnAngle;

  def turnRight(turnAngle: Double): Unit = angle -= turnAngle;

  def turnNorth(): Unit = angle = 90;

  def penDown(): Unit = isPenDown = true;

  def penUp(): Unit = isPenDown = false;

  def turnTo(newAngle: Double): Unit = angle = newAngle;
}

