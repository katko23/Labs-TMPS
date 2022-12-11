package Iterator;
import Template.*;

public class IteratorTest {
    public static void main(String[] args) {
        User user = new Programmers("programmer", "programmer");
        String[] arr = {"add 15 and 25", "add 5 and 20"};
        UserCalculation userCalc = new UserCalculation(arr);

        for(Iterator iterator = userCalc.getIterator();
            iterator.hasNext();) {
            String ex = (String)iterator.next();
            user.calculate(ex);
        }
    }
}
