# Report for labs

### Course: TMPS
### Author: Coseru Catalin

----


## Objectives:

* Make 5 different types of creational design patterns.
* Get familiarized with creational patterns.

## Implementation description
**Abstract Factory**
* In my FurnitureFactory.java file I have an interface furniture , with 3 kind of objects 
of abstract class chair ,coffeetable and sofa. All that abstract classes has 2 class , that
extends the initial one , each of two is Modern and Victorian style for object creation .

I can add what in GenerateFurniture I have a kind of implementation of that abstract factory 
soo it's just to show some working examples.

**Builder**
* Soo in Buider file I have a class House ,with some required variables ,and some optional
, and in order to add this optional parameters I implement another class builder , that have
methods , each with an creation of object of BuilderHouse class , and of course one build 
method that allow to make an object of class House , with same param as in BuilderHouse class.
  (I mean after building)

**Factory Method**
* Is the first one that I implement, in this case I use a shiping factory to have a Shipping class
in that I have some param and a method , all this has extended in classes Avia , Ship and Truck.
In the fact it's just an object creator of shipping class.

... etc ( sorry ,it's not so hard to understand in code what I wrote , but if it will be needed a explanation I will be at lesson.)