import parcs.*;

public class IntegralCalc implements AM {

    @Override
    public void run(AMInfo info) {

        double a = info.parent.readDouble();
        double b = info.parent.readDouble();
        int n = 1000000000 / 100000;

        double h = (b - a) / n;

        double integralSum = 0.0;

        for (int i = 0; i < n; i++) {
            double x = a + i * h;
            integralSum += f(x);;
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
