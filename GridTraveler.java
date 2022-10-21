import java.util.Arrays;

public class GridTraveler {

    public static void main(String[] args) {
        int[][] memo = new int[3][4];
        for(int i=0;i<memo.length;i++)
            Arrays.fill(memo[i],-1);
        System.out.println(numberOfTravels(2,3, memo));
    }
    /**
     * Given a grid M*N. and you can move down, right in grid cells.
     * Your initial position is the top-left corner of the grid. So you have to tell
     * how many ways are there to go bottom, right corner of the grid.
     */
    public static int numberOfTravels(int x, int y, int M, int N)
    {
        // validate position
        if(x<0 || x>M || y<0 || y>N) return 0;
        //base case
        if(x == M-1 && y == N-1) return 1;
                // number of way if Traveler (go right + go down)
        return (numberOfTravels(x, y+1, M,N) + numberOfTravels(x+1,y,M,N));
    }

    /**
     * Let's see the problem in another perspective. If you are given 1*1 grid then, the result will be one. So, to go down: position
     * index will be x-1,y and go right: x,y-1; recursively you will come across x==1 and y==1 position, then you can said that the result is
     * one.
     * @param x: grid height
     * @param y: grid width
     *         it's indicating that you are in position (x,y) which is top-left corner of x*y grid.
     * @return
     */
    public static int numberOfTravels(int x, int y, int[][] memo)
    {
        // validate position
        if(x<=0 || y<=0) return 0;
        // base case
        if(x == 1 && y == 1) return 1;
        if(memo[x][y]!=-1) return memo[x][y];
        return memo[x][y] = (numberOfTravels(x, y-1, memo) + numberOfTravels(x-1, y, memo));
    }

    /**
     * memorization needed, when the grid size is high. because solution space is increase with grid size.
     */
}
