public class Log implements Expression {

    Expression x;
    Expression base;

    public Log(Expression x, Expression base){
        this.x = x;
        this.base = base;

    }

    @Override
    public DualNumber evaluate(DualNumber dn){
        //first 
        DualNumber xevaluated = x.evaluate(dn);
        DualNumber baseevaluated = base.evaluate(dn);
        double u = xevaluated.u;
        double uprime = xevaluated.uprime;
        double base = baseevaluated.u;
        double base_prime = baseevaluated.uprime;
        return new DualNumber(
                (Math.log(u))/(Math.log(base)),
                uprime/u*((Math.log(base_prime))/(Math.log(Math.E)))
        );
    }
}