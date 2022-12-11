package Iterator;

import Template.User;

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