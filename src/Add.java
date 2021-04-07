public class Add extends BinaryOperator {

    public Add(Expression a, Expression b){
        super(a,b);
    }

    @Override
    public DualNumber evaluate(DualNumber dn){
        DualNumber dnl = left.evaluate(dn);
        DualNumber dnr = right.evaluate(dn);
        return new DualNumber(dnl.u + dnr.u, dnl.uprime + dnr.uprime);
    }
}