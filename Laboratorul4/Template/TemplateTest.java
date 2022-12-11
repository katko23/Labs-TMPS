package Template;

public class TemplateTest {
    public static void main(String[] args) {
        User user = new Programmers("admin", "admin");
        user.authentificate();
        user.calculate("add 15 and 25");

        System.out.println();

        user = new SimpleUser("user","user");
        user.authentificate();
        user.calculate("add 15 and 25");

        System.out.println();

        user = new Programmers("programmer", "programmer");
        user.authentificate();
        user.calculate("add 15 and 25");
    }
}
