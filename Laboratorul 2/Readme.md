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
```
interface furniture{
Chair createChair();
CoffeeTable createCoffeeTable();
Sofa createSofa();
}

abstract class Chair{
protected int numberOfLegs;
protected int numberOfSits;
abstract void getnumberOfLegs(int l);
abstract void getnumberOfSits(int s);
}

abstract class CoffeeTable{
protected int numberOfLegs;
protected double length;
protected double width;
abstract void getnumberOfLegs(int l);
abstract void getLength(double l);
abstract void getWidth(double w);
}

abstract class Sofa{
protected int numberOfSits;
protected String materialChoosen;
abstract void getnumberOfSits(int s);
abstract void getMaterial(String m);
}
```
soo we can see an interface of furniture and some abstract classes for all kind of furniture

in addition I make for all kind of styles , some aditional classes
for example in modern style :
```
class ModernChairs extends Chair{
    void getnumberOfLegs(int l){
        numberOfLegs = l;
    }
    void getnumberOfSits(int s){
        numberOfSits = s;
    }
}

class ModernCoffeeTable extends CoffeeTable{
    void getnumberOfLegs(int l){
        numberOfLegs = l;
    }

    @Override
    void getLength(double l) {
        length = l;
    }

    @Override
    void getWidth(double w) {
        width = w;
    }
}

class ModernSofa extends Sofa{
    @Override
    void getMaterial(String m) {
        materialChoosen = m;
    }

    @Override
    void getnumberOfSits(int s) {
        numberOfSits = s;
    }
}

class ModernStyle implements furniture{
    @Override
    public Chair createChair() {
        ModernChairs tempChair = new ModernChairs();
        return tempChair;
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        ModernCoffeeTable tempCoffee = new ModernCoffeeTable();
        return tempCoffee;
    }

    @Override
    public Sofa createSofa() {
        ModernSofa tempSofa = new ModernSofa();
        return tempSofa;
    }
}

```
Then I create a  piece of furniture , I make a new one in the modern/victorian style .
Soo I can get from the factory an object in wanted style. 

* I can add what in GenerateFurniture I have a kind of implementation of that abstract factory 
soo it's just to show some working examples.

**Builder**
* Soo in Buider file I have a class House ,with some required variables ,and some optional
, and in order to add this optional parameters I implement another class builder , that have
methods , each with an creation of object of BuilderHouse class , and of course one build 
method that allow to make an object of class House , with same param as in BuilderHouse class.
  (I mean after building)

First of all the class itself:
```
class House{
        // required param
        private int nr_of_walls;
        private int nr_of_doors;
        private int nr_of_windows;

        //optional
        private boolean isMedieval;
        private boolean isRococo;
        private int nr_of_towers;
        private int nr_of_guns;
        private int nr_of_staff;

        public int getNr_of_walls(){
            return nr_of_walls;
        }

        public int getNr_of_doors() {
            return nr_of_doors;
        }

        public int getNr_of_windows() {
            return nr_of_windows;
        }

        public boolean isMedieval() {
            return isMedieval;
        }

        public boolean isRococo() {
            return isRococo;
        }

        public int getNr_of_towers() {
            return nr_of_towers;
        }

        public int getNr_of_guns() {
            return nr_of_guns;
        }

        public int getNr_of_staff() {
            return nr_of_staff;
        }
```

the copy-constructor for getting an object with builder in fitch :
```
private House(HouseBuilder builder){
            this.isMedieval = builder.isMedieval;
            this.isRococo = builder.isRococo;
            this.nr_of_walls = builder.nr_of_walls;
            this.nr_of_doors = builder.nr_of_doors;
            this.nr_of_windows = builder.nr_of_windows;
            this.nr_of_towers = builder.nr_of_towers;
            this.nr_of_guns = builder.nr_of_guns;
            this.nr_of_staff = builder.nr_of_staff;
        }
```

soo the builder class :

