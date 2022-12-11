package Memento;

import Iterator.Iterator;
import Iterator.UserCalculation;
import Template.Programmers;
import Template.User;

public class MementoTest {
    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();

        User user = new Programmers("programmer", "programmer");
        String[] arr = {"add 15 and 25", "add 5 and 20"};
        UserCalculation userCalc = new UserCalculation(arr);

        for(Iterator iterator = userCalc.getIterator();
            iterator.hasNext();) {
            String ex = (String)iterator.next();
            originator.setState(user.calculate(ex));
            careTaker.add(originator.saveStateToMemento());
        }

        originator.getStateFromMemento(careTaker.get(0));
        System.out.println("First saved state: " + originator.getState());
        originator.getStateFromMemento(careTaker.get(1));
        System.out.println("Second saved state: " + originator.getState());
    }
}
