package Strategy;

public class InputContext {
    private Strategy strategy;

    public InputContext(Strategy strategy) {
        this.strategy = strategy;
    }

    public String executeStrategy() {
        return strategy.calculate();
    }
}