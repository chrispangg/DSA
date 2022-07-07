import java.util.ArrayList;
import java.util.Hashtable;

public class DynamicFibonacci {
    Hashtable<Integer, Integer> cache;
    int cal = 0;

    public int fibonacci(int n) {
        cal++;
        if (n < 2) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public int dynamicFibonacci(int n) {
        cal++;
        if (n < 2) {
            return n;
        } else if (cache.containsKey(n)) {
            return cache.get(n);
        } else {
            // caching the answer in a hashtable if we don't have n
            int result = dynamicFibonacci(n - 1) + dynamicFibonacci(n - 2);
            cache.put(n, result);
            return result;
        }
    }

    //BottomUp Approach to Dynamic Programming
    public int dynamicFibonacciBottomUp(int n){
        ArrayList<Integer> answer = new ArrayList<Integer>();
        answer.add(0); answer.add(1);
        for (int i = 2; i <= n; i++) {
            answer.add(answer.get(i-2) + answer.get(i-1));
        }
        return answer.get(n);
    }

    public static void main(String[] args) {
        DynamicFibonacci df = new DynamicFibonacci();
        df.cache = new Hashtable<Integer, Integer>();
        System.out.println("fib ans: " + df.fibonacci(20));
        System.out.println("operations: " + df.cal);
        df.cal = 0;

        System.out.println("dynfib ans: " + df.dynamicFibonacci(20));
        System.out.println("operations: " + df.cal);

        //operation = 0 for BottomUp Approach
        System.out.println("dynfibBU ans: " + df.dynamicFibonacciBottomUp(20));
    }
}
