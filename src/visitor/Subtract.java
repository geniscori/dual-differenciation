package visitor;

public class Subtract extends BinaryOperator {
    public Subtract(ArithmeticExpression operandEsquerra, ArithmeticExpression operandDret) {
        super(operandEsquerra, operandDret);
    }

    @Override
    public void acceptVisitor(Visitor v) {
        v.visitSubtract(this);
    }

}
