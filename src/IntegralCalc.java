import parcs.*;

public class IntegralCalc implements AM {

    @Override
    public void run(AMInfo info) {
        double a = 0;
        double b = 10;
        int n = 1000000000;

        double h = (b - a) / n;

        double integralSum = 0.0;

        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            double fx = f(x);
            integralSum += fx;
        }

        double integralResult = h * ((f(a) + f(b)) / 2 + integralSum);

        info.parent.write(integralResult);

    }

    private double f(double x) {
        double sin_xx = Math.sin(x * x);

        return sin_xx * sin_xx * sin_xx * Math.cos(x / 2.0) * Math.exp(x / 3.0) * Math.log(x + 1) * Math.sqrt(x)
                + Math.atan(x) / (x + 1);
    }

}
