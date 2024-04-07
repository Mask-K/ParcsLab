import parcs.*;

public class Main {
    public static void main(String[] args) throws Exception {
        task curtask = new task();
        curtask.addJarFile("IntegralCalc.jar");

        AMInfo info = new AMInfo(curtask, null);
        double a = 0;
        double b = 10;
        int numPoints = 100000;
        double step = (b - a) / numPoints;

        point[] points = new point[numPoints];
        channel[] channels = new channel[numPoints];

        for (int i = 0; i < numPoints; i++) {
            points[i] = info.createPoint();
            channels[i] = points[i].createChannel();

            double subrangeA = a + i * step;
            double subrangeB = subrangeA + step;
            
            points[i].execute("IntegralCalc");
            channels[i].write(subrangeA);
            channels[i].write(subrangeB);
        }

        System.out.println("Waiting for result...");

        double integralResult = 0;

        for (int i = 0; i < numPoints; i++) {
            double partialResult = channels[i].readDouble();
            integralResult += partialResult;
            points[i].delete();
        }

        System.out.println("Result: " + integralResult);
        curtask.end();
    }
}
