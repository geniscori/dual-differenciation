package visitor;

public class Product extends BinaryOperator {
    public Product(ArithmeticExpression operandEsquerra, ArithmeticExpression operandDret) {
        super(operandEsquerra, operandDret);
    }

    @Override
    public void acceptVisitor(Visitor v) {
        v.visitProduct(this);
    }

}
