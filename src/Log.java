public class Log implements Expression {

    Expression x;
    double base;

    public Log(Expression x, double base){
        this.x = x;
        this.base = base;

    }

    @Override
    public DualNumber evaluate(DualNumber dn){

        DualNumber xevaluated = x.evaluate(dn);
        double u = xevaluated.u;
        double uprime = xevaluated.uprime;
        return new DualNumber(
                (Math.log(u))/(Math.log(base)),
                uprime/u*((Math.log(base))/(Math.log(Math.E)))
        );
    }
}