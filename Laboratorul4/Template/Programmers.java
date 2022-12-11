package Template;
import Interpreter.*;

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