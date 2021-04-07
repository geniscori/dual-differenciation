public class Substract extends BinaryOperator {

    public Substract(Expression x, Expression y){
        super(x,y);
    }

    @Override
    public DualNumber evaluate(DualNumber dn){
        DualNumber dnl = left.evaluate(dn) , dnr = right.evaluate(dn);
        return new DualNumber(dnl.u - dnr.u, dnl.uprime - dnr.uprime);
    }
}