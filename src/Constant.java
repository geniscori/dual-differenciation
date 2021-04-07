public class Constant implements Expression {
    private double k;
    
    public Constant(double k) {
        this.k = k;
    } //k: constant value
    
    @Override
    public DualNumber evaluate(DualNumber dn){
        return new DualNumber(k,0);
    }

}
