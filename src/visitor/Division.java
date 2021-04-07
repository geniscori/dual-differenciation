package visitor;

public class Division extends BinaryOperator {
    public Division(ArithmeticExpression operandEsquerra, ArithmeticExpression operandDret) {
        super(operandEsquerra, operandDret);
    }

    @Override
    public void acceptVisitor(Visitor v) {
        v.visitDivision(this);
    }

}
