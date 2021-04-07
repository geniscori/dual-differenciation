import java.lang.Math;
public class Sin implements Expression {
    private Expression x;

    public Sin(Expression x){
        this.x = x;
    }

    @Override
    public DualNumber evaluate(DualNumber dn){
        DualNumber xevaluated = x.evaluate(dn);
        double u = xevaluated.u;
        double uprime = xevaluated.uprime;
        return new DualNumber(Math.sin(u),uprime*Math.cos(u));
    }
}
