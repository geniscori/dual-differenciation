import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.resolve.constants.NullValue;
import visitor.Sum;

import java.lang.Math;
import java.lang.reflect.Executable;

public class Main {
    // to validate the mehtod
    private static double f(double x){
        return Math.pow(x,2)*(Math.pow(Math.sin(x),2) + Math.cos(x));
    }

    private static double df(double x){
        return 2*x*(Math.pow(Math.sin(x),2)+Math.cos(x))+Math.pow(x,2)*(2*Math.sin(x)*Math.cos(x)-Math.sin(x));
    }

    private static Double[] extension(Expression function, double xmin, double xmax, double x0, double epsilon, int K) {
        double  x0min = x0, x0max = x0;
        Double max = null , min = null;

        assert xmin > x0 && xmax < x0 : "x0 is not inside interval";
        for (int i = 0; i < K; i++) {
            // finding the minimum
            if (xmin <= x0min && x0min <= xmax) {
                DualNumber res = function.evaluate(new DualNumber(x0min, epsilon));
                min = x0min - res.uprime * epsilon;

                if (x0min == min) {
                    break;
                }
                x0min = min;
            } else {
                break;
            }
        }
        for (int i = 0; i < K; i++) {
            // finding the minimum
            if (xmin <= x0max && x0max <= xmax) {
                DualNumber res = function.evaluate(new DualNumber(x0max, epsilon));
                max = x0max + res.uprime * epsilon;

                if (x0max == max) {
                    break;
                }
                x0max = max;
            } else {
                break;
            }
        }
        return new Double[]{min, max};
    }

    public static void main(String[] args){
        Expression x = new X();
        // test with expression
        Expression expr = new Multiply(new Power(x,2),new Add(new Power(new Sin(x),2),new Cos(x)));

        // x0 is a test parameter
        double x0 = 1.57;
        DualNumber res = expr.evaluate(new DualNumber(x0, 0.001));
        double valorReal = f(x0);
        double derivadaReal = df(x0);

        //EXTENSION CODE
        double min=0, max=4*Math.PI, starpoint=2 , epsilon=0.001;
        int K=1000;

        Double[] ext = extension(expr,min,max,starpoint,epsilon,K);
        System.out.println("Minimum: "+ext[0]+ " Maximum: "+ext[1]);

        System.out.println("real");
        System.out.println("f(" + x0 +") = "+valorReal);
        System.out.println("f'(" + x0 + ") = "+derivadaReal);
        System.out.println("calculat");
        System.out.println("f(" + x0 + ") = "+ res.u);
        System.out.println("f'(" + x0 + ") = "+ res.uprime);
        System.out.println("diferencia valor " + (valorReal - res.u));
        System.out.println("diferencia derivada " + (derivadaReal - res.uprime));

        System.out.println("derivada per diferencies finites");
        final double[] epsilons = {1e-6, 1e-8, 1e-10, 1e-12};
        for (double v : epsilons) {
            double derivadaDifFinites = (f(x0 + v) - f(x0)) / v;
            System.out.println("per epsilon " + v + ", " + derivadaDifFinites + ", " + "diferencia " + (derivadaReal - derivadaDifFinites));
        }
    }
}

