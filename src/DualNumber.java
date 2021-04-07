public class DualNumber {
    double u;
    double uprime;

    public DualNumber(double x, double dx){
        this.u = x;
        this.uprime = dx;
    }

    public String toString(){
        return "U:" +u+ "Uprime:" +uprime;
    }
}
