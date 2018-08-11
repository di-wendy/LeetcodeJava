class Solution {
    double radius, x_center, y_center;
    Random rand;
    public Solution(double radius, double x_center, double y_center) {
        rand = new Random();
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }
    
    public double[] randPoint() {
        double dis = Math.pow(radius, 2) + 1;
        double x = 0.0;
        double y = 0.0;
        while (dis > Math.pow(radius, 2)){
            x = x_center - radius + radius * 2 * rand.nextDouble();
            y = y_center - radius + radius * 2 * rand.nextDouble();
            dis = Math.pow(x - x_center, 2) + Math.pow(y - y_center, 2);
        }
        //System.out.print(dis + " ");
        return new double[]{x, y};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */
