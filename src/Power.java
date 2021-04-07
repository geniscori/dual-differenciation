import java.lang.Math;
public class Power implements Expression {

    Expression x;
    Expression exp;

    public Power(Expression x, Expression exp){
        this.x = x;
        this.exp = exp;

    }

    @Override
    public DualNumber evaluate(DualNumber dn){
        DualNumber xevaluated = x.evaluate(dn);
        DualNumber expevaluated = exp.evaluate(dn);
        double u = xevaluated.u;
        double uprime = xevaluated.uprime;
        double exp = expevaluated.u;
        double exp_prime = expevaluated.uprime;

        return new DualNumber(Math.pow(u,exp), uprime*Math.pow(u,exp)*((Math.log(u))/(Math.log(Math.E))+1));
    }
}