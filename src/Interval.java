import java.io.Serializable;

public class Interval implements Serializable{
    public double a;
    public double b;

    public Interval(double a, double b) {
        this.a = a;
        this.b = b;
    }
}
