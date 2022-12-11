# Report for labs 4

### Course: TMPS
### Author: Coseru Catalin

----


## Objectives:

* Make 5 different types of behavioral design patterns.
* Get familiarized with behavioral patterns.

## Implementation description
**Interpreter**

* The Interpreter pattern is used anytime we need to evaluate any kind of language grammar or expressions. A good example of this pattern would be Google Translate, which interprets the input, and shows us the output in another language. 

    Another example would be the Java compiler. The compiler interprets Java code and translates it into bytecode that the JVM uses to perform operations on the device it runs on.

    This pattern also represents a great way to write simple programs that understand human-like syntax.



In my case, I made a simple interpreter, which adds or multiplies 2 numbers, in case the words add or multiply are in a sentence. In general, I took a simple String, I checked if it contained the words add or multiply, then I deleted everything I didn't need and only 2 numbers remained, which were later added or multiplied depending on the sentence.
You can see code bellow:

```
    public int add(String input) {
        String[] tokens = interpret(input);
        int num1 = Integer.parseInt(tokens[0]);
        int num2 = Integer.parseInt(tokens[1]);
        return (num1+num2);
    }

    public int multiply(String input) {
        String[] tokens = interpret(input);
        int num1 = Integer.parseInt(tokens[0]);
        int num2 = Integer.parseInt(tokens[1]);
        return (num1*num2);
    }

    private String[] interpret(String input) {
        String string = input.replaceAll("[^0-9]", " ");
        string = string.replaceAll("( )+", " ").trim();
        String[] tokens = string.split(" ");
        return tokens;
    }
```

I cannot add anything to this pattern , it's simply used to evaluate a so-called grammar. In my example is avery simple grammar.

**Template**
* The Template Method, otherwise known as Template Pattern is all around us. It boils down to defining an abstract class that provides predefined ways to run its methods. Sub-classes that inherit these methods must also follow the way defined in the abstract class.

    In some cases, the abstract class may already include a method implementation, not just instructions, if it's a functionality that will be shared amongst all or most of the sub-classes.

This example illustrates how I thought at the time of creating the laboratory, I was hoping for an easy and simple implementation, and I found the idea to create as many patterns as possible. So I started by making an application for calculating the sum and multiplication of 2 numbers depending on the string taken. Thus, I would have needed users to have access to this application, and to receive different messages depending on who they are. Thus I made a pattern template for users. Users was the initial, general interface somewhat representing the template, and programmers and simple users were the concrete implementations.

Thus, depending on the template used for the calculation, I got different messages in the console, all the code being somewhat simple:

``` 
public abstract class User {
    protected String username;
    protected String pass;
    abstract boolean authentificate();
    public abstract String calculate(String mess);
}
```

The template of corse is an abstract class as you can see , and in programmers class , the implementation is :


``` 
public class Programmers extends User {
    public Programmers(String username,String pass){
        this.username = username;
        this.pass = pass;
    }

    @Override
    boolean authentificate() {
        if(username.equals("programmer") && pass.equals("programmer")) {
            System.out.println("Admin Successful authentification");
            return true;
        }
        return false;
    }

    @Override
    public String calculate(String mess) {
        String reslt = "Error";
        if(authentificate()) {
            InterpreterTest calc = new InterpreterTest(new InterpreterEngine());
            System.out.println("Admin the result is: " + calc.interpret(mess));
            reslt = "Admin the result is: " + calc.interpret(mess);
        }
        else {
            System.out.println("Admin Bad username or pass");
            reslt = "Admin Bad username or pass";
        }
        return reslt;
    }
}
```

same we have in User class , if you want you can see this class in folder template.

**Iterator**
* The Iterator pattern is used as the core pattern of Java's Collection Framework. It's used to access the members of collections all the while hiding the underlying implementation.

As we can see, This is a fairly simple implementation and is used as the core pattern in multiple frameworks, including the framework mentioned above.
But the idea behind this implementation was very simple. So we have users, who after authorization can calculate something. If they have several exercises in a row, they have to enter and write each one in turn, which steals time. I can create an array in which all the equations that need to be calculated will be saved, and then we will iteratively go through this array and execute each exercise.

