public class MaxMin {
    
    public static class Result {
        private int max;
        private int min;
        
        public Result(int max, int min) {
            this.max = max;
            this.min = min;
        }
        
        public double getMax() {
            return max;
        }
        
        public double getMin() {
            return min;
        }
    }
    
    public static Result getResult(int[] array) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i : array) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        return new Result(max, min);
    }
}
