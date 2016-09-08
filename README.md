# spark-example

## From course 
https://app.pluralsight.com/player?course=apache-spark-fundamentals

## Setting it up

* Download Hadoop
* Download Spark wih hadoop file system
* Set SPARK_HOME and HADOOP_HOME and place winutils.exe for hadoop version under hadoop bin folder
  * https://github.com/steveloughran/winutils/


## Starting Spark
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

### Count the instances of each Word ans sort them

``` 
 val countPrep = tokenizedFileData.map(word=>(word,1))
 
 val counts = countPrep.reduceByKey((accumValue, newValue)=>accumValue + newValue)
 
 val sortedCounts = counts.sortBy(kvPair=>kvPair._2, false)
```

### Write File and check output parts
```
 sortedCounts.saveAsTexFile("file:///<SOME_OUTPUT_LOCATION>/ReadMeWordCount")
```