The implementation was very simple , cause we need a checker , if we have next object , and an ref to this object , and of corse another interface for geting Iterator.

The iterator is this interface for check. 

```
public interface Iterator {
    public boolean hasNext();
    public Object next();
}
```

and the getter interface is Examples

``` 
public interface Exemples {
    public Iterator getIterator();
}
```
So in the UserCalculation class we have an array of exercises that need  to be computed ,
and the iterator , that is going through array:
```
public class UserCalculation implements Exemples {
    public String[] ex = {"add 15 and 25", "add 5 and 20", "multiply 10 and 10"};

    public UserCalculation(String[] arr_ex){
        this.ex = arr_ex;
    }
    UserCalculation(){}

    @Override
    public Iterator getIterator() {
        return new ExIterator();
    }

    private class ExIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            if (index < ex.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return ex[index++];
            }
            return null;
        }
    }
}
```

That's all with Iterator

**Memento**

* The Memento pattern is concerned with previous states of the object. This means that the pattern is used when we want to save some state of an object, in the case we might want to restore the object to that state later on.

This pattern relies on the work of three classes, also known as actor classes. The Memento object contains a state that we wish to save for later use. The Originator object creates and stores states in the Memento objects, while the CareTaker object takes care of the restoration process.

In my case, I take into account and save only the answers to the exercises, so that in an ordinary computer, if necessary, I can go back to an answer above, but my implementation is more general, being very simple. I save any type of string in Memento, and then through Originator and CareTracker I can access any moment in the history of solutions.
THe implementation of memento is :

```
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
```

Then my originator and caretaker:

```
public class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }
}
```

```
public class CareTaker {
    private List<Memento> mementoList = new ArrayList<>();

    public void add(Memento memento) {
        mementoList.add(memento);
    }
    public Memento get(int index) {
        return mementoList.get(index);
    }
}
```

So how it's work you can see by executing my MementoTest class from folder Memento

**Strategy**
And finally , last design pattern today :

* The Strategy pattern is employed in situations where algorithms or class' behavior should be dynamic. This means that both the behavior and the algorithms can be changed at runtime, based on the input of the client.

    Similar to the State Pattern, this pattern employs multiple strategy objects which define different strategies for the targeted class. The targeted class adapts its algorithms and behaviors based on these strategies.

And I thought so, because it's a "calculation application" with users and a history of saves, why not make different types of input. So that I have input from the keyboard in the terminal and predefined input, through an array (as in the case of the Iterator design pattern).
I start off with defining a strategy ( cause it was the hardest thing ):

```
public interface Strategy {
    public String calculate();
}
```
soo this strategy will be used to take different types of user input. These input types implement the strategy each in a different way:

From Console :
```
public class Console implements Strategy {

    private String getUserInput() {
        String ecuation = "Error";
        try {
            // Enter data using BufferReader
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));

            // Reading data using readLine
            ecuation = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ecuation;
    }

    @Override
    public String calculate(){
        User user = new Programmers("programmer", "programmer");
        System.out.println("User please write input : (like 'adds 5 and 2000001') ");
        String ex = getUserInput();
        return "Result is" + user.calculate(ex);
    }
```

and from array of data :
```
public class Data implements Strategy {

    String[] arr = {"add 15 and 25", "add 5 and 20", "multiply 10 and 10"};

    public Data(String[] arr_ex) {
        this.arr = arr_ex;
    }

    Data() {
    }

    @Override
    public String calculate() {
        User user = new Programmers("programmer", "programmer");
        for(int i=0;i<arr.length;i++){
            user.calculate(arr[i]);
        }
        return "All is done";
    }
}
```
Similar to the State pattern, a Context class will use the strategy:

```
public class InputContext {
    private Strategy strategy;

    public InputContext(Strategy strategy) {
        this.strategy = strategy;
    }

    public String executeStrategy() {
        return strategy.calculate();
    }
}
```

##Conclusion and some words to add
In Conclusion it's a very simple implementation of the "backend" of a virtual calculator , what works with words and sentences. 

Also, each design pattern in this laboratory has a special test, through which you can observe in reality how everything works.