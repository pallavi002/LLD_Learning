package Calculator;

public class Number implements ArithematicExpression {
    int value;

    public Number(int value) {
        this.value = value;
    }

    @Override
    public int evaluate() {
        return this.value;
    }
}