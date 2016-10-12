package turtlerace
import scala.collection.mutable.ArrayBuffer;

object Main {
  def main(args : Array[String]): Unit = {
    val window = new RaceWindow(800, 400, "Turtlerace");
    var turtles = for(i <- 0 to 31) yield randTurtle(window, i, "Turtle " + i);
    var activeSeq: Seq[RaceTurtle];
    var winners: ArrayBuffer[RaceTurtle];
    var i=1;
    while(i<=4){
      var x = -1;
      while(x<32/i){
        activeSeq = for(j <- 0 until 8) yield{
          x+=1;
          turtles(x).asInstanceOf[RaceTurtle];
        }
        winners = TurtleRace.race(activeSeq, window, "Tournament part " + i).to[ArrayBuffer];
      }
      turtles = winners.toIndexedSeq;
      i*=2;
    }
  }

  def randTurtle(window: RaceWindow, num: Int, name: String): RaceTurtle = {

  }
}
