#Evaluator

> Note The project structure is important for this exercise as it uses the sbt-assembly plugin

The Example uses some Example Wiki Data available in the Pluralsight Course documentation

* plugins.sbt must be placed under the **project** folder
* The assembly plugin is used to include the non spark dependencies in a **fat jar**

# Building the Example

```
sbt assembly
```

# Running the Example

```
spark-submit --class main.Evaluator target\scala-2.10\Language-Evaluator-0.1.jar
```

The output should resemble

```
(14,classification)
(13,FUNCTIONMACRO)
(13,intelligently)
(12,checkpointed)
(12,thermometers)
(11,conclusions)
(11,occurrences)
(11,revolutions)
(11,competition)
(10,internally)
(10,synthesize)
(10,regardless)
(10,subscriber)
(10,adjustable)
(10,Elasticity)
(9,preserved)
(9,reasoning)
(9,Essential)
(9,Microsoft)
(9,employers)
(9,commodity)
(8,founders)
(8,hospital)
(8,affected)
(8,Included)
(8,attached)
...
```


