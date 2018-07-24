public class Main {
    public static void main(String[] args) {
        PercolationStats one = new PercolationStats(100,1000);
        System.out.println("Mean: " + one.mean());
        System.out.println("Stddev: " + one.stddev());
        System.out.println("Confidence Low:" + one.confidenceLow());
        System.out.println("Confidence High:" + one.confidenceHigh());

        PercolationStats two = new PercolationStats(20,10);
        System.out.println("Mean: " + two.mean());
        System.out.println("Stddev: " + two.stddev());
        System.out.println("Confidence Low:" + two.confidenceLow());
        System.out.println("Confidence High:" + two.confidenceHigh());

        PercolationStats three = new PercolationStats(200,100);
        System.out.println("Mean: " + three.mean());
        System.out.println("Stddev: " + three.stddev());
        System.out.println("Confidence Low:" + three.confidenceLow());
        System.out.println("Confidence High:" + three.confidenceHigh());

    }
}
