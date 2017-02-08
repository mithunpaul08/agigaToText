package RAPShell


import java.io.{BufferedWriter, File, FileWriter}
import java.util.Calendar

import scala.io
import scala.collection.parallel.immutable._
import scala.collection.parallel.immutable.ParVector
//import GradabilityClassifier.{classifierForAgro, ratioCalculator}
//import RAPShell.wrapperForOdin.newsArticle
import initializer.initializer
import jline.console.ConsoleReader
import jline.console.history.FileHistory
import org.clulab.agiga
import org.clulab.learning.RVFDatum
import org.clulab.odin.{ExtractorEngine, Mention}
import org.clulab.processors.{Document, Processor}
import org.clulab.processors.fastnlp.FastNLPProcessor
import org.clulab.processors.shallownlp.ShallowNLPProcessor

import scala.collection.mutable.ArrayBuffer
import scala.compat.Platform.arraycopy
import scala.reflect.ClassTag
import scala.runtime.ScalaRunTime._
import scala.collection.immutable.ListMap
import scala.collection.{mutable, parallel}
import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import scala.collection.parallel.ForkJoinTaskSupport
import scala.io.Source
import util.control.Breaks._


/**
  * Interactive shell for parsing RAPs
  * User: mihais
  * Date: 7/4/16
  */

//creating a function to merge with world-modeling code. Note that the main function has been moved to mainfile()
//so removing the extends app part
//object RAPShell extends App {
  object shell {

  //val filenameOfThisfile = "filenameOfThisfile.txt";
  val nthreads = 4
  var resourcesDirectory = "src/main/resources/agigaFiles/"
  var outputDirectoryPath = "src/main/outputs/"


  def convertAgigaToText(): Unit = {

    //if running on server, change the input and output directories accordingly. This is beacuse the file mapping is
    //totally different on server.
    if (initializer.runOnServer) {
      resourcesDirectory = "/work/mithunpaul/testbed/agigaFiles/"
      outputDirectoryPath = "/work/mithunpaul/newOutputs/agigaToText/"
      val listOfFiles = new File(resourcesDirectory).listFiles().par
      listOfFiles.tasksupport = new ForkJoinTaskSupport(new scala.concurrent.forkjoin.ForkJoinPool(nthreads))
    }
    val listOfFiles = new File(resourcesDirectory).listFiles()


    for (indivFileName <- listOfFiles) {
      //for each input file, create a corresponding output file with .txt extension.
      val filenameOfThisfile = indivFileName.getName + ".txt"
      utilities.DeleteFileIfExistsAndCreateNewOne(filenameOfThisfile, outputDirectoryPath)
      println("going to read from file:" + indivFileName)
      //      utilities.AppendToFile("\n Start of news article\n", filenameOfThisfile, outputDirectoryPath)
      utilities.AppendToFile("\n \n", filenameOfThisfile, outputDirectoryPath)
      //get the annotated gigaword document- this gives a list of documents IN a given xml file. There can be 1000s
      val doc = agiga.toDocuments(indivFileName.getAbsolutePath)
      println("done reading agiga documents. The number of news articles in this document is:" + doc.length)
      for (newsArticles <- doc) {

        utilities.AppendToFile("\n \n", filenameOfThisfile, outputDirectoryPath)
        for (sentence <- newsArticles.sentences) {
          println(sentence.words.mkString(" "))
          utilities.AppendToFile(sentence.words.mkString(" "), filenameOfThisfile, outputDirectoryPath)
        }
      }
    }
  }
}