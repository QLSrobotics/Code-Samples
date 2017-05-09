# Style Guide

## What is a style guide
This is intedned to make the process of creating the software much easier. By follwing theese rules everyone in the team can be constiant with each other and work more efttlyiy together. The style guirde is a colletion of rules that applies to writng software for the team robt. If your code does not follow the rules then it does not go on to the robot.

## Varibles
There are many varbles that are on the robot. Some are interal to the funtion/method that is in a probgam and some span acrros all the files. Keeping varble names contint will make copy code easier cna drastily reduce debugging time.
### Varibles that repsent physical objects
Any varble that reprents an onbect in real life (sensors, motors, etc) need to labeled as such on that object. If a motors name is BLMot then the motor should have BLMot wrtten on it.
### Motors
motors are the most important varible on the robot. there are many methods that interacat with them. the naming system for them is as follows. (B or F)(L or R)(Mot)
Example
>BLMot

this is the back left motor
>FRMot

this si the fornt right motor

this system should be used on all four drive train motors. All methods that invole theese motors should use thoose names. In both the robot setup on the phone and in the software on the laptop.

on drive traint motors shoudl be names by (funtion)(Mot)

>shootMot

this is the motor that controls the shooting

>lifterMot

this motor controls the lifter

what matters more than the actual name is that the names are constiant bwteen progams By labeling it on to the motor istelf all progammers should use the same name for every motor 
