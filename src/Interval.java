import java.io.Serializable;

public class Interval implements Serializable{
    public double a;
    public double b;
    public int n;
    public Interval(double a, double b, int n) {
        this.a = a;
        this.b = b;
        this.n = n;
    }
}