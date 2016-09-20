package main

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

/** Word Counter
  * @author zemertz
  * to split a document and tokenize it and working out the occurences of each string
  * 
  * The file is written to a defined output location
  */
  
def document: Nothing
object WordCounter {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("Word Counter")
    val sc = new SparkContext(conf)
    val textFile = sc.textFile("file:///<SPARK_HOME>README.md")
    val tokenizedFileData = textFile.flatMap(line=>line.split(" "))
    val countPrep = tokenizedFileData.map(word=>(word,1))
    val counts = countPrep.reduceByKey((accumValue, newValue)=>accumValue + newValue)
    val sortedCounts = counts.sortBy(kvPair=>kvPair._2, false)
    sortedCounts.saveAsTextFile("file:///<OUTPUT_LOCATION>/ReadMeWordCount")
  }
}
