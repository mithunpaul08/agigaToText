//package GradabilityClassifier
//testing for push from chung

package initializer


//import GradabilityClassifier._
import RAPShell._

object initializer {
  def main(args: Array[String]) = println("Exiting main program")

  //to specify if running on jenny or local machine
  val runOnServer = true;


  try {

    shell.convertAgigaToText()
  }

  catch {
    // handling any other exception that might come up
    case unknown: Throwable => println("Got this unknown exception: " + unknown.printStackTrace)
  }
}
