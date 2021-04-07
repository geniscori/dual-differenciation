public abstract class BinaryOperator implements Expression {
    Expression left;
    Expression right;
    public BinaryOperator(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
}