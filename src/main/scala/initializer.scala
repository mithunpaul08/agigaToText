//package GradabilityClassifier
//testing for push from chung

package initializer


//import GradabilityClassifier._
import RAPShell._
//package agiga
//Just a main file to trigger the required parsing. Either for adjective or adverb
//update: after merging world-modeling and agroclassifier- this file should act as the one single entry point. Its control
//floow is as follows
//1. initialize and run the classifier
//2. Run RAP shell
// 3. Use this classifier to grade adjectives found in RAPShell
// update://the main file remains outside the 2 packages we use. Historically thsee 2 packages were two different projects

object initializer {
  def main(args: Array[String]) = println("Exiting main program")

  //to specify if running on jenny or local machine
  val runOnServer = false;

//  //if you dont want the agiga parser code to run.
//  // Note: this goes through the agiga files in kate and converts it to processor document format
//  //this was used only in sep2016 once. You probably dont need to use this anymore ever
//  val runAgigaParser = false;
//
//
//  //if you dont want classifier code to run, switch this to false. Instead it will go directly to
//  // RAPshell. Good for testing ODIN rules
//  val runClassifier = true;
//
//  //mention what instrument if you want the code to be run for Eg: "farmsize", "pests".
//  // if you want to read from the ScrapedFiles folder, just say "all"
//  //Note: use "all" if you want to test your grammar. Then go paste the input file inside the scrapedFiles/ directory.
//  // val agroInstrument = "pests"
//  //val agroInstrument = "farmsize"
//  //val agroInstrument = "all"
//  //if you want to read agiga files directly, say "agiga". Note that agiga files are in .gz format, and are already annotated.
//  // So you will have to use:parseAndWriteToFileAddRelationsToTripletClass instead of parseAndWriteToFileAddRelationsToTripletClassWithStringInput
//  //update:Jan312017 this boolean value is used in shell.scala - whre we try to recognize/print files based on certain conditions.
//  //note that the files must be copied into the scrapedFiles directory manually.
//  //on chung the agiga files can be found at ~/fall2016/archive/
//  val agroInstrument = "agiga"
//
//
//  //this findIfGradable is used to check whether the adjectives we discovered from AGIGA are actually gradable or not.
//  //This boolean flag had to be set because on 2Feb2017 it was discovered that we might have to test the code just on
//  // ODIN parsers, without wasting time on gradability.
//  //note: if the below findIfGradable is set to true, you will have to set the  runClassifier above as TRUE. Without
//  //training a classifier you cannot use to test it.
//  val findIfGradable= true

  try {

//    if (runAgigaParser == true) {
//      agigParser.readFiles()
//    }
//
//    if (runClassifier == true) {
//      var hashmapOfColderCold = removeErFromAdj.readErRemovedFile(runOnServer);
//      classifierForAgro.initializeAndClassify(runOnServer, hashmapOfColderCold);
//    }

    shell.convertAgigaToText()
  }

  catch {
    // handling any other exception that might come up
    case unknown: Throwable => println("Got this unknown exception: " + unknown.printStackTrace)
  }
}
