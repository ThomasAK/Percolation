import java.util.Objects;

public class Percolation {
    public String[][] grid;
    public boolean percolates;
    public double numOpen;

    public Percolation(int n){
        if(n<=0){
            throw new IllegalArgumentException();
        }else {
            grid = new String[n][n];
        }
    }
    public void checkOpen(int i, int j){
        if(i == grid.length-1){
            percolates = true;
        }
        if(i-1 >= 0 && isOpen(i-1,j)){
            grid[i-1][j] = "Full";
            checkOpen(i-1, j);
        }
        if(i+1 <= grid.length-1 && isOpen(i+1,j)){
            grid[i+1][j] = "Full";
            checkOpen(i+1, j);
        }
        if(j-1 >= 0 && isOpen(i,j-1)){
            grid[i][j-1] = "Full";
            checkOpen(i, j-1);
        }
        if(j+1 <= grid.length-1 && isOpen(i,j+1)){
            grid[i][j+1] = "Full";
            checkOpen(i, j+1);
        }
    }

    public void open(int i, int j){
        if(i<0 || j<0 || i > grid.length-1 || j>grid.length-1){
            throw new IndexOutOfBoundsException();
        }else {
            if (i - 1 >= 0 && isFull(i - 1, j)) {
                grid[i][j] = "Full";
                checkOpen(i, j);
            } else if (i + 1 <= grid.length - 1 && isFull(i + 1, j)) {
                grid[i][j] = "Full";
                checkOpen(i, j);
            } else if (j - 1 >= 0 && isFull(i, j - 1)) {
                grid[i][j] = "Full";
                checkOpen(i, j);
            } else if (j + 1 <= grid.length - 1 && isFull(i, j + 1)) {
                grid[i][j] = "Full";
                checkOpen(i, j);
            } else if (i == 0 && grid[i][j] == null) {
                grid[i][j] = "Full";
                checkOpen(i, j);
                numOpen++;
            } else if(grid[i][j] == null){
                grid[i][j] = "Open";
                numOpen++;
            }
        }

    }
    public boolean isOpen(int i,int j){
        if(Objects.equals(grid[i][j], "Open")){
            return true;
        }
        return false;
    }
    public boolean isFull(int i, int j){
        if(Objects.equals(grid[i][j], "Full")){
            return true;
        }
        return false;
    }
    public boolean percolates(){
        return percolates;
    }

    public String[][] getGrid() {
        return grid;

    }
}
