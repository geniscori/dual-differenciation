package visitor;

public abstract class BinaryOperator implements ArithmeticExpression {
    
    public BinaryOperator(ArithmeticExpression leftOperand, ArithmeticExpression rightOperand) {
        left = leftOperand;
        right = rightOperand;
    }

    protected ArithmeticExpression left;

    protected ArithmeticExpression right;

    public ArithmeticExpression getLeft() {
        return left;
    }

    public ArithmeticExpression getRight() {
        return right;
    }
 
}
