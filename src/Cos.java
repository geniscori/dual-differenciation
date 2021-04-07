import java.lang.Math;
public class Cos implements Expression {
    private Expression x;

    public Cos(Expression x){
        this.x = x;
    }

    @Override
    public DualNumber evaluate(DualNumber dn){
        DualNumber xevaluated = x.evaluate(dn);
        double u = xevaluated.u;
        double uprime = xevaluated.uprime;
        return new DualNumber(Math.cos(u),-uprime*Math.sin(u));
    }
}
