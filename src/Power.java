import java.lang.Math;
public class Power implements Expression {

    DualNumber x;
    int exp;

    public Power(DualNumber x, int exp){
        this.x = x;
        this.exp = exp;

    }

    @Override
    public DualNumber evaluate(DualNumber dn){
        return new DualNumber(Math.pow(dn.u,exp),exp*Math.pow(dn.u,exp-1)*dn.uprime);
    }
}