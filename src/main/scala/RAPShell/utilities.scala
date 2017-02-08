package RAPShell

//package org.clulab
//package agiga

import java.io.{BufferedWriter, File, FileWriter}

import org.clulab.learning.{Datasets, PerceptronClassifier, RVFDataset, RVFDatum}
/**
  * Created by mithunpaul on 10/14/16.
  */
object utilities {


  def AppendToFile(stringToWrite: String, outputFilename: String, outputDirectoryPath: String): Unit = {

    val outFile = new File(outputDirectoryPath, outputFilename)
    val bw = new BufferedWriter(new FileWriter(outFile, true))
    bw.write(stringToWrite)
    bw.close()
  }

  def WriteToFile(stringToWrite: String, outputFilename: String, outputDirectoryPath: String): Unit = {


    val outFile = new File(outputDirectoryPath, outputFilename)

    val bw = new BufferedWriter(new FileWriter(outFile))


    bw.write(stringToWrite)
    bw.close()


  }

  def DeleteFileIfExistsAndCreateNewOne(fileToDelete: String,  outputDirectoryPath: String): Unit = {
    val outFileoutputFileForThisNewsArticle = new File(outputDirectoryPath, fileToDelete)
    //remove if it exists. And create a new one to append And keep adding to it- in the for loop below.
    if (outFileoutputFileForThisNewsArticle.exists) {
      outFileoutputFileForThisNewsArticle.delete()
    }
    // create a new file of the same name and write into it some emptyline
    val file2 = new File(outputDirectoryPath + fileToDelete)
    val bw1 = new BufferedWriter(new FileWriter(file2))
    bw1.write("")
    bw1.close()
  }

}
