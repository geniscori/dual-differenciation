import java.lang.Math;
public class Power implements Expression {

    Expression x;
    double exp;

    public Power(Expression x, double exp){
        this.x = x;
        this.exp = exp;

    }

    @Override
    public DualNumber evaluate(DualNumber dn){
        return new DualNumber(Math.pow(dn.u,exp),exp*Math.pow(dn.u,exp-1)*dn.uprime);
    }
}