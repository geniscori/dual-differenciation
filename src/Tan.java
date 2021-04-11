import java.lang.Math;
public class Tan implements Expression {
    private Expression x;
    public Tan(Expression x){
        this.x = x;
    }

    @Override
    public DualNumber evaluate(DualNumber dn){
        DualNumber xevaluated = x.evaluate(dn);
        double u = xevaluated.u;
        double uprime = xevaluated.uprime;
        return new DualNumber(Math.tan(u),uprime/(Math.cos(u)*Math.cos(u)));
    }
}
