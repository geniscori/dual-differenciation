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
        DualNumber xevaluated = x.evaluate(dn);
        double u = xevaluated.u;
        double uprime = xevaluated.uprime;

        return new DualNumber(Math.pow(u,exp), uprime*Math.pow(u,exp-1)*exp);
    }
}