public class PercolationStats {
   private double[] mean;
   private double stddev;
   private double confidenceLow;
   private double confidenceHigh;
   private int t;
   private double add;

    public PercolationStats(int n, int t){
        this.t = t;
        mean = new double[t];
        if(n <= 0 || t <= 0){
            throw new IllegalArgumentException();
        }else {
            for (int i = 0; i < t; i++) {
                Percolation percolation = new Percolation(n);
                while (percolation.percolates == false) {
                    int row = (int) (Math.random() * n);
                    int col = (int) (Math.random() * n);
                    percolation.open(row, col);
                }
                mean[i] = percolation.numOpen / (n * n);
            }
            for (int i = 0; i<mean.length;i++){
                add = add + mean[i];
            }
            for(int i =0; i<mean.length;i++){
                stddev = stddev + Math.pow(mean[i]-mean(),2);
            }
            double confidence = (1.96 * stddev) / Math.sqrt(t);
            confidenceLow = mean() - confidence;
            confidenceHigh = mean() + confidence;

        }
    }
    public double mean(){
        return add/t;
    }
    public double stddev(){

        return Math.pow(stddev/t-1,2);
    }
    public double confidenceLow(){
        return confidenceLow;
    }
    public double confidenceHigh(){
        return confidenceHigh;
    }
}
