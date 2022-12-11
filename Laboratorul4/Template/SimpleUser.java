package Template;
import Interpreter.*;

public class SimpleUser extends User {
    public SimpleUser(String username,String pass){
        this.username = username;
        this.pass = pass;
    }

    @Override
    boolean authentificate() {
        if(username.equals("user") && pass.equals("user")) {
            System.out.println("User Successful authentification");
            return true;
        }
        return false;
    }

    @Override
    public String calculate(String mess) {
        String reslt = "Error";
        if(authentificate()) {
            InterpreterTest calc = new InterpreterTest(new InterpreterEngine());
            System.out.println("Result: " + calc.interpret(mess));
            reslt = "Result: " + calc.interpret(mess);
        }
        else {
            System.out.println("User bad username or pass");
            reslt =  "User bad username or pass";
        }
        return reslt;
    }

}