import parcs.*;

public class Main {
    public static void main(String[] args) throws Exception {
        task curtask = new task();
        curtask.addJarFile("IntegralCalc.jar");

        AMInfo info = new AMInfo(curtask, null);
        point p = info.createPoint();
        channel c = p.createChannel();
        p.execute("IntegralCalc");

        System.out.println("Waiting for result...");
        System.out.println("Result: " + c.readDouble());
        curtask.end();
    }
}
