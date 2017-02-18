public class MovingAverage {
    
    private int[] window;
    private int n,num;
    private long total;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        window = new int[size];
        num = 0;
        n = 0;
        total = 0;
        
    }
    
    public double next(int val) {
        
        if (n < window.length) n++;
        
        if (n == window.length){
            total -= window[num%window.length];
        }
        
        window[num%window.length] = val;
        total += val;
        num += 1;
        
        return (double)total/n;
    }
}
