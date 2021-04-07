public class Log implements Expression {

    DualNumber x;
    int base;

    public Log(DualNumber x, int base){
        this.x = x;
        this.base = base;

    }

    @Override
    public DualNumber evaluate(DualNumber dn){
        return new DualNumber(
                (Math.log(dn.u))/(Math.log(base)),
                dn.uprime/dn.u*((Math.log(base))/(Math.log(Math.E)))
        );
    }
}