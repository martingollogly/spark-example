#Scala Examples

## Pre-requisites

Download sbt from http://www.scala-sbt.org/ to package your scala app. (Thie initial run of this tool will download a number of dependencies)

## Packaging
Go to the folder with your scala project and run 

* build. sbt - manages the dependencies
* *.scala is the code

```
sbt pakage 
```
> Should produce a jar file under your target directory


## Running Example

```
spark-submit --class main.WordCounter --master local[*]  <YOUR_BUILT_JAR_LOCATION>\word-count_2.10-0.1.jar
```
> where local[*] is all available cores on the local machine

> The program should run and create the Folder with sorted entries by number of word occurences in split files

> Note any ARGS passed in following the jar are fed as input to the Main method defined with --classs
