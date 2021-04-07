public class Divide extends BinaryOperator {

    public Divide(Expression x, Expression y){
        super(x,y);
    }

    @Override
    public DualNumber evaluate(DualNumber dn){
        DualNumber dnl = left.evaluate(dn) , dnr = right.evaluate(dn);
        return new DualNumber(dnl.u / dnr.u, (dnl.uprime * dnr.u - dnr.uprime * dnl.u)/(dn.uprime*Math.pow(dn.u,2)));
    }
}