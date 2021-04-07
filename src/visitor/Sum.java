package visitor;

public class Sum extends BinaryOperator {
    public Sum(ArithmeticExpression operandEsquerra, ArithmeticExpression operandDret) {
        super(operandEsquerra, operandDret);
    }

    @Override
    public void acceptVisitor(Visitor v) {
        v.visitSum(this);
    }

}
