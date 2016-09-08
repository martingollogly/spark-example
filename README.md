# spark-example

## From course 
https://app.pluralsight.com/player?course=apache-spark-fundamentals

## Spark Documentation
http://spark.apache.org/docs/latest/quick-start.html

## Setting it up

* Download Hadoop
* Download Spark wih hadoop file system
* Set SPARK_HOME and HADOOP_HOME and place winutils.exe for hadoop version under hadoop bin folder
  * https://github.com/steveloughran/winutils/


## Starting Spark with scala
 Open Command prompt or shell and run 
 
 ``` 
 spark-shell
 ```

All Spark jobs begin with sc (The Spark Context) which is supplied by the spark-shell

The shell creates 2 contexts
* sc 
* sqlContext
 
## Using Spark
 
 ``` 
 :help
 ```
 
## Simple Example

### Read in a text file and write first line
 
 ```
 val textFile = sc.textFile("file:///<SPARK_HOME>/README.md")
 ```
 
 ```
 textFile.first
 ```
 
 > res0: String = # Apache Spark
 
### Tokenize the File Data with a space

```
 val tokenizedFileData = textFile.flatMap(line=>line.split(" "))
```
> This is the Map in Map/Reduce

### Count the instances of each Word

Here the word is the key and the value is the count
``` 
 val countPrep = tokenizedFileData.map(word=>(word,1))
 
 val counts = countPrep.reduceByKey((accumValue, newValue)=>accumValue + newValue)
```
> This is the Reduce in Map/Reduce

###

Sort in decending order (_2 represents 2nd position in the tuple)
```
 val sortedCounts = counts.sortBy(kvPair=>kvPair._2, false)
```

### Write File and check output parts
```
 sortedCounts.saveAsTexFile("file:///<SOME_OUTPUT_LOCATION>/ReadMeWordCount")
```

## An even Simpler way using the Api
```
tokenizedFileData.countByValue
```