```
public static class HouseBuilder{
            // required param
            private int nr_of_walls;
            private int nr_of_doors;
            private int nr_of_windows;

            //optional
            private boolean isMedieval;
            private boolean isRococo;
            private int nr_of_towers;
            private int nr_of_guns;
            private int nr_of_staff;

            public HouseBuilder(int nr_walls,int nr_doors,int nr_windows){
                this.nr_of_walls = nr_walls;
                this.nr_of_doors = nr_doors;
                this.nr_of_windows = nr_windows;
            }

            public HouseBuilder setMedieval(boolean medieval) {
                this.isMedieval = medieval;
                return this;
            }

            public HouseBuilder setRococo(boolean rococo){
                this.isRococo = rococo;
                return this;
            }

            public HouseBuilder hasTowers(int nr_of_towers){
                this.nr_of_towers = nr_of_towers;
                return this;
            }

            public HouseBuilder hasGuns(int nr_guns){
                this.nr_of_guns = nr_guns;
                return this;
            }

            public HouseBuilder hasStaff(int nr_staff){
                this.nr_of_staff = nr_staff;
                return this;
            }

            public House build(){
                return new House(this);
            }
        }
```

**Factory Method**
* Is the first one that I implement, in this case I use a shiping factory to have a Shipping class
in that I have some param and a method , all this has extended in classes Avia , Ship and Truck.
In the fact it's just an object creator of shipping class.

I have one abstract class named shipping, and some concrete class like avia , ship and truck
to present the factory objects , soo I can get a concrete object with some working stuff like 
a method to calculate bill ( each concrete class has different equation to compute bill)

Soo all my factory method is :
abstract class Shipping{
protected double price_km;
abstract void getPrice_Km();

```
    public void calculateBill(int dist){
            getPrice_Km();
            System.out.println(dist*price_km);
        }
    }
    // make a abstract class of shipping

    class Avia extends Shipping{
        //@override
        public void getPrice_Km(){
            price_km = 5.5;
        }
    }
    // first class of shipping with a plane

    class Ship extends Shipping{
        //@override
        public void getPrice_Km(){
            price_km = 7.5;
        }
    }
    // Deliver by sea in a container ##DOCKER##

    class Truck extends Shipping{

        public void getPrice_Km(){
            price_km = 2.3;
        }
    }//Deliver by the Truck , but at a lower price
```

**Prototype**

* Prototype a design pattern there we can have some clones of the same object

* Like that in my execution I have an abstract method called shapes , and it is extended by 2 concrete 
classes Rectangle and Circle , in my test app : "GenerateShapes" I have a creation of object
of class Circle , and after that I clone it into another object of same type . 
So in that case I get a prototype to make soo many object of the same type as I want.
In my code I write all the classes in this way:

```
abstract class Shape{
    int x ;
    int y ;
    String color;

    Shape(){};

    Shape(Shape tempShape){
        this();
        this.x = tempShape.x;
        this.y = tempShape.y;
        this.color = tempShape.color;
    }



    public abstract Shape clone();
}

class Circle extends Shape{
    int radius;

    public Circle(Circle ctemp){
        super(ctemp);
        this.radius = ctemp.radius;
    }

    public Circle(int x,int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }


    public Shape clone(){
        return new Circle(this);
    }
}
```

**Singleton**

* The simplest design pattern in creational DP .

The ideea behind this is simple , we use it then we need to instantiate only one object of a 
class , it can be achieved by 2 methods, I choose to initiate the obj at the load time :

```
    private static Singleton obj=new Singleton();//Early, instance will be created at load time
    private Singleton(){}

    public static Singleton getSingleton(){
        return obj;
    }

    public void doSomething(){
        System.out.println("Only one object will be initiated , by Early initialization");
    }
```

So I achieve that just putting the constructor in private field , and now I have just a class
with an object of that class , that can do something , and I can't make any other obj-s of that class.
