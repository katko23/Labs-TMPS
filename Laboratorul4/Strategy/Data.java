package Strategy;

import Template.Programmers;
import Template.User;

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
