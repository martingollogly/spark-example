# Spark examples repo for getting started

<a href='https://travis-ci.org/martingollogly/spark-examples/builds'><img src='https://travis-ci.org/martingollogly/spark-examples.svg?branch=master'></a>
[![Coverage Status](https://coveralls.io/repos/github/martingollogly/spark-examples/badge.svg?branch=master)](https://coveralls.io/github/martingollogly/spark-examples?branch=master)

## Insight from following course 
https://app.pluralsight.com/player?course=apache-spark-fundamentals
> Note: Code Examples are built on those provided From Pluralsight Course above


## Spark Documentation
http://spark.apache.org/docs/latest/quick-start.html

## Setting it up (Pre-reqs)

* Download Hadoop
* Download Spark wih hadoop file system
* Set SPARK_HOME and HADOOP_HOME and place winutils.exe for hadoop version under hadoop bin folder
  * https://github.com/steveloughran/winutils/

### Or start with Docker Image with preinstalled Spark 
See https://github.com/sequenceiq/docker-spark


## Starting Spark with scala
 Open Command prompt or shell and run 
 
 ``` 
 spark-shell
 ```

All Spark jobs begin with sc (The Spark Context) which is supplied by the spark-shell

The shell creates 2 contexts
* **sc** - a special interpreter-aware SparkContext is already created for you in spark shell
* **sqlContext** - entry point for working with structured data (rows and columns) in Spark
 
## Using Spark shell
 
 ``` 
 :help for help
 ```
 ``` 
 use two tabs to see method definitions rather than return (e.g. sc.parallelize)
 ```
 
 
## Simple Example

### Read in a text file and write first line
 
 ```scala
 val textFile = sc.textFile("file:///<SPARK_HOME>/README.md")
 ```
 
 ```scala
 textFile.first
 ```
 
 > res0: String = # Apache Spark
 
### Tokenize the File Data with a space

```scala
 val tokenizedFileData = textFile.flatMap(line=>line.split(" "))
```
> This is the Map in Map/Reduce

### Count the instances of each Word

Here the word is the key and the value is the count
```scala 
 val countPrep = tokenizedFileData.map(word=>(word,1))
 
 val counts = countPrep.reduceByKey((accumValue, newValue)=>accumValue + newValue)
```
> This is the Reduce in Map/Reduce

### Sort in decending order (_2 represents 2nd position in the tuple)
```scala
 val sortedCounts = counts.sortBy(kvPair=>kvPair._2, false)
```

### Write File and check output parts
```scala
 sortedCounts.saveAsTexFile("file:///<SOME_OUTPUT_LOCATION>/ReadMeWordCount")
```

## An even Simpler way using the Api
```scala
tokenizedFileData.countByValue
```

