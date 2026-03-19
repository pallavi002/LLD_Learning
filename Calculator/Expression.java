package Calculator;

public class Expression implements ArithematicExpression {
    ArithematicExpression left;
    ArithematicExpression right;
    char operator;

    public Expression(ArithematicExpression left, ArithematicExpression right, char operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    @Override
    public int evaluate() {
        int leftValue = this.left.evaluate();
        int rightValue = this.right.evaluate();

        switch (this.operator) {
            case '+':
                return leftValue + rightValue;
            case '-':
                return leftValue - rightValue;
            case '*':
                return leftValue * rightValue;
            case '/':
                return leftValue / rightValue;
            default:
                throw new IllegalArgumentException("Invalid operator: " + this.operator);
        }
    }
}