package turtlerace;

import cslib.window.SimpleWindow

class colorTurtle(window: SimpleWindow, position:Point, angle: Double, isPenDown: Boolean, color: java.awt.Color)
      extends Turtle(window, position, angle, isPenDown){
  override def forward(length: Double): Unit = {
    val old = window.getLineColor();
    window.setLineColor(color);
    super.forward(length);
    window.setLineColor(old);
  }
}
