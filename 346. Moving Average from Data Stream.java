public class MovingAverage {

    private int[] window;
    private int insert, n;
    private double sum;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        window = new int[size];
        insert = 0;
        n = 0;
        sum = 0;
    }
    
    public double next(int val) {
        // Write your code here
        if(n < window.length) n++;
        sum += val;
        
        if(n == window.length){
            sum -= window[insert%window.length];
        }
        
        window[insert%window.length] = val;
        insert += 1;
        return (sum)/n;
    }
}