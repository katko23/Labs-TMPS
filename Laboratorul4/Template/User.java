package Template;

public abstract class User {
    protected String username;
    protected String pass;
    abstract boolean authentificate();
    public abstract String calculate(String mess);
}
