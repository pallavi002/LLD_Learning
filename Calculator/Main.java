package Calculator;

public class Main {
    public static void main(String[] args) {
        ArithematicExpression two = new Number(2);

        ArithematicExpression one = new Number(1);
        ArithematicExpression seven = new Number(7);

        ArithematicExpression addition = new Expression(one, seven, '+');

        ArithematicExpression multiplication = new Expression(two, addition, '*');

        System.out.println(multiplication.evaluate());
    }
}