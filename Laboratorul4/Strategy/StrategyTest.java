package Strategy;

public class StrategyTest {
    public static void main(String[] args) {
        InputContext inputContext = new InputContext(new Console());
        inputContext.executeStrategy();

        inputContext = new InputContext(new Data());
        inputContext.executeStrategy();

    }
}
